package com.box.android.capture.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.box.android.base.presentation.activities.ShortcutEntryActivity;
import com.box.android.capture.R;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.capture.CaptureMode;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureShortcutActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u0005H\u0002¨\u0006\u000f"}, d2 = {"Lcom/box/android/capture/activities/CaptureShortcutActivity;", "Lcom/box/android/base/presentation/activities/ShortcutEntryActivity;", "<init>", "()V", "onBoxCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getAuthErrorMessageRes", "", "onAuthenticated", NotificationCompat.CATEGORY_MESSAGE, "Lcom/box/android/coreservices/modelcontroller/messages/BoxUserAuthenticationMessage;", "launchCapture", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class CaptureShortcutActivity extends Hilt_CaptureShortcutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = ShortcutEntryActivity.$stable;

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle savedInstanceState) {
        super.onBoxCreate(savedInstanceState);
        BoxAmplitudeAnalytics.getInstance().setReferrer(BoxAnalyticsParams.REFERRER_CAPTURE_WIDGET);
    }

    @Override // com.box.android.base.presentation.activities.ShortcutEntryActivity
    public int getAuthErrorMessageRes() {
        return R.string.err_login7;
    }

    @Override // com.box.android.base.presentation.activities.ShortcutEntryActivity, com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected void onAuthenticated(BoxUserAuthenticationMessage msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.wasSuccessful()) {
            launchCapture();
        }
        super.onAuthenticated(msg);
    }

    private final void launchCapture() {
        Intent intent = new Intent(this, (Class<?>) CaptureActivity.class);
        intent.setAction(getIntent().getAction());
        intent.setFlags(335544320);
        startActivity(intent);
    }

    /* JADX INFO: compiled from: CaptureShortcutActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/box/android/capture/activities/CaptureShortcutActivity$Companion;", "", "<init>", "()V", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getLaunchIntent(Context context, CaptureMode captureMode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(captureMode, "captureMode");
            Intent intent = new Intent(context, (Class<?>) CaptureShortcutActivity.class);
            intent.setAction(captureMode.name());
            return intent;
        }
    }
}
