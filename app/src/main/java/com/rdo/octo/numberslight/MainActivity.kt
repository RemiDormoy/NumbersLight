package com.rdo.octo.numberslight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rdo.octo.numberslight.detail.NumberDetailFragment
import com.rdo.octo.numberslight.list.NumbersListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val BUNDLE_NAME = "name"
    }

    private var detailOpen: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.rootViewNumber, NumbersListFragment())
            .commit()
        savedInstanceState?.let {
            it.getString(BUNDLE_NAME)?.let { name ->
                loadDetail(name)
            }
        }
    }

    fun loadDetail(name: String) {
        detailOpen = name
        detailFragmentContainer?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.detailFragmentContainer, NumberDetailFragment().apply { this.name = name })
                .commit()
        } ?: {
            supportFragmentManager.beginTransaction()
                .replace(R.id.rootViewNumber, NumberDetailFragment().apply { this.name = name })
                .addToBackStack("detail")
                .commit()
        }.invoke()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        detailOpen?.let {
            outState.putString(BUNDLE_NAME, it)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        if (detailOpen != null) {
            detailOpen = null
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}

