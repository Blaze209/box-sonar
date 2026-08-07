package io.opentelemetry.instrumentation.api.db;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_SqlStatementSanitizer_CacheKey extends SqlStatementSanitizer.CacheKey {
    private final SqlDialect dialect;
    private final String statement;

    AutoValue_SqlStatementSanitizer_CacheKey(String str, SqlDialect sqlDialect) {
        if (str == null) {
            throw new NullPointerException("Null statement");
        }
        this.statement = str;
        if (sqlDialect == null) {
            throw new NullPointerException("Null dialect");
        }
        this.dialect = sqlDialect;
    }

    @Override // io.opentelemetry.instrumentation.api.db.SqlStatementSanitizer.CacheKey
    String getStatement() {
        return this.statement;
    }

    @Override // io.opentelemetry.instrumentation.api.db.SqlStatementSanitizer.CacheKey
    SqlDialect getDialect() {
        return this.dialect;
    }

    public String toString() {
        return "CacheKey{statement=" + this.statement + ", dialect=" + this.dialect + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SqlStatementSanitizer.CacheKey) {
            SqlStatementSanitizer.CacheKey cacheKey = (SqlStatementSanitizer.CacheKey) obj;
            if (this.statement.equals(cacheKey.getStatement()) && this.dialect.equals(cacheKey.getDialect())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.dialect.hashCode() ^ ((this.statement.hashCode() ^ 1000003) * 1000003);
    }
}
