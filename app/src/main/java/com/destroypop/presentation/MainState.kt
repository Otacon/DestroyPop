package com.destroypop.presentation

import com.airbnb.mvrx.MvRxState

data class MainState(
    val counter: Int = 0,
    val isSelected: Boolean = false
) : MvRxState {

}