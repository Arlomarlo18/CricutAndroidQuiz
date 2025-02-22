package com.bhiapps.cricutandroidquiz.viewModel.viewStateViewModelGroup

import androidx.lifecycle.ViewModel
import com.bhiapps.cricutandroidquiz.models.enums.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewStateViewModel: ViewModel() {

    private val _viewState = MutableStateFlow(ViewState.START_GAME)
    val viewState = _viewState.asStateFlow()

    fun setViewState(viewState: ViewState) {
        _viewState.value = viewState
    }


}