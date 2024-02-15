package com.yusuf.weaterapp.presentation.list

import com.yusuf.weaterapp.domain.model.DayModel

data class ListScreenUiState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val daysList: List<DayModel> = emptyList()
)