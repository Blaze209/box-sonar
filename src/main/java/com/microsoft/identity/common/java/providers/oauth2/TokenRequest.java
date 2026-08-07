package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class TokenRequest implements IHasExtraParameters {

    @SerializedName(AbstractJwtRequest.ClaimNames.BRK_CLIENT_ID)
    @Expose
    private String mBrkClientId;

    @SerializedName(AbstractJwtRequest.ClaimNames.BRK_REDIRECT_URI)
    @Expose
    private String mBrkRedirectUri;

    @SerializedName("client_assertion")
    private String mClientAssertion;

    @SerializedName("client_assertion_type")
    @Expose
    private String mClientAssertionType;

    @SerializedName("client_id")
    @Expose
    private String mClientId;

    @SerializedName("client_secret")
    private String mClientSecret;

    @SerializedName("code")
    private String mCode;
    private transient Iterable<Map.Entry<String, String>> mExtendedParameters;

    @SerializedName("grant_type")
    @Expose
    private String mGrantType;

    @SerializedName("redirect_uri")
    @Expose
    private String mRedirectUri;

    @SerializedName("refresh_token")
    private String mRefreshToken;

    @SerializedName("req_cnf")
    private String mRequestConfirmation;

    @SerializedName("scope")
    @Expose
    private String mScope;

    @SerializedName("token_type")
    @Expose
    private String mTokenType;

    public static class GrantTypes {
        public static final String AUTHORIZATION_CODE = "authorization_code";
        public static final String CLIENT_CREDENTIALS = "client_credentials";
        public static final String DEVICE_CODE = "urn:ietf:params:oauth:grant-type:device_code";
        public static final String JWT_BEARER = "urn:ietf:params:oauth:grant-type:jwt-bearer";
        public static final String PASSWORD = "password";
        public static final String REFRESH_TOKEN = "refresh_token";
        public static final String RESOURCE_ACCOUNT = "resource_account";
        public static final String TRANSFER_TOKEN = "transfer_token";
    }

    public static class TokenType {
        public static final String POP = "pop";
    }

    public String getRequestConfirmation() {
        return this.mRequestConfirmation;
    }

    public void setRequestConfirmation(String str) {
        this.mRequestConfirmation = str;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    public synchronized Iterable<Map.Entry<String, String>> getExtraParameters() {
        return this.mExtendedParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    public synchronized void setExtraParameters(Iterable<Map.Entry<String, String>> iterable) {
        this.mExtendedParameters = iterable;
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public void setTokenType(String str) {
        this.mTokenType = str;
    }

    public String getCode() {
        return this.mCode;
    }

    public void setCode(String str) {
        this.mCode = str;
    }

    public String getRedirectUri() {
        return this.mRedirectUri;
    }

    public void setRedirectUri(String str) {
        this.mRedirectUri = str;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public void setClientId(String str) {
        this.mClientId = str;
    }

    public String getBrkRedirectUri() {
        return this.mBrkRedirectUri;
    }

    public void setBrkRedirectUri(String str) {
        this.mBrkRedirectUri = str;
    }

    public String getBrkClientId() {
        return this.mBrkClientId;
    }

    public void setBrkClientId(String str) {
        this.mBrkClientId = str;
    }

    public String getGrantType() {
        return this.mGrantType;
    }

    public void setGrantType(String str) {
        this.mGrantType = str;
    }

    public void setClientSecret(String str) {
        this.mClientSecret = str;
    }

    public String getClientSecret() {
        return this.mClientSecret;
    }

    public String getClientAssertionType() {
        return this.mClientAssertionType;
    }

    public void setClientAssertionType(String str) {
        this.mClientAssertionType = str;
    }

    public String getClientAssertion() {
        return this.mClientAssertion;
    }

    public void setClientAssertion(String str) {
        this.mClientAssertion = str;
    }

    public String getScope() {
        return this.mScope;
    }

    public void setScope(String str) {
        this.mScope = str;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }
}
