package com.jwalrus.alphavantage4k.data.fundamental

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import java.math.BigDecimal
import java.math.BigInteger
import java.time.LocalDate

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy::class)
data class CompanyOverview(
    val symbol: String,
    val assetType: String,
    val name: String,
    val description: String,
    val exchange: String,
    val currency: String,
    val country: String,
    val sector: String,
    val industry: String,
    val address: String,
    val fullTimeEmployees: Int,
    val fiscalYearEnd: String,
    @JsonDeserialize(using = LocalDateDeserializer::class)
    val latestQuarter: LocalDate,
    val marketCapitalization: BigInteger,
    @JsonProperty("EBITDA")
    val ebitda: BigInteger,
    @JsonProperty("PERatio")
    val peRatio: BigDecimal,
    @JsonProperty("PEGRatio")
    val pegRation: BigDecimal,
    val bookValue: BigDecimal,
    val dividendPerShare: BigDecimal,
    val dividendYield: BigDecimal,
    @JsonProperty("EPS")
    val eps: BigDecimal,
    val revenuePerShareTTM: BigDecimal,
    val profitMargin: BigDecimal,
    val operatingMarginTTM: BigDecimal,
    val returnOnAssetsTTM: BigDecimal,
    val returnOnEquityTTM: BigDecimal,
    val revenueTTM: BigDecimal,
    val grossProfitTTM: BigDecimal,
    val dilutedEPSTTM: BigDecimal,
    val quarterlyEarningsGrowthYOY: BigDecimal,
    val quarterlyRevenueGrowthYOY: BigDecimal,
    val analystTargetPrice: BigDecimal,
    val trailingPE: BigDecimal,
    val forwardPE: BigDecimal,
    val priceToSalesRatioTTM: BigDecimal,
    val priceToBookRatio: BigDecimal,
    @JsonProperty("EVToRevenue")
    val evToRevenue: BigDecimal,
    @JsonProperty("EVToEBITDA")
    val evToEBITDA: BigDecimal,
    val beta: BigDecimal,
    @JsonProperty("52WeekHigh")
    val high52Week: BigDecimal,
    @JsonProperty("52WeekLow")
    val low52Week: BigDecimal,
    @JsonProperty("50DayMovingAverage")
    val movingAverage50Day: BigDecimal,
    @JsonProperty("200DayMovingAverage")
    val movingAverage200Day: BigDecimal,
    val sharesOutstanding: BigInteger,
    val sharesFloat: BigInteger,
    val sharesShort: BigInteger,
    val sharesShortPriorMonth: BigInteger,
    val shortRatio: BigDecimal,
    val shortPercentOutstanding: BigDecimal,
    val shortPercentFloat: BigDecimal,
    val percentInsiders: BigDecimal,
    val percentInstitutions: BigDecimal,
    val forwardAnnualDividendRate: BigDecimal,
    val forwardAnnualDividendYield: BigDecimal,
    val payoutRatio: BigDecimal,
    @JsonDeserialize(using = LocalDateDeserializer::class)
    val dividendDate: LocalDate,
    @JsonDeserialize(using = LocalDateDeserializer::class)
    val exDividendDate: LocalDate,
    val lastSplitFactor: String,
    @JsonDeserialize(using = LocalDateDeserializer::class)
    val lastSplitDate: LocalDate,
)