package com.ogulcankirtay.besinlerkitab.ui.fragment.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ogulcankirtay.besinlerkitab.data.model.Meal
import com.ogulcankirtay.besinlerkitab.data.repository.MealRepository


class MealListViewModel:ViewModel() {
    val mealRepository=MealRepository()
    val mealList=MutableLiveData<List<Meal>?>()
    val isLoaded=MutableLiveData<Boolean>()
    val isError=MutableLiveData<Boolean>()

    fun getData(){
        isError.value=true
        isLoaded.value=true
        mealRepository.getMealList(succes = {it->
            println(it)
            mealList.value=it
            isError.value=false
            isLoaded.value=false
        }, error = {
            it.let {
                isError.value=true
            }
        })
    }

}