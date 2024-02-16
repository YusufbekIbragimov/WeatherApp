package com.yusuf.weaterapp.data.network.repository

import com.yusuf.weaterapp.data.room.dao.WeatherDao
import com.yusuf.weaterapp.data.room.entitiy.DayEntity
import com.yusuf.weaterapp.data.room.entitiy.DayWithHourListEntity
import com.yusuf.weaterapp.data.room.entitiy.HourEntity
import com.yusuf.weaterapp.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val dao: WeatherDao
) : LocalRepository {
    override suspend fun saveAllDays(days: List<DayEntity>) {
        dao.saveAllDays(days)
    }

    override suspend fun saveAllHours(hours: List<HourEntity>) {
        dao.saveAllHours(hours)
    }

    override suspend fun getCurrentTemp(today: String, time:String): Flow<HourEntity?> {
        return dao.getCurrentTemp(today,time)
    }

    override suspend fun getAllDays(limit: Int): Flow<List<DayEntity>> {
        return dao.getAllDays(limit)
    }

    override suspend fun getDayWithHours(date:String): Flow<DayWithHourListEntity> {
        return dao.getDayWithHours(date)
    }
}