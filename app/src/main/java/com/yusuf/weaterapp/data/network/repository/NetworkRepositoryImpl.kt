package com.yusuf.weaterapp.data.network.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.yusuf.weaterapp.data.network.NetworkService
import com.yusuf.weaterapp.data.network.response.WeatherResponse
import com.yusuf.weaterapp.domain.repository.NetworkRepository
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val service: NetworkService
) : NetworkRepository {
    override suspend fun getDaysInfo(
        key: String,
        location: String,
        dayLimit: String
    ): NetworkResponse<WeatherResponse, String> {
        return service.getWeatherInfo(location, dayLimit, key)
    }
}