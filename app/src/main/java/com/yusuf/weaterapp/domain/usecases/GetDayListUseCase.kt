package com.yusuf.weaterapp.domain.usecases

import com.yusuf.weaterapp.data.room.entitiy.toDomain
import com.yusuf.weaterapp.domain.model.DayModel
import com.yusuf.weaterapp.domain.repository.LocalCardRepository
import com.yusuf.weaterapp.utils.DispatchersProvider
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class GetDayListUseCase @Inject constructor(
    private val localCardRepository: LocalCardRepository,
    private val dispatcher: DispatchersProvider,
) {
    suspend operator fun invoke(): Flow<List<DayModel>> {
        return withContext(dispatcher.io) {
            localCardRepository.getAllDays().map { it.map { card -> card.toDomain() } }
        }
    }
}