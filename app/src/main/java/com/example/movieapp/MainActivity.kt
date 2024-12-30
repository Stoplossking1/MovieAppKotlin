package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.ui.theme.MovieAppTheme
import androidx.compose.material3.*
import com.example.movieapp.navigation.MovieNavigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp{
            MovieNavigation()
        }}
    }
}

// receives a content param which is a lamda composabel that return nothing
@OptIn(ExperimentalMaterial3Api::class)
@Composable fun MyApp(content : @Composable () -> Unit){
    MovieAppTheme {
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp {
        MovieNavigation()
    }
}