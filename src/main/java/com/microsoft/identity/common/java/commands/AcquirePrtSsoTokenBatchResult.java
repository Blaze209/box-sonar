package com.microsoft.identity.common.java.commands;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class AcquirePrtSsoTokenBatchResult {

    @SerializedName("authority")
    private final String mAuthority;

    @SerializedName("correlationId")
    private final String mCorrelationId;

    @SerializedName("error")
    private final String mError;

    @SerializedName("failedAccounts")
    private final Map<String, String> mFailedAccounts;

    @SerializedName("results")
    private final List<AcquirePrtSsoTokenResult> mResults;

    public static class AcquirePrtSsoTokenBatchResultBuilder {
        private String authority;
        private String correlationId;
        private String error;
        private Map<String, String> failedAccounts;
        private List<AcquirePrtSsoTokenResult> results;

        AcquirePrtSsoTokenBatchResultBuilder() {
        }

        public AcquirePrtSsoTokenBatchResultBuilder authority(String str) {
            this.authority = str;
            return this;
        }

        public AcquirePrtSsoTokenBatchResult build() {
            return new AcquirePrtSsoTokenBatchResult(this.results, this.failedAccounts, this.error, this.correlationId, this.authority);
        }

        public AcquirePrtSsoTokenBatchResultBuilder correlationId(String str) {
            this.correlationId = str;
            return this;
        }

        public AcquirePrtSsoTokenBatchResultBuilder error(String str) {
            this.error = str;
            return this;
        }

        public AcquirePrtSsoTokenBatchResultBuilder failedAccounts(Map<String, String> map) {
            this.failedAccounts = map;
            return this;
        }

        public AcquirePrtSsoTokenBatchResultBuilder results(List<AcquirePrtSsoTokenResult> list) {
            if (list == null) {
                throw new NullPointerException("results is marked non-null but is null");
            }
            this.results = list;
            return this;
        }

        public String toString() {
            return "AcquirePrtSsoTokenBatchResult.AcquirePrtSsoTokenBatchResultBuilder(results=" + this.results + ", failedAccounts=" + this.failedAccounts + ", error=" + this.error + ", correlationId=" + this.correlationId + ", authority=" + this.authority + ")";
        }
    }

    AcquirePrtSsoTokenBatchResult(List<AcquirePrtSsoTokenResult> list, Map<String, String> map, String str, String str2, String str3) {
        if (list == null) {
            throw new NullPointerException("results is marked non-null but is null");
        }
        this.mResults = list;
        this.mFailedAccounts = map;
        this.mError = str;
        this.mCorrelationId = str2;
        this.mAuthority = str3;
    }

    public static AcquirePrtSsoTokenBatchResultBuilder builder() {
        return new AcquirePrtSsoTokenBatchResultBuilder();
    }

    public List<AcquirePrtSsoTokenResult> getResults() {
        return this.mResults;
    }

    public Map<String, String> getFailedAccounts() {
        return this.mFailedAccounts;
    }

    public String getError() {
        return this.mError;
    }

    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    public String getAuthority() {
        return this.mAuthority;
    }
}
