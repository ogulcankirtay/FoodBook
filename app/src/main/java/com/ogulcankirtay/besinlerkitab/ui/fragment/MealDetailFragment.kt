package com.ogulcankirtay.besinlerkitab.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.ogulcankirtay.besinlerkitab.base.Fragment.BaseFragment
import com.ogulcankirtay.besinlerkitab.databinding.FragmentMealDetailBinding
import com.ogulcankirtay.besinlerkitab.ui.fragment.viewModel.MealDetailViewModel
import com.squareup.picasso.Picasso


class MealDetailFragment : BaseFragment<FragmentMealDetailBinding,MealDetailViewModel>() {

    val args: MealDetailFragmentArgs by navArgs()
    var mealID=-1

    override fun provideViewModel()=MealDetailViewModel::class.java

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentMealDetailBinding {
        return FragmentMealDetailBinding.inflate(inflater,container,false)
    }

    override fun initialize() {
        mealID = args.mealID
        viewModel.loadData(mealID)
        prepareUi()
    }

   private fun prepareUi(){
       viewModel.meal.observe(viewLifecycleOwner, Observer {
           it.let {meal ->


                binding?.tvMealName?.text=meal.isim
                binding?.tvMealCalories?.text=meal.kalori
                binding?.tvMealProtein?.text=meal.protein
                binding?.tvMealCarbohydrate?.text=meal.karbonhidrat
                binding?.tvMealFat?.text=meal.yag
                Picasso.get().load(meal.gorsel).into(binding?.ivMealImage)



           }
       })

   }


}