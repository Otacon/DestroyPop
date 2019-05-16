package com.destroypop.presentation

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.destroypop.domain.model.Cat

data class MainState(
    val counter: Int = 0,
    val isSelected: Boolean = false,
    val currentCat: Cat? = null,
    val currentCatState: Async<Cat> = Uninitialized
) : MvRxState