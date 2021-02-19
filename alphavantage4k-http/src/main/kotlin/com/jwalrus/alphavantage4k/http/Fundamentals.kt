package com.jwalrus.alphavantage4k.http

import com.jwalrus.alphavantage4k.data.fundamental.CompanyOverview
import com.jwalrus.alphavantage4k.data.fundamental.IncomeStatement
import org.http4k.core.Body
import org.http4k.core.HttpHandler
import org.http4k.format.Jackson.auto


internal object Overview : Endpoint<CompanyOverview> {
    override val function = "OVERVIEW"
    override val lens = Body.auto<CompanyOverview>().toLens()
}

internal object IncomeStatementEndpoint : Endpoint<IncomeStatement> {
    override val function = "INCOME_STATEMENT"
    override val lens = Body.auto<IncomeStatement>().toLens()
}


class Fundamentals internal constructor(
    override val client: HttpHandler,
    override val apiKey: String
) : EndpointExecutor {

    fun companyOverview(symbol: String) =
        fetch(Overview, mapOf("symbol" to symbol))

    fun incomeStatement(symbol: String) =
        fetch(IncomeStatementEndpoint, mapOf("symbol" to symbol))
}