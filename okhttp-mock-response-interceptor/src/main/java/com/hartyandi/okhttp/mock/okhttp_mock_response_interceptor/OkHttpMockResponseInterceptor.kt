package com.hartyandi.okhttp.mock.okhttp_mock_response_interceptor

import okhttp3.Interceptor
import retrofit2.Invocation
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody


class OkHttpMockResponseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        val annotation = response.request.tag(Invocation::class.java)?.method()?.getAnnotation(MOCK::class.java)
        response.close()

        if (annotation != null) {
            return chain.proceed(chain.request())
                .newBuilder()
                .body((annotation.jsonString).toResponseBody(APPLICATION_JSON.toMediaType()))
                .code(annotation.code)
                .build()
        }

        val request = chain.request()
        return chain.proceed(request)
    }

    @Retention(AnnotationRetention.RUNTIME)
    annotation class MOCK(val code: Int, val jsonString: String)

    companion object {
        const val APPLICATION_JSON = "application/json; charset=utf-8"
    }

}