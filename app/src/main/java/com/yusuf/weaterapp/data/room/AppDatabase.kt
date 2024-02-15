package com.yusuf.weaterapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yusuf.weaterapp.data.room.dao.WeatherDao
import com.yusuf.weaterapp.data.room.entitiy.DayEntity
import com.yusuf.weaterapp.data.room.entitiy.HourEntity
import com.yusuf.weaterapp.utils.DoubleConverter

@Database(entities = [DayEntity::class, HourEntity::class], version = 1, exportSchema = false)
@TypeConverters(
    DoubleConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cardDao(): WeatherDao
}