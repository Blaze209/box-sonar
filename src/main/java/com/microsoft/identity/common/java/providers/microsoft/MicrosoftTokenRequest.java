package com.microsoft.identity.common.java.providers.microsoft;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftTokenRequest extends TokenRequest implements IHasExtraParameters {
    public static final String CLAIMS = "claims";
    public static final String CLIENT_APP_NAME = "x-app-name";
    public static final String CLIENT_APP_VERSION = "x-app-ver";
    public static final String CLIENT_INFO = "client_info";
    public static final String CODE_VERIFIER = "code_verifier";
    public static final String CORRELATION_ID = "client-request-id";
    public static final String DEVICE_CODE = "device_code";
    public static final String ID_TOKEN_VERSION = "itver";
    public static final String INSTANCE_AWARE = "instance_aware";
    public static final String MAM_VERSION = "mamver";
    public static final String MICROSOFT_ENROLLMENT_ID = "microsoft_enrollment_id";
    public static final String TRANSFER_TOKEN = "transfer_token";
    private transient String mBrokerVersion;

    @SerializedName("claims")
    @Expose
    private String mClaims;

    @SerializedName("x-app-name")
    @Expose
    private String mClientAppName;

    @SerializedName("x-app-ver")
    @Expose
    private String mClientAppVersion;

    @SerializedName("client_info")
    @Expose
    private String mClientInfoEnabled = "1";

    @SerializedName(CODE_VERIFIER)
    private String mCodeVerifier;

    @SerializedName("client-request-id")
    @Expose
    private UUID mCorrelationId;

    @SerializedName("device_code")
    @Expose
    private String mDeviceCode;

    @SerializedName("itver")
    @Expose
    private String mIdTokenVersion;

    @SerializedName("instance_aware")
    @Expose
    private String mInstanceAware;

    @SerializedName(MAM_VERSION)
    @Expose
    private String mMamVersion;

    @SerializedName(MICROSOFT_ENROLLMENT_ID)
    @Expose
    private String mMicrosoftEnrollmentId;
    private boolean mPKeyAuthHeaderAllowed;
    private String mTokenScope;

    @SerializedName("transfer_token")
    @Expose
    private String mTransferToken;

    public boolean isPKeyAuthHeaderAllowed() {
        return this.mPKeyAuthHeaderAllowed;
    }

    public void setPKeyAuthHeaderAllowed(boolean z) {
        this.mPKeyAuthHeaderAllowed = z;
    }

    public String getCodeVerifier() {
        return this.mCodeVerifier;
    }

    public void setCodeVerifier(String str) {
        this.mCodeVerifier = str;
    }

    public String getClientInfoEnabled() {
        return this.mClientInfoEnabled;
    }

    public void setCorrelationId(UUID uuid) {
        this.mCorrelationId = uuid;
    }

    public UUID getCorrelationId() {
        return this.mCorrelationId;
    }

    public String getIdTokenVersion() {
        return this.mIdTokenVersion;
    }

    public void setIdTokenVersion(String str) {
        this.mIdTokenVersion = str;
    }

    public String getClaims() {
        return this.mClaims;
    }

    public void setClaims(String str) {
        this.mClaims = str;
    }

    public String getInstanceAware() {
        return this.mInstanceAware;
    }

    public void setInstanceAware(String str) {
        this.mInstanceAware = str;
    }

    public String getClientAppName() {
        return this.mClientAppName;
    }

    public void setClientAppName(String str) {
        this.mClientAppName = str;
    }

    public String getTokenScope() {
        return this.mTokenScope;
    }

    public void setTokenScope(String str) {
        this.mTokenScope = str;
    }

    public String getClientAppVersion() {
        return this.mClientAppVersion;
    }

    public void setClientAppVersion(String str) {
        this.mClientAppVersion = str;
    }

    public String getMamVersion() {
        return this.mMamVersion;
    }

    public void setMamversion(String str) {
        this.mMamVersion = str;
    }

    public String getBrokerVersion() {
        return this.mBrokerVersion;
    }

    public void setBrokerVersion(String str) {
        this.mBrokerVersion = str;
    }

    public String getMicrosoftEnrollmentId() {
        return this.mMicrosoftEnrollmentId;
    }

    public void setMicrosoftEnrollmentId(String str) {
        this.mMicrosoftEnrollmentId = str;
    }

    public String getDeviceCode() {
        return this.mDeviceCode;
    }

    public void setDeviceCode(String str) {
        this.mDeviceCode = str;
    }

    public String getTransferToken() {
        return this.mTransferToken;
    }

    public void setTransferToken(String str) {
        this.mTransferToken = str;
    }
}
