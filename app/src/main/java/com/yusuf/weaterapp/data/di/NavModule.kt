package com.yusuf.weaterapp.data.di

import com.yusuf.weaterapp.presentation.navigation.AppNavigator
import com.yusuf.weaterapp.presentation.navigation.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavModule {

    @Binds
    @Singleton
    fun bindNavigator(nav: AppNavigatorImpl): AppNavigator
}