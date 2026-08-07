package com.microsoft.identity.common.java.jwt;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes14.dex */
public final class JwtRequestBody extends AbstractJwtRequest {

    @SerializedName(AbstractJwtRequest.ClaimNames.ASSERTION)
    private String mAssertion;

    @SerializedName("aud")
    private String mAudience;

    @SerializedName(AbstractJwtRequest.ClaimNames.BRK_REDIRECT_URI)
    private String mBrkRedirectUri;

    @SerializedName(AbstractJwtRequest.ClaimNames.CLIENT_SCENARIO)
    private String mClientScenario;

    @SerializedName("exp")
    private String mExp;

    @SerializedName("grant_type")
    private String mGrantType;

    @SerializedName("iat")
    private String mIat;

    @SerializedName("iss")
    private String mIssuer;

    @SerializedName(AbstractJwtRequest.ClaimNames.JWE_CRYPTO)
    private JsonObject mJweCrypto;

    @SerializedName("scope")
    private String mJwtScope;

    @SerializedName("nbf")
    private String mNbf;

    @SerializedName(AbstractJwtRequest.ClaimNames.NONCE)
    private String mNonce;

    @SerializedName(AbstractJwtRequest.ClaimNames.PURPOSE)
    private String mPurpose;

    @SerializedName("redirect_uri")
    private String mRedirectUri;

    @SerializedName(AbstractJwtRequest.ClaimNames.SESSION_KEY_CRYPTO)
    private JsonObject mSessionKeyCrypto;

    public void setAssertion(String str) {
        this.mAssertion = str;
    }

    public void setAudience(String str) {
        this.mAudience = str;
    }

    public void setBrkRedirectUri(String str) {
        this.mBrkRedirectUri = str;
    }

    public void setClientScenario(String str) {
        this.mClientScenario = str;
    }

    public void setGrantType(String str) {
        this.mGrantType = str;
    }

    public void setIssuer(String str) {
        this.mIssuer = str;
    }

    public void setJweCrypto(JsonObject jsonObject) {
        this.mJweCrypto = jsonObject;
    }

    public void setJwtScope(String str) {
        this.mJwtScope = str;
    }

    public void setNonce(String str) {
        this.mNonce = str;
    }

    public void setPurpose(String str) {
        this.mPurpose = str;
    }

    public void setRedirectUri(String str) {
        this.mRedirectUri = str;
    }

    public void setSessionKeyCrypto(JsonObject jsonObject) {
        this.mSessionKeyCrypto = jsonObject;
    }

    public String getJwtScope() {
        return this.mJwtScope;
    }

    public String getAudience() {
        return this.mAudience;
    }

    public String getIssuer() {
        return this.mIssuer;
    }

    public String getAssertion() {
        return this.mAssertion;
    }

    public String getGrantType() {
        return this.mGrantType;
    }

    public String getNonce() {
        return this.mNonce;
    }

    public String getRedirectUri() {
        return this.mRedirectUri;
    }

    public String getBrkRedirectUri() {
        return this.mBrkRedirectUri;
    }

    public String getIat() {
        return this.mIat;
    }

    public String getNbf() {
        return this.mNbf;
    }

    public String getExp() {
        return this.mExp;
    }

    public JsonObject getJweCrypto() {
        return this.mJweCrypto;
    }

    public JsonObject getSessionKeyCrypto() {
        return this.mSessionKeyCrypto;
    }

    public String getPurpose() {
        return this.mPurpose;
    }

    public String getClientScenario() {
        return this.mClientScenario;
    }

    public void setIat(long j) {
        this.mIat = String.valueOf(j);
    }

    public void setNBF(long j) {
        this.mNbf = String.valueOf(j);
    }

    public void setExp(long j, long j2) {
        this.mExp = String.valueOf(j + j2);
    }
}
