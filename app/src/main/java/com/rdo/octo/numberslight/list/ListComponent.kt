package com.rdo.octo.numberslight.list

import com.rdo.octo.numberslight.utils.LocalScope
import dagger.*
import retrofit2.Retrofit

@LocalScope
@Subcomponent(modules = [ListModule::class])
interface ListComponent {

    fun inject(fragment: NumbersListFragment)
}

@Module
class ListModule(private val fragment: NumbersListFragment) {

    @Provides
    fun providesFragment(): ListView = fragment

    @Provides
    fun providesNumbersService(retrofit: Retrofit): NumbersService =
        retrofit.create(NumbersService::class.java)
}
