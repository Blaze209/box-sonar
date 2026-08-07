package com.microsoft.intune.mam.client.ipcclient;

import com.microsoft.intune.mam.client.notification.MAMNotificationReceiver;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistryBaseImpl;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistryInternal;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.notification.MAMNotification;
import com.microsoft.intune.mam.policy.notification.MAMNotificationType;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class MAMNotificationReceiverRegistryImpl extends MAMNotificationReceiverRegistryBaseImpl<MAMNotification, MAMNotificationReceiver, MAMNotificationType> implements MAMNotificationReceiverRegistryInternal {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMNotificationReceiverRegistryImpl.class);

    @Override // com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistry
    public /* bridge */ /* synthetic */ void unregisterReceiver(MAMNotificationReceiver mAMNotificationReceiver, MAMNotificationType mAMNotificationType) {
        super.unregisterReceiver(mAMNotificationReceiver, mAMNotificationType);
    }

    public MAMNotificationReceiverRegistryImpl() {
        super(MAMNotificationType.values());
    }

    @Override // com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistryBaseImpl
    public void registerReceiver(MAMNotificationReceiver mAMNotificationReceiver, MAMNotificationType mAMNotificationType) {
        super.registerReceiver(mAMNotificationReceiver, mAMNotificationType);
        if ((mAMNotificationType != MAMNotificationType.WIPE_USER_DATA && mAMNotificationType != MAMNotificationType.WIPE_USER_AUXILIARY_DATA) || ((Set) this.mReceivers.get(MAMNotificationType.WIPE_USER_DATA)).isEmpty() || ((Set) this.mReceivers.get(MAMNotificationType.WIPE_USER_AUXILIARY_DATA)).isEmpty()) {
            return;
        }
        LOGGER.warning("Handlers are registered for both WIPE_USER_DATA and WIPE_USER_AUXILIARY_DATA. WIPE_USER_DATA takes precedence so WIPE_USER_AUXILIARY_DATA notification will never be sent.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistryBaseImpl
    public boolean invokeReceiver(MAMNotificationReceiver mAMNotificationReceiver, MAMNotification mAMNotification) {
        return mAMNotificationReceiver.onReceive(mAMNotification);
    }

    @Override // com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistryInternalBase
    public boolean sendNotification(MAMNotification mAMNotification) {
        return super.sendNotificationBase(mAMNotification, mAMNotification.getType());
    }
}
