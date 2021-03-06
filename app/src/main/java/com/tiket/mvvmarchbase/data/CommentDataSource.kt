package com.tiket.mvvmarchbase.data

import com.tiket.mvvmarchbase.data.model.api.Comment
import com.tiket.mvvmarchbase.data.model.api.Post
import io.reactivex.Single

/**
 * Created by Steve on 16/05/18.
 */
interface CommentDataSource {
    fun getCommentsRemote(postId: String): Single<List<Comment>>

    fun getPostsRemote(): Single<List<Post>>
}
