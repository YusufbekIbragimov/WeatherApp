package com.yusuf.weaterapp.domain.usecases

import com.yusuf.weaterapp.data.room.entitiy.toDomain
import com.yusuf.weaterapp.domain.model.DayModel
import com.yusuf.weaterapp.domain.repository.LocalRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class GetDayListUseCase @Inject constructor(
    private val localCardRepository: LocalRepository
) {
    suspend operator fun invoke(limit: Int): Flow<List<DayModel>> {
        return withContext(Dispatchers.IO) {
            localCardRepository.getAllDays(limit).map { it.map { card -> card.toDomain() } }
        }
    }
}