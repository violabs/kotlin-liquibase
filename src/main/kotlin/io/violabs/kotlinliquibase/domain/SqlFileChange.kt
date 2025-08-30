package io.violabs.kotlinliquibase.domain

import io.violabs.konstellation.metaDsl.annotation.GeneratedDsl

@GeneratedDsl
data class SqlFileChange(
    /**
     * Specifies the file path of the SQL file to load.
     */
    val path: String,
    /**
     * Specifies which database type(s) a changeset is to be used for. See valid database type names on dbms.
     * Separate multiple databases with commas. Specify that a changeset is not applicable to a particular database
     * type by prefixing with !. The keywords all and none are also available.
     */
    val dbms: String? = null,
    /**
     * Encoding used in the file specified in the path attribute. Default: UTF-8.
     */
    val encoding: String? = null,
    /**
     * Specifies delimiter to apply to the end of the statement.
     * Your delimiter string can be a combination of one or more letters, symbols, and/or numbers,
     * or the empty string ("").
     * Default: ";". See also: --pro-global-end-delimiter and --pro-global-end-delimiter-prioritized.
     */
    val endDelimiter: String? = null,
    /**
     * Specifies whether the file path is relative to the changelog file rather than looked
     * up in the search path.
     * Default: false.
     */
    val relativeToChangelogFile: Boolean? = null,
    /**
     * If required, Liquibase will automatically add splitstatements:true to generated changesets
     * in Formatted SQL changelogs. Otherwise, the default setting for generated changelogs
     * is splitstatements:false.
     *
     * Example: If the generated SQL has multiple SQL statements, then
     * Liquibase adds splitStatements:true to the changelog.
     */
    val splitStatements: Boolean? = null,
    /**
     * When true, removes any comments in the statement before executing.
     * If false, Liquibase does not remove any comments. Default: false.
     * See also: --pro-global-strip-comments and --pro-global-strip-comments-prioritized.
     */
    val stripComments: Boolean? = null
)