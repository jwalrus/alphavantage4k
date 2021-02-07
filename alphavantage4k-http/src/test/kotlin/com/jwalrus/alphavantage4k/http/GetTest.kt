package com.jwalrus.alphavantage4k.http

import com.jwalrus.alphavantage4k.http.enums.OutputSize
import com.jwalrus.alphavantage4k.http.stock.DailyAdjusted
import com.jwalrus.alphavantage4k.http.stock.Quote
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.shouldBe


class GetUtil : DescribeSpec({

    val testSubject = DailyAdjusted()

    describe("daily adjusted returns") {
        val series = testSubject.fetch("F", OutputSize.LAST_100).also(::println)
        series.metadata.symbol shouldBe "F"
        series.timeSeries.size shouldBeExactly 100
    }

    describe("global quote") {
        val quote = Quote().fetch("F").also(::println)
        quote.symbol shouldBe "F"
    }
})
