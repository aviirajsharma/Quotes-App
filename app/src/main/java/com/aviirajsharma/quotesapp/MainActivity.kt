package com.aviirajsharma.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aviirajsharma.quotesapp.presentation.screens.QuotesScreen
import dagger.hilt.android.AndroidEntryPoint


//App ka entry point hai.
//Compose UI call hota hai yaha se.
//@AndroidEntryPoint lagana zaruri hai taaki Hilt ViewModel inject kar sake.

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuotesScreen()
        }
    }
}

