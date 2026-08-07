package com.box.android.capture.activities;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.box.android.base.presentation.activities.ShortcutEntryActivity;
import com.box.android.capture.R;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.domain.models.capture.CaptureMode;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateCaptureShortcutActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/activities/CreateCaptureShortcutActivity;", "Lcom/box/android/base/presentation/activities/ShortcutEntryActivity;", "<init>", "()V", "onBoxCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "authenticateOnResume", "", "onAuthenticated", NotificationCompat.CATEGORY_MESSAGE, "Lcom/box/android/coreservices/modelcontroller/messages/BoxUserAuthenticationMessage;", "buildIntent", "Landroid/content/Intent;", "getAuthErrorMessageRes", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class CreateCaptureShortcutActivity extends Hilt_CreateCaptureShortcutActivity {
    public static final int $stable = ShortcutEntryActivity.$stable;

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected boolean authenticateOnResume() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.ShortcutEntryActivity, com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected void onAuthenticated(BoxUserAuthenticationMessage msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle savedInstanceState) {
        super.onBoxCreate(savedInstanceState);
        setResult(-1, buildIntent());
        finish();
    }

    private final Intent buildIntent() {
        String string = getString(R.string.box_capture_widget_label);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Object systemService = getSystemService(ShortcutManager.class);
        Intrinsics.checkNotNull(systemService);
        CreateCaptureShortcutActivity createCaptureShortcutActivity = this;
        ShortcutInfo.Builder builder = new ShortcutInfo.Builder(createCaptureShortcutActivity, string);
        String str = string;
        ShortcutInfo shortcutInfoBuild = builder.setShortLabel(str).setLongLabel(str).setIcon(Icon.createWithResource(createCaptureShortcutActivity, R.drawable.ic_capture_widget_icon)).setIntent(CaptureShortcutActivity.INSTANCE.getLaunchIntent(createCaptureShortcutActivity, CaptureMode.PHOTO)).build();
        Intrinsics.checkNotNullExpressionValue(shortcutInfoBuild, "build(...)");
        Intent intentCreateShortcutResultIntent = ((ShortcutManager) systemService).createShortcutResultIntent(shortcutInfoBuild);
        Intrinsics.checkNotNullExpressionValue(intentCreateShortcutResultIntent, "createShortcutResultIntent(...)");
        return intentCreateShortcutResultIntent;
    }

    @Override // com.box.android.base.presentation.activities.ShortcutEntryActivity
    public int getAuthErrorMessageRes() {
        return R.string.err_login7;
    }
}
