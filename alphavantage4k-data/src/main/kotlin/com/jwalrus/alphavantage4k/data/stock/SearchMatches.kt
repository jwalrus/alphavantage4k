package com.jwalrus.alphavantage4k.data.stock

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer
import java.time.LocalTime

data class SearchMatches(
    val bestMatches: Collection<Match>
)

data class Match(
    @JsonProperty("1. symbol")
    val symbol: String,
    @JsonProperty("2. name")
    val name: String,
    @JsonProperty("3. type")
    val type: String,
    @JsonProperty("4. region")
    val region: String,
    @JsonDeserialize(using = LocalTimeDeserializer::class)
    @JsonProperty("5. marketOpen")
    val marketOpen: LocalTime,
    @JsonDeserialize(using = LocalTimeDeserializer::class)
    @JsonProperty("6. marketClose")
    val marketClose: LocalTime,
    @JsonProperty("7. timezone")
    val timezone: String,
    @JsonProperty("8. currency")
    val currency: String,
    @JsonProperty("9. matchScore")
    val matchScore: String
)
