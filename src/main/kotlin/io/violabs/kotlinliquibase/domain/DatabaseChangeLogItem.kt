package io.violabs.kotlinliquibase.domain

import io.violabs.konstellation.metaDsl.annotation.GeneratedDsl

@GeneratedDsl(withListGroup = true)
data class DatabaseChangeLogItem(
    /**
     * The changeset to execute.
     */
    val changeSet: ChangeSet? = null,
    /**
     * Preconditions required to execute the changelog.
     * If global, must be passed before the changeset is run.
     * Preconditions are typically used for doing a data sanity check before doing something
     * unrecoverable such as a dropTable. Since 1.7
     *
     * Not supported with Formatted Mongo.
     */
    val preConditions: List<Any>? = null,
    /**
     * Additional files containing changesets to execute.
     */
    val include: List<Any>? = null,
    /**
     * 	An additional directory containing files with changesets to execute.
     */
    val includeAll: List<Any>? = null,
    /**
     * The value for which to set the property.
     */
    val property: ChangeLogProperty? = null,
    val modifyChangeSets: List<Any>? = null
)