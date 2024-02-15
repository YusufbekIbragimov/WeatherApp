package com.yusuf.weaterapp.data.room.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yusuf.weaterapp.domain.model.DayModel

@Entity
data class DayEntity(
    @PrimaryKey val datetime: String,
    val temp: Double,
    val tempmax: Double,
    val tempmin: Double
)

fun DayEntity.toDomain(): DayModel {
    return DayModel(datetime, temp, tempmax, tempmin)
}