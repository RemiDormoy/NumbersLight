package com.rdo.octo.numberslight

import com.rdo.octo.numberslight.detail.DetailComponent
import com.rdo.octo.numberslight.detail.DetailModule
import com.rdo.octo.numberslight.list.ListComponent
import com.rdo.octo.numberslight.list.ListModule
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Component(modules = [MainModule::class])
interface MainComponent {

    fun plus(module: ListModule): ListComponent
    fun plus(module: DetailModule): DetailComponent
}

@Module
object MainModule {

    @JvmStatic
    @Provides
    fun providesRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("http://dev.tapptic.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @JvmStatic
    @Provides
    fun providesOkhttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = if (BuildConfig.LOG_ENABLED) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }
}
