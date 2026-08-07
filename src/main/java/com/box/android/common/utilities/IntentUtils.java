package com.box.android.common.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\"\u0010\b\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/common/utilities/IntentUtils;", "", "<init>", "()V", "getApplicationSettingsIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "launchWithLauncherIfExistOrWithActivity", "", "activity", "Landroid/app/Activity;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IntentUtils {
    public static final IntentUtils INSTANCE = new IntentUtils();

    private IntentUtils() {
    }

    public final Intent getApplicationSettingsIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    public final void launchWithLauncherIfExistOrWithActivity(Intent intent, Activity activity, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        } else {
            activity.startActivity(intent);
        }
    }
}
