package com.yusuf.weaterapp.domain.repository

import com.yusuf.weaterapp.data.room.entitiy.DayEntity
import com.yusuf.weaterapp.data.room.entitiy.DayWithHourListEntity
import com.yusuf.weaterapp.data.room.entitiy.HourEntity
import kotlinx.coroutines.flow.Flow

interface LocalCardRepository {
    suspend fun saveAllDays(cards: List<DayEntity>)
    suspend fun saveAllHours(cards: List<HourEntity>)
    suspend fun getAllDays(): Flow<List<DayEntity>>
    suspend fun getDayWithHours(): Flow<DayWithHourListEntity>
}