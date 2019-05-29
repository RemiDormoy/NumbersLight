package com.rdo.octo.numberslight.detail

import com.rdo.octo.numberslight.entities.NumberDetail

interface DetailView {

    fun displayError()

    fun displayDetail(numberDetail: NumberDetail)
}
