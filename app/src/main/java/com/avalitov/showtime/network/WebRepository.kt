package com.avalitov.showtime.network

import com.avalitov.showtime.network.retrofit.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebRepository {

    private val retrofit: ApiInterface = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(ApiInterface::class.java)

    companion object {
        private const val TAG = "WEB_REPO"
        private const val BASE_URL = "https://api.apilayer.com/exchangerates_data/"
    }

    suspend fun loadRates(): Map<String, Double> {
        return retrofit.getLatestRates().rates
    }
}