package com.tiket.mvvmarchbase.data.local

/**
 * Created by Steve on 16/05/18.
 */
interface AppPreference {
    fun saveLastComment(lastComment: String)

    fun getLastComment(): String
}
