package cn.numeron.responsibility

class Chain<I, O> private constructor(
    override val request: I,
    private val interceptors: List<Interceptor<I, O>>,
    private val index: Int = 0
) : Interceptor.Chain<I, O> {

    override fun proceed(request: I): O {
        val nextChain = Chain(request, interceptors, index + 1)
        return interceptors[index].intercept(nextChain)
    }

    class Builder<I, O>(private val input: I, private val transformer: Function1<I, O>) {

        private val list = mutableListOf<Interceptor<I, O>>()

        fun addInterceptor(interceptor: Interceptor<I, O>): Builder<I, O> {
            list += interceptor
            return this
        }

        fun start(): O {
            list.add(FinallyInterceptor(transformer))
            val chain = Chain(input, list.map(::WrapperInterceptor))
            return chain.proceed(input)
        }

    }

}