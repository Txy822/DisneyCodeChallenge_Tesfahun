package com.tes.apps.development.disneycodechallenge_tesfahun.presentation

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun SelectGuestScreen(
    navController: NavController,
    viewModel:SelectGuestsViewModel = viewModel()

    ) {

    Column(
    ) {
        TopAppBars(navController = navController)
        SelectGuests(navController,viewModel)

    }
}

@Composable
fun TopAppBars(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Select Guest",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = {
                navController.navigateUp()
            }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Go back",
                )
            }
        }
    )
}

@Composable
fun SelectGuests(
    navController: NavController,
    viewModel: SelectGuestsViewModel,
    ) {
    Column(
        Modifier
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState()),
    ) {

        Spacer(modifier = Modifier.padding(10.dp))

        val uiState by viewModel.uiState.collectAsState()

        val guestNeedReservationIsChecked = remember { mutableStateOf(false) }
        val guestHaveReservationIsChecked = remember { mutableStateOf(false) }
        val namesOfGuestsHaveReservation = listOf(
            "Vincent Warner",
            "Shelly Wilson",
            "Michael Wright",
            "Christian Richardson",
            "Vincent Warner",
            "Shelly Wilson",
            "Michael Wright",
            "Christian Richardson",

            )
        val namesOfGuestsNeedReservation =
            listOf(
                "David Oconnor",
                "Kelsey Stevenson",
                "John Lynch",
                "Martin Rasmussen",
                "Kelsey Stevenson"
            )
        Column(
            modifier = Modifier
                .padding(start=30.dp)
        ) {
            Text(
                text = "These Guests Have Reservations", fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.padding(8.dp))

            GuestsHaveReservation(
                guestHaveReservationIsChecked,
                names = namesOfGuestsHaveReservation,
                viewModel
            )

            Text(
                text = "These Guests Need Reservations", fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.padding(8.dp))
            GuestsNeedReservation(
                guestNeedReservationIsChecked,
                names = namesOfGuestsNeedReservation,
                viewModel
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))
        Row(modifier = Modifier.padding(20.dp)) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Info icon",
                modifier = Modifier
                    .size(20.dp)
                    .padding(3.dp)
            )
            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                fontSize = 12.sp,
                text = "At least one Guest in the party must have a reservation. Guests without reservations must remain in the same booking party in order to enter"
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(20.dp),
            onClick = {
                Log.i("Continue ", "Continue clicked")

            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue
            ),
            shape = RoundedCornerShape(40),
            enabled = (uiState.guestHaveReservation || (uiState.guestNeedReservation && uiState.guestHaveReservation))

        ) {
            Text(
                text = "Continue",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.White
                )
            )

        }
    }
}


@Composable
fun GuestsHaveReservation(
    isChecked: MutableState<Boolean>,
    names: List<String>,
    viewModel: SelectGuestsViewModel
) {
    Column() {
        names.forEach {
            SingleGuestHaveReserve(name = it, checked = isChecked.value, viewModel)
            Spacer(modifier = Modifier.padding(8.dp))
        }

    }
}

@Composable
fun GuestsNeedReservation(
    isChecked: MutableState<Boolean>,
    names: List<String>,
    viewModel: SelectGuestsViewModel
) {
    Column() {
        names.forEach {
            SingleGuestNeedReserve(name = it, checked = isChecked.value, viewModel)
            Spacer(modifier = Modifier.padding(8.dp))
        }

    }
}

@Composable
fun SingleGuestNeedReserve(
    name: String,
    checked: Boolean,
    viewModel: SelectGuestsViewModel
) {
    val isChecked = remember { mutableStateOf(checked) }

    Row(
        horizontalArrangement = Arrangement.Center,
    ) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = {
                isChecked.value = it
                viewModel.countNeedReservationGuests(it)
            },
            enabled = true,
            colors = CheckboxDefaults.colors(Color.Gray),
            modifier = Modifier
                .padding(5.dp)
                .size(3.dp),
        )

        Spacer(modifier = Modifier.padding(2.dp))

        Text(
            text = name,
            modifier = Modifier.padding(start = 14.dp),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            color = Color.Black
        )

    }
}

@Composable
fun SingleGuestHaveReserve(
    name: String,
    checked: Boolean,
    viewModel: SelectGuestsViewModel
) {
    val isChecked = remember { mutableStateOf(checked) }

    Row(
        horizontalArrangement = Arrangement.Center,
    ) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = {
                isChecked.value = it

                viewModel.countHaveReservationGuests(it)
            },
            enabled = true,
            colors = CheckboxDefaults.colors(Color.Gray),
            modifier = Modifier
                .padding(5.dp)
                .size(3.dp),
        )

        Spacer(modifier = Modifier.padding(2.dp))

        Text(
            text = name,
            modifier = Modifier.padding(start = 14.dp),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            color = Color.Black
        )

    }
}