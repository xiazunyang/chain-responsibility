package cn.numeron

data class Response(val request: Request, val body: String, val headers: Map<String, String>? = null)