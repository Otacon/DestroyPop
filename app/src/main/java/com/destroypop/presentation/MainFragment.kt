package com.destroypop.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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
        getRandomCatButton.setOnClickListener {
            mainViewModel.loadACat()
        }
    }

    override fun invalidate() {
        withState(mainViewModel) { state ->
            renderState(state)

            counter.text = "${state.counter}"

            Glide.with(image)
                .load(state.currentCat?.url)
                .apply(RequestOptions.centerCropTransform())
                .into(image)
        }
    }

    private fun renderState(state: MainState) {
        val visibility = when (state.currentCatState) {
            is Loading -> View.VISIBLE
            else -> View.GONE
        }

        catLoading.visibility = visibility
    }

}