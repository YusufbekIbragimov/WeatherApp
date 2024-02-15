package com.yusuf.weaterapp.data.room.entitiy

import androidx.room.Embedded
import androidx.room.Relation
import com.yusuf.weaterapp.domain.model.DayWithHourListModel

data class DayWithHourListEntity(
    @Embedded val day: DayEntity,
    @Relation(
        parentColumn = "datetime",
        entityColumn = "datetime"
    )
    val hoursList: List<HourEntity>
)

fun DayWithHourListEntity.toDomain(): DayWithHourListModel {
    return DayWithHourListModel(day.toDomain(), hoursList.map { it.toDomain() })
}