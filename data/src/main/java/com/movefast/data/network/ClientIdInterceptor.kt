package com.movefast.data.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
class ClientIdInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url().toString().plus("&client_id=$CLIENT_ID")
        return chain.proceed(chain.request().newBuilder().url(url).build())
    }

    private companion object {

        private const val CLIENT_ID = "cb2856e2d99a0dcdb7e1f7b626e896a198083ba0d3b5cde55f3d728dcd3214c7"
    }
}
