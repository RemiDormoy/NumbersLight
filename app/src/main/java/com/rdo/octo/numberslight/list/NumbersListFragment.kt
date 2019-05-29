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
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cell_number.view.*
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class NumbersListFragment : Fragment(), ListView{

    @Inject
    lateinit var presenter: ListPresenter

    private val adapter : NumbersAdapter by lazy {
        NumbersAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.fragment_list, container, false)
        return inflate
    }

    override fun displayError() {
        Toast.makeText(requireContext(), "Une erreur est survenue", Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerMainComponent.create()
            .plus(ListModule(this))
            .inject(this)
        numbersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        numbersRecyclerView.adapter = adapter
        presenter.displayNumbers()
    }

    override fun displayList(numbers: List<NumberElement>) {
        adapter.setNumbers(numbers)
    }
}

class NumbersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var numbersList = emptyList<NumberElement>()

    override fun getItemCount() = numbersList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val number = numbersList[position]
        holder.itemView.numberTextView.text = number.name
        Picasso.get()
            .load(number.image)
            .into(holder.itemView.pictureImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.cell_number,
            parent,
            false
        )
        return object : RecyclerView.ViewHolder(
            view
        ) {}
    }

    fun setNumbers(numbers: List<NumberElement>) {
        numbersList = numbers
        notifyDataSetChanged()
    }

}