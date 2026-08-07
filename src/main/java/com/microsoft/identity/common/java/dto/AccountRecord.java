package com.microsoft.identity.common.java.dto;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes14.dex */
public class AccountRecord extends AccountCredentialBase implements IAccountRecord {

    @SerializedName(SerializedNames.ALTERNATIVE_ACCOUNT_ID)
    private String mAlternativeAccountId;

    @SerializedName(SerializedNames.AUTHORITY_TYPE)
    private String mAuthorityType;

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("client_info")
    private String mClientInfo;

    @SerializedName("environment")
    private String mEnvironment;

    @SerializedName("family_name")
    private String mFamilyName;

    @SerializedName(SerializedNames.FIRST_NAME)
    private String mFirstName;

    @SerializedName("home_account_id")
    private String mHomeAccountId;

    @SerializedName(SerializedNames.LOCAL_ACCOUNT_ID)
    private String mLocalAccountId;

    @SerializedName("middle_name")
    private String mMiddleName;

    @SerializedName("name")
    private String mName;

    @SerializedName("realm")
    private String mRealm;

    @SerializedName("username")
    private String mUsername;

    public static class SerializedNames {
        public static final String ALTERNATIVE_ACCOUNT_ID = "alternative_account_id";
        public static final String AUTHORITY_TYPE = "authority_type";
        public static final String AVATAR_URL = "avatar_url";
        public static final String CLIENT_INFO = "client_info";
        public static final String ENVIRONMENT = "environment";
        public static final String FAMILY_NAME = "family_name";
        public static final String FIRST_NAME = "first_name";
        public static final String HOME_ACCOUNT_ID = "home_account_id";
        public static final String LOCAL_ACCOUNT_ID = "local_account_id";
        public static final String MIDDLE_NAME = "middle_name";
        public static final String NAME = "name";
        public static final String REALM = "realm";
        public static final String USERNAME = "username";
    }

    public AccountRecord() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AccountRecord(IAccountRecord iAccountRecord) {
        setHomeAccountId(iAccountRecord.getHomeAccountId());
        setEnvironment(iAccountRecord.getEnvironment());
        setRealm(iAccountRecord.getRealm());
        setLocalAccountId(iAccountRecord.getLocalAccountId());
        setUsername(iAccountRecord.getUsername());
        setAuthorityType(iAccountRecord.getAuthorityType());
        setClientInfo(iAccountRecord.getClientInfo());
        setAlternativeAccountId(iAccountRecord.getAlternativeAccountId());
        setFirstName(iAccountRecord.getFirstName());
        setFamilyName(iAccountRecord.getFamilyName());
        setMiddleName(iAccountRecord.getMiddleName());
        setName(iAccountRecord.getName());
        setAvatarUrl(iAccountRecord.getAvatarUrl());
        if (iAccountRecord instanceof AccountCredentialBase) {
            setAdditionalFields(((AccountCredentialBase) iAccountRecord).getAdditionalFields());
        }
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getHomeAccountId() {
        return this.mHomeAccountId;
    }

    public void setHomeAccountId(String str) {
        this.mHomeAccountId = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getEnvironment() {
        return this.mEnvironment;
    }

    public void setEnvironment(String str) {
        this.mEnvironment = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getRealm() {
        return this.mRealm;
    }

    public void setRealm(String str) {
        this.mRealm = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getLocalAccountId() {
        return this.mLocalAccountId;
    }

    public void setLocalAccountId(String str) {
        this.mLocalAccountId = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getUsername() {
        return this.mUsername;
    }

    public void setUsername(String str) {
        this.mUsername = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAuthorityType() {
        return this.mAuthorityType;
    }

    public void setAuthorityType(String str) {
        this.mAuthorityType = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAlternativeAccountId() {
        return this.mAlternativeAccountId;
    }

    public void setAlternativeAccountId(String str) {
        this.mAlternativeAccountId = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getFirstName() {
        return this.mFirstName;
    }

    public void setFirstName(String str) {
        this.mFirstName = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getFamilyName() {
        return this.mFamilyName;
    }

    public void setMiddleName(String str) {
        this.mMiddleName = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getMiddleName() {
        return this.mMiddleName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getName() {
        return this.mName;
    }

    public void setFamilyName(String str) {
        this.mFamilyName = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAvatarUrl() {
        return this.mAvatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.mAvatarUrl = str;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getClientInfo() {
        return this.mClientInfo;
    }

    public void setClientInfo(String str) {
        this.mClientInfo = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AccountRecord accountRecord = (AccountRecord) obj;
            String str = this.mHomeAccountId;
            if (str == null ? accountRecord.mHomeAccountId != null : !str.equals(accountRecord.mHomeAccountId)) {
                return false;
            }
            String str2 = this.mEnvironment;
            if (str2 == null ? accountRecord.mEnvironment != null : !str2.equals(accountRecord.mEnvironment)) {
                return false;
            }
            String str3 = this.mRealm;
            if (str3 == null ? accountRecord.mRealm != null : !str3.equals(accountRecord.mRealm)) {
                return false;
            }
            String str4 = this.mLocalAccountId;
            if (str4 == null ? accountRecord.mLocalAccountId != null : !str4.equals(accountRecord.mLocalAccountId)) {
                return false;
            }
            String str5 = this.mUsername;
            if (str5 == null ? accountRecord.mUsername != null : !str5.equals(accountRecord.mUsername)) {
                return false;
            }
            String str6 = this.mAuthorityType;
            if (str6 == null ? accountRecord.mAuthorityType != null : !str6.equals(accountRecord.mAuthorityType)) {
                return false;
            }
            String str7 = this.mAlternativeAccountId;
            if (str7 == null ? accountRecord.mAlternativeAccountId != null : !str7.equals(accountRecord.mAlternativeAccountId)) {
                return false;
            }
            String str8 = this.mFirstName;
            if (str8 == null ? accountRecord.mFirstName != null : !str8.equals(accountRecord.mFirstName)) {
                return false;
            }
            String str9 = this.mFamilyName;
            if (str9 == null ? accountRecord.mFamilyName != null : !str9.equals(accountRecord.mFamilyName)) {
                return false;
            }
            String str10 = this.mAvatarUrl;
            if (str10 != null) {
                return str10.equals(accountRecord.mAvatarUrl);
            }
            if (accountRecord.mAvatarUrl == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.mHomeAccountId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mEnvironment;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mRealm;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mLocalAccountId;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mUsername;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.mAuthorityType;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.mAlternativeAccountId;
        int iHashCode7 = (iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.mFirstName;
        int iHashCode8 = (iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.mFamilyName;
        int iHashCode9 = (iHashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.mAvatarUrl;
        return iHashCode9 + (str10 != null ? str10.hashCode() : 0);
    }
}
