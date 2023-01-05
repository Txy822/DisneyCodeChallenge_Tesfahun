package com.tes.apps.development.disneycodechallenge_tesfahun.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun  ConfirmationScreen( navController: NavController) {

    Box(modifier = Modifier.padding(start = 50.dp)
        .background(Color.Gray)) {
        Text(text = "Confirmation Screen")
    }
}