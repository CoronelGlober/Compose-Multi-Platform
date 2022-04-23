package com.david.remote.server.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun App(viewModel: SharedViewModel = SharedViewModel()) {

    var state = viewModel.flowableState.collectAsState()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { viewModel.startTimer() }) {
            Text(if (state.value.timerStarted) "Counting!! -> ${state.value.seconds}" else "Start Timer!")
        }
    }
}
