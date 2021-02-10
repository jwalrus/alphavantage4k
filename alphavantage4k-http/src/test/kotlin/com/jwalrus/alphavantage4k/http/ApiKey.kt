package com.jwalrus.alphavantage4k.http

import java.nio.file.Paths

fun apiKey() = Paths.get("src", "test", "resources", "api-key.txt").toFile().readText()