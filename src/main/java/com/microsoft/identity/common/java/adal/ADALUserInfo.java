package com.microsoft.identity.common.java.adal;

import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccount;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.java.util.DateExtensions;
import com.microsoft.identity.common.java.util.SchemaUtil;
import java.net.URL;
import java.util.Date;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes14.dex */
public class ADALUserInfo {
    private String mDisplayableId;
    private String mFamilyName;
    private String mGivenName;
    private String mIdentityProvider;
    private transient URL mPasswordChangeUrl;
    private transient Date mPasswordExpiresOn;
    private String mUniqueId;

    public ADALUserInfo(AzureActiveDirectoryAccount azureActiveDirectoryAccount) {
        this.mUniqueId = azureActiveDirectoryAccount.getUserId();
        this.mDisplayableId = azureActiveDirectoryAccount.getDisplayableId();
        this.mGivenName = azureActiveDirectoryAccount.getFirstName();
        this.mFamilyName = azureActiveDirectoryAccount.getFamilyName();
        this.mIdentityProvider = azureActiveDirectoryAccount.getIdentityProvider();
        this.mPasswordChangeUrl = azureActiveDirectoryAccount.getPasswordChangeUrl();
        this.mPasswordExpiresOn = azureActiveDirectoryAccount.getPasswordExpiresOn();
    }

    public ADALUserInfo(ILocalAuthenticationResult iLocalAuthenticationResult) {
        this.mUniqueId = iLocalAuthenticationResult.getUniqueId();
        this.mDisplayableId = iLocalAuthenticationResult.getAccountRecord().getUsername();
        this.mGivenName = iLocalAuthenticationResult.getAccountRecord().getFirstName();
        this.mFamilyName = iLocalAuthenticationResult.getAccountRecord().getFamilyName();
        this.mIdentityProvider = SchemaUtil.getIdentityProvider(iLocalAuthenticationResult.getIdToken());
    }

    public ADALUserInfo(String str, String str2, String str3, String str4, String str5) {
        this.mUniqueId = str;
        this.mGivenName = str2;
        this.mFamilyName = str3;
        this.mIdentityProvider = str4;
        this.mDisplayableId = str5;
    }

    public String getUserId() {
        return this.mUniqueId;
    }

    void setUserId(String str) {
        this.mUniqueId = str;
    }

    public String getGivenName() {
        return this.mGivenName;
    }

    public String getFamilyName() {
        return this.mFamilyName;
    }

    public String getIdentityProvider() {
        return this.mIdentityProvider;
    }

    public String getDisplayableId() {
        return this.mDisplayableId;
    }

    void setDisplayableId(String str) {
        this.mDisplayableId = str;
    }

    public URL getPasswordChangeUrl() {
        return this.mPasswordChangeUrl;
    }

    public Date getPasswordExpiresOn() {
        return DateExtensions.createCopy(this.mPasswordExpiresOn);
    }

    public String toString() {
        return "ADALUserInfo{mUniqueId='" + this.mUniqueId + "', mDisplayableId='" + this.mDisplayableId + "', mGivenName='" + this.mGivenName + "', mFamilyName='" + this.mFamilyName + "', mIdentityProvider='" + this.mIdentityProvider + "', mPasswordChangeUrl=" + this.mPasswordChangeUrl + ", mPasswordExpiresOn=" + this.mPasswordExpiresOn + AbstractJsonLexerKt.END_OBJ;
    }
}
