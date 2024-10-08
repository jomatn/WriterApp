package com.example.writerapp.ui.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding> (
    private val inflate: Inflate<VB>
): Fragment()   {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupClickListeners()
        initViews()
    }

    protected open fun setupObservers() {}
    protected open fun setupClickListeners() {}
    protected open fun initViews() {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}