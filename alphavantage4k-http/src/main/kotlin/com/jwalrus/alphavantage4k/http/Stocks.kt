package com.jwalrus.alphavantage4k.http

import com.jwalrus.alphavantage4k.data.stock.*
import org.http4k.core.Body
import org.http4k.core.HttpHandler
import org.http4k.format.Jackson.auto

internal object Quote : Endpoint<GlobalQuote> {
    override val function = "GLOBAL_QUOTE"
    override val lens = Body.auto<GlobalQuote>().toLens()
}

internal object Daily : Endpoint<DailySeries> {
    override val function: String = "TIME_SERIES_DAILY"
    override val lens = Body.auto<DailySeries>().toLens()
}

internal object DailyAdjusted : Endpoint<DailyAdjustedSeries> {
    override val function = "TIME_SERIES_DAILY_ADJUSTED"
    override val lens = Body.auto<DailyAdjustedSeries>().toLens()
}

internal object Weekly : Endpoint<WeeklySeries> {
    override val function = "TIME_SERIES_WEEKLY"
    override val lens = Body.auto<WeeklySeries>().toLens()
}

internal object WeeklyAdjusted : Endpoint<WeeklyAdjustedSeries> {
    override val function = "TIME_SERIES_WEEKLY_ADJUSTED"
    override val lens = Body.auto<WeeklyAdjustedSeries>().toLens()
}

internal object Monthly : Endpoint<MonthlySeries> {
    override val function = "TIME_SERIES_MONTHLY"
    override val lens = Body.auto<MonthlySeries>().toLens()
}

internal object MonthlyAdjusted : Endpoint<MonthlyAdjustedSeries> {
    override val function = "TIME_SERIES_MONTHLY_ADJUSTED"
    override val lens = Body.auto<MonthlyAdjustedSeries>().toLens()
}


class Stocks internal constructor(
    override val client: HttpHandler,
    override val apiKey: String
) : EndpointExecutor {

    fun daily(symbol: String, outputSize: OutputSize) =
        fetch(Daily, mapOf("symbol" to symbol, "outputsize" to outputSize.value))

    fun dailyAdjusted(symbol: String, outputSize: OutputSize) =
        fetch(DailyAdjusted, mapOf("symbol" to symbol, "outputsize" to outputSize.value))

    fun weekly(symbol: String) =
        fetch(Weekly, mapOf("symbol" to symbol))

    fun weeklyAdjusted(symbol: String) =
        fetch(WeeklyAdjusted, mapOf("symbol" to symbol))

    fun monthly(symbol: String) =
        fetch(Monthly, mapOf("symbol" to symbol))

    fun monthlyAdjusted(symbol: String) =
        fetch(MonthlyAdjusted, mapOf("symbol" to symbol))

    fun quote(symbol: String) =
        fetch(Quote, mapOf("symbol" to symbol))
}