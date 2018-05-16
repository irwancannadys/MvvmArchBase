package com.tiket.mvvmarchbase.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection

/**
 * Created by Steve on 16/05/18.
 */
abstract class BaseFragment<out T : ViewDataBinding, out V : BaseViewModel<*>> : Fragment() {

    private var activity: BaseActivity<ViewDataBinding, BaseViewModel<*>>? = null
    private lateinit var viewDataBinding: T
    private lateinit var viewModel: V

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract fun getBindingVariable(): Int

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): V

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity<ViewDataBinding, BaseViewModel<*>>) {
            activity = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return viewDataBinding.root
    }

    override fun onDetach() {
        activity = null
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.setVariable(getBindingVariable(), viewModel)
        viewDataBinding.executePendingBindings()
    }

    protected fun getBaseActivity(): BaseActivity<ViewDataBinding, BaseViewModel<*>>? = activity

    protected fun getViewDataBinding(): T = viewDataBinding

    protected fun isNetworkConnected(): Boolean = activity?.isNetworkConnected() ?: false

    protected fun hideKeyboard() {
        activity?.hideKeyboard()
    }

    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }
}
