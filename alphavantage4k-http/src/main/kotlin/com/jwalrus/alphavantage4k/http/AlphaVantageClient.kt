package com.jwalrus.alphavantage4k.http

import com.jwalrus.alphavantage4k.data.stock.DailyAdjustedSeries
import com.jwalrus.alphavantage4k.data.stock.GlobalQuote
import com.jwalrus.alphavantage4k.data.stock.Quote
import com.jwalrus.alphavantage4k.http.enums.OutputSize
import org.http4k.client.Java8HttpClient
import org.http4k.core.Body
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.format.Jackson.auto

class AlphaVantageClient(private val apiKey: String) {

    companion object {
        private val host = "www.alphavantage.co"
    }

    private val client = Java8HttpClient()

    private fun genUrl(endpoint: String) = "https://$host/$endpoint&apikey=$apiKey"

    fun dailyAdjusted(symbol: String, outputSize: OutputSize): DailyAdjustedSeries {
        val func = "TIME_SERIES_DAILY_ADJUSTED"
        val url = genUrl("/query?function=$func&symbol=$symbol&outputsize=${outputSize.value}")
        val lens = Body.auto<DailyAdjustedSeries>().toLens()
        val request = Request(Method.GET, url)
        return lens(client(request))
    }

    fun quote(symbol: String): Quote {
        val func = "GLOBAL_QUOTE"
        val url = genUrl("/query?function=$func&symbol=$symbol")
        val lens = Body.auto<GlobalQuote>().toLens()
        val request = Request(Method.GET, url)
        return lens(client(request)).globalQuote
    }
}