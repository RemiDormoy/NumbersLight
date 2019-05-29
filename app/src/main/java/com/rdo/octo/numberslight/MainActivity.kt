package com.rdo.octo.numberslight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rdo.octo.numberslight.detail.NumberDetailFragment
import com.rdo.octo.numberslight.list.NumbersListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var hasDetailOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.rootViewNumber, NumbersListFragment())
            .commit()
    }

    fun loadDetail(name: String) {
        detailFragmentContainer?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.detailFragmentContainer, NumberDetailFragment(name))
                .commit()
        } ?: {
            hasDetailOpen = true
            supportFragmentManager.beginTransaction()
                .replace(R.id.rootViewNumber, NumberDetailFragment(name))
                .addToBackStack("detail")
                .commit()
        }.invoke()
    }

    override fun onBackPressed() {
        if (hasDetailOpen) {
            hasDetailOpen = false
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}

