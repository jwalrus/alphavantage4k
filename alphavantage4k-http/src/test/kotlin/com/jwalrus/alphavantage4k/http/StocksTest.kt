package com.jwalrus.alphavantage4k.http

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.shouldBe
import org.http4k.core.Status
import org.http4k.kotest.shouldHaveStatus

class StocksTest : DescribeSpec({

    val testSubject = AlphaVantageClient(apiKey()).stocks()

    describe("daily adjusted returns") {
        val response = testSubject.dailyAdjusted("F", OutputSize.LAST_100)
        response shouldHaveStatus Status.OK
        response.value().metadata.symbol shouldBe "F"
        response.value().timeSeries.size shouldBeExactly 100
    }

    describe("global quote") {
        val response = testSubject.quote("F")
        response shouldHaveStatus Status.OK
        response.value().globalQuote.symbol shouldBe "F"
    }
})
