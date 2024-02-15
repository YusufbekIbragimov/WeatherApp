package com.yusuf.weaterapp.data.network.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("days")
    val days: List<Day>,
)