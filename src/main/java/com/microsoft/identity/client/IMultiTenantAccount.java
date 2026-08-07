package com.microsoft.identity.client;

import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface IMultiTenantAccount extends IAccount {
    Map<String, ITenantProfile> getTenantProfiles();
}
