package com.microsoft.identity.common.java.commands;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class AcquirePrtSsoTokenResult {

    @SerializedName("accountAuthority")
    private final String mAccountAuthority;

    @SerializedName("accountName")
    private final String mAccountName;

    @SerializedName("acquisitionTimeMillis")
    private final Long mAcquisitionTimeMillis;

    @SerializedName("ssoToken")
    private final String mCookieContent;

    @SerializedName("cookieName")
    private final String mCookieName;

    @SerializedName("error")
    private final String mError;

    @SerializedName("homeAccountId")
    private final String mHomeAccountId;

    @SerializedName("localAccountId")
    private final String mLocalAccountId;

    @SerializedName("telemetry")
    private final Map<String, Object> mTelemetry;

    public static class AcquirePrtSsoTokenResultBuilder {
        private String accountAuthority;
        private String accountName;
        private Long acquisitionTimeMillis;
        private String cookieContent;
        private String cookieName;
        private String error;
        private String homeAccountId;
        private String localAccountId;
        private Map<String, Object> telemetry;

        AcquirePrtSsoTokenResultBuilder() {
        }

        public AcquirePrtSsoTokenResultBuilder accountAuthority(String str) {
            this.accountAuthority = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder accountName(String str) {
            this.accountName = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder acquisitionTimeMillis(Long l) {
            this.acquisitionTimeMillis = l;
            return this;
        }

        public AcquirePrtSsoTokenResult build() {
            return new AcquirePrtSsoTokenResult(this.homeAccountId, this.localAccountId, this.accountName, this.error, this.accountAuthority, this.cookieName, this.cookieContent, this.telemetry, this.acquisitionTimeMillis);
        }

        public AcquirePrtSsoTokenResultBuilder cookieContent(String str) {
            this.cookieContent = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder cookieName(String str) {
            this.cookieName = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder error(String str) {
            this.error = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder homeAccountId(String str) {
            this.homeAccountId = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder localAccountId(String str) {
            this.localAccountId = str;
            return this;
        }

        public AcquirePrtSsoTokenResultBuilder telemetry(Map<String, Object> map) {
            if (map == null) {
                throw new NullPointerException("telemetry is marked non-null but is null");
            }
            this.telemetry = map;
            return this;
        }

        public String toString() {
            return "AcquirePrtSsoTokenResult.AcquirePrtSsoTokenResultBuilder(homeAccountId=" + this.homeAccountId + ", localAccountId=" + this.localAccountId + ", accountName=" + this.accountName + ", error=" + this.error + ", accountAuthority=" + this.accountAuthority + ", cookieName=" + this.cookieName + ", cookieContent=" + this.cookieContent + ", telemetry=" + this.telemetry + ", acquisitionTimeMillis=" + this.acquisitionTimeMillis + ")";
        }
    }

    AcquirePrtSsoTokenResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<String, Object> map, Long l) {
        if (map == null) {
            throw new NullPointerException("telemetry is marked non-null but is null");
        }
        this.mHomeAccountId = str;
        this.mLocalAccountId = str2;
        this.mAccountName = str3;
        this.mError = str4;
        this.mAccountAuthority = str5;
        this.mCookieName = str6;
        this.mCookieContent = str7;
        this.mTelemetry = map;
        this.mAcquisitionTimeMillis = l;
    }

    public static AcquirePrtSsoTokenResultBuilder builder() {
        return new AcquirePrtSsoTokenResultBuilder();
    }

    public String getHomeAccountId() {
        return this.mHomeAccountId;
    }

    public String getLocalAccountId() {
        return this.mLocalAccountId;
    }

    public String getAccountName() {
        return this.mAccountName;
    }

    public String getError() {
        return this.mError;
    }

    public String getAccountAuthority() {
        return this.mAccountAuthority;
    }

    public String getCookieName() {
        return this.mCookieName;
    }

    public String getCookieContent() {
        return this.mCookieContent;
    }

    public Map<String, Object> getTelemetry() {
        return this.mTelemetry;
    }

    public Long getAcquisitionTimeMillis() {
        return this.mAcquisitionTimeMillis;
    }
}
