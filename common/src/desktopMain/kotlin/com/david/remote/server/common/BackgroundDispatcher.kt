package com.david.remote.server.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


actual val defaultDispatcher: CoroutineDispatcher
    get() = Dispatchers.Default