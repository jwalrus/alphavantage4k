package com.jwalrus.alphavantage4k.data.parser

import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.KeyDeserializer
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateTimeKeyDeserializer : KeyDeserializer() {
    override fun deserializeKey(key: String?, ctxt: DeserializationContext?): LocalDateTime {
        return LocalDateTime.parse(key, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }
}