package com.yusuf.weaterapp.domain.model

data class DayWithHourListModel(
    val day: DayModel,
    val hoursList: List<HourModel>
)