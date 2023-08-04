package com.ogulcankirtay.besinlerkitab.base.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.ogulcankirtay.besinlerkitab.R

abstract class BaseFragment<T: ViewBinding, VM: ViewModel> : Fragment() {

    private var _binding: T? = null
    val binding: T? get() = _binding

    private lateinit var _viewModel:VM
    val viewModel get()=_viewModel

    abstract fun inflateBinding(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?):T
    abstract fun initialize()
    abstract fun provideViewModel():Class<VM>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=inflateBinding(inflater,container,savedInstanceState)
        _viewModel=ViewModelProvider(this)[provideViewModel()]

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}