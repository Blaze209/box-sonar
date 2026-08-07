package com.microsoft.intune.mam.client.app.offline;

import android.app.Application;
import android.os.Process;
import com.microsoft.intune.mam.client.app.ActivityLifecycleMonitorBase;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.notification.OfflineCompanyPortalInstallReceiver;
import com.microsoft.intune.mam.policy.MAMWEAccountManager;
import com.microsoft.intune.mam.policy.cache.MAMEnrolledIdentitiesCache;

/* JADX INFO: loaded from: classes3.dex */
public final class OfflineCommonApplicationOnCreateOps {
    private OfflineCommonApplicationOnCreateOps() {
    }

    public static void registerInstallReceivers(Application application) {
        application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) OfflineComponents.get(ActivityLifecycleMonitorBase.class));
        ((OfflineCompanyPortalInstallReceiver) OfflineComponents.get(OfflineCompanyPortalInstallReceiver.class)).registerReceiver(application);
    }

    public static void cleanUpEnrollment(MAMEnrolledIdentitiesCache mAMEnrolledIdentitiesCache, MAMIdentity mAMIdentity, boolean z) {
        if (!z) {
            mAMEnrolledIdentitiesCache.remove(mAMIdentity);
        }
        ((MAMWEAccountManager) MAMComponents.get(MAMWEAccountManager.class)).removeAccount(mAMIdentity);
    }

    public static void retryEnrollments() {
        new Thread(new Runnable() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineCommonApplicationOnCreateOps.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                Process.setThreadPriority(10);
                ((MAMWEAccountManager) MAMComponents.get(MAMWEAccountManager.class)).retryEnrollmentsAtStartup(null);
            }
        }, "Intune MAM enrollment").start();
    }
}
