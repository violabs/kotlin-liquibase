package io.violabs.kotlinliquibase.domain

enum class DbExecutor {
    JDBC,
    MONGOSH,
    PSQL,
    SQLCMD,
    CUSTOM
}