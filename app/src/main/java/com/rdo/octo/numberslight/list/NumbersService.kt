package com.rdo.octo.numberslight.list

import com.rdo.octo.numberslight.entities.NumberElement
import retrofit2.Call
import retrofit2.http.GET

interface NumbersService {

    @GET("test/json.php")
    fun getNumbers() : Call<List<NumberElement>>
}