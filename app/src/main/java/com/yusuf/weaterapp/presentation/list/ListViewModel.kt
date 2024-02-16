package com.yusuf.weaterapp.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf.weaterapp.domain.usecases.GetCurrentTempUseCase
import com.yusuf.weaterapp.domain.usecases.GetDayListUseCase
import com.yusuf.weaterapp.domain.usecases.SyncDaysUseCase
import com.yusuf.weaterapp.presentation.navigation.AppNavigator
import com.yusuf.weaterapp.presentation.navigation.Destination
import com.yusuf.weaterapp.utils.toCelsiusString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class ListViewModel @Inject constructor(
    private val getDaysUseCase: GetDayListUseCase,
    private val getCurrentTempUseCase: GetCurrentTempUseCase,
    private val syncDaysUseCase: SyncDaysUseCase,
    private val navigator: AppNavigator
) : ViewModel() {

    private val _uiState = MutableStateFlow(ListScreenUiState())
    val uiState = _uiState.asStateFlow()

    private val _activeFilter = MutableStateFlow(uiState.value.activeFilter)
    private val _isLoading = MutableStateFlow(false)
    private val _errorMessage = MutableStateFlow("")

    init {
        viewModelScope.launch {
            _activeFilter.flatMapLatest { filter ->
                combine(
                    getDaysUseCase(filter),
                    _isLoading,
                    _errorMessage,
                    getCurrentTempUseCase(uiState.value.today, uiState.value.time),
                    _activeFilter
                ) { list, loading, error, cur, activeFilter ->
                    _uiState.emit(
                        ListScreenUiState(
                            isLoading = loading,
                            errorMessage = error,
                            daysList = list.take(activeFilter),
                            currentTemp = cur?.temp?.toCelsiusString(),
                            activeFilter = activeFilter
                        )
                    )
                }
            }.collect()
        }
    }

    init {
        viewModelScope.launch {
            syncDaysUseCase()
        }
    }

    fun setFilter(filter: Int) {
        viewModelScope.launch {
            _activeFilter.emit(filter)
        }
    }

    fun openDetails(datetime: String) {
        viewModelScope.launch {
            navigator.navigateTo(Destination.DetailsScreen(datetime))
        }
    }

}