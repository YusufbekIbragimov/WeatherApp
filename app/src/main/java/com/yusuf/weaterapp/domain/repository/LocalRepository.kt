package com.yusuf.weaterapp.domain.repository

import com.yusuf.weaterapp.data.room.entitiy.DayEntity
import com.yusuf.weaterapp.data.room.entitiy.DayWithHourListEntity
import com.yusuf.weaterapp.data.room.entitiy.HourEntity
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun saveAllDays(days: List<DayEntity>)
    suspend fun saveAllHours(hours: List<HourEntity>)
    suspend fun getCurrentTemp(today: String, time:String): Flow<HourEntity?>
    suspend fun getAllDays(limit: Int): Flow<List<DayEntity>>
    suspend fun getDayWithHours(date:String): Flow<DayWithHourListEntity>
}