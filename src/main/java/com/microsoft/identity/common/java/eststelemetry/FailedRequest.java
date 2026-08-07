package com.microsoft.identity.common.java.eststelemetry;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes14.dex */
class FailedRequest {
    private final String mApiId;
    private final String mCorrelationId;
    private final String mError;

    public FailedRequest(String str, String str2, String str3) {
        this.mApiId = str;
        this.mCorrelationId = str2;
        this.mError = str3;
    }

    public String toApiIdCorrelationString() {
        return this.mApiId + AbstractJsonLexerKt.COMMA + this.mCorrelationId;
    }

    public String toErrorCodeString() {
        return this.mError;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mCorrelationId.equals(((FailedRequest) obj).mCorrelationId);
    }

    public int hashCode() {
        return this.mCorrelationId.hashCode();
    }
}
