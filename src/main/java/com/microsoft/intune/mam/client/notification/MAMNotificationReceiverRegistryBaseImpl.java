package com.microsoft.intune.mam.client.notification;

import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.lang.Enum;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMNotificationReceiverRegistryBaseImpl<Notification, NotificationReceiver, NotificationType extends Enum<?>> implements MAMNotificationReceiverRegistryInternalBase<NotificationType, Notification> {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMNotificationReceiverRegistryBaseImpl.class);
    protected final Map<NotificationType, Set<NotificationReceiver>> mReceivers;

    protected abstract boolean invokeReceiver(NotificationReceiver notificationreceiver, Notification notification);

    public MAMNotificationReceiverRegistryBaseImpl(NotificationType[] notificationtypeArr) {
        HashMap map = new HashMap();
        for (NotificationType notificationtype : notificationtypeArr) {
            map.put(notificationtype, new CopyOnWriteArraySet());
        }
        this.mReceivers = Collections.unmodifiableMap(map);
    }

    public void registerReceiver(NotificationReceiver notificationreceiver, NotificationType notificationtype) {
        if (notificationreceiver == null) {
            throw new IllegalArgumentException("Parameter 'receiver' should not be null.");
        }
        if (notificationtype == null) {
            throw new IllegalArgumentException("Parameter 'handledType' should not be null.");
        }
        this.mReceivers.get(notificationtype).add(notificationreceiver);
    }

    public void unregisterReceiver(NotificationReceiver notificationreceiver, NotificationType notificationtype) {
        if (notificationreceiver == null) {
            throw new IllegalArgumentException("Parameter 'receiver' should not be null.");
        }
        if (notificationtype == null) {
            throw new IllegalArgumentException("Parameter 'handledType' should not be null.");
        }
        this.mReceivers.get(notificationtype).remove(notificationreceiver);
    }

    @Override // com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistryInternalBase
    public boolean hasRegisteredReceiver(NotificationType notificationtype) {
        return !this.mReceivers.get(notificationtype).isEmpty();
    }

    protected boolean sendNotificationBase(Notification notification, NotificationType notificationtype) {
        Iterator<NotificationReceiver> it = this.mReceivers.get(notificationtype).iterator();
        boolean zInvokeReceiver = true;
        while (it.hasNext()) {
            try {
                zInvokeReceiver &= invokeReceiver(it.next(), notification);
            } catch (Exception e) {
                LOGGER.error(MAMInterfaceError.MAM_NOTIFICATION_HANDLER_APP_THREW, "App threw exception while handling notification " + notificationtype, e);
                zInvokeReceiver = false;
            }
        }
        return zInvokeReceiver;
    }
}
