package com.neilkrishna.basicapplication.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel constructor(
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState = _uiState.asStateFlow()

    fun increaseCountByOne() {
        _uiState.value = uiState.value.copy(count = uiState.value.count + 1)
    }
}