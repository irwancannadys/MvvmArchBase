package com.tiket.mvvmarchbase.ui.detailcomment.fragment

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tiket.mvvmarchbase.R
import com.tiket.mvvmarchbase.data.model.api.Post
import com.tiket.mvvmarchbase.databinding.ListItemPostBinding

/**
 * Created by Steve on 17/05/18.
 */
class DetailCommentListAdapter(private val posts: MutableList<Post>) : RecyclerView.Adapter<DetailCommentListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ListItemPostBinding>(LayoutInflater.from(parent.context),
                R.layout.list_item_post, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.post = posts[position]
        holder.binding.executePendingBindings()
    }

    fun updateListPost(newPosts: List<Post>) {
        val diffResult = DiffUtil.calculateDiff(PostDiffCallback(posts, newPosts))
        posts.clear()
        posts.addAll(newPosts)
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(val binding: ListItemPostBinding) : RecyclerView.ViewHolder(binding.root)

}
