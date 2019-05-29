package com.rdo.octo.numberslight.list

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.rdo.octo.numberslight.entities.NumberElement
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cell_number.view.*

class NumbersAdapter(private val onItemClicked: (String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var numbersList = emptyList<NumberElement>()
    private var selectedPosition = -1

    override fun getItemCount() = numbersList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val number = numbersList[position]
        holder.itemView.numberTextView.text = number.name
        Picasso.get()
            .load(number.image)
            .into(holder.itemView.pictureImageView)
        if (position != selectedPosition) {
            val outValue = TypedValue()
            holder.itemView.context.theme.resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)
            holder.itemView.numberContainer.setBackgroundResource(outValue.resourceId)
        } else {
            holder.itemView.numberContainer.setBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    android.R.color.holo_green_light
                )
            )
        }
        holder.itemView.numberContainer.setOnClickListener {
            val oldSelectedPosition = selectedPosition
            selectedPosition = position
            if (oldSelectedPosition != -1) {
                notifyItemChanged(oldSelectedPosition)
            }
            notifyItemChanged(position)
            selectedPosition = position
            onItemClicked(number.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            com.rdo.octo.numberslight.R.layout.cell_number,
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