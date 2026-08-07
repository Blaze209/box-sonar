package com.microsoft.identity.client;

import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface IClaimable {
    Map<String, ?> getClaims();

    String getIdToken();

    String getTenantId();

    String getUsername();
}
