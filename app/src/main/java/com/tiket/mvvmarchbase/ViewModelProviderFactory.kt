package com.tiket.mvvmarchbase

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.tiket.mvvmarchbase.base.BaseViewModel

/**
 * Created by Steve on 16/05/18.
 */
class ViewModelProviderFactory<V: BaseViewModel<*>>(private val viewModel: V) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel::class.java)) {
            return viewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
