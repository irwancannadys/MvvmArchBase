package com.tiket.mvvmarchbase.data.model.api

import com.google.gson.annotations.SerializedName

/**
 * Created by Steve on 17/05/18.
 */
data class Post(@SerializedName("userId") val userId: Long?,
                @SerializedName("id") val id: Long?,
                @SerializedName("title") val title: String?,
                @SerializedName("body") val body: String?)
