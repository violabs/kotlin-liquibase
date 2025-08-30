package io.violabs.kotlinliquibase.domain

enum class ObjectQuotingStrategy {
    LEGACY,
    QUOTE_ALL_OBJECTS,
    QUOTE_ONLY_RESERVED_WORDS
}