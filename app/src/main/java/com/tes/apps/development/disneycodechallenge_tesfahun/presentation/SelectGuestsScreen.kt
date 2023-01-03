package com.tes.apps.development.disneycodechallenge_tesfahun.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tes.apps.development.disneycodechallenge_tesfahun.data.People

@Composable
fun SelectGuestsScreen(
    navController: NavController,
    viewModel: SelectGuestsViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBarContentForListOfShows(navController)
        LazyColumn(
            modifier = Modifier.padding(10.dp)
        ) {
            items(uiState.shows.size) { i ->
                val show = uiState.shows[i]

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {

                    ShowItem(
                        show = show,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TopAppBarContentForListOfShows(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "List of Shows",
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
fun ShowItem(
    show: People,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxWidth()
    ) {
        Text(
            text = show.name,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}

