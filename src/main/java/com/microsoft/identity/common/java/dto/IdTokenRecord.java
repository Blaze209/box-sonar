package com.microsoft.identity.common.java.dto;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes14.dex */
public class IdTokenRecord extends Credential {

    @SerializedName("authority")
    private String mAuthority;

    @SerializedName("realm")
    private String mRealm;

    public static class SerializedNames extends Credential.SerializedNames {
        public static final String AUTHORITY = "authority";
        public static final String REALM = "realm";
    }

    @Override // com.microsoft.identity.common.java.dto.Credential
    public boolean isExpired() {
        return false;
    }

    public String getAuthority() {
        return this.mAuthority;
    }

    public void setAuthority(String str) {
        this.mAuthority = str;
    }

    public String getRealm() {
        return this.mRealm;
    }

    public void setRealm(String str) {
        this.mRealm = str;
    }

    @Override // com.microsoft.identity.common.java.dto.Credential
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        IdTokenRecord idTokenRecord = (IdTokenRecord) obj;
        String str = this.mRealm;
        if (str == null ? idTokenRecord.mRealm != null : !str.equals(idTokenRecord.mRealm)) {
            return false;
        }
        String str2 = this.mAuthority;
        if (str2 != null) {
            return str2.equals(idTokenRecord.mAuthority);
        }
        return idTokenRecord.mAuthority == null;
    }

    @Override // com.microsoft.identity.common.java.dto.Credential
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.mRealm;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mAuthority;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
