package com.ogulcankirtay.besinlerkitab.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ogulcankirtay.besinlerkitab.R
import com.ogulcankirtay.besinlerkitab.base.Fragment.BaseFragment
import com.ogulcankirtay.besinlerkitab.base.listener.RecyclerItemClickListener
import com.ogulcankirtay.besinlerkitab.data.model.Meal
import com.ogulcankirtay.besinlerkitab.databinding.FragmentMealListBinding
import com.ogulcankirtay.besinlerkitab.network.NetworkHelper
import com.ogulcankirtay.besinlerkitab.ui.fragment.adapter.MealAdapter
import com.ogulcankirtay.besinlerkitab.ui.fragment.adapter.MealViewHolder
import com.ogulcankirtay.besinlerkitab.ui.fragment.viewModel.MealListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MealListFragment : BaseFragment<FragmentMealListBinding,MealListViewModel>() {


    private lateinit var mealAdapter: MealAdapter

    override fun provideViewModel()=MealListViewModel::class.java

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentMealListBinding {
        return FragmentMealListBinding.inflate(inflater,container,false)
    }

    override fun initialize() {

        viewModel.getData()
        observeLiveData()
        prepareAdapter()

    }

    fun observeLiveData(){
        viewModel.mealList.observe(viewLifecycleOwner, Observer {it->
            it.let {it->
                println(it)
                binding?.recyclerView?.visibility=View.VISIBLE
                mealAdapter.submitList(it)


            }
        })
        viewModel.isLoaded.observe(viewLifecycleOwner,Observer{error->
            error.let { it->
                if(it){
                    binding?.recyclerView?.visibility=View.GONE
                    binding?.tvError?.visibility=View.GONE
                    binding?.progressBar?.visibility=View.VISIBLE
                }else{
                    binding?.progressBar?.visibility=View.GONE
                }
            }
        })
        viewModel.isError.observe(viewLifecycleOwner,Observer{
            it.let { it->
                if(it){
                    binding?.tvError?.visibility=View.VISIBLE

                }else{
                    binding?.tvError?.visibility=View.GONE
                }
            } })
    }
    private fun prepareAdapter(){

        mealAdapter= MealAdapter(recyclerItemClickListener)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding?.recyclerView?.adapter=mealAdapter
    }
private val recyclerItemClickListener=object: RecyclerItemClickListener<Int>{
    override fun onClick(item: Int) {
       findNavController().navigate(MealListFragmentDirections.actionMealListFragmentToMealDetailFragment(item))

    } }


}
