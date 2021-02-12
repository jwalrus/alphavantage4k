package com.jwalrus.alphavantage4k.data.parser

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.math.BigDecimal

class LongOrNullDeserializer : StdDeserializer<Long?>(Long::class.java) {

    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Long? {
        val node: JsonNode = p?.codec?.readTree(p)
            ?: throw IllegalArgumentException("No JsonParser provided.")

        return node.asText().toLongOrNull()
    }
}