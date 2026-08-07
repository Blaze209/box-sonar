package com.microsoft.identity.common.internal.broker;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.dto.AadDeviceIdRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerResult {
    private static final long serialVersionUID = 8606631820514878489L;

    @SerializedName("broker_aad_device_id_record")
    private final AadDeviceIdRecord mAadDeviceIdRecord;

    @SerializedName("access_token")
    private String mAccessToken;

    @SerializedName("authority")
    private String mAuthority;

    @SerializedName(Credential.SerializedNames.CACHED_AT)
    private long mCachedAt;

    @SerializedName("cli_telem_error_code")
    private String mCliTelemErrorCode;

    @SerializedName("cli_telem_suberror_code")
    private String mCliTelemSubErrorCode;

    @SerializedName("client_id")
    private String mClientId;

    @SerializedName("client_info")
    private String mClientInfo;

    @SerializedName("correlation_id")
    private String mCorrelationId;

    @SerializedName("environment")
    private String mEnvironment;

    @SerializedName("broker_error_code")
    private String mErrorCode;

    @SerializedName("broker_error_message")
    private String mErrorMessage;

    @SerializedName("broker_exception_type")
    private final String mExceptionType;

    @SerializedName(Credential.SerializedNames.EXPIRES_ON)
    private long mExpiresOn;

    @SerializedName("ext_expires_on")
    private long mExtendedExpiresOn;

    @SerializedName("family_id")
    private String mFamilyId;

    @SerializedName("home_account_id")
    private String mHomeAccountId;

    @SerializedName("http_response_body")
    private String mHttpResponseBody;

    @SerializedName("http_response_headers")
    private String mHttpResponseHeaders;

    @SerializedName("http_response_code")
    private int mHttpStatusCode;

    @SerializedName("id_token")
    private String mIdToken;

    @SerializedName(AccountRecord.SerializedNames.LOCAL_ACCOUNT_ID)
    private String mLocalAccountId;

    @SerializedName("refresh_token")
    private String mRefreshToken;

    @SerializedName("refresh_token_age")
    private String mRefreshTokenAge;

    @SerializedName("scopes")
    private String mScope;

    @SerializedName("serviced_from_cache")
    private boolean mServicedFromCache;

    @SerializedName("spe_ring")
    private String mSpeRing;

    @SerializedName("oauth_sub_error")
    private String mSubErrorCode;

    @SerializedName("success")
    private boolean mSuccess;

    @SerializedName("tenant_id")
    private String mTenantId;

    @SerializedName("tenant_profile_cache_records")
    private final List<ICacheRecord> mTenantProfileData;

    @SerializedName("token_type")
    private String mTokenType;

    @SerializedName("username")
    private String mUserName;

    private static class SerializedNames {
        static final String ACCESS_TOKEN = "access_token";
        static final String AUTHORITY = "authority";
        static final String BROKER_AAD_DEVICE_ID_RECORD = "broker_aad_device_id_record";
        static final String BROKER_ERROR_CODE = "broker_error_code";
        static final String BROKER_ERROR_MESSAGE = "broker_error_message";
        static final String BROKER_EXCEPTION_TYPE = "broker_exception_type";
        static final String CACHED_AT = "cached_at";
        static final String CLIENT_ID = "client_id";
        static final String CLIENT_INFO = "client_info";
        static final String CLI_TELEM_ERRORCODE = "cli_telem_error_code";
        static final String CLI_TELEM_SUB_ERROR_CODE = "cli_telem_suberror_code";
        static final String CORRELATION_ID = "correlation_id";
        static final String ENVIRONMENT = "environment";
        static final String EXPIRES_ON = "expires_on";
        static final String EXTENDED_EXPIRES_ON = "ext_expires_on";
        static final String FAMILY_ID = "family_id";
        static final String HOME_ACCOUNT_ID = "home_account_id";
        static final String HTTP_HEADERS = "http_response_headers";
        static final String HTTP_RESPONSE_BODY = "http_response_body";
        static final String HTTP_RESPONSE_CODE = "http_response_code";
        static final String ID_TOKEN = "id_token";
        static final String LOCAL_ACCOUNT_ID = "local_account_id";
        static final String OAUTH_SUB_ERROR = "oauth_sub_error";
        static final String REFRESH_TOKEN = "refresh_token";
        static final String REFRESH_TOKEN_AGE = "refresh_token_age";
        static final String SCOPES = "scopes";
        static final String SERVICED_FROM_CACHE = "serviced_from_cache";
        static final String SPE_RING = "spe_ring";
        static final String SUCCESS = "success";
        static final String TENANT_ID = "tenant_id";
        static final String TENANT_PROFILE_CACHE_RECORDS = "tenant_profile_cache_records";
        static final String TOKEN_TYPE = "token_type";
        static final String USERNAME = "username";

        private SerializedNames() {
        }
    }

    private BrokerResult(Builder builder) {
        this.mAccessToken = builder.mAccessToken;
        this.mIdToken = builder.mIdToken;
        this.mRefreshToken = builder.mRefreshToken;
        this.mHomeAccountId = builder.mHomeAccountId;
        this.mLocalAccountId = builder.mLocalAccountId;
        this.mUserName = builder.mUserName;
        this.mTokenType = builder.mTokenType;
        this.mClientId = builder.mClientId;
        this.mFamilyId = builder.mFamilyId;
        this.mScope = builder.mScope;
        this.mClientInfo = builder.mClientInfo;
        this.mAuthority = builder.mAuthority;
        this.mEnvironment = builder.mEnvironment;
        this.mTenantId = builder.mTenantId;
        this.mExpiresOn = builder.mExpiresOn;
        this.mExtendedExpiresOn = builder.mExtendedExpiresOn;
        this.mCachedAt = builder.mCachedAt;
        this.mSpeRing = builder.mSpeRing;
        this.mRefreshTokenAge = builder.mRefreshTokenAge;
        this.mSuccess = builder.mSuccess;
        this.mTenantProfileData = builder.mTenantProfileData;
        this.mServicedFromCache = builder.mServicedFromCache;
        this.mErrorCode = builder.mErrorCode;
        this.mErrorMessage = builder.mErrorMessage;
        this.mCorrelationId = builder.mCorrelationId;
        this.mSubErrorCode = builder.mSubErrorCode;
        this.mHttpStatusCode = builder.mHttpStatusCode;
        this.mHttpResponseBody = builder.mHttpResponseBody;
        this.mHttpResponseHeaders = builder.mHttpResponseHeaders;
        this.mCliTelemErrorCode = builder.mCliTelemErrorCode;
        this.mCliTelemSubErrorCode = builder.mCliTelemSubErrorCode;
        this.mExceptionType = builder.mExceptionType;
        this.mAadDeviceIdRecord = builder.mAadDeviceIdRecord;
    }

    public String getExceptionType() {
        return this.mExceptionType;
    }

    public List<ICacheRecord> getTenantProfileData() {
        if (this.mTenantProfileData == null) {
            return null;
        }
        return new ArrayList(this.mTenantProfileData);
    }

    public String getCliTelemSubErrorCode() {
        return this.mCliTelemSubErrorCode;
    }

    public String getCliTelemErrorCode() {
        return this.mCliTelemErrorCode;
    }

    public String getHttpResponseBody() {
        return this.mHttpResponseBody;
    }

    public String getHttpResponseHeaders() {
        return this.mHttpResponseHeaders;
    }

    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    public String getSubErrorCode() {
        return this.mSubErrorCode;
    }

    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public boolean isSuccess() {
        return this.mSuccess;
    }

    public boolean isServicedFromCache() {
        return this.mServicedFromCache;
    }

    public String getRefreshTokenAge() {
        return this.mRefreshTokenAge;
    }

    public String getSpeRing() {
        return this.mSpeRing;
    }

    public long getCachedAt() {
        return this.mCachedAt;
    }

    public long getExtendedExpiresOn() {
        return this.mExtendedExpiresOn;
    }

    public long getExpiresOn() {
        return this.mExpiresOn;
    }

    public String getTenantId() {
        return this.mTenantId;
    }

    public String getEnvironment() {
        return this.mEnvironment;
    }

    public String getAuthority() {
        return this.mAuthority;
    }

    public String getClientInfo() {
        return this.mClientInfo;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getFamilyId() {
        return this.mFamilyId;
    }

    public String getScope() {
        return this.mScope;
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getLocalAccountId() {
        return this.mLocalAccountId;
    }

    public String getHomeAccountId() {
        return this.mHomeAccountId;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getIdToken() {
        return this.mIdToken;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public AadDeviceIdRecord getAadDeviceIdRecord() {
        return this.mAadDeviceIdRecord;
    }

    public static class Builder {
        private AadDeviceIdRecord mAadDeviceIdRecord;
        private String mAccessToken;
        private String mAuthority;
        private long mCachedAt;
        private String mCliTelemErrorCode;
        private String mCliTelemSubErrorCode;
        private String mClientId;
        private String mClientInfo;
        private String mCorrelationId;
        private String mEnvironment;
        private String mErrorCode;
        private String mErrorMessage;
        private String mExceptionType;
        private long mExpiresOn;
        private long mExtendedExpiresOn;
        private String mFamilyId;
        private String mHomeAccountId;
        private String mHttpResponseBody;
        private String mHttpResponseHeaders;
        private int mHttpStatusCode;
        private String mIdToken;
        private String mLocalAccountId;
        private String mNegotiatedBrokerProtocolVersion;
        private String mRefreshToken;
        private String mRefreshTokenAge;
        private String mScope;
        private boolean mServicedFromCache;
        private String mSpeRing;
        private String mSubErrorCode;
        private boolean mSuccess;
        private String mTenantId;
        private List<ICacheRecord> mTenantProfileData;
        private String mTokenType;
        private String mUserName;

        public Builder accessToken(String str) {
            this.mAccessToken = str;
            return this;
        }

        public Builder idToken(String str) {
            this.mIdToken = str;
            return this;
        }

        public Builder refreshToken(String str) {
            this.mRefreshToken = str;
            return this;
        }

        public Builder homeAccountId(String str) {
            this.mHomeAccountId = str;
            return this;
        }

        public Builder localAccountId(String str) {
            this.mLocalAccountId = str;
            return this;
        }

        public Builder userName(String str) {
            this.mUserName = str;
            return this;
        }

        public Builder tokenType(String str) {
            this.mTokenType = str;
            return this;
        }

        public Builder clientId(String str) {
            this.mClientId = str;
            return this;
        }

        public Builder familyId(String str) {
            this.mFamilyId = str;
            return this;
        }

        public Builder scope(String str) {
            this.mScope = str;
            return this;
        }

        public Builder clientInfo(String str) {
            this.mClientInfo = str;
            return this;
        }

        public Builder authority(String str) {
            this.mAuthority = str;
            return this;
        }

        public Builder environment(String str) {
            this.mEnvironment = str;
            return this;
        }

        public Builder tenantId(String str) {
            this.mTenantId = str;
            return this;
        }

        public Builder expiresOn(long j) {
            this.mExpiresOn = j;
            return this;
        }

        public Builder extendedExpiresOn(long j) {
            this.mExtendedExpiresOn = j;
            return this;
        }

        public Builder cachedAt(long j) {
            this.mCachedAt = j;
            return this;
        }

        public Builder speRing(String str) {
            this.mSpeRing = str;
            return this;
        }

        public Builder refreshTokenAge(String str) {
            this.mRefreshTokenAge = str;
            return this;
        }

        public Builder success(boolean z) {
            this.mSuccess = z;
            return this;
        }

        public Builder servicedFromCache(boolean z) {
            this.mServicedFromCache = z;
            return this;
        }

        public Builder negotiatedBrokerProtocolVersion(String str) {
            this.mNegotiatedBrokerProtocolVersion = str;
            return this;
        }

        public Builder aadDeviceIdRecord(AadDeviceIdRecord aadDeviceIdRecord) {
            this.mAadDeviceIdRecord = aadDeviceIdRecord;
            return this;
        }

        public Builder errorCode(String str) {
            this.mErrorCode = str;
            return this;
        }

        public Builder errorMessage(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public Builder correlationId(String str) {
            this.mCorrelationId = str;
            return this;
        }

        public Builder subErrorCode(String str) {
            this.mSubErrorCode = str;
            return this;
        }

        public Builder httpStatusCode(int i) {
            this.mHttpStatusCode = i;
            return this;
        }

        public Builder httpResponseHeaders(String str) {
            this.mHttpResponseHeaders = str;
            return this;
        }

        public Builder httpResponseBody(String str) {
            this.mHttpResponseBody = str;
            return this;
        }

        public Builder cliTelemErrorCode(String str) {
            this.mCliTelemErrorCode = str;
            return this;
        }

        public Builder cliTelemSubErrorCode(String str) {
            this.mCliTelemSubErrorCode = str;
            return this;
        }

        public BrokerResult build() {
            return new BrokerResult(this);
        }

        public Builder tenantProfileRecords(List<ICacheRecord> list) {
            if (list != null) {
                this.mTenantProfileData = new ArrayList(list);
            }
            return this;
        }

        public Builder exceptionType(String str) {
            this.mExceptionType = str;
            return this;
        }
    }
}
