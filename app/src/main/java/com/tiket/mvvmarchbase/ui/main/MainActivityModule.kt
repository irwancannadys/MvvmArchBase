package com.tiket.mvvmarchbase.ui.main

import android.arch.lifecycle.ViewModelProvider
import com.tiket.mvvmarchbase.ViewModelProviderFactory
import com.tiket.mvvmarchbase.data.AppRepository
import com.tiket.mvvmarchbase.data.CommentRepository
import com.tiket.mvvmarchbase.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Steve on 16/05/18.
 */
@Module
class MainActivityModule {
    @Provides
    fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }

    @Provides
    fun provideMainViewModel(commentRepository: CommentRepository,
                             appRepository: AppRepository,
                             schedulerProvider: SchedulerProvider): MainViewModel {
        return MainViewModel(commentRepository, appRepository, schedulerProvider)
    }
}
