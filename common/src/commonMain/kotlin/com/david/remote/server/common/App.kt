package com.david.remote.server.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun App(viewModel: SharedViewModel = SharedViewModel()) {

    val state = viewModel.flowableState.collectAsState()

    Scaffold(topBar = {
        TopAppBar {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Compose Multi Platform",
                    style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
    }) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = { viewModel.startTimer() }) {
                Text(if (state.value.timerStarted) "Counting!! -> ${state.value.seconds}" else "Start Timer!")
            }
        }
    }
}
