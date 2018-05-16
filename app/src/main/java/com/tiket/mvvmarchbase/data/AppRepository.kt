package com.tiket.mvvmarchbase.data

import android.content.SharedPreferences
import com.tiket.mvvmarchbase.data.local.AppPreference

/**
 * Created by Steve on 16/05/18.
 */
class AppRepository(private val preference: SharedPreferences) : AppPreference {
    companion object {
        private const val LAST_COMMENT = "lastComment"
    }

    override fun saveLastComment(lastComment: String) {
        preference.edit().putString(LAST_COMMENT, lastComment).apply()
    }

    override fun getLastComment(): String {
        return preference.getString(LAST_COMMENT, "")
    }
}
