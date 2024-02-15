package com.yusuf.weaterapp.data.network.response

import com.yusuf.weaterapp.data.room.entitiy.DayEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Day(
    @SerialName("datetime")
    val datetime: String,
    @SerialName("hours")
    val hours: List<Hour>,
    @SerialName("temp")
    val temp: Double,
    @SerialName("tempmax")
    val tempmax: Double,
    @SerialName("tempmin")
    val tempmin: Double,
)

fun Day.toEntity(): DayEntity {
    return DayEntity(datetime, temp, tempmax, tempmin)
}