package com.destroypop.presentation

import android.os.Bundle
import com.airbnb.mvrx.BaseMvRxActivity
import com.destroypop.R

class MainActivity : BaseMvRxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, MainFragment())
                .commit()
        }
    }
}
