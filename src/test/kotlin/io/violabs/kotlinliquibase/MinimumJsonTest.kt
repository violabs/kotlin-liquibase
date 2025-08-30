package io.violabs.kotlinliquibase

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumJsonTest {
    @Test
    fun `can generate minimum json`() {
        val expected = this.javaClass.getResource("/json/minimum-json-expected.json")!!.readText().trim()

        val sharedAuthor = "violabs"
        val sharedEncoding = "UTF-8"

        val actualObj = liquibaseConfig {
            databaseChangeLog {
                databaseChangeLogItem {
                    changeSet {
                        id = "user_init"
                        author = sharedAuthor
                        changes {
                            change {
                                sqlFile {
                                    path = "changesets/user/initial_db.sql"
                                    relativeToChangelogFile()
                                    encoding = sharedEncoding
                                }
                            }
                        }
                        rollback {
                            sqlFile {
                                path = "changesets/user/rollback_db.sql"
                                relativeToChangelogFile()
                                encoding = sharedEncoding
                            }
                        }
                    }
                }

                databaseChangeLogItem {
                    changeSet {
                        id = "subscription_init"
                        author = sharedAuthor
                        changes {
                            change {
                                sqlFile {
                                    path = "changesets/subscription/initial_db.sql"
                                    relativeToChangelogFile()
                                    encoding = sharedEncoding
                                }
                            }
                        }
                        rollback {
                            sqlFile {
                                path = "changesets/subscription/rollback_db.sql"
                                relativeToChangelogFile()
                                encoding = sharedEncoding
                            }
                        }
                    }
                }
            }
        }

        val actual = JsonFactory.build(actualObj, prettyPrint = true).trim()

        assertEquals(expected, actual)
    }
}