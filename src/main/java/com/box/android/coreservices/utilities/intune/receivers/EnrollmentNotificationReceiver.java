package com.box.android.coreservices.utilities.intune.receivers;

import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiver;
import com.microsoft.intune.mam.policy.MAMEnrollmentManager;
import com.microsoft.intune.mam.policy.notification.MAMEnrollmentNotification;
import com.microsoft.intune.mam.policy.notification.MAMNotification;
import com.microsoft.intune.mam.policy.notification.MAMNotificationType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnrollmentNotificationReceiver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/coreservices/utilities/intune/receivers/EnrollmentNotificationReceiver;", "Lcom/microsoft/intune/mam/client/notification/MAMNotificationReceiver;", "onUnenrollmentSucceeded", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "onReceive", "", "notification", "Lcom/microsoft/intune/mam/policy/notification/MAMNotification;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EnrollmentNotificationReceiver implements MAMNotificationReceiver {
    private final Function0<Unit> onUnenrollmentSucceeded;

    /* JADX INFO: compiled from: EnrollmentNotificationReceiver.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MAMEnrollmentManager.Result.values().length];
            try {
                iArr[MAMEnrollmentManager.Result.UNENROLLMENT_SUCCEEDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MAMEnrollmentManager.Result.UNENROLLMENT_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MAMEnrollmentManager.Result.ENROLLMENT_SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MAMEnrollmentManager.Result.ENROLLMENT_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public EnrollmentNotificationReceiver(Function0<Unit> onUnenrollmentSucceeded) {
        Intrinsics.checkNotNullParameter(onUnenrollmentSucceeded, "onUnenrollmentSucceeded");
        this.onUnenrollmentSucceeded = onUnenrollmentSucceeded;
    }

    @Override // com.microsoft.intune.mam.client.notification.MAMNotificationReceiver
    public boolean onReceive(MAMNotification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        if (notification.getType() != MAMNotificationType.MAM_ENROLLMENT_RESULT) {
            return true;
        }
        MAMEnrollmentManager.Result enrollmentResult = ((MAMEnrollmentNotification) notification).getEnrollmentResult();
        int i = enrollmentResult == null ? -1 : WhenMappings.$EnumSwitchMapping$0[enrollmentResult.ordinal()];
        if (i == 1) {
            BoxLogUtils.w(ExtensionsKt.getTAG(this), "MAM unenrollment succeeded");
            this.onUnenrollmentSucceeded.invoke();
        } else if (i == 2) {
            BoxLogUtils.w(ExtensionsKt.getTAG(this), "MAM unenrollment failed");
        } else if (i == 3) {
            BoxLogUtils.i(ExtensionsKt.getTAG(this), "MAM enrollment succeeded");
        } else if (i == 4) {
            BoxLogUtils.w(ExtensionsKt.getTAG(this), "MAM enrollment failed");
        } else {
            BoxLogUtils.i(ExtensionsKt.getTAG(this), "MAM enrollment result: " + enrollmentResult);
        }
        return true;
    }
}
