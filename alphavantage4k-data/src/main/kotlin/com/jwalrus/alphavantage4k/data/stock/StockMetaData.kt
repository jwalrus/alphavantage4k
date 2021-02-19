package com.jwalrus.alphavantage4k.data.stock

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty

data class StockMetaData(
    @JsonProperty("1. Information")
    val information: String,
    @JsonProperty("2. Symbol")
    val symbol: String,
    @JsonProperty("3. Last Refreshed")
    val lastRefreshed: String,
    @JsonProperty("4. Interval")
    val interval: String? = null,
    @JsonAlias(value = ["5. Output Size", "4. Output Size"])
    val outputSize: String? = null,
    @JsonAlias(value = ["6. Time Zone", "5. Time Zone", "4. Time Zone"])
    val timezone: String
)