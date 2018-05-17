package com.tiket.mvvmarchbase.di.builder

import com.tiket.mvvmarchbase.ui.detailcomment.DetailCommentActivity
import com.tiket.mvvmarchbase.ui.detailcomment.DetailCommentActivityModule
import com.tiket.mvvmarchbase.ui.detailcomment.fragment.DetailCommentFragmentProvider
import com.tiket.mvvmarchbase.ui.main.MainActivity
import com.tiket.mvvmarchbase.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Steve on 16/05/18.
 */
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [DetailCommentActivityModule::class,
        DetailCommentFragmentProvider::class])
    abstract fun bindDetailCommentActivity(): DetailCommentActivity
}
