package com.yusuf.weaterapp.domain.usecases

import com.haroldadmin.cnradapter.NetworkResponse
import com.yusuf.weaterapp.data.network.response.toEntity
import com.yusuf.weaterapp.domain.repository.LocalRepository
import com.yusuf.weaterapp.domain.repository.NetworkRepository
import com.yusuf.weaterapp.utils.Constants
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class SyncDaysUseCase @Inject constructor(
    private val repository: NetworkRepository,
    private val local: LocalRepository
) {
    suspend operator fun invoke() {
        return withContext(Dispatchers.IO) {
            when (
                val result = repository.getDaysInfo(
                    Constants.API_KEY,
                    Constants.LOCATION,
                    Constants.DAYS_LIMIT
                )
            ) {
                is NetworkResponse.Success -> {
                    local.saveAllDays(result.body.days.map { it.toEntity() })
                    result.body.days.forEach { day ->
                        local.saveAllHours(day.hours.map { it.toEntity(day.datetime) })
                    }
                }

                is NetworkResponse.ServerError -> {}
                is NetworkResponse.NetworkError -> {}
                is NetworkResponse.UnknownError -> {}
            }
        }
    }
}