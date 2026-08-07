package com.microsoft.intune.mam.client.app.offline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.microsoft.intune.mam.ProxyWith;
import com.microsoft.intune.mam.client.identity.IdentityParamConverter;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistryInternal;
import com.microsoft.intune.mam.policy.appconfig.AndroidEnterpriseAppConfig;
import com.microsoft.intune.mam.policy.appconfig.MAMAppConfig;
import com.microsoft.intune.mam.policy.appconfig.MAMAppConfigManager;
import com.microsoft.intune.mam.policy.notification.MAMNotificationType;
import com.microsoft.intune.mam.policy.notification.MAMUserNotification;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineMAMAppConfigManager implements MAMAppConfigManager {
    private static boolean sRegistered = false;
    private final Context mContext;
    private final IdentityParamConverter mIdentityParamConverter;
    private final MAMNotificationReceiverRegistryInternal mMAMNotificationReceiverRegistry;

    public OfflineMAMAppConfigManager(Context context, MAMNotificationReceiverRegistryInternal mAMNotificationReceiverRegistryInternal, IdentityParamConverter identityParamConverter) {
        this.mContext = context;
        this.mMAMNotificationReceiverRegistry = mAMNotificationReceiverRegistryInternal;
        this.mIdentityParamConverter = identityParamConverter;
    }

    @Override // com.microsoft.intune.mam.policy.appconfig.MAMAppConfigManager
    @Deprecated
    public MAMAppConfig getAppConfig(String str) {
        registerReceiver();
        this.mIdentityParamConverter.emitUpnUsageWarnings(str);
        return AndroidEnterpriseAppConfig.create(this.mContext);
    }

    @Override // com.microsoft.intune.mam.policy.appconfig.MAMAppConfigManager
    public MAMAppConfig getAppConfigForOID(String str) {
        registerReceiver();
        return AndroidEnterpriseAppConfig.create(this.mContext);
    }

    @ProxyWith({MAMUserNotification.class})
    static class AppConfigUpdatedNotification implements MAMUserNotification {
        private final MAMIdentity mIdentity;
        private final MAMNotificationType mNotificationType;

        AppConfigUpdatedNotification(MAMIdentity mAMIdentity, MAMNotificationType mAMNotificationType) {
            this.mIdentity = mAMIdentity;
            this.mNotificationType = mAMNotificationType;
        }

        @Override // com.microsoft.intune.mam.policy.notification.MAMNotification
        public MAMNotificationType getType() {
            return this.mNotificationType;
        }

        @Override // com.microsoft.intune.mam.policy.notification.MAMUserNotification
        public String getUserIdentity() {
            return this.mIdentity.rawUPN();
        }

        @Override // com.microsoft.intune.mam.policy.notification.MAMUserNotification
        public String getUserOid() {
            return this.mIdentity.aadId();
        }
    }

    private synchronized void registerReceiver() {
        if (sRegistered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.APPLICATION_RESTRICTIONS_CHANGED");
        this.mContext.registerReceiver(new BroadcastReceiver() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineMAMAppConfigManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                OfflineMAMAppConfigManager.this.mMAMNotificationReceiverRegistry.sendNotification(new AppConfigUpdatedNotification(MAMIdentity.EMPTY, MAMNotificationType.REFRESH_APP_CONFIG));
            }
        }, intentFilter);
        sRegistered = true;
    }
}
