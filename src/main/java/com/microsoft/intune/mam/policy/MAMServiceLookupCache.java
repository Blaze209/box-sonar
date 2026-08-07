package com.microsoft.intune.mam.policy;

import com.microsoft.intune.mam.client.identity.MAMIdentity;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMServiceLookupCache {
    public static final long CACHE_ENTRY_TTL_MS = 1209600000;
    public static final long DEFAULT_REQUERY_INTERVAL_MS = TimeUnit.MINUTES.toMillis(30);

    void clearMAMServiceUrls(MAMIdentity mAMIdentity);

    Map<String, String> getMAMServiceUrls(MAMIdentity mAMIdentity);

    boolean okToReQuery(MAMIdentity mAMIdentity);

    void setMAMServiceUrls(MAMIdentity mAMIdentity, Map<String, String> map, long j);
}
