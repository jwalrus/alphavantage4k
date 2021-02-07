package com.jwalrus.alphavantage4k.http.stock

import com.jwalrus.alphavantage4k.data.stock.DailyAdjustedSeries
import com.jwalrus.alphavantage4k.data.stock.GlobalQuote
import com.jwalrus.alphavantage4k.data.stock.Quote
import com.jwalrus.alphavantage4k.http.enums.OutputSize
import org.http4k.client.Java8HttpClient
import org.http4k.core.Body
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.format.Jackson.auto

class Quote {

    private val client = Java8HttpClient()

    private val host = "www.alphavantage.co"
    private val api = "GLOBAL_QUOTE"
    private val apiKey = "DLHS8JXY7FL8RWW1"

    fun fetch(symbol: String): Quote {
        val url = "https://$host/query?function=$api&symbol=$symbol&apikey=$apiKey"
        val lens = Body.auto<GlobalQuote>().toLens()
        val request = Request(Method.GET, url)
        return lens(client(request)).globalQuote
    }
}