package io.opentelemetry.instrumentation.api.instrumenter.db;

import io.opentelemetry.instrumentation.api.db.SqlStatementInfo;
import io.opentelemetry.instrumentation.api.db.SqlStatementSanitizer;
import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DbClientSpanNameExtractor<REQUEST> implements SpanNameExtractor<REQUEST> {
    private static final String DEFAULT_SPAN_NAME = "DB Query";

    public static <REQUEST> SpanNameExtractor<REQUEST> create(DbClientAttributesGetter<REQUEST> dbClientAttributesGetter) {
        return new GenericDbClientSpanNameExtractor(dbClientAttributesGetter);
    }

    public static <REQUEST> SpanNameExtractor<REQUEST> create(SqlClientAttributesGetter<REQUEST> sqlClientAttributesGetter) {
        return new SqlClientSpanNameExtractor(sqlClientAttributesGetter);
    }

    private DbClientSpanNameExtractor() {
    }

    protected String computeSpanName(String str, String str2, String str3) {
        if (str2 == null) {
            return str == null ? DEFAULT_SPAN_NAME : str;
        }
        StringBuilder sb = new StringBuilder(str2);
        if (str != null || str3 != null) {
            sb.append(' ');
        }
        if (str != null && (str3 == null || str3.indexOf(46) == -1)) {
            sb.append(str);
            if (str3 != null) {
                sb.append('.');
            }
        }
        if (str3 != null) {
            sb.append(str3);
        }
        return sb.toString();
    }

    private static final class GenericDbClientSpanNameExtractor<REQUEST> extends DbClientSpanNameExtractor<REQUEST> {
        private final DbClientAttributesGetter<REQUEST> getter;

        private GenericDbClientSpanNameExtractor(DbClientAttributesGetter<REQUEST> dbClientAttributesGetter) {
            super();
            this.getter = dbClientAttributesGetter;
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
        public String extract(REQUEST request) {
            return computeSpanName(this.getter.name(request), this.getter.operation(request), null);
        }
    }

    private static final class SqlClientSpanNameExtractor<REQUEST> extends DbClientSpanNameExtractor<REQUEST> {
        private static final SqlStatementSanitizer sanitizer = SqlStatementSanitizer.create(true);
        private final SqlClientAttributesGetter<REQUEST> getter;

        private SqlClientSpanNameExtractor(SqlClientAttributesGetter<REQUEST> sqlClientAttributesGetter) {
            super();
            this.getter = sqlClientAttributesGetter;
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
        public String extract(REQUEST request) {
            String strName = this.getter.name(request);
            SqlStatementInfo sqlStatementInfoSanitize = sanitizer.sanitize(this.getter.rawStatement(request));
            return computeSpanName(strName, sqlStatementInfoSanitize.getOperation(), sqlStatementInfoSanitize.getTable());
        }
    }
}
