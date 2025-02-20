package com.bhiapps.cricutandroidquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bhiapps.cricutandroidquiz.ui.theme.CricutAndroidQuizTheme
import com.bhiapps.cricutandroidquiz.views.CricutAndroidQuizApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CricutAndroidQuizTheme {
                CricutAndroidQuizApp()
            }
        }
    }
}