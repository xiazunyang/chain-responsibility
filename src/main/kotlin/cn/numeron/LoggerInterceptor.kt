package cn.numeron

import cn.numeron.responsibility.Interceptor

class LoggerInterceptor : Interceptor<Request, Response> {

    override fun intercept(chain: Interceptor.Chain<Request, Response>): Response {
        val request = chain.request
        println("----------request----------")
        println("url: ${request.url}")
        println("headers: ${request.headers}")
        val response = chain.proceed(request)
        println("----------response----------")
        println("url: ${response.request.url}")
        println("headers: ${response.headers}")
        println("body: ${response.body}")
        return response
    }

}