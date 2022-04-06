### 责任链模式

```kotlin

fun main() {

    val request = Request("baidu.com", mapOf("request header 1" to "1", "request header 2" to "2"))

    val response = Chain.Builder(request, ::getResponse)
        .addInterceptor(RetryInterceptor())
        .addInterceptor(HeadersInterceptor())
        //.addInterceptor(LoggerInterceptor())
        .start()

    println("finish. $response")
}

fun getResponse(request: Request): Response {
    if (Random(System.currentTimeMillis()).nextBoolean()) {
        throw IOException()
    }
    return Response(request, "response body.", mapOf("response1" to "10", "response2" to "11"))
}

```