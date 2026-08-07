package com.microsoft.identity.common.java.jwt;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.util.StringUtil;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractJwtRequest {

    @SerializedName(ClaimNames.BRK_CLIENT_ID)
    private String mBrkClientId;

    @SerializedName("x5c")
    private String mCert;

    @SerializedName("client_id")
    private String mClientId;

    @SerializedName("refresh_token")
    private String mRefreshToken;

    @SerializedName("resource")
    private String mResource;

    @SerializedName("use")
    private String mUse;

    public static class ClaimNames {
        public static final String ALG = "alg";
        public static final String ASSERTION = "assertion";
        public static final String AUDIENCE = "aud";
        public static final String BRK_CLIENT_ID = "brk_client_id";
        public static final String BRK_REDIRECT_URI = "brk_redirect_uri";
        public static final String CLIENT_ID = "client_id";
        public static final String CLIENT_SCENARIO = "client_scenario";
        public static final String CTX = "ctx";
        public static final String EXP = "exp";
        public static final String GRANT_TYPE = "grant_type";
        public static final String IAT = "iat";
        public static final String ISSUER = "iss";
        public static final String JWE_CRYPTO = "jwe_crypto";
        public static final String KDF_VER = "kdf_ver";
        public static final String KID = "kid";
        public static final String NBF = "nbf";
        public static final String NONCE = "request_nonce";
        public static final String PURPOSE = "purpose";
        public static final String REDIRECT_URI = "redirect_uri";
        public static final String REFRESH_TOKEN = "refresh_token";
        public static final String RESOURCE = "resource";
        public static final String SCOPE = "scope";
        public static final String SESSION_KEY_CRYPTO = "session_key_crypto";
        public static final String TYPE = "typ";
        public static final String USE = "use";
        public static final String X5C = "x5c";
    }

    public void setBrkClientId(String str) {
        this.mBrkClientId = str;
    }

    public void setCert(String str) {
        this.mCert = str;
    }

    public void setClientId(String str) {
        this.mClientId = str;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public void setUse(String str) {
        this.mUse = str;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getCert() {
        return this.mCert;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getBrkClientId() {
        return this.mBrkClientId;
    }

    public String getUse() {
        return this.mUse;
    }

    public String getResource() {
        return this.mResource;
    }

    public void setResource(String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return;
        }
        this.mResource = str;
    }
}
