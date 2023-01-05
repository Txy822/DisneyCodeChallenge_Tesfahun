package com.tes.apps.development.disneycodechallenge_tesfahun.presentation

import android.media.Rating
import com.tes.apps.development.disneycodechallenge_tesfahun.data.People

data class UiState(
    val guestNeedReservation:Boolean=false,
    val guestHaveReservation:Boolean=false,
    val countGuestsHaveReservation:Int=0,
    val countGuestsNeedReservation:Int=0,
)