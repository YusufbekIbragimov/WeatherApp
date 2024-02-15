package com.yusuf.weaterapp.presentation.details

import com.yusuf.weaterapp.domain.model.DayWithHourListModel

data class DetailsScreenUiState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val daysList: DayWithHourListModel? = null
)