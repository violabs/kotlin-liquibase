package io.violabs.kotlinliquibase

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.util.DefaultIndenter
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

object JsonFactory {
    private val om = ObjectMapper()
        .registerKotlinModule()
        .registerModule(JavaTimeModule())
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)

    private class CustomPrettyPrinter : DefaultPrettyPrinter() {
        init {
            val indenter = DefaultIndenter("    ", "\n")
            indentArraysWith(indenter)
            indentObjectsWith(indenter)
        }
        
        override fun createInstance(): DefaultPrettyPrinter {
            return CustomPrettyPrinter()
        }
        
        override fun writeObjectFieldValueSeparator(g: JsonGenerator) {
            g.writeRaw(": ")
        }
    }

    fun build(o: Any, prettyPrint: Boolean = true): String {
        return if (prettyPrint) {
            om.writer(CustomPrettyPrinter()).writeValueAsString(o)
        } else {
            om.writeValueAsString(o)
        }
    }
}