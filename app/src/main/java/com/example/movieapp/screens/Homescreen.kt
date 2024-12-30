package com.example.movieapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.widgets.MovieRow
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(text = "Movies", color = Color.Black) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) { paddingValues ->

        MainContent(navController, paddingValues)
    }
}
    @Composable
        fun MainContent(
            navController: NavController,
            paddingValues: PaddingValues,
            movieList: List<Movie> = getMovies()
        ) {
            Column(modifier = Modifier.padding(paddingValues)) {
                LazyColumn(contentPadding = PaddingValues(horizontal = 19.dp)) {
                    items(items = movieList) {
                        MovieRow(movie = it) { movie ->
                            navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
//                            Log.d("movie", "MainContent: $movie")
                        }
                    }
                }
            }

        }



