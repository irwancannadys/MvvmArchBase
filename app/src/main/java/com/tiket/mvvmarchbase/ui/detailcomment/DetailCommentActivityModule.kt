package com.tiket.mvvmarchbase.ui.detailcomment

import android.arch.lifecycle.ViewModelProvider
import com.tiket.mvvmarchbase.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Steve on 17/05/18.
 */
@Module
class DetailCommentActivityModule {
    @Provides
    fun detailCommentViewModelProvider(detailCommentViewModel: DetailCommentViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(detailCommentViewModel)
    }

    @Provides
    fun provideDetailCommentViewModel(): DetailCommentViewModel {
        return DetailCommentViewModel()
    }
}
