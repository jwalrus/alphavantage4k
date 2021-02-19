package com.jwalrus.alphavantage4k.data.stock

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.jwalrus.alphavantage4k.data.parser.LocalDateTimeKeyDeserializer
import java.time.LocalDateTime


data class IntradaySeries(
    @JsonProperty("Meta Data")
    val metadata: StockMetaData,
    @JsonAlias(value = [
        "Time Series (1min)",
        "Time Series (5min)",
        "Time Series (15min)",
        "Time Series (30min)",
        "Time Series (60min)"
    ])
    @JsonDeserialize(keyUsing = LocalDateTimeKeyDeserializer::class)
    val timeSeries: Map<LocalDateTime, Price>
)