package com.david.remote.server.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren

actual fun getPlatformName(): String {
    return "Desktop"
}