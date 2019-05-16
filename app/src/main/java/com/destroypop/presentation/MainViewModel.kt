package com.destroypop.presentation

import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.destroypop.data.CatRepository
import com.destroypop.domain.CatInteractor
import com.destroypop.util.BaseViewModel
import kotlinx.coroutines.delay

class MainViewModel(
    initialState: MainState,
    val catInteractor: CatInteractor
) : BaseViewModel<MainState>(initialState) {

    init {
        loadACat()
    }

    fun increment() {
        setState { copy(counter = counter + 1) }
    }

    fun decrement() {
        setState { copy(counter = counter - 1) }
    }

    fun loadACat() {
        executeIO({
            delay(4000)
            catInteractor.getRandomCat()
        }) {
            copy(currentCatState = it, currentCat = it())
        }
    }

    companion object : MvRxViewModelFactory<MainViewModel, MainState> {

        override fun create(viewModelContext: ViewModelContext, state: MainState): MainViewModel? {
            val repository: MainServiceLocator = viewModelContext.activity<MainActivity>().getServiceLocator()
            return MainViewModel(state, repository.getInteractor())
        }

    }

}