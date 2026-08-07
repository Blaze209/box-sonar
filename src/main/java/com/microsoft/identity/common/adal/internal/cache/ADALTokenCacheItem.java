package com.microsoft.identity.common.adal.internal.cache;

import com.microsoft.identity.common.java.adal.ADALUserInfo;
import com.microsoft.identity.common.java.cache.ITokenCacheItem;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccessToken;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccount;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryTokenResponse;
import com.microsoft.identity.common.java.util.DateExtensions;
import java.util.Date;

/* JADX INFO: loaded from: classes14.dex */
public class ADALTokenCacheItem implements ITokenCacheItem {
    private String mAccessToken;
    private String mAuthority;
    private String mClientId;
    private Date mExpiresOn;
    private Date mExtendedExpiresOn;
    private String mFamilyClientId;
    private boolean mIsMultiResourceRefreshToken;
    private String mRawIdToken;
    private String mRefreshtoken;
    private String mResource;
    private String mSpeRing;
    private String mTenantId;
    private ADALUserInfo mUserInfo;

    public ADALTokenCacheItem() {
    }

    ADALTokenCacheItem(ADALTokenCacheItem aDALTokenCacheItem) {
        this.mAuthority = aDALTokenCacheItem.getAuthority();
        this.mResource = aDALTokenCacheItem.getResource();
        this.mClientId = aDALTokenCacheItem.getClientId();
        this.mAccessToken = aDALTokenCacheItem.getAccessToken();
        this.mRefreshtoken = aDALTokenCacheItem.getRefreshToken();
        this.mRawIdToken = aDALTokenCacheItem.getRawIdToken();
        this.mUserInfo = aDALTokenCacheItem.getUserInfo();
        this.mExpiresOn = aDALTokenCacheItem.getExpiresOn();
        this.mIsMultiResourceRefreshToken = aDALTokenCacheItem.getIsMultiResourceRefreshToken();
        this.mTenantId = aDALTokenCacheItem.getTenantId();
        this.mFamilyClientId = aDALTokenCacheItem.getFamilyClientId();
        this.mExtendedExpiresOn = aDALTokenCacheItem.getExtendedExpiresOn();
        this.mSpeRing = aDALTokenCacheItem.getSpeRing();
    }

    ADALTokenCacheItem(AzureActiveDirectoryOAuth2Strategy azureActiveDirectoryOAuth2Strategy, AzureActiveDirectoryAuthorizationRequest azureActiveDirectoryAuthorizationRequest, AzureActiveDirectoryTokenResponse azureActiveDirectoryTokenResponse) throws ClientException {
        String issuerCacheIdentifier = azureActiveDirectoryOAuth2Strategy.getIssuerCacheIdentifier(azureActiveDirectoryAuthorizationRequest);
        AzureActiveDirectoryAccount azureActiveDirectoryAccountCreateAccount = azureActiveDirectoryOAuth2Strategy.createAccount(azureActiveDirectoryTokenResponse);
        azureActiveDirectoryAccountCreateAccount.setEnvironment(issuerCacheIdentifier);
        AzureActiveDirectoryAccessToken accessTokenFromResponse = azureActiveDirectoryOAuth2Strategy.getAccessTokenFromResponse(azureActiveDirectoryTokenResponse);
        AzureActiveDirectoryRefreshToken refreshTokenFromResponse = azureActiveDirectoryOAuth2Strategy.getRefreshTokenFromResponse(azureActiveDirectoryTokenResponse);
        this.mAuthority = issuerCacheIdentifier;
        this.mResource = azureActiveDirectoryAuthorizationRequest.getScope();
        this.mClientId = azureActiveDirectoryAuthorizationRequest.getClientId();
        this.mAccessToken = accessTokenFromResponse.getAccessToken();
        this.mRefreshtoken = refreshTokenFromResponse.getRefreshToken();
        this.mRawIdToken = azureActiveDirectoryTokenResponse.getIdToken();
        this.mUserInfo = new ADALUserInfo(azureActiveDirectoryAccountCreateAccount);
        this.mTenantId = azureActiveDirectoryAccountCreateAccount.getRealm();
        this.mExpiresOn = accessTokenFromResponse.getExpiresOn();
        this.mExtendedExpiresOn = accessTokenFromResponse.getExtendedExpiresOn();
        this.mIsMultiResourceRefreshToken = true;
        this.mFamilyClientId = refreshTokenFromResponse.getFamilyId();
        this.mSpeRing = azureActiveDirectoryTokenResponse.getSpeRing();
    }

