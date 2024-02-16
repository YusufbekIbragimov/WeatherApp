package com.yusuf.weaterapp.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf.weaterapp.domain.usecases.GetHoursListUseCase
import com.yusuf.weaterapp.presentation.navigation.AppNavigator
import com.yusuf.weaterapp.presentation.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getHoursList: GetHoursListUseCase,
    private val navigator: AppNavigator,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val datetime =
        savedStateHandle.get<String>(Destination.DetailsScreen.DAY_NAME_KEY) ?: ""

    private val _uiState = MutableStateFlow(DetailsScreenUiState())
    val uiState = _uiState.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    private val _errorMessage = MutableStateFlow("")

    init {
        viewModelScope.launch {
            combine(
                getHoursList(datetime),
                _isLoading,
                _errorMessage
            ) { list, loading, error ->
                _uiState.emit(
                    DetailsScreenUiState(
                        isLoading = loading,
                        errorMessage = error,
                        daysList = list
                    )
                )
            }.collect()
        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            navigator.navigateBack()
        }
    }

}