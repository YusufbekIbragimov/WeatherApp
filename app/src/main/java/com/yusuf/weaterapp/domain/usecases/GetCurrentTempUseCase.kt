package com.yusuf.weaterapp.domain.usecases

import com.yusuf.weaterapp.data.room.entitiy.toDomain
import com.yusuf.weaterapp.domain.model.HourModel
import com.yusuf.weaterapp.domain.repository.LocalRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class GetCurrentTempUseCase @Inject constructor(
    private val localCardRepository: LocalRepository
) {
    suspend operator fun invoke(today: String, time: String): Flow<HourModel?> {
        return withContext(Dispatchers.IO) {
            localCardRepository.getCurrentTemp(today, time).map { it?.toDomain() }
        }
    }
}