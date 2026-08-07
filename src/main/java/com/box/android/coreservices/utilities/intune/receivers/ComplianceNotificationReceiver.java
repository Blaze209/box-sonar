package com.box.android.coreservices.utilities.intune.receivers;

import com.box.android.coreservices.services.NotificationServices;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiver;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistry;
import com.microsoft.intune.mam.policy.MAMCAComplianceStatus;
import com.microsoft.intune.mam.policy.notification.MAMComplianceNotification;
import com.microsoft.intune.mam.policy.notification.MAMNotification;
import com.microsoft.intune.mam.policy.notification.MAMNotificationType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComplianceNotificationReceiver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/coreservices/utilities/intune/receivers/ComplianceNotificationReceiver;", "Lcom/microsoft/intune/mam/client/notification/MAMNotificationReceiver;", "mamNotificationRegistry", "Lcom/microsoft/intune/mam/client/notification/MAMNotificationReceiverRegistry;", "notificationServices", "Lcom/box/android/coreservices/services/NotificationServices;", "onComplianceRemediation", "Lkotlin/Function0;", "", "onError", "Lkotlin/Function3;", "", "Lcom/microsoft/intune/mam/policy/MAMCAComplianceStatus;", "<init>", "(Lcom/microsoft/intune/mam/client/notification/MAMNotificationReceiverRegistry;Lcom/box/android/coreservices/services/NotificationServices;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)V", "onReceive", "", "notification", "Lcom/microsoft/intune/mam/policy/notification/MAMNotification;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ComplianceNotificationReceiver implements MAMNotificationReceiver {
    private final MAMNotificationReceiverRegistry mamNotificationRegistry;
    private final NotificationServices notificationServices;
    private final Function0<Unit> onComplianceRemediation;
    private final Function3<String, String, MAMCAComplianceStatus, Unit> onError;

    /* JADX INFO: compiled from: ComplianceNotificationReceiver.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MAMCAComplianceStatus.values().length];
            try {
                iArr[MAMCAComplianceStatus.COMPLIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComplianceNotificationReceiver(MAMNotificationReceiverRegistry mamNotificationRegistry, NotificationServices notificationServices, Function0<Unit> onComplianceRemediation, Function3<? super String, ? super String, ? super MAMCAComplianceStatus, Unit> onError) {
        Intrinsics.checkNotNullParameter(mamNotificationRegistry, "mamNotificationRegistry");
        Intrinsics.checkNotNullParameter(notificationServices, "notificationServices");
        Intrinsics.checkNotNullParameter(onComplianceRemediation, "onComplianceRemediation");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.mamNotificationRegistry = mamNotificationRegistry;
        this.notificationServices = notificationServices;
        this.onComplianceRemediation = onComplianceRemediation;
        this.onError = onError;
    }

    @Override // com.microsoft.intune.mam.client.notification.MAMNotificationReceiver
    public boolean onReceive(MAMNotification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        if (notification.getType() == MAMNotificationType.COMPLIANCE_STATUS) {
            MAMComplianceNotification mAMComplianceNotification = (MAMComplianceNotification) notification;
            MAMCAComplianceStatus complianceStatus = mAMComplianceNotification.getComplianceStatus();
            if ((complianceStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[complianceStatus.ordinal()]) == 1) {
                this.onComplianceRemediation.invoke();
            } else {
                String complianceErrorTitle = mAMComplianceNotification.getComplianceErrorTitle();
                String complianceErrorMessage = mAMComplianceNotification.getComplianceErrorMessage();
                MAMCAComplianceStatus complianceStatus2 = mAMComplianceNotification.getComplianceStatus();
                NotificationServices notificationServices = this.notificationServices;
                Intrinsics.checkNotNull(complianceErrorTitle);
                Intrinsics.checkNotNull(complianceErrorMessage);
                notificationServices.displayDialog(complianceErrorTitle, complianceErrorMessage);
                Function3<String, String, MAMCAComplianceStatus, Unit> function3 = this.onError;
                Intrinsics.checkNotNull(complianceStatus2);
                function3.invoke(complianceErrorTitle, complianceErrorMessage, complianceStatus2);
            }
            this.mamNotificationRegistry.unregisterReceiver(this, MAMNotificationType.COMPLIANCE_STATUS);
        }
        return true;
    }
}
