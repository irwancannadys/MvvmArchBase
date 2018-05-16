package com.tiket.mvvmarchbase.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Steve on 16/05/18.
 */
abstract class BaseViewModel<N>() : ViewModel() {

    private val isLoading = ObservableBoolean(false)
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var navigator: N? = null

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun getCompositeDisposable(): CompositeDisposable = compositeDisposable

    fun getIsLoading(): ObservableBoolean = isLoading

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    fun getNavigator(): N? = navigator

    fun setNavigator(navigator: N?) {
        this.navigator = navigator
    }
}
