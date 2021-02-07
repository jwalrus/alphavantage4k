package com.jwalrus.alphavantage4k.data.stock

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.jwalrus.alphavantage4k.data.parser.PercentDeserializer
import java.math.BigDecimal
import java.time.LocalDate

data class Quote(
    @JsonProperty("01. symbol")
    val symbol: String,
    @JsonProperty("02. open")
    val open: BigDecimal,
    @JsonProperty("03. high")
    val high: BigDecimal,
    @JsonProperty("04. low")
    val low: BigDecimal,
    @JsonProperty("05. price")
    val price: BigDecimal,
    @JsonProperty("06. volume")
    val volume: Long,
    @JsonProperty("07. latest trading day")
    @JsonDeserialize(using = LocalDateDeserializer::class)
    val latestTradingDate: LocalDate,
    @JsonProperty("08. previous close")
    val previousClose: BigDecimal,
    @JsonProperty("09. change")
    val change: BigDecimal,
    @JsonProperty("10. change percent")
    @JsonDeserialize(using = PercentDeserializer::class)
    val changePercent: BigDecimal
)

data class GlobalQuote(
    @JsonProperty("Global Quote")
    val globalQuote: Quote
)