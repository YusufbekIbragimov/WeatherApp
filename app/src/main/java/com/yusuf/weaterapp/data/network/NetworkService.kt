package com.yusuf.weaterapp.data.network

import com.haroldadmin.cnradapter.NetworkResponse
import com.yusuf.weaterapp.data.network.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkService {

    @GET("{location}")
    suspend fun getWeatherInfo(
        @Path("location") location: String,
        @Query("key") key: String
    ): NetworkResponse<WeatherResponse, String>

}