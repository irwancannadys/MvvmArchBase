package com.tiket.mvvmarchbase.ui.detailcomment.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Steve on 17/05/18.
 */
@Module
abstract class DetailCommentFragmentProvider {

    @ContributesAndroidInjector(modules = [DetailCommentFragmentModule::class])
    abstract fun provideDetailCommentFragmentFactory(): DetailCommentFragment
}
