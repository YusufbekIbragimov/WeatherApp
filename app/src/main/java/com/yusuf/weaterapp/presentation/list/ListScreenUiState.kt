package com.yusuf.weaterapp.presentation.list

import com.yusuf.weaterapp.domain.model.DayModel
import com.yusuf.weaterapp.utils.roundToHours
import com.yusuf.weaterapp.utils.toFormattedStringDay
import java.util.Date

data class ListScreenUiState(
    val today: String = Date().toFormattedStringDay(),
    val time: String = Date().roundToHours(),
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val daysList: List<DayModel> = emptyList(),
    val currentTemp: String? = null,
    val filters: List<Int> = listOf(3, 7, 10),
    val activeFilter: Int = 3
)