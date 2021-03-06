package com.tiket.mvvmarchbase.ui.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.tiket.mvvmarchbase.base.BaseViewModel
import com.tiket.mvvmarchbase.data.CommentDataSource
import com.tiket.mvvmarchbase.data.local.AppPreference
import com.tiket.mvvmarchbase.data.model.api.Comment
import com.tiket.mvvmarchbase.utils.SchedulerProvider

/**
 * Created by Steve on 16/05/18.
 */
class MainViewModel(private val commentDataSource: CommentDataSource,
                    private val appPreference: AppPreference,
                    private val schedulerProvider: SchedulerProvider) : BaseViewModel<MainNavigator>() {

    val listComment: MutableLiveData<List<Comment>> = MutableLiveData()
    val commentBody: ObservableField<String> = ObservableField()

    fun fetchComments() {
        getCompositeDisposable().add(commentDataSource.getCommentsRemote("1")
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe {
                    getIsLoading().set(true)
                }
                .subscribe({
                    if (it.isNotEmpty()) appPreference.saveLastComment(it[0].body ?: "")
                    listComment.value = it
                    getIsLoading().set(false)
                }, {
                    val lastCommentCache = appPreference.getLastComment()
                    if (lastCommentCache.isNotBlank()) commentBody.set(lastCommentCache)

                    getNavigator()?.showErrorMessage(it.message ?: "")
                    getIsLoading().set(false)
                }))
    }

    fun showFirstCommentBody(comments: List<Comment>) {
        if (comments.isNotEmpty()) commentBody.set(comments[0].body ?: "")
    }
}
