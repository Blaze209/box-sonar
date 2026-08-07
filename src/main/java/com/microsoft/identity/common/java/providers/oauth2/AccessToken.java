package com.microsoft.identity.common.java.providers.oauth2;

/* JADX INFO: loaded from: classes14.dex */
public class AccessToken {
    private static final int SECONDS_MS = 1000;
    private static final long TOKEN_EXPIRED_BUFFER = 600000;
    private long mExpiresIn;
    private String mRawAccessToken;
    private long mTokenReceivedTime;
    private String mTokenType;

    public long getTokenExpiredBuffer() {
        return 600000L;
    }

    public AccessToken(TokenResponse tokenResponse) {
        this.mExpiresIn = tokenResponse.getExpiresIn().longValue();
        this.mTokenReceivedTime = tokenResponse.getResponseReceivedTime();
        this.mTokenType = tokenResponse.getTokenType();
        this.mRawAccessToken = tokenResponse.getAccessToken();
    }

    public String getAccessToken() {
        return this.mRawAccessToken;
    }

    public boolean isExpired() {
        return this.mTokenReceivedTime + (this.mExpiresIn * 1000) > System.currentTimeMillis() + 600000;
    }

    public long getExpiresIn() {
        return this.mExpiresIn;
    }

    public void setExpiresIn(long j) {
        this.mExpiresIn = j;
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public void setTokenType(String str) {
        this.mTokenType = str;
    }

    public long getTokenReceivedTime() {
        return this.mTokenReceivedTime;
    }

    public void setTokenReceivedTime(long j) {
        this.mTokenReceivedTime = j;
    }

    public String getRawAccessToken() {
        return this.mRawAccessToken;
    }

    public void setRawAccessToken(String str) {
        this.mRawAccessToken = str;
    }
}
