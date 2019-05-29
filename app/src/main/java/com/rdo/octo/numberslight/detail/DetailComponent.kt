package com.rdo.octo.numberslight.detail

import com.rdo.octo.numberslight.utils.LocalScope
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import retrofit2.Retrofit

@LocalScope
@Subcomponent(modules = [DetailModule::class])
interface DetailComponent {

    fun inject(fragment: NumberDetailFragment)
}

@Module
class DetailModule(private val fragment: NumberDetailFragment) {

    @Provides
    fun providesView() : DetailView = fragment

    @Provides
    fun providesDetailService(retrofit: Retrofit): DetailService =
            retrofit.create(DetailService::class.java)
}