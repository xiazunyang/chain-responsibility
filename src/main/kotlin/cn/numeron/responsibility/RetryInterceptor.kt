package cn.numeron.responsibility

class RetryInterceptor<I, O>(private val count: Int = 2) : Interceptor<I, O> {

    override fun intercept(chain: Interceptor.Chain<I, O>): O {
        return retry(chain)
    }

    private fun retry(chain: Interceptor.Chain<I, O>, count: Int = 0): O {
        return try {
            chain.proceed(chain.request)
        } catch (throwable: Throwable) {
            if (count < this.count) {
                println("第${count + 1}次重试 -->>")
                retry(chain, count + 1)
            } else {
                throw throwable
            }
        }
    }

}