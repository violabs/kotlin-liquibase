package io.violabs.kotlinliquibase.domain

import io.violabs.konstellation.metaDsl.annotation.GeneratedDsl

@GeneratedDsl(isRoot = true)
data class LiquibaseConfig(
    val context: String? = null,
    val logicalFilePath: String? = null,
    val objectQuotingStrategy: String? = null,
    val databaseChangeLog: List<DatabaseChangeLogItem>? = null
)