package com.jwalrus.alphavantage4k.http

import org.http4k.client.ApacheClient

class AlphaVantageClient(private val apiKey: String) {

    private val client = ApacheClient()

    fun stocks(): Stocks = Stocks(client, apiKey)
    fun fundamentals(): Fundamentals = Fundamentals(client, apiKey)
}