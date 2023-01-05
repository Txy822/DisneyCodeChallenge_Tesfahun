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






    fun countHaveReservationGuest( countUp: Boolean) {
        var haveValue=_uiState.value.countGuestsHaveReservation
        if(countUp && haveValue>0) {
            haveValue=_uiState.value.countGuestsHaveReservation
            println(" value 1 $haveValue")
            _uiState.update { it.copy(countGuestsHaveReservation = haveValue +1,guestHaveReservation=true) }
        }
        else if(!countUp &&haveValue>0) {
            haveValue=_uiState.value.countGuestsHaveReservation
            println(" value  before2 $haveValue")
            if(haveValue==1) {
                _uiState.update {
                    it.copy(
                        countGuestsHaveReservation = haveValue - 1,
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
            haveValue=_uiState.value.countGuestsHaveReservation
            println(" value  after 2 $haveValue")
        }
        else if(!countUp && haveValue==0) {
            haveValue=_uiState.value.countGuestsHaveReservation
            println(" value 3 $haveValue")
            _uiState.update { it.copy(countGuestsHaveReservation = 0,guestHaveReservation = false) }
        }
        else if(countUp && haveValue==0) {
            haveValue=_uiState.value.countGuestsHaveReservation
            println(" value  before 4 $haveValue")
            _uiState.update { it.copy(countGuestsHaveReservation = 1, guestHaveReservation = true) }

            haveValue=_uiState.value.countGuestsHaveReservation
            println(" value  after 4 $haveValue")
        }
        else {
            haveValue=_uiState.value.countGuestsHaveReservation
            println(" value 5 $haveValue")
            _uiState.update { it.copy(countGuestsHaveReservation = 0, guestHaveReservation = false) }
        }
    }
    fun countNeedReservationGuest(countUp: Boolean){
        val needValue=_uiState.value.countGuestsNeedReservation

        if(countUp && needValue>0) {
            _uiState.update { it.copy(countGuestsNeedReservation = needValue+1,guestNeedReservation=true) }
        }
        else if(!countUp &&needValue>0) {
            if(needValue==1){
                _uiState.update { it.copy(countGuestsNeedReservation = needValue-1, guestNeedReservation = false) }
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