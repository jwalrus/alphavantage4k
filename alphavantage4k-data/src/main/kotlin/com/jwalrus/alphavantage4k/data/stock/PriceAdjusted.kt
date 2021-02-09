package com.jwalrus.alphavantage4k.data.stock

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal


data class PriceAdjusted(
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