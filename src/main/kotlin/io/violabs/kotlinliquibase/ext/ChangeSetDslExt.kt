package io.violabs.kotlinliquibase.ext

import io.violabs.kotlinliquibase.domain.ChangeSetDslBuilder
import io.violabs.kotlinliquibase.domain.DbExecutor

fun ChangeSetDslBuilder.runWith(executor: DbExecutor) {
    this.runWith {
        this.value = executor.name
    }
}

fun ChangeSetDslBuilder.runWith(executorName: String) {
    this.runWith {
        this.value = executorName
    }
}