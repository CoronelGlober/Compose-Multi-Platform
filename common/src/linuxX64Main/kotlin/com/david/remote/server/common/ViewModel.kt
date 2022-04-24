package com.david.remote.server.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren

actual open class ViewModel actual constructor() {
    protected actual val viewModelScope: CoroutineScope = createViewModelScope

    actual open fun onCleared() {
        viewModelScope.coroutineContext.cancelChildren()
    }
}