package com.tes.apps.development.disneycodechallenge_tesfahun.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun ConfirmationScreen(navController: NavController, viewModel: SelectGuestsViewModel) {

    // Launch a coroutine bound to the scope of the composable, viewModel relaunched
    LaunchedEffect(key1 = viewModel, block = {
        viewModel.initialiseStats()
    })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Column(Modifier.align(alignment = Alignment.Center)) {
            Text(
                text = "Confirmation Screen",
                fontSize = 40.sp,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            //need improvement
            Spacer(modifier = Modifier.padding(300.dp))
            Button(
                onClick = { navController.navigateUp() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black
                ),
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(32.dp),
                shape = RoundedCornerShape(40)

            ) {
                Text(text = "Guests Select",
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier.semantics {
                        contentDescription =
                            "To Guest Select "
                    }
                )
            }
        }

    }
}