package com.microsoft.identity.client;

import java.util.Date;
import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
public interface IAuthenticationResult {
    String getAccessToken();

    IAccount getAccount();

    String getAuthenticationScheme();

    String getAuthorizationHeader();

    UUID getCorrelationId();

    Date getExpiresOn();

    String[] getScope();

    String getTenantId();
}
