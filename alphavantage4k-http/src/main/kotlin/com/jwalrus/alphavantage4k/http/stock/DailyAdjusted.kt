package com.jwalrus.alphavantage4k.http.stock

import com.jwalrus.alphavantage4k.data.stock.DailyAdjustedSeries
import com.jwalrus.alphavantage4k.http.enums.OutputSize
import org.http4k.client.Java8HttpClient
import org.http4k.core.Body
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.format.Jackson.auto

class DailyAdjusted {

    private val client = Java8HttpClient()

    private val host = "www.alphavantage.co"
    private val api = "TIME_SERIES_DAILY_ADJUSTED"
    private val apiKey = "DLHS8JXY7FL8RWW1"

    fun fetch(symbol: String, outputSize: OutputSize): DailyAdjustedSeries {
        val url = "https://$host/query?function=$api&symbol=$symbol&outputsize=${outputSize.value}&apikey=$apiKey"
        val stockLens = Body.auto<DailyAdjustedSeries>().toLens()
        val request = Request(Method.GET, url)
        return stockLens(client(request))
    }
}