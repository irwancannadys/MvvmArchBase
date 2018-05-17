package com.tiket.mvvmarchbase.ui.detailcomment.fragment

import android.arch.lifecycle.MutableLiveData
import com.tiket.mvvmarchbase.base.BaseViewModel
import com.tiket.mvvmarchbase.data.CommentRepository
import com.tiket.mvvmarchbase.data.model.api.Post
import com.tiket.mvvmarchbase.utils.SchedulerProvider

/**
 * Created by Steve on 17/05/18.
 */
class DetailCommentFragmentViewModel(private val commentRepository: CommentRepository,
                                     private val schedulerProvider: SchedulerProvider)
    : BaseViewModel<DetailCommentFragmentNavigator>() {

    val listPost: MutableLiveData<List<Post>> = MutableLiveData()

    fun fetchPosts() {
        getCompositeDisposable().add(commentRepository.getPostsRemote()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe {
                    getIsLoading().set(true)
                }.subscribe({
                    listPost.value = it
                    getIsLoading().set(false)
                },{
                    getNavigator()?.showErrorMessage(it.message ?: "")
                    getIsLoading().set(false)
                }))
    }

}
