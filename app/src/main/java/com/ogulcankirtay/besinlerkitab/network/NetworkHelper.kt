package com.ogulcankirtay.besinlerkitab.network

import com.ogulcankirtay.besinlerkitab.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit


object NetworkHelper {

    private lateinit var retrofit: Retrofit

    lateinit var mealService: MealService

    init {
        retrofitBuilder()
        bindService()
    }

    private fun retrofitBuilder() {
        retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun bindService() {
        mealService = retrofit.create(MealService::class.java)
    }

    private fun getOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.writeTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)

        return httpClient.build()
    }
}