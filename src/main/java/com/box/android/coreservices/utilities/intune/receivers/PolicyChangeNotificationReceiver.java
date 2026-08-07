package com.box.android.coreservices.utilities.intune.receivers;

import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiver;
import com.microsoft.intune.mam.policy.notification.MAMNotification;
import com.microsoft.intune.mam.policy.notification.MAMNotificationType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PolicyChangeNotificationReceiver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/coreservices/utilities/intune/receivers/PolicyChangeNotificationReceiver;", "Lcom/microsoft/intune/mam/client/notification/MAMNotificationReceiver;", "onPolicyRefresh", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "onReceive", "", "notification", "Lcom/microsoft/intune/mam/policy/notification/MAMNotification;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PolicyChangeNotificationReceiver implements MAMNotificationReceiver {
    private final Function0<Unit> onPolicyRefresh;

    /* JADX INFO: compiled from: PolicyChangeNotificationReceiver.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MAMNotificationType.values().length];
            try {
                iArr[MAMNotificationType.REFRESH_POLICY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PolicyChangeNotificationReceiver(Function0<Unit> onPolicyRefresh) {
        Intrinsics.checkNotNullParameter(onPolicyRefresh, "onPolicyRefresh");
        this.onPolicyRefresh = onPolicyRefresh;
    }

    @Override // com.microsoft.intune.mam.client.notification.MAMNotificationReceiver
    public boolean onReceive(MAMNotification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        MAMNotificationType type = notification.getType();
        if ((type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) == 1) {
            BoxLogUtils.i(ExtensionsKt.getTAG(this), "Received REFRESH_POLICY notification, checking enrollment status");
            this.onPolicyRefresh.invoke();
        }
        return true;
    }
}
