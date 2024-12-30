package com.example.movieapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow

//afficher details about a movie using the id of the movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {
    val movieList = getMovies()
    val thisMovie = movieList.find { it.id == movieId.toString() }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back arrow",
                            modifier = Modifier.clickable {
                                navController.popBackStack()
                            }
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = "Movies", color = Color.Black)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) { paddingValues ->

        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)
            .fillMaxHeight()
            .fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally) {


            if(thisMovie == null) {
                Text(
                    text = "Error, this movie was not found",
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyLarge
                )

            }
                else {
                MovieRow(movie = thisMovie, {})
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalScrollableImageView(thisMovie)
            }
            


    }
    }
    }

@Composable
private fun HorizontalScrollableImageView(thisMovie: Movie) {
    Card(modifier = Modifier.padding(12.dp) .size(250.dp), elevation = CardDefaults.cardElevation(5.dp))  {
        LazyRow {
            items(thisMovie.images) { imageUrl ->
                AsyncImage(model = imageUrl, contentDescription = "image url")
            }
        }

    }
}


