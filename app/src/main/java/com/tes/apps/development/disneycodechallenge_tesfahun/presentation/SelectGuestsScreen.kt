package com.tes.apps.development.disneycodechallenge_tesfahun.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tes.apps.development.disneycodechallenge_tesfahun.R
import com.tes.apps.development.disneycodechallenge_tesfahun.core.navigation.Screen


@Composable
fun SelectGuestScreen(
    navController: NavController, viewModel: SelectGuestsViewModel = viewModel()
) {
    Column(
    ) {
        TopAppBars(navController = navController)
        SelectGuests(navController, viewModel)
    }
}

@Composable
fun TopAppBars(navController: NavController) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.select_guests),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.semantics {
                    contentDescription = "Select Guests Screen"
                })
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screen.Home.route)
            }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.cd_navigate_up)
                )
            }
        },
    )
}

@Composable
fun SelectGuests(
    navController: NavController,
    viewModel: SelectGuestsViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()
    val namesOfGuestsHaveReservation = listOf(
        "Vincent Warner",
        "Shelly Wilson",
        "Michael Wright",
        "Christian Richardson",
        "Vincent Warner",
        "Shelly Wilson",
        "Michael Wright",
        "Vincent Warner",
        "Shelly Wilson",
        "Michael Wright",
        "Christian Richardson",
        "Vincent Warner",
        "Shelly Wilson",
        "Michael Wright",
        "Vincent Warner",
        "Shelly Wilson",
        "Michael Wright",
        "Christian Richardson",
        "Vincent Warner",
        "Shelly Wilson",
        "Michael Wright",
        "Vincent Warner",
        "Shelly Wilson",
        "Michael Wright",
        "Christian Richardson",
        "Vincent Warner",
        "Shelly Wilson",
        "Michael Wright",
    )
    val namesOfGuestsNeedReservation = listOf(
        "David Oconnor",
        "Kelsey Stevenson",
        "John Lynch",
        "Martin Rasmussen",
        "Kelsey Stevenson",
        "John Lynch",
        "John Lynch",
    )

    Column(
        modifier = Modifier
            .padding(start = 16.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.these_guests_have_reservation),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .semantics { heading() }
                    .semantics {
                    contentDescription =
                        "These" + namesOfGuestsHaveReservation.size + "guests have Reservations and you selected total of " + uiState.countGuestsHaveReservation + "guests"
                })
            Spacer(modifier = Modifier.padding(8.dp))

            GuestsHaveReservation(
                names = namesOfGuestsHaveReservation, viewModel
            )
            Spacer(modifier = Modifier.padding(8.dp))

            Text(text = stringResource(id = R.string.these_guests_need_reservation),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .semantics { heading() }
                    .semantics {
                    contentDescription =
                        "These" + namesOfGuestsNeedReservation.size + "Guests Need Reservations and you selected total of " + uiState.countGuestsNeedReservation + "guests"
                }
            )

            Spacer(modifier = Modifier.padding(8.dp))
            GuestsNeedReservation(
                names = namesOfGuestsNeedReservation, viewModel
            )
        }
        Spacer(modifier = Modifier.padding(6.dp))
        Row(modifier = Modifier.padding(end = 10.dp)) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = stringResource(id = R.string.info_icon),
                modifier = Modifier
                    .size(20.dp)
                    .padding(3.dp)
            )
            Spacer(modifier = Modifier.padding(6.dp))

            Text(
                fontSize = 12.sp, text = stringResource(id = R.string.info_description)
            )
        }

        Spacer(modifier = Modifier.padding(6.dp))
        val context = LocalContext.current
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            onClick = {
                if (uiState.guestHaveReservation && (!uiState.guestNeedReservation)) {
                    navController.navigate(route = Screen.Confirmation.route)
                    // Toast.makeText(context, " To Confirmation Screen", Toast.LENGTH_SHORT).show()
                } else if (!uiState.guestHaveReservation && uiState.guestNeedReservation) {
                    Toast.makeText(
                        context,
                        "Reservation Needed, Select at least one Guest that has a reservation",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (uiState.guestHaveReservation && uiState.guestNeedReservation) {
                    navController.navigate(route = Screen.Conflict.route)
                    // Toast.makeText(context, " Mixed party, To Conflict Screen", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue
            ),
            shape = RoundedCornerShape(40),
            enabled = (uiState.guestHaveReservation || uiState.guestNeedReservation)

        ) {
            Text(text = "Continue", style = TextStyle(
                fontSize = 18.sp,
                color = Color.White,
            ), modifier = Modifier.semantics {
                contentDescription = "Continue "
            })
        }
    }
}

