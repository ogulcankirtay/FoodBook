package com.ogulcankirtay.besinlerkitab.data.repository

import com.ogulcankirtay.besinlerkitab.data.model.Meal
import com.ogulcankirtay.besinlerkitab.network.NetworkHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealRepository {
    fun getMealList(
        succes: (meals: List<Meal>?)-> Unit,
        error: (errMessage: String?)-> Unit
    ) {
        NetworkHelper.mealService.getBesin().enqueue(object: Callback<List<Meal>> {
            override fun onResponse(call: Call<List<Meal>>, response: Response<List<Meal>>) {
                when{
                    response.isSuccessful->{
                        succes.invoke(response.body())
                        println(response.body())
                    }else->{
                    error.invoke(response.message())
                }
                }
            }

            override fun onFailure(call: Call<List<Meal>>, t: Throwable) {
                println(t.localizedMessage)
                error.invoke(t.localizedMessage)
            }

        })

    }

}