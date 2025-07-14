package com.aviirajsharma.quotesapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Ye app-level class hoti hai.
//Isme @HiltAndroidApp lagane se Hilt dependency injection app mein enable hota hai.
//Ye Hilt ka starting point hai.

@HiltAndroidApp
class MyApplication : Application()