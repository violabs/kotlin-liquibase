package io.violabs.kotlinliquibase.domain

enum class RunOrder {
    FIRST, LAST;

    override fun toString(): String {
        return name.lowercase()
    }
}