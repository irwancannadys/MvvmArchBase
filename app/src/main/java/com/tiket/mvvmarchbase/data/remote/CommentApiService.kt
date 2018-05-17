package com.tiket.mvvmarchbase.data.remote

import com.tiket.mvvmarchbase.data.model.api.Comment
import com.tiket.mvvmarchbase.data.model.api.Post
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Steve on 16/05/18.
 */
interface CommentApiService {
    @GET("posts/{post_id}/comments")
    fun getComments(@Path("post_id") postId: String): Single<List<Comment>>

    @GET("posts")
    fun getPosts(): Single<List<Post>>
}
