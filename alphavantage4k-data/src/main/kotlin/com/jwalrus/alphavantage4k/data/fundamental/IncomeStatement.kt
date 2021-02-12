package com.jwalrus.alphavantage4k.data.fundamental

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.jwalrus.alphavantage4k.data.parser.LongOrNullDeserializer
import java.time.LocalDate

data class IncomeStatement(
    val symbol: String,
    val annualReports: Collection<AnnualReport>
)

// todo: need to test with more symbols, a lot of these fields might be nullable
data class AnnualReport(
    @JsonDeserialize(using = LocalDateDeserializer::class)
    val fiscalDateEnding: LocalDate,
    val reportedCurrency: String,
    val totalRevenue: Long,
    val totalOperatingExpense: Long,
    val costOfRevenue: Long,
    val grossProfit: Long,
    val ebit: Long,
    val netIncome: Long,
    val researchAndDevelopment: Long,
    @JsonDeserialize(using = LongOrNullDeserializer::class)
    val effectOfAccountingCharges: Long?,
    val incomeBeforeTax: Long,
    @JsonDeserialize(using = LongOrNullDeserializer::class)
    val minorityInterest: Long?,
    val sellingGeneralAdministrative: Long,
    @JsonDeserialize(using = LongOrNullDeserializer::class)
    val otherNonOperatingIncome: Long?,
    val operatingIncome: Long,
    @JsonDeserialize(using = LongOrNullDeserializer::class)
    val otherOperatingExpense: Long?,
    val interestExpense: Long,
    val taxProvision: Long,
    @JsonDeserialize(using = LongOrNullDeserializer::class)
    val interestIncome: Long?,
    val netInterestIncome: Long,
    @JsonDeserialize(using = LongOrNullDeserializer::class)
    val extraordinaryItems: Long?,
    @JsonDeserialize(using = LongOrNullDeserializer::class)
    val nonRecurring: Long?,
    @JsonDeserialize(using = LongOrNullDeserializer::class)
    val otherItems: Long?,
    val incomeTaxExpense: Long,
    val totalOtherIncomeExpense: Long,
    @JsonDeserialize(using = LongOrNullDeserializer::class)
    val discontinuedOperations: Long?,
    val netIncomeFromContinuingOperations: Long,
    val netIncomeApplicableToCommonShares: Long,
    @JsonDeserialize(using = LongOrNullDeserializer::class)
    val preferredStockAndOtherAdjustments: Long?
)