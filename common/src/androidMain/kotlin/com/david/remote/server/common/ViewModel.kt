package com.david.remote.server.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import androidx.lifecycle.viewModelScope as viewModelScopeExt

actual open class ViewModel actual constructor() : ViewModel() {

     actual val viewModelScope: CoroutineScope = viewModelScopeExt

    public actual override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}