package io.violabs.kotlinliquibase

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumJsonTest {
    @Test
    fun `can generate minimum json`() {
        val expected = this.javaClass.getResource("/json/minimum-json-expected.json")!!.readText().trim()

        val actualObj = liquibaseConfig {
            databaseChangeLog {
                databaseChangeLogItem {
                    changeSet {
                        id = "user_init"
                        author = "violabs"
                        changes {
                            change {
                                sqlFile {
                                    path = "changesets/user/initial_db.sql"
                                    relativeToChangelogFile()
                                    encoding = "UTF-8"
                                }
                            }
                        }
                    }
                }
            }
        }

        val actual = JsonFactory.build(actualObj).trim()

        assertEquals(expected, actual)
    }
}