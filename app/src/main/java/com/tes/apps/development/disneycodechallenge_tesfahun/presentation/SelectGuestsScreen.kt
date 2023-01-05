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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    continueButton: () -> Unit,
    navController: NavController,

    ) {
    val okToProceed = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        TopAppBars(navController = navController)
        SelectGuests(navController)

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

    ) {
    Column(
        Modifier
            .fillMaxWidth().verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current

        Spacer(modifier = Modifier.padding(10.dp))

        val isChecked1 = remember { mutableStateOf(false) }
        val isChecked2 = remember { mutableStateOf(false) }
        val isChecked3 = remember { mutableStateOf(false) }
        val isGuestHaveReserve = remember { mutableStateOf(false) }
        val isGuestNeedReserve = remember { mutableStateOf(false) }
        val namesOfGuestsHaveReservation = listOf(
            "Vincent Warner",
            "Shelly Wilson",
            "Michael Wright",
            "Christian Richardson",
            "Vincent Warner",
            "Shelly Wilson",
            "Michael Wright",
            "Christian Richardson",
            "Vincent Warner",
            "Shelly Wilson",
            "Michael Wright",
            "Christian Richardson",
            "Vincent Warner",
            "Shelly Wilson",
            "Michael Wright",
            "Christian Richardson",
            "Shelly Wilson",
            "Michael Wright",
            "Christian Richardson",
            "Vincent Warner",
            "Shelly Wilson",
            "Michael Wright",
            "Christian Richardson",
            "Vincent Warner",
            "Shelly Wilson",
            "Michael Wright",
            "Christian Richardson"


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
                .padding(20.dp)
        ) {
            Text(
                text = "These Guests Have Reservations", fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.padding(8.dp))

            GuestsHaveReservation(
                isChecked3,
                isGuestHaveReserve,
                names = namesOfGuestsHaveReservation
            )

            Text(
                text = "These Guests Need Reservations", fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.padding(8.dp))
            GuestsNeedReservation(
                isChecked2,
                isGuestNeedReserve,
                names = namesOfGuestsNeedReservation
            )
        }

        Spacer(modifier = Modifier.padding(20.dp))
        Row() {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Info icon",
                modifier = Modifier
                    .size(20.dp)
                    .padding(3.dp)
            )
            Text(
                fontSize = 12.sp,
                text = "At least one Guest in the party must have a reservation. Guests without reservations must remain in the same booking party in order to enter"
            )
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(10.dp),
            onClick = {
                Log.i("Continue ", "Continue clicked")

            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Green
            ),
            shape = RoundedCornerShape(30),
            enabled = isGuestHaveReserve.value || (isGuestNeedReserve.value && isGuestHaveReserve.value)
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
    isGuestHaveReserve: MutableState<Boolean>,
    names: List<String>
) {
    Column() {
        names.forEach {
            SingleGuestHaveReserve(name = it, checked = isChecked.value, isGuestHaveReserve = isGuestHaveReserve)
            Spacer(modifier = Modifier.padding(8.dp))
        }

    }
}

@Composable
fun GuestsNeedReservation(
    isChecked: MutableState<Boolean>,
    isGuestNeedReserve: MutableState<Boolean>,
    names: List<String>
) {
    Column() {
        names.forEach {
            SingleGuestNeedReserve(name = it, checked = isChecked.value, isGuestNeedReserve = isGuestNeedReserve)
            Spacer(modifier = Modifier.padding(8.dp))
        }

    }
}

@Composable
fun SingleGuestNeedReserve(
    name: String,
    checked: Boolean,
    isGuestNeedReserve: MutableState<Boolean>
) {
    val isChecked = remember { mutableStateOf(checked) }

    Row(
        horizontalArrangement = Arrangement.Center,
    ) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = {
                isChecked.value = it
                isGuestNeedReserve.value = it
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
            modifier = Modifier.width(320.dp),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            color = Color.Gray
        )

    }
}

@Composable
fun SingleGuestHaveReserve(
    name: String,
    checked: Boolean,
    isGuestHaveReserve: MutableState<Boolean>
) {
    val isChecked = remember { mutableStateOf(checked) }

    Row(
        horizontalArrangement = Arrangement.Center,
    ) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = {
                isChecked.value = it
                isGuestHaveReserve.value = it
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