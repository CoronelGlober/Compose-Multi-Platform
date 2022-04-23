package com.david.remote.server.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Runnable
import platform.Foundation.NSRunLoop
import platform.Foundation.performBlock
import platform.darwin.*


actual val uiDispatcher: CoroutineDispatcher
    get() = Dispatchers.Main

actual val defaultDispatcher: CoroutineDispatcher
    get() = object: CoroutineDispatcher() {
        override fun dispatch(context: CoroutineContext, block: Runnable) {
            dispatch_async(
                dispatch_get_global_queue(
                    platform.darwin.DISPATCH_QUEUE_PRIORITY_BACKGROUND.toLong(),
                    0.toULong()
                )
            ) {
                try {
                    block.run()
                } catch (err: Throwable) {
                    throw err
                }
            }
        }
    }

@ThreadLocal
private object MainDispatcher: CoroutineDispatcher(){
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) {
            try {
                block.run()
            }catch (err: Throwable) {
                throw err
            }
        }
    }
}
//Background
private object IODispatcher: CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(
            dispatch_get_global_queue(
                DISPATCH_QUEUE_PRIORITY_DEFAULT.toLong(),
                0.toULong()
            )
        ) {
            try {
                block.run()
            } catch (err: Throwable) {
                throw err
            }
        }
    }
}