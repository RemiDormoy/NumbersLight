package com.rdo.octo.numberslight.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rdo.octo.numberslight.DaggerMainComponent
import com.rdo.octo.numberslight.R
import com.rdo.octo.numberslight.entities.NumberDetail
import com.rdo.octo.numberslight.list.ListModule
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

class NumberDetailFragment(private val name: String) : Fragment(), DetailView {

    @Inject
    lateinit var presenter: DetailPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerMainComponent.create()
            .plus(DetailModule(this))
            .inject(this)
        presenter.loadDetail(name)
    }

    override fun displayError() {
        Toast.makeText(requireContext(), "Une erreur est survenue", Toast.LENGTH_SHORT).show()
    }

    override fun displayDetail(numberDetail: NumberDetail) {
        Picasso.get()
            .load(numberDetail.image)
            .into(detailImageView)
        detailTextView.text = numberDetail.text
        titleTextView.text = numberDetail.name
    }
}