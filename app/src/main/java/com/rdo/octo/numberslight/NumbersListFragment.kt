package com.rdo.octo.numberslight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rdo.octo.numberslight.entities.NumberElement
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cell_number.view.*
import kotlinx.android.synthetic.main.fragment_list.*

class NumbersListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.fragment_list, container, false)
        return inflate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numbersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        numbersRecyclerView.adapter = NumbersAdapter()
    }

    override fun onStart() {
        super.onStart()
    }

}

class NumbersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val numbersList = listOf(
        NumberElement("1", "http://inu.tapptic.com/test/image.php?text=%E4%B8%80"),
        NumberElement("2", "http://inu.tapptic.com/test/image.php?text=%E4%BA%8C"),
        NumberElement("3", "http://inu.tapptic.com/test/image.php?text=%E4%B8%89"),
        NumberElement("4", "http://inu.tapptic.com/test/image.php?text=%E5%9B%9B"),
        NumberElement("5", "http://inu.tapptic.com/test/image.php?text=%E4%BA%94"),
        NumberElement("6", "http://inu.tapptic.com/test/image.php?text=%E5%85%AD"),
        NumberElement("7", "http://inu.tapptic.com/test/image.php?text=%E4%B8%83"),
        NumberElement("8", "http://inu.tapptic.com/test/image.php?text=%E5%85%AB"),
        NumberElement("9", "http://inu.tapptic.com/test/image.php?text=%E4%B9%9D"),
        NumberElement("10", "http://inu.tapptic.com/test/image.php?text=%E5%8D%81"),
        NumberElement("11", "http://inu.tapptic.com/test/image.php?text=%E5%8D%81%E4%B8%80"),
        NumberElement("12", "http://inu.tapptic.com/test/image.php?text=%E5%8D%81%E4%BA%8C"),
        NumberElement("13", "http://inu.tapptic.com/test/image.php?text=%E5%8D%81%E4%B8%89"),
        NumberElement("14", "http://inu.tapptic.com/test/image.php?text=%E5%8D%81%E5%9B%9B"),
        NumberElement("15", "http://inu.tapptic.com/test/image.php?text=%E5%8D%81%E4%BA%94"),
        NumberElement("16", "http://inu.tapptic.com/test/image.php?text=%E5%8D%81%E5%85%AD"),
        NumberElement("17", "http://inu.tapptic.com/test/image.php?text=%E5%8D%81%E4%B8%83"),
        NumberElement("18", "http://inu.tapptic.com/test/image.php?text=%E5%8D%81%E5%85%AB"),
        NumberElement("19", "http://inu.tapptic.com/test/image.php?text=%E5%8D%81%E4%B9%9D"),
        NumberElement("20", "http://inu.tapptic.com/test/image.php?text=%E4%BA%8C%E5%8D%81"),
        NumberElement("21", "http://inu.tapptic.com/test/image.php?text=%E4%BA%8C%E5%8D%81%E4%B8%80"),
        NumberElement("22", "http://inu.tapptic.com/test/image.php?text=%E4%BA%8C%E5%8D%81%E4%BA%8C"),
        NumberElement("23", "http://inu.tapptic.com/test/image.php?text=%E4%BA%8C%E5%8D%81%E4%B8%89"),
        NumberElement("30", "http://inu.tapptic.com/test/image.php?text=%E4%B8%89%E5%8D%81"),
        NumberElement("31", "http://inu.tapptic.com/test/image.php?text=%E4%B8%89%E5%8D%81%E4%B8%80"),
        NumberElement("32", "http://inu.tapptic.com/test/image.php?text=%E4%B8%89%E5%8D%81%E4%BA%8C"),
        NumberElement("40", "http://inu.tapptic.com/test/image.php?text=%E5%9B%9B%E5%8D%81"),
        NumberElement("41", "http://inu.tapptic.com/test/image.php?text=%E5%9B%9B%E5%8D%81%E4%B8%80"),
        NumberElement("42", "http://inu.tapptic.com/test/image.php?text=%E5%9B%9B%E5%8D%81%E4%BA%8C"),
        NumberElement("50", "http://inu.tapptic.com/test/image.php?text=%E4%BA%94%E5%8D%81"),
        NumberElement("51", "http://inu.tapptic.com/test/image.php?text=%E4%BA%94%E5%8D%81%E4%B8%80"),
        NumberElement("52", "http://inu.tapptic.com/test/image.php?text=%E4%BA%94%E5%8D%81%E4%BA%8C"),
        NumberElement("60", "http://inu.tapptic.com/test/image.php?text=%E5%85%AD%E5%8D%81"),
        NumberElement("61", "http://inu.tapptic.com/test/image.php?text=%E5%85%AD%E5%8D%81%E4%B8%80"),
        NumberElement("70", "http://inu.tapptic.com/test/image.php?text=%E4%B8%83%E5%8D%81"),
        NumberElement("71", "http://inu.tapptic.com/test/image.php?text=%E4%B8%83%E5%8D%81%E4%B8%80"),
        NumberElement("80", "http://inu.tapptic.com/test/image.php?text=%E5%85%AB%E5%8D%81"),
        NumberElement("81", "http://inu.tapptic.com/test/image.php?text=%E5%85%AB%E5%8D%81%E4%B8%80"),
        NumberElement("90", "http://inu.tapptic.com/test/image.php?text=%E4%B9%9D%E5%8D%81"),
        NumberElement("91", "http://inu.tapptic.com/test/image.php?text=%E4%B9%9D%E5%8D%81%E4%B8%80"),
        NumberElement("100", "http://inu.tapptic.com/test/image.php?text=%E7%99%BE"),
        NumberElement("150", "http://inu.tapptic.com/test/image.php?text=%E7%99%BE%E4%BA%94%E5%8D%81"),
        NumberElement("200", "http://inu.tapptic.com/test/image.php?text=%E4%BA%8C%E7%99%BE"),
        NumberElement("300", "http://inu.tapptic.com/test/image.php?text=%E4%B8%89%E7%99%BE"),
        NumberElement("1000", "http://inu.tapptic.com/test/image.php?text=%E5%8D%83"),
        NumberElement("1500", "http://inu.tapptic.com/test/image.php?text=%E5%8D%83%E4%BA%94%E7%99%BE"),
        NumberElement("2000", "http://inu.tapptic.com/test/image.php?text=%E4%BA%8C%E5%8D%83"),
        NumberElement("10,000", "http://inu.tapptic.com/test/image.php?text=%E4%B8%80%E4%B8%87"),
        NumberElement("100,000", "http://inu.tapptic.com/test/image.php?text=%E5%8D%81%E4%B8%87"),
        NumberElement("1,000,000", "http://inu.tapptic.com/test/image.php?text=%E7%99%BE%E4%B8%87"),
        NumberElement("10,000,000", "http://inu.tapptic.com/test/image.php?text=%E5%8D%83%E4%B8%87"),
        NumberElement("100,000,000", "http://inu.tapptic.com/test/image.php?text=%E4%B8%80%E5%84%84")
    )

    override fun getItemCount() = numbersList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val number = numbersList[position]
        holder.itemView.numberTextView.text = number.name
        Picasso.get()
            .load(number.imageUrl)
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

}