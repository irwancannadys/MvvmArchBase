package com.tiket.mvvmarchbase.ui.detailcomment

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import com.tiket.mvvmarchbase.BR
import com.tiket.mvvmarchbase.R
import com.tiket.mvvmarchbase.base.BaseActivity
import com.tiket.mvvmarchbase.databinding.ActivityDetailCommentBinding
import com.tiket.mvvmarchbase.ui.detailcomment.fragment.DetailCommentFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class DetailCommentActivity : BaseActivity<ActivityDetailCommentBinding, DetailCommentViewModel>(), HasSupportFragmentInjector,
        DetailCommentNavigator {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var activityDetailCommentBinding: ActivityDetailCommentBinding
    private lateinit var detailCommentViewModel: DetailCommentViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.activity_detail_comment

    override fun getViewModel(): DetailCommentViewModel {
        detailCommentViewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailCommentViewModel::class.java)
        return detailCommentViewModel
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailCommentBinding = getViewDataBinding()
        detailCommentViewModel.setNavigator(this)
        setUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_comment, menu)
        return true
    }

    private fun setUp() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailCommentFragment.newInstance())
                .commit()
    }

}
