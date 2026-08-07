package com.microsoft.intune.mam.client.app.offline;

import android.content.Context;
import android.os.Binder;
import android.os.Parcel;
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.app.IPCUtils;
import com.microsoft.intune.mam.client.app.MAMApplication;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.notification.NotificationReceiverBinderFactory;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineNotificationReceiver extends Binder implements NotificationReceiverBinderFactory {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineNotificationReceiver.class);
    private Context mContext;

    @Override // com.microsoft.intune.mam.policy.notification.NotificationReceiverBinderFactory
    public Binder create() {
        return this;
    }

    public OfflineNotificationReceiver(Context context) {
        this.mContext = context;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (!verifyCallerIsTrusted(this.mContext)) {
            parcel2.writeException(new SecurityException("Caller package did not match " + MAMInfo.getPackageName()));
            return false;
        }
        parcel2.writeNoException();
        if (MAMComponents.isManagedApp(this.mContext)) {
            LOGGER.info("Received offline notification and app is now managed. Ending process", new Object[0]);
            OfflineActivityBehavior.softRestart(this.mContext);
        }
        if (!MAMComponents.isWipeInProgress(this.mContext)) {
            return true;
        }
        LOGGER.info("Received offline notification and a wipe is in process. Ending process", new Object[0]);
        MAMApplication.endProcess();
        return true;
    }

    private boolean verifyCallerIsTrusted(Context context) {
        return MAMComponents.isCompanyPortalInstalled(context) && IPCUtils.getCallingPackageCandidates(context).contains(MAMInfo.getPackageName());
    }
}
