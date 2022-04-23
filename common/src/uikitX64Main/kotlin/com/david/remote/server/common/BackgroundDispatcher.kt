package com.david.remote.server.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Runnable
import platform.Foundation.NSRunLoop
import platform.Foundation.performBlock

actual val defaultDispatcher: CoroutineDispatcher
    get() = object : CoroutineDispatcher() {
        override fun dispatch(context: CoroutineContext, block: Runnable) {
            NSRunLoop.mainRunLoop().performBlock {
                block.run()
            }
        }
    }
