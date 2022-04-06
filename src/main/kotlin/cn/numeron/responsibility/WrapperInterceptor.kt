package cn.numeron.responsibility

class WrapperInterceptor<I, O>(private val interceptor: Interceptor<I, O>) : Interceptor<I, O> {

    override fun intercept(chain: Interceptor.Chain<I, O>): O {
        println("${interceptor.javaClass.simpleName} run")
        return interceptor.intercept(chain)
    }

}