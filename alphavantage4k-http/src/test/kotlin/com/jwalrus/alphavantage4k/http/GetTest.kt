package com.jwalrus.alphavantage4k.http

import com.jwalrus.alphavantage4k.http.enums.OutputSize
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.shouldBe
import java.nio.file.Paths


class GetUtil : DescribeSpec({

    val apiKey = Paths.get("src", "test", "resources", "api-key.txt").toFile().readText()
    val client = AlphaVantageClient(apiKey)

    describe("daily adjusted returns") {
//        val series = DailyAdjusted().fetch("F", OutputSize.LAST_100).also(::println)
        val series = client.dailyAdjusted("F", OutputSize.LAST_100)
        series.metadata.symbol shouldBe "F"
        series.timeSeries.size shouldBeExactly 100
    }

    describe("global quote") {
//        val quote = Quote().fetch("F").also(::println)
        val quote = client.quote("F")
        quote.symbol shouldBe "F"
    }
})
