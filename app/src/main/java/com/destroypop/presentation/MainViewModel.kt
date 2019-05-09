package com.destroypop.presentation

import com.destroypop.util.BaseViewModel

class MainViewModel(initialState: MainState) : BaseViewModel<MainState>(initialState) {

    fun increment() {
        setState { copy(counter = counter + 1) }
    }

    fun decrement() {
        setState { copy(counter = counter - 1) }
    }

}