package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;

/* JADX INFO: loaded from: classes14.dex */
public final class CacheRecord implements ICacheRecord {
    private final AccessTokenRecord mAccessToken;
    private final AccountRecord mAccount;
    private final IdTokenRecord mIdToken;
    private final RefreshTokenRecord mRefreshToken;
    private final IdTokenRecord mV1IdToken;

    public static class CacheRecordBuilder {
        private AccessTokenRecord accessToken;
        private AccountRecord account;
        private IdTokenRecord idToken;
        private RefreshTokenRecord refreshToken;
        private IdTokenRecord v1IdToken;

        CacheRecordBuilder() {
        }

        public CacheRecordBuilder accessToken(AccessTokenRecord accessTokenRecord) {
            this.accessToken = accessTokenRecord;
            return this;
        }

        public CacheRecordBuilder account(AccountRecord accountRecord) {
            if (accountRecord == null) {
                throw new NullPointerException("account is marked non-null but is null");
            }
            this.account = accountRecord;
            return this;
        }

        public CacheRecord build() {
            return new CacheRecord(this.account, this.accessToken, this.refreshToken, this.idToken, this.v1IdToken);
        }

        public CacheRecordBuilder idToken(IdTokenRecord idTokenRecord) {
            this.idToken = idTokenRecord;
            return this;
        }

        public CacheRecordBuilder refreshToken(RefreshTokenRecord refreshTokenRecord) {
            this.refreshToken = refreshTokenRecord;
            return this;
        }

        public String toString() {
            return "CacheRecord.CacheRecordBuilder(account=" + this.account + ", accessToken=" + this.accessToken + ", refreshToken=" + this.refreshToken + ", idToken=" + this.idToken + ", v1IdToken=" + this.v1IdToken + ")";
        }

        public CacheRecordBuilder v1IdToken(IdTokenRecord idTokenRecord) {
            this.v1IdToken = idTokenRecord;
            return this;
        }

        @Deprecated
        public CacheRecordBuilder mAccount(AccountRecord accountRecord) {
            if (accountRecord == null) {
                throw new NullPointerException("The account record for a CacheRecord may not be null");
            }
            this.account = accountRecord;
            return this;
        }
    }

    public String toString() {
        return "CacheRecord(mAccount=" + getAccount() + ", mAccessToken=" + getAccessToken() + ", mRefreshToken=" + getRefreshToken() + ", mIdToken=" + getIdToken() + ", mV1IdToken=" + getV1IdToken() + ")";
    }

    CacheRecord(AccountRecord accountRecord, AccessTokenRecord accessTokenRecord, RefreshTokenRecord refreshTokenRecord, IdTokenRecord idTokenRecord, IdTokenRecord idTokenRecord2) {
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        this.mAccount = accountRecord;
        this.mAccessToken = accessTokenRecord;
        this.mRefreshToken = refreshTokenRecord;
        this.mIdToken = idTokenRecord;
        this.mV1IdToken = idTokenRecord2;
    }

    public static CacheRecordBuilder builder() {
        return new CacheRecordBuilder();
    }

    @Override // com.microsoft.identity.common.java.cache.ICacheRecord
    public AccountRecord getAccount() {
        return this.mAccount;
    }

    @Override // com.microsoft.identity.common.java.cache.ICacheRecord
    public AccessTokenRecord getAccessToken() {
        return this.mAccessToken;
    }

    @Override // com.microsoft.identity.common.java.cache.ICacheRecord
    public RefreshTokenRecord getRefreshToken() {
        return this.mRefreshToken;
    }

    @Override // com.microsoft.identity.common.java.cache.ICacheRecord
    public IdTokenRecord getIdToken() {
        return this.mIdToken;
    }

    @Override // com.microsoft.identity.common.java.cache.ICacheRecord
    public IdTokenRecord getV1IdToken() {
        return this.mV1IdToken;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CacheRecord cacheRecord = (CacheRecord) obj;
            AccountRecord accountRecord = this.mAccount;
            if (accountRecord == null ? cacheRecord.mAccount != null : !accountRecord.equals(cacheRecord.mAccount)) {
                return false;
            }
            AccessTokenRecord accessTokenRecord = this.mAccessToken;
            if (accessTokenRecord == null ? cacheRecord.mAccessToken != null : !accessTokenRecord.equals(cacheRecord.mAccessToken)) {
                return false;
            }
            RefreshTokenRecord refreshTokenRecord = this.mRefreshToken;
            if (refreshTokenRecord == null ? cacheRecord.mRefreshToken != null : !refreshTokenRecord.equals(cacheRecord.mRefreshToken)) {
                return false;
            }
            IdTokenRecord idTokenRecord = this.mIdToken;
            if (idTokenRecord != null) {
                return idTokenRecord.equals(cacheRecord.mIdToken);
            }
            if (cacheRecord.mIdToken == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        AccountRecord accountRecord = this.mAccount;
        int iHashCode = (accountRecord != null ? accountRecord.hashCode() : 0) * 31;
        AccessTokenRecord accessTokenRecord = this.mAccessToken;
        int iHashCode2 = (iHashCode + (accessTokenRecord != null ? accessTokenRecord.hashCode() : 0)) * 31;
        RefreshTokenRecord refreshTokenRecord = this.mRefreshToken;
        int iHashCode3 = (iHashCode2 + (refreshTokenRecord != null ? refreshTokenRecord.hashCode() : 0)) * 31;
        IdTokenRecord idTokenRecord = this.mIdToken;
        return iHashCode3 + (idTokenRecord != null ? idTokenRecord.hashCode() : 0);
    }
}
