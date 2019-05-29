package com.rdo.octo.numberslight.list

import com.rdo.octo.numberslight.entities.NumberElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ListPresenter @Inject constructor(
    private val listView: ListView,
    private val numbersService: NumbersService
) : Callback<List<NumberElement>> {


    override fun onFailure(call: Call<List<NumberElement>>, t: Throwable) {
        listView.displayError()
    }

    override fun onResponse(call: Call<List<NumberElement>>, response: Response<List<NumberElement>>) {
        val list = response.body() ?: listOf()
        listView.displayList(list)
    }

    fun displayNumbers() {
        numbersService.getNumbers().enqueue(this)
    }

    fun onItemSelected(name: String) {

    }

}

interface ListView {
    fun displayList(numbers: List<NumberElement>)
    fun displayError()

}