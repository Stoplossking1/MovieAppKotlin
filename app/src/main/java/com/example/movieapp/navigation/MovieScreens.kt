package com.example.movieapp.navigation

import android.graphics.Movie

enum class MovieScreens {
    HomeScreen,
    DetailsScreen;
    companion object {
        // navigation function if route = homescreen return the home screen
        fun fromRoute(route: String): MovieScreens
        = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("route $route is not recognized")
        }
    }

}