package com.microsoft.identity.common.java.providers.microsoft;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.java.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.java.util.CopyUtil;
import com.microsoft.identity.common.java.util.SchemaUtil;
import java.util.Date;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftTokenResponse extends TokenResponse {
    private static final String CLIENT_INFO = "client_info";
    private static final String EXT_EXPIRES_IN = "ext_expires_in";
    private static final String FAMILY_ID = "foci";
    private static final String REFRESH_TOKEN_EXPIRES_IN = "refresh_token_expires_in";
    private static final String SESSION_KEY_JWE = "session_key_jwe";
    private String mAuthority;
    private String mCliTelemErrorCode;
    private String mCliTelemSubErrorCode;
    private transient String mClientId;

    @SerializedName("client_info")
    private String mClientInfo;

    @SerializedName("cloud_instance_host_name")
    @Expose
    private String mCloudInstanceHostName;
    private Date mExtExpiresOn;

    @SerializedName("ext_expires_in")
    @Expose
    private Long mExtendedExpiresIn;

    @SerializedName("foci")
    @Expose
    private String mFamilyId;

    @Expose
    private String mRefreshTokenAge;

    @SerializedName(REFRESH_TOKEN_EXPIRES_IN)
    private String mRefreshTokenExpiresIn;

    @SerializedName("session_key_jwe")
    private String mSessionKeyJwe;

    @Expose
    private String mSpeRing;

    public String getRefreshTokenExpiresIn() {
        return this.mRefreshTokenExpiresIn;
    }

    public void setRefreshTokenExpiresIn(String str) {
        this.mRefreshTokenExpiresIn = str;
    }

    public String getSessionKeyJwe() {
        return this.mSessionKeyJwe;
    }

    public void setSessionKeyJwe(String str) {
        this.mSessionKeyJwe = str;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.TokenResponse
    public String getAuthority() {
        return this.mAuthority;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.TokenResponse
    public void setAuthority(String str) {
        this.mAuthority = str;
    }

    public String getSpeRing() {
        return this.mSpeRing;
    }

    public void setSpeRing(String str) {
        this.mSpeRing = str;
    }

    public String getRefreshTokenAge() {
        return this.mRefreshTokenAge;
    }

    public void setRefreshTokenAge(String str) {
        this.mRefreshTokenAge = str;
    }

    public String getCliTelemErrorCode() {
        return this.mCliTelemErrorCode;
    }

    public void setCliTelemErrorCode(String str) {
        this.mCliTelemErrorCode = str;
    }

    public String getCliTelemSubErrorCode() {
        return this.mCliTelemSubErrorCode;
    }

    public void setCliTelemSubErrorCode(String str) {
        this.mCliTelemSubErrorCode = str;
    }

    public Long getExtExpiresIn() {
        return this.mExtendedExpiresIn;
    }

    public void setExtExpiresIn(Long l) {
        this.mExtendedExpiresIn = l;
    }

    public String getClientInfo() {
        return this.mClientInfo;
    }

    public void setClientInfo(String str) {
        this.mClientInfo = str;
    }

    public Date getExtExpiresOn() {
        return CopyUtil.copyIfNotNull(this.mExtExpiresOn);
    }

    public void setExtExpiresOn(Date date) {
        this.mExtExpiresOn = CopyUtil.copyIfNotNull(date);
    }

    public String getFamilyId() {
        return this.mFamilyId;
    }

    public void setFamilyId(String str) {
        this.mFamilyId = str;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public void setClientId(String str) {
        this.mClientId = str;
    }

    public String getCloudInstanceHostName() {
        return this.mCloudInstanceHostName;
    }

    public void setCloudInstanceHostName(String str) {
        this.mCloudInstanceHostName = str;
    }

    public String getTenantId() {
        return SchemaUtil.getTenantId(getClientInfo(), getIdToken());
    }

    public boolean isMsaAccount() {
        return AzureActiveDirectoryAudience.MSA_MEGA_TENANT_ID.equalsIgnoreCase(getTenantId());
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.TokenResponse
    public String toString() {
        return "MicrosoftTokenResponse{mExtExpiresOn=" + this.mExtExpiresOn + ", mClientInfo='" + this.mClientInfo + "', mClientId='" + this.mClientId + "', mExtendedExpiresIn=" + this.mExtendedExpiresIn + ", mFamilyId='" + this.mFamilyId + "'} " + super.toString();
    }
}
