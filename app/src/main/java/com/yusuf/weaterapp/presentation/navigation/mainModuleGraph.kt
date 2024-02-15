package com.yusuf.weaterapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import com.yusuf.weaterapp.presentation.details.DetailsScreen
import com.yusuf.weaterapp.presentation.list.ListScreen

fun NavGraphBuilder.mainModuleGraph() {
    composable(Destination.ListScreen) { ListScreen() }
    composable(Destination.DetailsScreen) { DetailsScreen() }
}