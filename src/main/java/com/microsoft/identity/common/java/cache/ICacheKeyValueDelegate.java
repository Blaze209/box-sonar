package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.dto.AccountCredentialBase;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;

/* JADX INFO: loaded from: classes14.dex */
public interface ICacheKeyValueDelegate {
    <T extends AccountCredentialBase> T fromCacheValue(String str, Class<? extends AccountCredentialBase> cls);

    String generateCacheKey(AccountRecord accountRecord);

    String generateCacheKey(Credential credential);

    String generateCacheValue(AccountRecord accountRecord);

    String generateCacheValue(Credential credential);
}
