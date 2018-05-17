package com.tiket.mvvmarchbase.ui.detailcomment.fragment

import com.tiket.mvvmarchbase.data.CommentRepository
import com.tiket.mvvmarchbase.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Steve on 17/05/18.
 */
@Module
class DetailCommentFragmentModule {

    @Provides
    fun provideDetailCommentFragmentViewModel(commentRepository: CommentRepository,
                                              schedulerProvider: SchedulerProvider): DetailCommentFragmentViewModel {
        return DetailCommentFragmentViewModel(commentRepository, schedulerProvider)
    }
}
