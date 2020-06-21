package com.hartyandi.okhttp.mock.okhttp_mock_response_interceptor

import android.content.Context
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Invocation
import retrofit2.Response


//class MockInterceptor() : Interceptor {
//    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
//        val response = chain.proceed(chain.request())
//
//        val annotation =
//            response
//                .request()
//                .tag(Invocation::class.java)?.method()?.getAnnotation(MOCK::class.java)
//
//        response.close()
//
//
//        if (annotation != null) {
//            return chain
//                .proceed(chain.request())
//                .newBuilder()
//                .body(ResponseBody.create(MediaType.get(APPLICATION_JSON), annotation.jsonString))
//                .code(annotation.code)
//                .build()
//        }
//
//        val request = chain.request()
//        return chain.proceed(request)
//    }
//
//    @Retention(AnnotationRetention.RUNTIME)
//    annotation class MOCK(val code: Int, val jsonString: String)
//
//    companion object {
//        const val APPLICATION_JSON = "application/json; charset=utf-8"
//    }
//}