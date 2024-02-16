package com.yusuf.weaterapp.utils

class Constants {
    companion object {
        const val BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
        const val LOCATION = "Tashkent,UZ"
        const val DAYS_LIMIT = "last10days"

        /**
         *  Usually, we have to save apiKeys in gradle.properties file
         *  and you have to add gradle.properties file to .gitignore
         *  I will do that for github version
         */
        const val API_KEY = "YPQAHJ6L4T46C5C26A3B5BA72"
    }
}