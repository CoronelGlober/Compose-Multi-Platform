package com.david.remote.server.common

import kotlinx.coroutines.CoroutineDispatcher


expect val defaultDispatcher: CoroutineDispatcher

expect val uiDispatcher: CoroutineDispatcher