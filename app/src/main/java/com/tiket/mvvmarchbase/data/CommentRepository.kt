package com.tiket.mvvmarchbase.data

import com.tiket.mvvmarchbase.data.model.api.Comment
import com.tiket.mvvmarchbase.data.remote.CommentApiService
import io.reactivex.Single

/**
 * Created by Steve on 16/05/18.
 */
class CommentRepository(private val commentApiService: CommentApiService) : CommentDataSource {

    override fun getCommentsRemote(postId: String): Single<List<Comment>> {
        return commentApiService.getComments(postId)
    }
}
