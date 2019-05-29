package com.rdo.octo.numberslight

import com.rdo.octo.numberslight.detail.DetailComponent
import com.rdo.octo.numberslight.detail.DetailModule
import com.rdo.octo.numberslight.list.ListComponent
import com.rdo.octo.numberslight.list.ListModule
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Component(modules = [MainModule::class])
interface MainComponent {

    fun plus(module: ListModule) : ListComponent
    fun plus(module: DetailModule) : DetailComponent
}

@Module
object MainModule {

    @JvmStatic
    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://dev.tapptic.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}