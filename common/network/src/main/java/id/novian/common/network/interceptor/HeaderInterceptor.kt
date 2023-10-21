package id.novian.common.network.interceptor

import android.util.Log
import id.novian.common.base.Constants
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .addHeader(
                Constants.Header.AUTH_HEADER,
                "${Constants.Header.AUTH_HEADER_PREFIX} ${Constants.Header.ACCESS_TOKEN}"
            )
            .addHeader(Constants.Header.ACCEPT_HEADER, Constants.Header.JSON_ACCEPT)
            .build()

        Log.i("intercep", "invoked with ${newRequest.method}")

        return chain.proceed(newRequest)
    }
}