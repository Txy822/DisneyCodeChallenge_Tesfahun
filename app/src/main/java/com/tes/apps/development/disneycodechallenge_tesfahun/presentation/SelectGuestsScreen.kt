package com.tes.apps.development.disneycodechallenge_tesfahun.presentation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@Composable
fun Guest(
    name: String,
    id: String,
    checked: Boolean,
    okToProceed: () -> Unit,
    onCheckedChange: ((Boolean) -> Unit)
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(MaterialTheme.shapes.small)
            .requiredHeight(ButtonDefaults.MinHeight)
            .padding(4.dp)) {
        val isChecked = remember { mutableStateOf(checked) }

        Checkbox(
            checked = isChecked.value,
            onCheckedChange = {
                isChecked.value = it
                if(id.equals("haveReservation") && it){
                    okToProceed
                }
            },
            colors = CheckboxDefaults.colors(Color.Green)
        )
        Text(text = name)
    }
}

@Composable
fun Guests(
    names: List<String>,
    id: String,
    okToProceed: () -> Unit) {
    Column() {
        names.forEach {
            Guest(name = it,id, false,okToProceed){}
        }
    }
}

@Composable
fun SelectGuests(
    modifier: Modifier = Modifier,
    okToProceed: () -> Unit,

    ) {
    Column(modifier = modifier
        //.height(500.dp)
        .verticalScroll(state = rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "These Guests Have Reservations", fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 18.dp),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(14.dp))

        Guests(names = listOf("David Oconnor", "Kelsey Stevenson" , "John Lynch", "Martin Rasmussen"),"haveReservation",okToProceed)

       // Guests(names = listOf("David Oconnor", "Kelsey Stevenson" , "John Lynch", "Martin Rasmussen" , "Joshua Graham", "Carlos Lane" , "gamma", "Nicole Watkins" , "Jennifer Collins", "Alexander Hurst" , "Jordan Mills", "Mathew Young" , "Carrie Woods", "Elizabeth Pacheco" , "Heather Cunningham"),"haveReservation",okToProceed)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "These Guests Need Reservations", fontWeight = FontWeight.Bold,
             modifier = Modifier.padding(start = 18.dp),
             fontSize = 20.sp

        )
        Spacer(modifier = Modifier.height(14.dp))

        Guests(names = listOf("Vincent Warner", "Shelly Wilson" , "Michael Wright", "Christian Richardson" , "Drew Garcia", "Dylan Reed"), "noReservation",okToProceed)
        Spacer(modifier = Modifier.height(8.dp))

        Row() {
            Icon(imageVector = Icons.Default.Info, contentDescription = "Info icon", modifier = Modifier
                .size(20.dp)
                .padding(3.dp))
            Text(fontSize = 12.sp,text = "At least one Guest in the party must have a reservation. Guests without reservations must remain in the same booking party in order to enter")
        }
    }
}

@Composable
fun SelectGuestScreen(continueButton: () -> Unit,
                      navController: NavController,

                      ) {
    val okToProceed = remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier
        .padding(8.dp)){
        TopAppBars(navController =navController )

        SelectGuests(modifier = Modifier.weight(1f)){
            okToProceed.value = true
        }
        Spacer(modifier = Modifier.height(10.dp))
        var num=0
        var enableButton=true
        if(num>0){
            enableButton=false
        }
        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            onClick = {
                if(okToProceed.value){
                    Log.d("proceed","Ok to proceed")
                }
                num++
            },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.Green,
            disabledContentColor = Color.Red),
            shape = RoundedCornerShape(50),
            enabled = enableButton
        ) {
            Text(text = "Continue")
        }
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
