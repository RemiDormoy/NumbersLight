package com.rdo.octo.numberslight.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rdo.octo.numberslight.DaggerMainComponent
import com.rdo.octo.numberslight.R
import com.rdo.octo.numberslight.entities.NumberElement
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject
import com.rdo.octo.numberslight.MainActivity


class NumbersListFragment : Fragment(), ListView {

    @Inject
    lateinit var presenter: ListPresenter

    private val adapter: NumbersAdapter by lazy {
        NumbersAdapter(::onItemClicked)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun displayError() {
        Toast.makeText(requireContext(), "Une erreur est survenue", Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerMainComponent.create()
            .plus(ListModule(this))
            .inject(this)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        numbersRecyclerView.layoutManager = linearLayoutManager
        numbersRecyclerView.adapter = adapter
        presenter.displayNumbers()
    }

    override fun displayList(numbers: List<NumberElement>) {
        adapter.setNumbers(numbers)
    }

    private fun onItemClicked(name: String) {
        val activity = requireActivity()
        if (activity is MainActivity) {
            activity.loadDetail(name)
        }
    }
}

