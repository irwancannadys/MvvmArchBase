package com.tiket.mvvmarchbase.data.model.api

import com.google.gson.annotations.SerializedName

/**
 * Created by Steve on 16/05/18.
 */
data class Comment(@SerializedName("postId") val postId: Long?,
                   @SerializedName("id") val id: Long?,
                   @SerializedName("name") val name: String?,
                   @SerializedName("email") val email: String?,
                   @SerializedName("body") val body: String?)