package io.violabs.kotlinliquibase.domain

import io.violabs.konstellation.metaDsl.annotation.GeneratedDsl

@GeneratedDsl
data class Rollback(
    val sqlFile: SqlFileChange? = null
)