@Composable
fun GuestsHaveReservation(
    names: List<String>, viewModel: SelectGuestsViewModel
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .size(240.dp)
    ) {
        items(names.size) { i ->
            val name = names[i]
            SingleGuestHaveReserve(name = name, viewModel)
        }
    }
}

@Composable
fun GuestsNeedReservation(
    names: List<String>, viewModel: SelectGuestsViewModel
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .size(240.dp)
    ) {
        items(names.size) { i ->
            val name = names[i]
            SingleGuestNeedReserve(
                name = name,
                viewModel,
            )
        }
    }
}

@Composable
fun SingleGuestNeedReserve(
    name: String,
    viewModel: SelectGuestsViewModel,
) {
    var selected by remember { mutableStateOf(false) }
    val state by viewModel.uiState.collectAsState()
    val accessibilityDescriptionNameWithNumberOfListsSelected: String =
        " $name" + "is Selected, and total of " + state.countGuestsNeedReservation + "guests are selected "
    val accessibilityDescriptionNameWithNumberOfListsUnSelected: String =
        " $name" + "is Un Selected , and total of " + state.countGuestsNeedReservation + "guests are selected "

    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .semantics(mergeDescendants = true) {}
            .semantics {
                stateDescription = if (selected) {
                    accessibilityDescriptionNameWithNumberOfListsSelected
                } else {
                    accessibilityDescriptionNameWithNumberOfListsUnSelected
                }
            }
            .toggleable(
                value = selected,
                role = Role.Checkbox,
                onValueChange = {
                    selected = !selected
                    viewModel.countNeedReservationGuests(it)
                },
            )
            .padding(8.dp)
    ) {
        Checkbox(
            checked = selected,
            onCheckedChange = null,
            enabled = true,
            colors = CheckboxDefaults.colors(Color.Green),
        )
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 6.dp)
        )
    }
}

@Composable
fun SingleGuestHaveReserve(
    name: String,
    viewModel: SelectGuestsViewModel,
) {
    val state by viewModel.uiState.collectAsState()
    var selected by remember { mutableStateOf(false) }
    val accessibilityDescriptionNameWithNumberOfListsSelected: String =
        " $name" + "is Selected, and total of " + state.countGuestsHaveReservation + "guests are selected "
    val accessibilityDescriptionNameWithNumberOfListsUnSelected: String =
        " $name" + "is Un Selected , and total of " + state.countGuestsHaveReservation + "guests are selected "
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .semantics(mergeDescendants = true) {}
            .semantics {
                stateDescription = if (selected) {
                    accessibilityDescriptionNameWithNumberOfListsSelected
                } else {
                    accessibilityDescriptionNameWithNumberOfListsUnSelected
                }
            }
            .toggleable(value = selected, role = Role.Checkbox, onValueChange = {
                selected = !selected
                viewModel.countHaveReservationGuests(it)
            })
            .padding(8.dp)
    ) {
        Checkbox(
            checked = selected,
            onCheckedChange = null,
            enabled = true,
            colors = CheckboxDefaults.colors(Color.Green),
        )
        Text(
            text = name,
            modifier = Modifier.padding(start = 6.dp),
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            color = Color.Black
        )
    }
}