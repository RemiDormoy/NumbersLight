package com.rdo.octo.numberslight.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
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

class NumberDetailFragment : Fragment(), DetailView {

    @Inject
    lateinit var presenter: DetailPresenter

    var name: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerMainComponent.create()
            .plus(DetailModule(this))
            .inject(this)
    }

    override fun onStart() {
        super.onStart()
        name?.let { name ->
            presenter.loadDetail(name)
            retryButton.setOnClickListener { presenter.loadDetail(name) }
        }
    }

    override fun displayError() {
        retryButton.visibility = VISIBLE
        Toast.makeText(requireContext(), getString(R.string.error_ocured), Toast.LENGTH_SHORT).show()
    }

    override fun displayDetail(numberDetail: NumberDetail) {
        retryButton.visibility = GONE
        Picasso.get()
            .load(numberDetail.image)
            .into(detailImageView)
        detailTextView.text = numberDetail.text
        titleTextView.text = numberDetail.name
    }
}