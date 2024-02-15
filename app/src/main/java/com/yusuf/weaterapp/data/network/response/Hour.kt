package com.yusuf.weaterapp.data.network.response

import com.yusuf.weaterapp.data.room.entitiy.HourEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hour(
    @SerialName("datetime")
    val datetime: String,
    @SerialName("temp")
    val temp: Double,
)

fun Hour.toEntity(): HourEntity {
    return HourEntity(datetime, temp)
}