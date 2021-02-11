package com.jwalrus.alphavantage4k.http

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.http4k.core.Status
import org.http4k.kotest.shouldHaveStatus

class FundamentalsTest : DescribeSpec({

    val testSubject = AlphaVantageClient(apiKey()).fundamentals()

    describe("daily returns") {
        val response = testSubject.companyOverview("AAPL")
        response shouldHaveStatus Status.OK
        response.value().symbol shouldBe "AAPL"
        println(response.value())
    }
})