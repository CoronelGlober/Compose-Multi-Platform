package com.david.remote.server.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import androidx.lifecycle.ViewModel

actual fun getPlatformName(): String {
    return "Android"
}
