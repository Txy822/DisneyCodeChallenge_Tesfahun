package com.tes.apps.development.disneycodechallenge_tesfahun.presentation

import android.media.Rating
import com.tes.apps.development.disneycodechallenge_tesfahun.data.People

data class UiState(
    val shows: List<People> = emptyList(),
    val isLoading:Boolean =false,
    val id:Int=0,
    val error:String=""
)