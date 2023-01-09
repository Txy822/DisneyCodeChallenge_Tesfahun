package com.tes.apps.development.disneycodechallenge_tesfahun.core.navigation

import androidx.annotation.StringRes
import com.tes.apps.development.disneycodechallenge_tesfahun.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object GuestSelect : Screen("guestSelectRoute", R.string.guest_elect)
    object Confirmation : Screen("confirmationRoute", R.string.confirmation)
    object Conflict : Screen("conflictRoute", R.string.conflict)

    object Home:Screen("homeRoute", R.string.home)
}