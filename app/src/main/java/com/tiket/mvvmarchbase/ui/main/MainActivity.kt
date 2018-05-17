package com.tiket.mvvmarchbase.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.tiket.mvvmarchbase.BR
import com.tiket.mvvmarchbase.R
import com.tiket.mvvmarchbase.base.BaseActivity
import com.tiket.mvvmarchbase.databinding.ActivityMainBinding
import com.tiket.mvvmarchbase.ui.detailcomment.DetailCommentActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModel(): MainViewModel {
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        return mainViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = getViewDataBinding()
        mainViewModel.setNavigator(this)
        setUp()
    }

    override fun showErrorMessage(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    private fun setUp() {
        activityMainBinding.btnDetail.setOnClickListener {
            val intent = Intent(this, DetailCommentActivity::class.java)
            startActivity(intent)
        }

        subscribeToLiveData()
        mainViewModel.fetchComments()
    }

    private fun subscribeToLiveData() {
        mainViewModel.listComment.observe(this, Observer {
            if (it != null) mainViewModel.showFirstCommentBody(it)
        })
    }
}
