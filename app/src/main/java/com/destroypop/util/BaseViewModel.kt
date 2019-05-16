package com.destroypop.util

import com.airbnb.mvrx.*
import com.destroypop.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<S : MvRxState>(
    initialState: S
) : BaseMvRxViewModel<S>(initialState, debugMode = BuildConfig.DEBUG), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val job = Job()

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }

    protected fun <T : Any> CoroutineScope.executeIO(
        fn: suspend () -> T,
        reducer: S.(Async<T>) -> S
    ) {
        launch(Dispatchers.IO) {
            setState { reducer(Loading()) }
            try {
                val result = fn()
                setState { reducer(Success(result)) }
            } catch (e: Exception) {
                setState { reducer(Fail(e)) }
            }
        }
    }

    protected fun <T : Any> CoroutineScope.executeDefault(
        fn: suspend () -> T,
        reducer: S.(Async<T>) -> S
    ) {
        launch(Dispatchers.Default) {
            setState { reducer(Loading()) }
            try {
                val result = fn()
                setState { reducer(Success(result)) }
            } catch (e: Exception) {
                setState { reducer(Fail(e)) }
            }
        }
    }

}