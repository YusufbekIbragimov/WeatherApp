package com.yusuf.weaterapp.data.room.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yusuf.weaterapp.domain.model.HourModel

@Entity
data class HourEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val time: String = "",
    val datetime: String = "",
    val temp: Double? = 0.0
)

fun HourEntity.toDomain(): HourModel {
    return HourModel(time, temp ?: 0.0)
}