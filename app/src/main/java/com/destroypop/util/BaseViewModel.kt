package com.destroypop.util

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.destroypop.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<T : MvRxState>(
    initialState: T
) : BaseMvRxViewModel<T>(initialState, debugMode = BuildConfig.DEBUG), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val job = Job()

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }

}