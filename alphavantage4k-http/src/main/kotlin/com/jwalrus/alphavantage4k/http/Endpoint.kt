package com.jwalrus.alphavantage4k.http


import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.lens.BiDiBodyLens

data class AlphaVantageResponse<T>(
    private val response: Response,
    private val deserializer: (Response) -> T
) : Response by response {
    private val _value: T by lazy { deserializer(response) }
    fun value() = _value
}


internal interface Endpoint<T> {
    val function: String
    val lens: BiDiBodyLens<T>
    fun wrap(response: Response): AlphaVantageResponse<T> = AlphaVantageResponse(response) { lens(it) }
}

internal interface EndpointExecutor {
    val client: HttpHandler
    val apiKey: String

    fun <T> fetch(endpoint: Endpoint<T>, params: Map<String, String>): AlphaVantageResponse<T> {
        val initial = Request(Method.GET, baseline)
            .query("apikey", apiKey)
            .query("function", endpoint.function)
        val request = params.entries.fold(initial) { acc, entry -> acc.query(entry.key, entry.value) }
        return endpoint.wrap(client(request))
    }

    companion object {
        private const val baseline = "https://www.alphavantage.co/query"
    }
}