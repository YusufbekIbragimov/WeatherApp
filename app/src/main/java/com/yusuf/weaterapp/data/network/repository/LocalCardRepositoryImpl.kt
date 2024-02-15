package com.yusuf.weaterapp.data.network.repository

import com.yusuf.weaterapp.data.room.dao.WeatherDao
import com.yusuf.weaterapp.data.room.entitiy.DayEntity
import com.yusuf.weaterapp.data.room.entitiy.DayWithHourListEntity
import com.yusuf.weaterapp.data.room.entitiy.HourEntity
import com.yusuf.weaterapp.domain.repository.LocalCardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalCardRepositoryImpl @Inject constructor(
    private val dao: WeatherDao
) : LocalCardRepository {
    override suspend fun saveAllDays(cards: List<DayEntity>) {
        dao.saveAllDays(cards)
    }
    override suspend fun saveAllHours(hours: List<HourEntity>) {
        dao.saveAllHours(hours)
    }

    override suspend fun getAllDays(): Flow<List<DayEntity>> {
        return dao.getAllDays()
    }

    override suspend fun getDayWithHours(): Flow<DayWithHourListEntity> {
        return dao.getDayWithHours()
    }
}