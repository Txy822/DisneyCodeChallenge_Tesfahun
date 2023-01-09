package com.tes.apps.development.disneycodechallenge_tesfahun.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tes.apps.development.disneycodechallenge_tesfahun.presentation.*

@Composable
fun NavGraph(navController: NavHostController, viewModel: SelectGuestsViewModel) {
    NavHost(navController, startDestination = Screen.GuestSelect.route) {
        composable(Screen.GuestSelect.route) { SelectGuestScreen(navController, viewModel) }
        composable(Screen.Confirmation.route) { ConfirmationScreen(navController, viewModel) }
        composable(Screen.Conflict.route) { ConflictScreen(navController,viewModel) }
        composable(Screen.Home.route) { HomeScreen(navController,viewModel) }
    }
}