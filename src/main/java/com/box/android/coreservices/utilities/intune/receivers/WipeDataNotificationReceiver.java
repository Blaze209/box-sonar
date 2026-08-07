package com.box.android.coreservices.utilities.intune.receivers;

import android.content.Context;
import com.box.android.coreservices.services.NotificationServices;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiver;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistry;
import com.microsoft.intune.mam.policy.notification.MAMNotification;
import com.microsoft.intune.mam.policy.notification.MAMNotificationType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WipeDataNotificationReceiver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/coreservices/utilities/intune/receivers/WipeDataNotificationReceiver;", "Lcom/microsoft/intune/mam/client/notification/MAMNotificationReceiver;", "mamNotificationRegistry", "Lcom/microsoft/intune/mam/client/notification/MAMNotificationReceiverRegistry;", "notificationServices", "Lcom/box/android/coreservices/services/NotificationServices;", "context", "Landroid/content/Context;", "<init>", "(Lcom/microsoft/intune/mam/client/notification/MAMNotificationReceiverRegistry;Lcom/box/android/coreservices/services/NotificationServices;Landroid/content/Context;)V", "onReceive", "", "notification", "Lcom/microsoft/intune/mam/policy/notification/MAMNotification;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WipeDataNotificationReceiver implements MAMNotificationReceiver {
    private final Context context;
    private final MAMNotificationReceiverRegistry mamNotificationRegistry;
    private final NotificationServices notificationServices;

    public WipeDataNotificationReceiver(MAMNotificationReceiverRegistry mamNotificationRegistry, NotificationServices notificationServices, Context context) {
        Intrinsics.checkNotNullParameter(mamNotificationRegistry, "mamNotificationRegistry");
        Intrinsics.checkNotNullParameter(notificationServices, "notificationServices");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mamNotificationRegistry = mamNotificationRegistry;
        this.notificationServices = notificationServices;
        this.context = context;
    }

    @Override // com.microsoft.intune.mam.client.notification.MAMNotificationReceiver
    public boolean onReceive(MAMNotification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        if (notification.getType() != MAMNotificationType.WIPE_USER_DATA) {
            return true;
        }
        this.notificationServices.displayToast("Organization data removed successfully. Please re-open the app to sign in again.", this.context);
        this.mamNotificationRegistry.unregisterReceiver(this, MAMNotificationType.WIPE_USER_DATA);
        return true;
    }
}
