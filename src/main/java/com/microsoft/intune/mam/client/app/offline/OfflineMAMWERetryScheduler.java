package com.microsoft.intune.mam.client.app.offline;

import android.content.Context;
import com.microsoft.intune.mam.client.identity.MAMIdentityManager;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.MAMWEEnroller;
import com.microsoft.intune.mam.policy.MAMWERetryScheduler;
import com.microsoft.intune.mam.policy.cache.MAMServiceUrlCache;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineMAMWERetryScheduler extends MAMWERetryScheduler {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineMAMWERetryScheduler.class);

    @Override // com.microsoft.intune.mam.policy.MAMWERetryScheduler
    protected MAMLogger logger() {
        return LOGGER;
    }

    public OfflineMAMWERetryScheduler(MAMWEEnroller mAMWEEnroller, MAMIdentityManager mAMIdentityManager, MAMLogPIIFactory mAMLogPIIFactory, Context context, MAMServiceUrlCache mAMServiceUrlCache) {
        super(mAMWEEnroller, mAMIdentityManager, mAMLogPIIFactory, context, mAMServiceUrlCache, false);
    }
}
