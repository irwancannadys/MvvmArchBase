package com.tiket.mvvmarchbase.di.module

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.GsonBuilder
import com.tiket.mvvmarchbase.data.AppRepository
import com.tiket.mvvmarchbase.data.CommentRepository
import com.tiket.mvvmarchbase.data.remote.CommentApiService
import com.tiket.mvvmarchbase.utils.AppSchedulerProvider
import com.tiket.mvvmarchbase.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Steve on 16/05/18.
 */
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideCommentRepository(retrofit: Retrofit): CommentRepository {
        return CommentRepository(retrofit.create(CommentApiService::class.java))
    }

    @Provides
    @Singleton
    fun provideAppRepository(context: Context): AppRepository {
        return AppRepository(PreferenceManager.getDefaultSharedPreferences(context))
    }
}
