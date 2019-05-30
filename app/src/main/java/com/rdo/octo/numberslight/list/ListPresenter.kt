package com.rdo.octo.numberslight.list

import com.rdo.octo.numberslight.entities.NumberElement
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ListPresenter @Inject constructor(
    private val listView: ListView,
    private val numbersService: NumbersService
) {

    fun displayNumbers() {
        Single.create<List<NumberElement>> { emitter ->
            emitter.onSuccess(numbersService.getNumbers().execute().body() ?: emptyList())
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                listView.displayError()
            }
            .doOnSuccess {
                listView.displayList(it)
            }
            .subscribe()
    }

}

interface ListView {
    fun displayList(numbers: List<NumberElement>)
    fun displayError()

}