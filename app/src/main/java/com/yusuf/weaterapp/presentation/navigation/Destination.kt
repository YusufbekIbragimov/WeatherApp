package com.yusuf.weaterapp.presentation.navigation

sealed class Destination(protected val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else buildString {
        append(route)
        params.forEach { append("/{$it}") }
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke(): String = route
    }

    data object ListScreen : NoArgumentsDestination(LIST_SCREEN_ROUTE)

    data object DetailsScreen : Destination(DETAILS_SCREEN_ROUTE, ParamKeys.DAY_NAME_KEY) {
        const val DAY_NAME_KEY = ParamKeys.DAY_NAME_KEY
        operator fun invoke(cardId: Int): String {
            return route.appendParams(DAY_NAME_KEY to cardId)
        }
    }

    companion object {
        private const val LIST_SCREEN_ROUTE = "list_screen"
        private const val DETAILS_SCREEN_ROUTE = "details_screen"
    }
}

private object ParamKeys {
    const val DAY_NAME_KEY = "datetime"
}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)

    params.forEach {
        it.second?.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }

    return builder.toString()
}