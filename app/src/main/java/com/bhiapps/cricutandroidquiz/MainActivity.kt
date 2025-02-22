package com.bhiapps.cricutandroidquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bhiapps.cricutandroidquiz.ui.theme.CricutAndroidQuizTheme
import com.bhiapps.cricutandroidquiz.utils.DataStoreManager
import com.bhiapps.cricutandroidquiz.viewModel.quizViewModelGroup.QuizViewModel
import com.bhiapps.cricutandroidquiz.viewModel.quizViewModelGroup.QuizViewModelFactory
import com.bhiapps.cricutandroidquiz.viewModel.viewStateViewModelGroup.ViewStateViewModel
import com.bhiapps.cricutandroidquiz.views.CricutAndroidQuizApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val viewStateVM: ViewStateViewModel by viewModels()

        val factory = QuizViewModelFactory(dataStoreManager = DataStoreManager(this))
        val quizVM = ViewModelProvider(this, factory)[QuizViewModel::class.java]

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CricutAndroidQuizTheme {
                CricutAndroidQuizApp(viewStateVM, quizVM)
            }
        }
    }
}