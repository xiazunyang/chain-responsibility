package cn.numeron

import cn.numeron.responsibility.Interceptor

class HeadersInterceptor : Interceptor<Request, Response> {

    override fun intercept(chain: Interceptor.Chain<Request, Response>): Response {
        var request = chain.request
        val headers = request.headers?.toMutableMap() ?: mutableMapOf()
        headers["intercept header 1"] = "intercept 1"
        request = request.copy(headers = headers)
        return chain.proceed(request)
    }

}