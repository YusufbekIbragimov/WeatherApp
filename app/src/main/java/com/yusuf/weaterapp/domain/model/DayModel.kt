package com.yusuf.weaterapp.domain.model

data class DayModel(
    val datetime: String,
    val temp: Double,
    val tempmax: Double,
    val tempmin: Double
)