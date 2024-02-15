package com.yusuf.weaterapp.utils

import androidx.room.TypeConverter

class DoubleConverter {
    @TypeConverter
    fun toDatabaseValue(value: Double): String {
        return value.toString()
    }

    @TypeConverter
    fun toEntityValue(value: String): Double {
        return value.toDouble()
    }
}