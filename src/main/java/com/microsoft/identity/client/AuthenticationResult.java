package com.microsoft.identity.client;

import android.text.TextUtils;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public final class AuthenticationResult implements IAuthenticationResult {
    private static final String TAG = "AuthenticationResult";
    private final AccessTokenRecord mAccessToken;
    private final IAccount mAccount;
    private final UUID mCorrelationId;
    private final String mTenantId;

    AuthenticationResult(List<ICacheRecord> list, String str) {
        ICacheRecord iCacheRecord = list.get(0);
        this.mAccessToken = iCacheRecord.getAccessToken();
        this.mTenantId = iCacheRecord.getAccount().getRealm();
        this.mAccount = AccountAdapter.adapt(list).get(0);
        this.mCorrelationId = sanitizeCorrelationId(str);
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    public String getAccessToken() {
        return this.mAccessToken.getSecret();
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    public String getAuthorizationHeader() {
        return this.mAccessToken.getAccessTokenType() + " " + this.mAccessToken.getSecret();
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    public String getAuthenticationScheme() {
        return this.mAccessToken.getAccessTokenType();
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    public Date getExpiresOn() {
        return new Date(TimeUnit.SECONDS.toMillis(Long.parseLong(this.mAccessToken.getExpiresOn())));
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    public String getTenantId() {
        return this.mTenantId;
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    public IAccount getAccount() {
        return this.mAccount;
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    public String[] getScope() {
        return this.mAccessToken.getTarget().split("\\s");
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    public UUID getCorrelationId() {
        return this.mCorrelationId;
    }

    private UUID sanitizeCorrelationId(String str) {
        String str2 = TAG + ":sanitizeCorrelationId";
        if (TextUtils.isEmpty(str)) {
            com.microsoft.identity.common.logging.Logger.warn(str2, "Correlation id was empty, returning null.");
            return null;
        }
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException e) {
            com.microsoft.identity.common.logging.Logger.error(str2, "Correlation id is not a valid UUID.", e);
            return null;
        }
    }
}
