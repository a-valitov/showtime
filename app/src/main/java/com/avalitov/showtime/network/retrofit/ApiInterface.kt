package com.avalitov.showtime.network.retrofit

import com.avalitov.showtime.data.model.RatesResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {

    @Headers("apikey: " + "k2WzYaR69hxytT7cjPfuzRKE0OA25LL0")
    @GET("latest")
    suspend fun getLatestRates() : RatesResponse
}