    public static ADALTokenCacheItem getAsMRRTTokenCacheItem(ADALTokenCacheItem aDALTokenCacheItem) {
        ADALTokenCacheItem aDALTokenCacheItem2 = new ADALTokenCacheItem(aDALTokenCacheItem);
        aDALTokenCacheItem2.setResource(null);
        aDALTokenCacheItem2.setAccessToken(null);
        return aDALTokenCacheItem2;
    }

    public static ADALTokenCacheItem getAsFRTTokenCacheItem(ADALTokenCacheItem aDALTokenCacheItem) {
        ADALTokenCacheItem aDALTokenCacheItem2 = new ADALTokenCacheItem(aDALTokenCacheItem);
        aDALTokenCacheItem2.setResource(null);
        aDALTokenCacheItem2.setAccessToken(null);
        aDALTokenCacheItem2.setClientId(null);
        return aDALTokenCacheItem2;
    }

    String getSpeRing() {
        return this.mSpeRing;
    }

    void setSpeRing(String str) {
        this.mSpeRing = str;
    }

    public ADALUserInfo getUserInfo() {
        return this.mUserInfo;
    }

    public void setUserInfo(ADALUserInfo aDALUserInfo) {
        this.mUserInfo = aDALUserInfo;
    }

    @Override // com.microsoft.identity.common.java.cache.ITokenCacheItem
    public String getResource() {
        return this.mResource;
    }

    public void setResource(String str) {
        this.mResource = str;
    }

    @Override // com.microsoft.identity.common.java.cache.ITokenCacheItem
    public String getAuthority() {
        return this.mAuthority;
    }

    public void setAuthority(String str) {
        this.mAuthority = str;
    }

    @Override // com.microsoft.identity.common.java.cache.ITokenCacheItem
    public String getClientId() {
        return this.mClientId;
    }

    public void setClientId(String str) {
        this.mClientId = str;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public void setAccessToken(String str) {
        this.mAccessToken = str;
    }

    @Override // com.microsoft.identity.common.java.cache.ITokenCacheItem
    public String getRefreshToken() {
        return this.mRefreshtoken;
    }

    public void setRefreshToken(String str) {
        this.mRefreshtoken = str;
    }

    public Date getExpiresOn() {
        return DateExtensions.createCopy(this.mExpiresOn);
    }

    public void setExpiresOn(Date date) {
        this.mExpiresOn = DateExtensions.createCopy(date);
    }

    public boolean getIsMultiResourceRefreshToken() {
        return this.mIsMultiResourceRefreshToken;
    }

    public void setIsMultiResourceRefreshToken(boolean z) {
        this.mIsMultiResourceRefreshToken = z;
    }

    public String getTenantId() {
        return this.mTenantId;
    }

    public void setTenantId(String str) {
        this.mTenantId = str;
    }

    public String getRawIdToken() {
        return this.mRawIdToken;
    }

    public void setRawIdToken(String str) {
        this.mRawIdToken = str;
    }

    public final String getFamilyClientId() {
        return this.mFamilyClientId;
    }

    public final void setFamilyClientId(String str) {
        this.mFamilyClientId = str;
    }

    public final void setExtendedExpiresOn(Date date) {
        this.mExtendedExpiresOn = DateExtensions.createCopy(date);
    }

    public final Date getExtendedExpiresOn() {
        return DateExtensions.createCopy(this.mExtendedExpiresOn);
    }
}
