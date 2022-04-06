package cn.numeron.responsibility

internal class FinallyInterceptor<I, O>(private val transformer: (I) -> O) : Interceptor<I, O> {

    override fun intercept(chain: Interceptor.Chain<I, O>): O {
        return transformer(chain.request)
    }

}