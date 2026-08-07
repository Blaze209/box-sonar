package com.microsoft.identity.common.java.dto;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes14.dex */
public class PrimaryRefreshTokenRecord extends Credential {

    @SerializedName(Credential.SerializedNames.EXPIRES_ON)
    private String mExpiresOn;

    @SerializedName("family_id")
    private String mFamilyId;

    @SerializedName(SerializedNames.PRT_PROTOCOL_VERSION)
    private String mPrtProtocolVersion;

    @SerializedName(SerializedNames.SESSION_KEY)
    private String mSessionKey;

    @SerializedName(SerializedNames.SESSION_KEY_ROLLING_DATE)
    private String mSessionKeyRollingDate;

    public static class SerializedNames extends Credential.SerializedNames {
        public static final String FAMILY_ID = "family_id";
        public static final String PRT_PROTOCOL_VERSION = "prt_protocol_version";
        public static final String SESSION_KEY = "session_key";
        public static final String SESSION_KEY_ROLLING_DATE = "session_key_rolling_date";
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof PrimaryRefreshTokenRecord;
    }

    @Override // com.microsoft.identity.common.java.dto.Credential
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimaryRefreshTokenRecord)) {
            return false;
        }
        PrimaryRefreshTokenRecord primaryRefreshTokenRecord = (PrimaryRefreshTokenRecord) obj;
        if (!primaryRefreshTokenRecord.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String str = this.mFamilyId;
        String str2 = primaryRefreshTokenRecord.mFamilyId;
        if (str != null ? !str.equals(str2) : str2 != null) {
            return false;
        }
        String str3 = this.mExpiresOn;
        String str4 = primaryRefreshTokenRecord.mExpiresOn;
        if (str3 != null ? !str3.equals(str4) : str4 != null) {
            return false;
        }
        String str5 = this.mSessionKey;
        String str6 = primaryRefreshTokenRecord.mSessionKey;
        if (str5 != null ? !str5.equals(str6) : str6 != null) {
            return false;
        }
        String str7 = this.mPrtProtocolVersion;
        String str8 = primaryRefreshTokenRecord.mPrtProtocolVersion;
        if (str7 != null ? !str7.equals(str8) : str8 != null) {
            return false;
        }
        String str9 = this.mSessionKeyRollingDate;
        String str10 = primaryRefreshTokenRecord.mSessionKeyRollingDate;
        return str9 != null ? str9.equals(str10) : str10 == null;
    }

    @Override // com.microsoft.identity.common.java.dto.Credential
    public int hashCode() {
        int iHashCode = super.hashCode();
        String str = this.mFamilyId;
        int iHashCode2 = (iHashCode * 59) + (str == null ? 43 : str.hashCode());
        String str2 = this.mExpiresOn;
        int iHashCode3 = (iHashCode2 * 59) + (str2 == null ? 43 : str2.hashCode());
        String str3 = this.mSessionKey;
        int iHashCode4 = (iHashCode3 * 59) + (str3 == null ? 43 : str3.hashCode());
        String str4 = this.mPrtProtocolVersion;
        int i = iHashCode4 * 59;
        int iHashCode5 = str4 == null ? 43 : str4.hashCode();
        String str5 = this.mSessionKeyRollingDate;
        return ((i + iHashCode5) * 59) + (str5 != null ? str5.hashCode() : 43);
    }

    public String getFamilyId() {
        return this.mFamilyId;
    }

    public void setFamilyId(String str) {
        this.mFamilyId = str;
    }

    public boolean isExpired(String str) {
        return Long.parseLong(str) * 1000 < System.currentTimeMillis();
    }

    @Override // com.microsoft.identity.common.java.dto.Credential
    public boolean isExpired() {
        return isExpired(getExpiresOn());
    }

    public String getExpiresOn() {
        return this.mExpiresOn;
    }

    public void setExpiresOn(String str) {
        this.mExpiresOn = str;
    }

    public String getSessionKey() {
        return this.mSessionKey;
    }

    public void setSessionKey(String str) {
        this.mSessionKey = str;
    }

    public String getPrtProtocolVersion() {
        return this.mPrtProtocolVersion;
    }

    public void setPrtProtocolVersion(String str) {
        this.mPrtProtocolVersion = str;
    }

    public String getSessionKeyRollingDate() {
        return this.mSessionKeyRollingDate;
    }

    public void setSessionKeyRollingDate(String str) {
        this.mSessionKeyRollingDate = str;
    }

    @Override // com.microsoft.identity.common.java.dto.AccountCredentialBase
    public String toString() {
        return "PrimaryRefreshTokenRecord{mFamilyId='" + this.mFamilyId + "', mExpiresOn='" + this.mExpiresOn + "', mSessionKey='" + this.mSessionKey + "', mPrtProtocolVersion='" + this.mPrtProtocolVersion + "', mSessionKeyRollingDate='" + this.mSessionKeyRollingDate + "'} " + super.toString();
    }
}
