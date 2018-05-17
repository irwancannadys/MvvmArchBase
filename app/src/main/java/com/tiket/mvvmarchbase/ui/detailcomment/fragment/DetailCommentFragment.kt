package com.tiket.mvvmarchbase.ui.detailcomment.fragment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.tiket.mvvmarchbase.BR

import com.tiket.mvvmarchbase.R
import com.tiket.mvvmarchbase.base.BaseFragment
import com.tiket.mvvmarchbase.databinding.FragmentDetailCommentBinding
import javax.inject.Inject

class DetailCommentFragment : BaseFragment<FragmentDetailCommentBinding, DetailCommentFragmentViewModel>(),
        DetailCommentFragmentNavigator {

    companion object {
        @JvmStatic
        fun newInstance() = DetailCommentFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }

    @Inject
    lateinit var detailCommentFragmentViewModel: DetailCommentFragmentViewModel

    private lateinit var fragmentDetailCommentBinding: FragmentDetailCommentBinding

    private val listAdapter: DetailCommentListAdapter = DetailCommentListAdapter(mutableListOf())

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.fragment_detail_comment

    override fun getViewModel(): DetailCommentFragmentViewModel {
        return detailCommentFragmentViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailCommentFragmentViewModel.setNavigator(this)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        fragmentDetailCommentBinding = getViewDataBinding()
        subscribeToLiveData()
        setUp(view)
    }

    override fun showErrorMessage(errorMessage: String) {
        activity?.let {
            Toast.makeText(it, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.refresh -> {
                detailCommentFragmentViewModel.fetchPosts()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setUp(view: View) {
        fragmentDetailCommentBinding.rvComment.run {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
            isNestedScrollingEnabled = true
            adapter = listAdapter
        }

        detailCommentFragmentViewModel.fetchPosts()
    }

    private fun subscribeToLiveData() {
        detailCommentFragmentViewModel.listPost.observe(this, Observer {
            if (it != null) listAdapter.updateListPost(it)
        })
    }
}
