package com.microsoft.intune.mam.client.notification;

import android.content.Context;
import com.microsoft.intune.mam.client.app.MAMApplication;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class OfflineCompanyPortalInstallReceiver extends CompanyPortalInstallReceiverBase {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineCompanyPortalInstallReceiver.class);

    @Override // com.microsoft.intune.mam.client.notification.CompanyPortalInstallReceiverBase
    public void onAgentPackageModified(Context context) {
        if (MAMComponents.isAppOffline()) {
            LOGGER.info("Company Portal installation or removal detected. Ending process for MAM app " + context.getPackageName(), new Object[0]);
            MAMApplication.endProcess();
        } else {
            LOGGER.warning("Company Portal installation or removal detected. Already online, so not ending process for MAM app " + context.getPackageName(), new Object[0]);
        }
    }
}
