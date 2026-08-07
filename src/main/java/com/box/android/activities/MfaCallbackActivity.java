package com.box.android.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.inbox.MfaCallbackIntentHandler;
import com.box.android.preview.wopi.WopiService;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MfaCallbackActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0014"}, d2 = {"Lcom/box/android/activities/MfaCallbackActivity;", "Lcom/box/android/base/presentation/activities/BoxEntrypointActivity;", "<init>", "()V", "onAuthenticated", "", NotificationCompat.CATEGORY_MESSAGE, "Lcom/box/android/coreservices/modelcontroller/messages/BoxUserAuthenticationMessage;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "handleOnNewIntent", "intent", "Landroid/content/Intent;", "handleIntent", "parseCallbackUrl", "Lcom/box/android/activities/MfaCallbackActivity$MfaCallbackData;", "callbackUrl", "", "MfaCallbackData", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class MfaCallbackActivity extends Hilt_MfaCallbackActivity {
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected void onAuthenticated(BoxUserAuthenticationMessage msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity, com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        handleIntent(intent);
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnNewIntent(Intent intent) {
        super.handleOnNewIntent(intent);
        if (intent != null) {
            handleIntent(intent);
        }
    }

    private final void handleIntent(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            String string = data.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            MfaCallbackData callbackUrl = parseCallbackUrl(string);
            if (callbackUrl != null) {
                Intent intentNavigationActivityIntent = this.mIntentServices.navigationActivityIntent(this, this.mFeatureFlips.getMainScreenRedesign().getEnabled(), IntentServices.NavigationIntentTarget.NOTIFICATIONS);
                intentNavigationActivityIntent.putExtra(MfaCallbackIntentHandler.EXTRA_MFA_EVENT, callbackUrl.getEvent());
                Long mobileSessionId = callbackUrl.getMobileSessionId();
                if (mobileSessionId != null) {
                    intentNavigationActivityIntent.putExtra(MfaCallbackIntentHandler.EXTRA_MFA_SESSION_ID, mobileSessionId.longValue());
                }
                intentNavigationActivityIntent.putExtra(MfaCallbackIntentHandler.EXTRA_MFA_IS_SUCCESS, callbackUrl.isSuccess());
                startActivity(intentNavigationActivityIntent);
            }
        }
        finish();
    }

    /* JADX INFO: compiled from: MfaCallbackActivity.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J0\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/activities/MfaCallbackActivity$MfaCallbackData;", "", "event", "", "mobileSessionId", "", "isSuccess", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Z)V", "getEvent", "()Ljava/lang/String;", "getMobileSessionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/Long;Z)Lcom/box/android/activities/MfaCallbackActivity$MfaCallbackData;", "equals", "other", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class MfaCallbackData {
        private final String event;
        private final boolean isSuccess;
        private final Long mobileSessionId;

        public static /* synthetic */ MfaCallbackData copy$default(MfaCallbackData mfaCallbackData, String str, Long l, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mfaCallbackData.event;
            }
            if ((i & 2) != 0) {
                l = mfaCallbackData.mobileSessionId;
            }
            if ((i & 4) != 0) {
                z = mfaCallbackData.isSuccess;
            }
            return mfaCallbackData.copy(str, l, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEvent() {
            return this.event;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getMobileSessionId() {
            return this.mobileSessionId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public final MfaCallbackData copy(String event, Long mobileSessionId, boolean isSuccess) {
            return new MfaCallbackData(event, mobileSessionId, isSuccess);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MfaCallbackData)) {
                return false;
            }
            MfaCallbackData mfaCallbackData = (MfaCallbackData) other;
            return Intrinsics.areEqual(this.event, mfaCallbackData.event) && Intrinsics.areEqual(this.mobileSessionId, mfaCallbackData.mobileSessionId) && this.isSuccess == mfaCallbackData.isSuccess;
        }

        public int hashCode() {
            String str = this.event;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Long l = this.mobileSessionId;
            return ((iHashCode + (l != null ? l.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSuccess);
        }

        public String toString() {
            return "MfaCallbackData(event=" + this.event + ", mobileSessionId=" + this.mobileSessionId + ", isSuccess=" + this.isSuccess + ")";
        }

        public MfaCallbackData(String str, Long l, boolean z) {
            this.event = str;
            this.mobileSessionId = l;
            this.isSuccess = z;
        }

        public final String getEvent() {
            return this.event;
        }

        public final Long getMobileSessionId() {
            return this.mobileSessionId;
        }

        public final boolean isSuccess() {
            return this.isSuccess;
        }
    }

    private final MfaCallbackData parseCallbackUrl(String callbackUrl) {
        try {
            Uri uri = Uri.parse(callbackUrl);
            if (Intrinsics.areEqual(uri.getScheme(), WopiService.BOX) && Intrinsics.areEqual(uri.getHost(), "web_callback")) {
                String queryParameter = uri.getQueryParameter("event");
                String queryParameter2 = uri.getQueryParameter("mobile_session_id");
                return new MfaCallbackData(queryParameter, queryParameter2 != null ? StringsKt.toLongOrNull(queryParameter2) : null, Intrinsics.areEqual(queryParameter, "mfa_enrollment_completed"));
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
