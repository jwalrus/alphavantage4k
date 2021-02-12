package com.jwalrus.alphavantage4k.http

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.shouldBe
import org.http4k.core.Status
import org.http4k.kotest.shouldHaveStatus

class FundamentalsTest : DescribeSpec({

    val testSubject = AlphaVantageClient(apiKey()).fundamentals()

    describe("company overview") {
        val response = testSubject.companyOverview("AAPL")
        response shouldHaveStatus Status.OK
        response.value().symbol shouldBe "AAPL"
        println(response.value())
    }

    describe("income statement") {
        val response = testSubject.incomeStatement("AAPL").also(::println)
        with(response.value()) {
            symbol shouldBe "AAPL"
            annualReports shouldHaveAtLeastSize 1
        }
    }
})