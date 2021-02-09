package com.jwalrus.alphavantage4k.http

import com.jwalrus.alphavantage4k.data.stock.DailyAdjustedSeries
import com.jwalrus.alphavantage4k.data.stock.GlobalQuote
import org.http4k.core.Body
import org.http4k.core.HttpHandler
import org.http4k.format.Jackson.auto

internal object Quote : Endpoint<GlobalQuote> {
    override val function = "GLOBAL_QUOTE"
    override val lens = Body.auto<GlobalQuote>().toLens()
}

internal object DailyAdjusted : Endpoint<DailyAdjustedSeries> {
    override val function = "TIME_SERIES_DAILY_ADJUSTED"
    override val lens = Body.auto<DailyAdjustedSeries>().toLens()
}

class Stocks internal constructor(
    override val client: HttpHandler,
    override val apiKey: String
) : EndpointExecutor {

    fun dailyAdjusted(symbol: String, outputSize: OutputSize) =
        fetch(DailyAdjusted, mapOf("symbol" to symbol, "outputsize" to outputSize.value))

    fun quote(symbol: String) =
        fetch(Quote, mapOf("symbol" to symbol))
}