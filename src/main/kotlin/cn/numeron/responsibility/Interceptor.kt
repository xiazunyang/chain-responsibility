package cn.numeron.responsibility

interface Interceptor<I, O> {

    fun intercept(chain: Chain<I, O>): O

    interface Chain<I, O> {
        val request: I
        fun proceed(request: I): O
    }

}