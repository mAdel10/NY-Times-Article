package com.example.nytimesarticle.frameworks.views.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.nytimesarticle.frameworks.views.mainActivity.MainViewModel

abstract class BaseFragment<VB : ViewDataBinding> : Fragment() {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    protected val viewModel by activityViewModels<MainViewModel>()

    abstract fun bindViews()

    @LayoutRes
    abstract fun getLayoutResId(): Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}