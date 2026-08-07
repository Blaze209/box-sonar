package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;

/* JADX INFO: loaded from: classes14.dex */
public interface ICacheRecord {
    AccessTokenRecord getAccessToken();

    AccountRecord getAccount();

    IdTokenRecord getIdToken();

    RefreshTokenRecord getRefreshToken();

    IdTokenRecord getV1IdToken();
}
