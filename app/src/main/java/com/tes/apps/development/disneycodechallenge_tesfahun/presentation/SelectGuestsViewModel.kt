package com.tes.apps.development.disneycodechallenge_tesfahun.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class SelectGuestsViewModel(

):ViewModel() {


    private val _uiState =MutableStateFlow(UiState())
    val uiState:StateFlow<UiState> = _uiState.asStateFlow()


    fun countHaveReservationGuests( countUp: Boolean) {
        val haveValue=_uiState.value.countGuestsHaveReservation
        if(countUp && haveValue>0) {
            _uiState.update { it.copy(countGuestsHaveReservation = haveValue +1,guestHaveReservation=true) }
        }
        else if(!countUp &&haveValue>0) {
            if(haveValue==1) {
                _uiState.update {
                    it.copy(
                        countGuestsHaveReservation = 0,
                        guestHaveReservation = false
                    )
                }
            }
            else {
                _uiState.update {
                    it.copy(
                        countGuestsHaveReservation = haveValue - 1,
                        guestHaveReservation = true
                    )
                }
            }
        }
        else if(!countUp && haveValue==0) {
            _uiState.update { it.copy(countGuestsHaveReservation = 0,guestHaveReservation = false) }
        }
        else if(countUp && haveValue==0) {
            _uiState.update { it.copy(countGuestsHaveReservation = 1, guestHaveReservation = true) }

        }
        else {
            _uiState.update { it.copy(countGuestsHaveReservation = 0, guestHaveReservation = false) }
        }
    }
    fun countNeedReservationGuests(countUp: Boolean){
        val needValue=_uiState.value.countGuestsNeedReservation

        if(countUp && needValue>0) {
            _uiState.update { it.copy(countGuestsNeedReservation = needValue+1,guestNeedReservation=true) }
        }
        else if(!countUp &&needValue>0) {
            if(needValue==1){
                _uiState.update { it.copy(countGuestsNeedReservation = 0, guestNeedReservation = false) }
            }
            else {
                _uiState.update { it.copy(countGuestsNeedReservation = needValue-1, guestNeedReservation = true) }
            }
        }
        else if(!countUp && needValue==0) {
            _uiState.update { it.copy(countGuestsNeedReservation = 0, guestNeedReservation = false) }
        }
        else if(countUp && needValue==0) {
            _uiState.update { it.copy(countGuestsNeedReservation = 1, guestNeedReservation = true) }
        }
    }

}