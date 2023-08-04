package com.ogulcankirtay.besinlerkitab.network

import com.ogulcankirtay.besinlerkitab.data.model.Meal
import retrofit2.Call
import retrofit2.http.GET

interface MealService {


    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getBesin() : Call<List<Meal>>

}