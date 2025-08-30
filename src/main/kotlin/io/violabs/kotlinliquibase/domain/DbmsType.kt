package io.violabs.kotlinliquibase.domain

enum class DbmsType(val ref: String) {
    DB2_LUW("db2/luw"),
    DB2_Z("db2/z"),
    DERBY("derby"),
    FIREBIRD("firebird"),
    GOOGLE_BIGQUERY("bigquery"),
    H2("h2"),
    HYPERSQL("hsqldb"),
    INGRES("ingres"),
    INFORMIX("informix"),
    MARIADB("mariadb"),
    MYSQL("mysql"),
    ORACLE("oracle"),
    POSTGRESQL("postgresql"),
    SNOWFLAKE("snowflake"),
    SQL_SERVER("sql server"),
    SQLITE("sqlite"),
    SYBASE("sybase"),
    SYBASE_ANYWHERE("sybase anywhere"), ;

    override fun toString(): String {
        return ref
    }
}