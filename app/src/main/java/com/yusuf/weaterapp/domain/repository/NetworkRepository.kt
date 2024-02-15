package com.yusuf.weaterapp.domain.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.yusuf.weaterapp.data.network.response.WeatherResponse

interface NetworkRepository {
    suspend fun getDaysInfo(key: String, location: String): NetworkResponse<WeatherResponse, String>
}