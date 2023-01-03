package com.tes.apps.development.disneycodechallenge_tesfahun.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class SelectGuestsViewModel @Inject constructor(

):ViewModel() {

    private val _uiState = MutableStateFlow(UiState())

    val uiState: StateFlow<UiState> = _uiState.asStateFlow()



}