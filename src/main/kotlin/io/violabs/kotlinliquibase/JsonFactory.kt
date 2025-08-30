package io.violabs.kotlinliquibase

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

//package io.violabs.picard
//
//import com.fasterxml.jackson.annotation.JsonInclude
//import com.fasterxml.jackson.databind.JsonMappingException
//import com.fasterxml.jackson.databind.ObjectMapper
//import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
//import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
//import com.fasterxml.jackson.module.kotlin.registerKotlinModule
//import io.violabs.picard.domain.manifest.Manifest
//
//object YamlBuilder {
//    val yamlFactory = YAMLFactory().apply {
//        disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
//        enable(YAMLGenerator.Feature.MINIMIZE_QUOTES)
//        enable(YAMLGenerator.Feature.INDENT_ARRAYS_WITH_INDICATOR)
//    }
//
//    val listYamlFactory = YAMLFactory().apply {
//        enable(YAMLGenerator.Feature.MINIMIZE_QUOTES)
//        enable(YAMLGenerator.Feature.INDENT_ARRAYS_WITH_INDICATOR)
//    }
//
//    private val singleOm = ObjectMapper(yamlFactory)
//        .registerKotlinModule()
//        .registerModule(JavaTimeModule())
//        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
//
//    private val listOm = ObjectMapper(listYamlFactory)
//        .registerKotlinModule()
//        .registerModule(JavaTimeModule())
//        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
//
//    fun singleBuild(o: Any): String = singleOm.writeValueAsString(o)
//
//    fun build(manifest: Manifest): String = try {
//        val resources = manifest.resources.flatMap { it.resources }
//
//        if (resources.size > 1)
//            resources.joinToString("\n", transform = listOm::writeValueAsString)
//        else {
//            singleOm.writeValueAsString(resources.firstOrNull())
//        }
//    } catch (e: JsonMappingException) {
//        if (e.message?.contains("cannot be cast to class io.violabs.picard.common.YAMLMap") == true) {
//            throw IllegalArgumentException(
//                "Missing YAMLMap implementation for ${e.pathReference}"
//            )
//        } else {
//            throw e
//        }
//    }
//}
object JsonFactory {
    private val om = ObjectMapper()
        .registerKotlinModule()
        .registerModule(JavaTimeModule())
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)

    fun build(o: Any): String = om.writeValueAsString(o)
}