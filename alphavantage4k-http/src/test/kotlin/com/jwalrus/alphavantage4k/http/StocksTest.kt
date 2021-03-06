package com.jwalrus.alphavantage4k.http

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.http4k.core.Status
import org.http4k.kotest.shouldHaveStatus

class StocksTest : DescribeSpec({

    val testSubject = AlphaVantageClient(apiKey()).stocks()

    describe("daily returns") {
        val response = testSubject.daily("AAPL", OutputSize.LAST_100)
        response shouldHaveStatus Status.OK
        response.value().metadata.symbol shouldBe "AAPL"
        response.value().timeSeries.size shouldBeExactly 100
    }

    describe("daily adjusted returns") {
        val response = testSubject.dailyAdjusted("F", OutputSize.LAST_100)
        response shouldHaveStatus Status.OK
        response.value().metadata.symbol shouldBe "F"
        response.value().timeSeries.size shouldBeExactly 100
    }

    describe("weekly returns") {
        val response = testSubject.weekly("GME")
        response shouldHaveStatus Status.OK
        response.value().metadata.symbol shouldBe "GME"
        response.value().timeSeries.size shouldBeGreaterThan 100
    }

    describe("weekly adjusted returns") {
        val response = testSubject.weeklyAdjusted("AMC")
        response shouldHaveStatus Status.OK
        response.value().metadata.symbol shouldBe "AMC"
        response.value().timeSeries.size shouldBeGreaterThan 100
    }

    describe("monthly returns") {
        val response = testSubject.monthly("IBM")
        response shouldHaveStatus Status.OK
        response.value().metadata.symbol shouldBe "IBM"
        response.value().timeSeries.size shouldBeGreaterThan 100
    }

    describe("monthly adjusted returns") {
        val response = testSubject.monthlyAdjusted("IBM")
        response shouldHaveStatus Status.OK
        response.value().metadata.symbol shouldBe "IBM"
        response.value().timeSeries.size shouldBeGreaterThan 100
    }

    describe("global quote") {
        val response = testSubject.quote("F")
        response shouldHaveStatus Status.OK
        response.value().globalQuote.symbol shouldBe "F"
    }

    describe("search") {
        val response = testSubject.search("games")
        response shouldHaveStatus Status.OK
        response.value().bestMatches.map { it.symbol } shouldContain "GME"
    }

    describe("intraday adjusted") {
        val response = testSubject.intraday("AAPL", IntradayInterval.FIFTEEN_MIN, OutputSize.LAST_100, adjusted = true)
        response shouldHaveStatus Status.OK
        response.value().timeSeries shouldHaveSize 100
    }

    describe("intraday unadjusted") {
        val response = testSubject.intraday("AAPL", IntradayInterval.ONE_MIN, OutputSize.LAST_100, adjusted = false)
        response shouldHaveStatus Status.OK
        response.value().timeSeries shouldHaveSize 100
    }
})
