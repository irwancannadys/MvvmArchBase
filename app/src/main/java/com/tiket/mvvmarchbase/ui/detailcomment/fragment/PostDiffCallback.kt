package com.tiket.mvvmarchbase.ui.detailcomment.fragment

import android.support.v7.util.DiffUtil
import com.tiket.mvvmarchbase.data.model.api.Post

/**
 * Created by Steve on 17/05/18.
 */
class PostDiffCallback(private val oldPost: List<Post>, private val newPost: List<Post>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPost[oldItemPosition].id == newPost[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldPost.size
    }

    override fun getNewListSize(): Int {
        return newPost.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPost[oldItemPosition] == newPost[newItemPosition]
    }
}
