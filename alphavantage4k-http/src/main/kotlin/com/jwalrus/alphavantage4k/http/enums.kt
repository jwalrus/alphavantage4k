package com.jwalrus.alphavantage4k.http

enum class OutputSize(val value: String) {
    FULL("full"), LAST_100("compact")
}

enum class IntradayInterval(val value: String) {
    ONE_MIN("1min"),
    FIVE_MIN("5min"),
    FIFTEEN_MIN("15min"),
    THIRTY_MIN("30min"),
    SIXTY_MIN("60min")
}