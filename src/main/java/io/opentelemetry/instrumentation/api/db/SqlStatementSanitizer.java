package io.opentelemetry.instrumentation.api.db;

import io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics;
import io.opentelemetry.instrumentation.api.internal.cache.Cache;
import java.util.function.Function;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class SqlStatementSanitizer {
    private final boolean statementSanitizationEnabled;
    private static final SupportabilityMetrics supportability = SupportabilityMetrics.instance();
    private static final Cache<CacheKey, SqlStatementInfo> sqlToStatementInfoCache = Cache.bounded(1000);

    public static SqlStatementSanitizer create(boolean z) {
        return new SqlStatementSanitizer(z);
    }

    private SqlStatementSanitizer(boolean z) {
        this.statementSanitizationEnabled = z;
    }

    public SqlStatementInfo sanitize(@Nullable String str) {
        return sanitize(str, SqlDialect.DEFAULT);
    }

    public SqlStatementInfo sanitize(@Nullable final String str, final SqlDialect sqlDialect) {
        if (!this.statementSanitizationEnabled || str == null) {
            return SqlStatementInfo.create(str, null, null);
        }
        return sqlToStatementInfoCache.computeIfAbsent(CacheKey.create(str, sqlDialect), new Function() { // from class: io.opentelemetry.instrumentation.api.db.SqlStatementSanitizer$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SqlStatementSanitizer.lambda$sanitize$0(str, sqlDialect, (SqlStatementSanitizer.CacheKey) obj);
            }
        });
    }

    static /* synthetic */ SqlStatementInfo lambda$sanitize$0(String str, SqlDialect sqlDialect, CacheKey cacheKey) {
        supportability.incrementCounter(SupportabilityMetrics.CounterNames.SQL_STATEMENT_SANITIZER_CACHE_MISS);
        return AutoSqlSanitizer.sanitize(str, sqlDialect);
    }

    static abstract class CacheKey {
        abstract SqlDialect getDialect();

        abstract String getStatement();

        CacheKey() {
        }

        static CacheKey create(String str, SqlDialect sqlDialect) {
            return new AutoValue_SqlStatementSanitizer_CacheKey(str, sqlDialect);
        }
    }
}
