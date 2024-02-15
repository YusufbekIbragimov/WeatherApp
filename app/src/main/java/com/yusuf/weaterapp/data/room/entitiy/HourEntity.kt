package com.yusuf.weaterapp.data.room.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yusuf.weaterapp.domain.model.HourModel

@Entity
data class HourEntity(
    @PrimaryKey val datetime: String,
    val temp: Double
)

fun HourEntity.toDomain(): HourModel {
    return HourModel(datetime, temp)
}