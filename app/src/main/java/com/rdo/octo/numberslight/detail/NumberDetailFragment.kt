package com.rdo.octo.numberslight.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rdo.octo.numberslight.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

class NumberDetailFragment(private val name: String) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get()
            .load("http://inu.tapptic.com/test/image.php?text=%E4%B8%80&size=60")
            .into(detailImageView)
        detailTextView.text = "Ichi"
        titleTextView.text = name
    }
}