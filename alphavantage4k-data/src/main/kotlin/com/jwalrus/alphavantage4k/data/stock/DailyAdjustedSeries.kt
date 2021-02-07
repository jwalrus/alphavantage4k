package com.jwalrus.alphavantage4k.data.stock

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalDateKeyDeserializer
import java.math.BigDecimal
import java.time.LocalDate

data class StockMetaData(
    @JsonProperty("1. Information")
    val information: String,
    @JsonProperty("2. Symbol")
    val symbol: String,
    @JsonProperty("3. Last Refreshed")
    val lastRefreshed: LocalDate,
    @JsonProperty("4. Output Size")
    val outputSize: String,
    @JsonProperty("5. Time Zone")
    val timezone: String
)

data class Price(
    @JsonProperty("1. open")
    val open: BigDecimal,
    @JsonProperty("2. high")
    val high: BigDecimal,
    @JsonProperty("3. low")
    val low: BigDecimal,
    @JsonProperty("4. close")
    val close: BigDecimal,
    @JsonProperty("5. adjusted close")
    val adjustedClose: BigDecimal,
    @JsonProperty("6. volume")
    val volume: Long
)

data class DailyAdjustedSeries(
    @JsonProperty("Meta Data")
    val metadata: StockMetaData,
    @JsonProperty("Time Series (Daily)")
    @JsonDeserialize(keyUsing = LocalDateKeyDeserializer::class)
    val timeSeries: Map<LocalDate, Price>
)