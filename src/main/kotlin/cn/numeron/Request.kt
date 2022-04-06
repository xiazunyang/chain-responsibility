package cn.numeron

data class Request(val url: String, val headers: Map<String, String>? = null)