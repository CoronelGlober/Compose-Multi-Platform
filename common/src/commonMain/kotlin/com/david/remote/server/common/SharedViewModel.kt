package com.david.remote.server.common

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.native.concurrent.ThreadLocal


data class State(val timerStarted: Boolean = false, val seconds: Int = 0)


class SharedViewModel : ViewModel() {

    private val state: MutableStateFlow<State> = MutableStateFlow(State())
    val flowableState = state.asStateFlow()
    val context = viewModelScope.coroutineContext

    fun startTimer() {
        viewModelScope.launch {
            println("Starting timer")
            withContext(defaultDispatcher) {
                while (true) {
                    delay(1000)
                    println("setting a new second ${state.value.seconds}")
                    state.value = State(true, state.value.seconds + 1)
                }
            }
        }
    }
}

@ThreadLocal
val createViewModelScope = CoroutineScope(defaultDispatcher + SupervisorJob())
