package com.david.remote.server.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.native.internal.GC

actual open class ViewModel actual constructor() {
    protected actual val viewModelScope: CoroutineScope = createViewModelScope

    actual open fun onCleared() {
        viewModelScope.coroutineContext.cancelChildren()
        dispatch_async(dispatch_get_main_queue()) { GC.collect() }
    }
}