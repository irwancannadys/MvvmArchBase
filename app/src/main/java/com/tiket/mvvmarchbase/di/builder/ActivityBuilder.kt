package com.tiket.mvvmarchbase.di.builder

import com.tiket.mvvmarchbase.ui.MainActivity
import com.tiket.mvvmarchbase.ui.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Steve on 16/05/18.
 */
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}
