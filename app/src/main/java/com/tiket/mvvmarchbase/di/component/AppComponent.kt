package com.tiket.mvvmarchbase.di.component

import android.app.Application
import com.tiket.mvvmarchbase.MyApplication
import com.tiket.mvvmarchbase.di.builder.ActivityBuilder
import com.tiket.mvvmarchbase.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Steve on 16/05/18.
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {

    fun inject(app: MyApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
