package com.box.android.inbox.mfasetup;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;

/* JADX INFO: compiled from: MfaSetupAnalytics.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/box/android/inbox/mfasetup/MfaSetupAnalytics;", "", "<init>", "()V", "setUpMfaButtonClicked", "", "mobileSessionId", "", "(Ljava/lang/Long;)V", "setUpMfaDialogPresented", "enrollMfaButtonClicked", "cancelMfaButtonClicked", "enrollMfaCompleted", "mfaEventBuilder", "Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$MfaSetupEventPropertyBuilder;", "kotlin.jvm.PlatformType", "(Ljava/lang/Long;)Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$MfaSetupEventPropertyBuilder;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MfaSetupAnalytics {
    public static final int $stable = 0;

    @Inject
    public MfaSetupAnalytics() {
    }

    public final void setUpMfaButtonClicked(Long mobileSessionId) {
        mfaEventBuilder(mobileSessionId).logEvent("mobile_android_inbox_notifications_collaboration_setupmfabutton_tapped");
    }

    public final void setUpMfaDialogPresented(Long mobileSessionId) {
        mfaEventBuilder(mobileSessionId).logEvent("mobile_android_inbox_notifications_collaboration_setupmfamodal_presented");
    }

    public final void enrollMfaButtonClicked(Long mobileSessionId) {
        mfaEventBuilder(mobileSessionId).logEvent("mobile_android_inbox_notifications_collaboration_enrollmfabutton_tapped");
    }

    public final void cancelMfaButtonClicked(Long mobileSessionId) {
        mfaEventBuilder(mobileSessionId).logEvent("mobile_android_inbox_notifications_collaboration_cancelmfabutton_tapped");
    }

    public final void enrollMfaCompleted(Long mobileSessionId) {
        mfaEventBuilder(mobileSessionId).logEvent("mobile_android_account_webcallback_mfaenrollment_completed");
    }

    private final BoxAmplitudeAnalytics.MfaSetupEventPropertyBuilder mfaEventBuilder(Long mobileSessionId) {
        BoxAmplitudeAnalytics.MfaSetupEventPropertyBuilder mfaSetupEventPropertyBuilderCreateMfaSetupEventPropertyBuilder = BoxAmplitudeAnalytics.createMfaSetupEventPropertyBuilder();
        mfaSetupEventPropertyBuilderCreateMfaSetupEventPropertyBuilder.setMobileSessionId(String.valueOf(mobileSessionId));
        return mfaSetupEventPropertyBuilderCreateMfaSetupEventPropertyBuilder;
    }
}
