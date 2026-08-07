package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes14.dex */
public class TokenResponse implements ISuccessResponse {

    @SerializedName("access_token")
    private String mAccessToken;

    @SerializedName("expires_in")
    @Expose
    private Long mExpiresIn;
    private transient Iterable<Map.Entry<String, String>> mExtraParameters;

    @SerializedName("id_token")
    private String mIdToken;

    @SerializedName("refresh_in")
    @Expose
    private Long mRefreshIn;

    @SerializedName("refresh_token")
    private String mRefreshToken;

    @Expose
    private long mResponseReceivedTime;

    @SerializedName("scope")
    @Expose
    private String mScope;

    @SerializedName("state")
    @Expose
    private String mState;
    private transient String mTokenAuthority;

    @SerializedName("token_type")
    @Expose
    private String mTokenType;

    public String getAuthority() {
        return this.mTokenAuthority;
    }

    public void setAuthority(String str) {
        this.mTokenAuthority = str;
    }

    public Long getExpiresIn() {
        return this.mExpiresIn;
    }

    public void setExpiresIn(Long l) {
        this.mExpiresIn = l;
    }

    public Long getRefreshIn() {
        return this.mRefreshIn;
    }

    public void setRefreshIn(Long l) {
        this.mRefreshIn = l;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public void setAccessToken(String str) {
        this.mAccessToken = str;
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public void setTokenType(String str) {
        this.mTokenType = str;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public String getScope() {
        return this.mScope;
    }

    public void setScope(String str) {
        this.mScope = str;
    }

    public String getState() {
        return this.mState;
    }

    public void setState(String str) {
        this.mState = str;
    }

    public String getIdToken() {
        return this.mIdToken;
    }

    public void setIdToken(String str) {
        this.mIdToken = str;
    }

    public void setResponseReceivedTime(Long l) {
        this.mResponseReceivedTime = l.longValue();
    }

    public long getResponseReceivedTime() {
        return this.mResponseReceivedTime;
    }

    public String toString() {
        return "TokenResponse{mExpiresIn=" + this.mExpiresIn + ", mRefreshIn=" + this.mRefreshIn + ", mAccessToken='" + this.mAccessToken + "', mTokenType='" + this.mTokenType + "', mRefreshToken='" + this.mRefreshToken + "', mScope='" + this.mScope + "', mState='" + this.mState + "', mIdToken='" + this.mIdToken + "', mResponseReceivedTime=" + this.mResponseReceivedTime + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    public synchronized Iterable<Map.Entry<String, String>> getExtraParameters() {
        return this.mExtraParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    public synchronized void setExtraParameters(Iterable<Map.Entry<String, String>> iterable) {
        this.mExtraParameters = iterable;
    }
}
