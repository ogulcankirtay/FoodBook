package com.ogulcankirtay.besinlerkitab.ui.fragment.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ogulcankirtay.besinlerkitab.data.model.Meal
import com.ogulcankirtay.besinlerkitab.data.repository.MealRepository

class MealDetailViewModel: ViewModel() {
    val mealRepository=MealRepository()
    val meal=MutableLiveData<Meal>()
    fun loadData(id:Int){
      mealRepository.getMealList(succes = {
                                          meal.value=it?.get(id)
      }, error = {})
    }

}