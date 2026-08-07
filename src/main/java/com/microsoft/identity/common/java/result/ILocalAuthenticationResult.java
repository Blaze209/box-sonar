package com.microsoft.identity.common.java.result;

import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public interface ILocalAuthenticationResult {
    String getAccessToken();

    AccessTokenRecord getAccessTokenRecord();

    IAccountRecord getAccountRecord();

    List<ICacheRecord> getCacheRecordWithTenantProfileData();

    String getCorrelationId();

    Date getExpiresOn();

    String getFamilyId();

    String getIdToken();

    String getRefreshToken();

    String getRefreshTokenAge();

    String[] getScope();

    String getSpeRing();

    String getTenantId();

    String getUniqueId();

    boolean isServicedFromCache();
}
