package com.microsoft.intune.mam.client.app.offline;

import android.app.Application;
import android.content.Context;
import com.microsoft.intune.mam.client.app.AppUtils;
import com.microsoft.intune.mam.client.app.DirectBootUtils;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.client.config.ConfigOnlyModeBehavior;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.policy.cache.MAMEnrolledIdentitiesCache;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineConfigOnlyModeBehavior implements ConfigOnlyModeBehavior {
    private MAMEnrolledIdentitiesCache mMAMEnrolledIdentitiesCache;

    public OfflineConfigOnlyModeBehavior(MAMEnrolledIdentitiesCache mAMEnrolledIdentitiesCache) {
        this.mMAMEnrolledIdentitiesCache = mAMEnrolledIdentitiesCache;
    }

    @Override // com.microsoft.intune.mam.client.config.ConfigOnlyModeBehavior
    public void initialize(Application application) {
        OfflineCommonApplicationOnCreateOps.registerInstallReceivers(application);
        Context applicationContext = application.getApplicationContext();
        DirectBootUtils.migrateSharedPrefsToDeviceProtectedStorageIfNeeded(applicationContext);
        if (AppUtils.isPrimaryProcess(applicationContext) && !MAMComponents.getAgentOutdated()) {
            Iterator<MAMIdentity> it = this.mMAMEnrolledIdentitiesCache.getEnrolledIdentities().iterator();
            while (it.hasNext()) {
                OfflineCommonApplicationOnCreateOps.cleanUpEnrollment(this.mMAMEnrolledIdentitiesCache, it.next(), false);
            }
        }
    }
}
