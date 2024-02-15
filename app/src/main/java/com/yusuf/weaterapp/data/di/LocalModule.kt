package com.yusuf.weaterapp.data.di

import com.yusuf.weaterapp.data.network.repository.LocalCardRepositoryImpl
import com.yusuf.weaterapp.data.network.repository.NetworkRepositoryImpl
import com.yusuf.weaterapp.domain.repository.LocalCardRepository
import com.yusuf.weaterapp.domain.repository.NetworkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface LocalModule {
    @Binds
    @Singleton
    fun bindLocalRepository(localRepository: LocalCardRepositoryImpl): LocalCardRepository

    @Binds
    @Singleton
    fun bindNetworkRepository(networkRepository: NetworkRepositoryImpl): NetworkRepository
}