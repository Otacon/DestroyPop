package com.destroypop.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.destroypop.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseMvRxFragment() {

    private val mainViewModel: MainViewModel by fragmentViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindActions()
    }

    private fun bindActions() {
        decrementButton.setOnClickListener {
            mainViewModel.decrement()
        }
        incrementButton.setOnClickListener {
            mainViewModel.increment()
        }
    }

    override fun invalidate() {
        withState(mainViewModel) { state ->
            counter.text = "${state.counter}"
        }
    }

}