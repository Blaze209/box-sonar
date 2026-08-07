package com.microsoft.intune.mam.client.app.data;

import com.microsoft.intune.mam.ProxyWith;
import com.microsoft.intune.mam.client.app.LocalSettingsBase;
import com.microsoft.intune.mam.client.app.UserLocalSettings;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistryInternal;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.MAMEnrollmentStatusCache;
import com.microsoft.intune.mam.policy.WipeReason;
import com.microsoft.intune.mam.policy.cache.MAMEnrolledIdentitiesCache;
import com.microsoft.intune.mam.policy.notification.MAMNotificationType;
import com.microsoft.intune.mam.policy.notification.MAMUserNotification;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineUserDataWiper extends AbstractUserDataWiper {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineUserDataWiper.class);
    private LocalSettingsBase mLocalSettings;
    private MAMNotificationReceiverRegistryInternal mMAMNotificationReceiverRegistry;
    private UserLocalSettings mUserLocalSettings;

    public OfflineUserDataWiper(MAMNotificationReceiverRegistryInternal mAMNotificationReceiverRegistryInternal, MAMLogPIIFactory mAMLogPIIFactory, LocalSettingsBase localSettingsBase, MAMEnrollmentStatusCache mAMEnrollmentStatusCache, MAMEnrolledIdentitiesCache mAMEnrolledIdentitiesCache, UserLocalSettings userLocalSettings) {
        super(mAMLogPIIFactory, localSettingsBase, mAMEnrollmentStatusCache, mAMEnrolledIdentitiesCache);
        this.mMAMNotificationReceiverRegistry = mAMNotificationReceiverRegistryInternal;
        this.mLocalSettings = localSettingsBase;
        this.mUserLocalSettings = userLocalSettings;
    }

    @ProxyWith({MAMUserNotification.class})
    static class OfflineWipeNotification implements MAMUserNotification {
        private final MAMIdentity mIdentity;
        private final MAMNotificationType mNotificationType;

        OfflineWipeNotification(MAMIdentity mAMIdentity, MAMNotificationType mAMNotificationType) {
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

    @Override // com.microsoft.intune.mam.client.app.data.AbstractUserDataWiper
    public boolean doWipe(MAMIdentity mAMIdentity, WipeReason wipeReason, boolean z) {
        boolean zSystemWipe;
        MAMLogger mAMLogger = LOGGER;
        mAMLogger.info("Wiping app for reason: " + wipeReason, new Object[0]);
        OfflineWipeNotification notification = getNotification(mAMIdentity);
        if (notification != null) {
            if (sendNotification(notification)) {
                this.mMAMEnrolledIdentitiesCache.remove(mAMIdentity);
                this.mUserLocalSettings.clear(mAMIdentity);
                if (this.mMAMEnrolledIdentitiesCache.getManagedIdentities().isEmpty()) {
                    this.mLocalSettings.clearLocalSettings();
                }
                zSystemWipe = true;
            } else {
                mAMLogger.warning("Send Wipe Notification failed. Try system wipe", new Object[0]);
                zSystemWipe = systemWipe();
            }
        } else {
            mAMLogger.warning("No Wipe notification registered. Try system wipe", new Object[0]);
            zSystemWipe = systemWipe();
        }
        if (zSystemWipe) {
            this.mMAMNotificationReceiverRegistry.sendNotification(new OfflineWipeNotification(mAMIdentity, MAMNotificationType.WIPE_COMPLETED));
        }
        return zSystemWipe;
    }

    private boolean systemWipe() {
        LOGGER.info("Set System Wipe Flag.", new Object[0]);
        this.mMAMEnrollmentStatusCache.setSystemWipeNotice();
        return true;
    }

    private boolean sendNotification(OfflineWipeNotification offlineWipeNotification) {
        boolean zSendNotification = this.mMAMNotificationReceiverRegistry.sendNotification(offlineWipeNotification);
        if (zSendNotification) {
            LOGGER.info("Wipe handler reported success.", new Object[0]);
            return zSendNotification;
        }
        LOGGER.warning("Wipe handler reported failure.", new Object[0]);
        return zSendNotification;
    }

    private OfflineWipeNotification getNotification(MAMIdentity mAMIdentity) {
        boolean zHasRegisteredReceiver = this.mMAMNotificationReceiverRegistry.hasRegisteredReceiver(MAMNotificationType.WIPE_USER_DATA);
        boolean zHasRegisteredReceiver2 = this.mMAMNotificationReceiverRegistry.hasRegisteredReceiver(MAMNotificationType.WIPE_USER_AUXILIARY_DATA);
        if (zHasRegisteredReceiver) {
            return new OfflineWipeNotification(mAMIdentity, MAMNotificationType.WIPE_USER_DATA);
        }
        if (!zHasRegisteredReceiver2) {
            return null;
        }
        LOGGER.info("No user data wipe handler registered.  Calling auxiliary data wipe handler for {0}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentity));
        return new OfflineWipeNotification(mAMIdentity, MAMNotificationType.WIPE_USER_AUXILIARY_DATA);
    }
}
