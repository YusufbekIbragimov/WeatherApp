package com.yusuf.weaterapp.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf.weaterapp.domain.usecases.GetDayListUseCase
import com.yusuf.weaterapp.domain.usecases.SyncDaysUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getDaysUseCase: GetDayListUseCase,
    private val syncDaysUseCase: SyncDaysUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ListScreenUiState())
    val uiState = _uiState.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    private val _errorMessage = MutableStateFlow("")

    init {
        viewModelScope.launch {
            combine(
                getDaysUseCase(),
                _isLoading,
                _errorMessage
            ) { list, loading, error ->
                _uiState.emit(
                    ListScreenUiState(
                        isLoading = loading,
                        errorMessage = error,
                        daysList = list
                    )
                )
            }.collect()
        }
    }

    init {
        viewModelScope.launch {
            syncDaysUseCase()
        }
    }

}