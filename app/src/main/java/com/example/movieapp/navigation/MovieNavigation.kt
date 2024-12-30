package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.HomeScreen
import com.example.movieapp.screens.DetailsScreen
//@Composable
//fun MovieNavigation() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){
//        composable(MovieScreens.HomeScreen.name){
//            HomeScreen(navController = navController)
//        }
//        composable(MovieScreens.DetailsScreen.name){
//            DetailsScreen(navController = navController)
//        }
//    }
//
//}


@Composable
fun MovieNavigation () {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name )
    {
        composable(MovieScreens.HomeScreen.name){
            // here we pass where this should lead us to
            HomeScreen(navController)
        }

        composable(
            MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailsScreen(navController, backStackEntry.arguments?.getString("movie"))
        }

    }
}