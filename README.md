```json
{
  "databaseChangeLog": [
    { "preConditions": [ /* global preconditions (optional) */ ] },
    { "property": { "name": "schemaName", "value": "public" } },
    { "include": { "file": "path/db.changelog-users.json" } },
    { "includeAll": { "path": "changes/" } },
    { "modifyChangeSets": { /* pro/executor options (optional) */ } },
    {
      "changeSet": {
        "id": "001",
        "author": "you",
        "labels": "init",
        "context": "prod",
        "runInTransaction": true,
        "changes": [ /* change types go here */ ],
        "preConditions": [ /* local preconditions (optional) */ ],
        "rollback": [ /* rollback steps (optional) */ ],
        "validCheckSum": "1:any" /* rarely needed */
      }
    }
  ]
}
```

changeSet — attributes and what’s required

Required

- id: string identifier (quote dotted numbers like "1.10" to prevent JSON number parsing shenanigans).

- author: string (non-empty if Liquibase runs with strict=true).

- changes: array with at least one change type (e.g., createTable, addColumn, …).

Common optional controls

- context, labels — filter execution by environment/labels.

- dbms — limit to specific DB engines.

- runInTransaction (default true) — set to false only when needed.

- runAlways / runOnChange — force re-execution semantics.

- runOrder: "first" | "last" — pin execution order without moving the file.

- onValidationFail: "HALT" | "MARK_RAN" — checksum validation behavior.

- failOnError (default true), ignore (treat as non-existent).

- logicalFilePath, objectQuotingStrategy, runWith, runWithSpoolFile.

Nested (peer to changes)

preConditions — local preconditions for this changeset.

rollback — explicit rollback steps.

comment, validCheckSum.

Full, current list lives on the Changeset page.