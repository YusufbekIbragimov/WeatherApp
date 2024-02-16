package com.yusuf.weaterapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yusuf.weaterapp.data.room.dao.WeatherDao
import com.yusuf.weaterapp.data.room.entitiy.DayEntity
import com.yusuf.weaterapp.data.room.entitiy.HourEntity

@Database(entities = [DayEntity::class, HourEntity::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cardDao(): WeatherDao
}