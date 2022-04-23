package com.david.remote.server.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val uiDispatcher: CoroutineDispatcher
    get() = Dispatchers.Main

actual val defaultDispatcher: CoroutineDispatcher
    get() = Dispatchers.Default