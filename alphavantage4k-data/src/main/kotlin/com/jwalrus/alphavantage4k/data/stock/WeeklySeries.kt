package com.jwalrus.alphavantage4k.data.stock

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalDateKeyDeserializer
import java.time.LocalDate


data class WeeklySeries(
    @JsonProperty("Meta Data")
    val metadata: StockMetaData,
    @JsonProperty("Weekly Time Series")
    @JsonDeserialize(keyUsing = LocalDateKeyDeserializer::class)
    val timeSeries: Map<LocalDate, Price>
)