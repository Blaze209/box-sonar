package io.opentelemetry.instrumentation.api.db;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_SqlStatementInfo extends SqlStatementInfo {
    private final String fullStatement;
    private final String operation;
    private final String table;

    AutoValue_SqlStatementInfo(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.fullStatement = str;
        this.operation = str2;
        this.table = str3;
    }

    @Override // io.opentelemetry.instrumentation.api.db.SqlStatementInfo
    @Nullable
    public String getFullStatement() {
        return this.fullStatement;
    }

    @Override // io.opentelemetry.instrumentation.api.db.SqlStatementInfo
    @Nullable
    public String getOperation() {
        return this.operation;
    }

    @Override // io.opentelemetry.instrumentation.api.db.SqlStatementInfo
    @Nullable
    public String getTable() {
        return this.table;
    }

    public String toString() {
        return "SqlStatementInfo{fullStatement=" + this.fullStatement + ", operation=" + this.operation + ", table=" + this.table + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SqlStatementInfo) {
            SqlStatementInfo sqlStatementInfo = (SqlStatementInfo) obj;
            String str = this.fullStatement;
            if (str != null ? str.equals(sqlStatementInfo.getFullStatement()) : sqlStatementInfo.getFullStatement() == null) {
                String str2 = this.operation;
                if (str2 != null ? str2.equals(sqlStatementInfo.getOperation()) : sqlStatementInfo.getOperation() == null) {
                    String str3 = this.table;
                    if (str3 != null ? str3.equals(sqlStatementInfo.getTable()) : sqlStatementInfo.getTable() == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.fullStatement;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.operation;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.table;
        return iHashCode2 ^ (str3 != null ? str3.hashCode() : 0);
    }
}
