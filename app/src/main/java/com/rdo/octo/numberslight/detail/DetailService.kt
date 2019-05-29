package com.rdo.octo.numberslight.detail

import com.rdo.octo.numberslight.entities.NumberDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DetailService {

    @GET("test/json.php")
    fun getDetail(@Query("name") name: String) : Call<NumberDetail>
}
