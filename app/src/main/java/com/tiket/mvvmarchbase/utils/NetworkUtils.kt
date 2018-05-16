package com.tiket.mvvmarchbase.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Steve on 16/05/18.
 */
class NetworkUtils {

    companion object {
        fun isNetworkConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
            cm?.let {
                val activeNetwork = it.activeNetworkInfo
                return activeNetwork != null && activeNetwork.isConnectedOrConnecting
            }
            return false
        }
    }
}
