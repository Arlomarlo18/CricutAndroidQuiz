package com.bhiapps.cricutandroidquiz.viewModel.quizViewModelGroup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bhiapps.cricutandroidquiz.utils.DataStoreManager

class QuizViewModelFactory(private val dataStoreManager: DataStoreManager) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuizViewModel(dataStoreManager = dataStoreManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}