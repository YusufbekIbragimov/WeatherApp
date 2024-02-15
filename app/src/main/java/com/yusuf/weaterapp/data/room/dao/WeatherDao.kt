package com.yusuf.weaterapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.yusuf.weaterapp.data.room.entitiy.DayEntity
import com.yusuf.weaterapp.data.room.entitiy.DayWithHourListEntity
import com.yusuf.weaterapp.data.room.entitiy.HourEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Query("SELECT * FROM DayEntity")
    fun getAllDays(): Flow<List<DayEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllDays(cards: List<DayEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllHours(cards: List<HourEntity>)

    @Transaction
    @Query("SELECT * FROM DayEntity")
    fun getDayWithHours(): Flow<DayWithHourListEntity>
}