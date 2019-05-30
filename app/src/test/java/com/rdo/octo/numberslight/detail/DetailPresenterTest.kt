package com.rdo.octo.numberslight.detail

import com.rdo.octo.numberslight.entities.NumberDetail
import okhttp3.Request
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.BDDMockito.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalStateException

@RunWith(MockitoJUnitRunner::class)
class DetailPresenterTest {

    @Mock
    private lateinit var view: DetailView
    @Mock
    private lateinit var service: DetailService
    @InjectMocks
    private lateinit var presenter: DetailPresenter

    @Test
    fun `loadDetail should call display detail when response from service is successfull`() {
        // Given
        val detail = NumberDetail("name", "image", "text")
        given(service.getDetail("name")).willReturn(SuccessCall(detail))

        // When
        presenter.loadDetail("name")

        // Then
        then(view).should(Mockito.only()).displayDetail(detail)
    }

    @Test
    fun `loadDetail should call display error when response from service is a failure`() {
        // Given
        given(service.getDetail("name")).willReturn(FailedCall(RuntimeException()))

        // When
        presenter.loadDetail("name")

        // Then
        then(view).should(Mockito.only()).displayError()
    }
}

class SuccessCall<T>(private val response: T) : Call<T> {
    override fun enqueue(callback: Callback<T>) {
        callback.onResponse(this, Response.success(response))
    }

    override fun isExecuted(): Boolean {
        throw IllegalStateException("shoud not be called")
    }

    override fun clone(): Call<T> {
        throw IllegalStateException("shoud not be called")
    }

    override fun isCanceled(): Boolean {
        throw IllegalStateException("shoud not be called")
    }

    override fun cancel() {
        throw IllegalStateException("shoud not be called")
    }

    override fun execute(): Response<T> {
        throw IllegalStateException("shoud not be called")
    }

    override fun request(): Request {
        throw IllegalStateException("shoud not be called")
    }
}

class FailedCall<T>(private val error: Throwable) : Call<T> {
    override fun enqueue(callback: Callback<T>) {
        callback.onFailure(this, error)
    }

    override fun isExecuted(): Boolean {
        throw IllegalStateException("shoud not be called")
    }

    override fun clone(): Call<T> {
        throw IllegalStateException("shoud not be called")
    }

    override fun isCanceled(): Boolean {
        throw IllegalStateException("shoud not be called")
    }

    override fun cancel() {
        throw IllegalStateException("shoud not be called")
    }

    override fun execute(): Response<T> {
        throw IllegalStateException("shoud not be called")
    }

    override fun request(): Request {
        throw IllegalStateException("shoud not be called")
    }
}
