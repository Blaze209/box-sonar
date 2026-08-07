package com.box.android.utilities.notificationmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.widget.Toast;
import com.box.android.R;
import com.box.android.activities.InfoDialogActivity;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.common.utilities.CommonBoxUtil;

/* JADX INFO: loaded from: classes13.dex */
public final class BoxNotificationHelper {
    private static long lastRateLimitTastTime = 0;
    private static final long rateLimitMinTimeBetween = 5000;

    private BoxNotificationHelper() {
    }

    public static void displayToast(String str, Activity activity) {
        BoxPresentationUtils.displayToast(str, BoxBaseApplication.getInstance().getApplicationContext());
    }

    public static void displayDialog(String str, String str2, String str3) {
        Intent intentNewInfoDialog = InfoDialogActivity.newInfoDialog(BoxBaseApplication.getInstance(), str, str2, str3);
        intentNewInfoDialog.setFlags(268435456);
        BoxBaseApplication.getInstance().startActivity(intentNewInfoDialog);
    }

    public static void displayDialog(String str) {
        displayDialog(null, str, CommonBoxUtil.LS(R.string.button_ok));
    }

    public static void displayDialog(String str, String str2) {
        displayDialog(str, str2, CommonBoxUtil.LS(R.string.button_ok));
    }

    public static void displayDialog(int i) {
        displayDialog(CommonBoxUtil.LS(i));
    }

    public static void displayDialog(int i, int i2) {
        displayDialog(CommonBoxUtil.LS(i), CommonBoxUtil.LS(i2));
    }

    public static void showRateLimitedToast() {
        if (SystemClock.uptimeMillis() - 5000 > lastRateLimitTastTime) {
            lastRateLimitTastTime = SystemClock.uptimeMillis();
            Toast.makeText(BoxBaseApplication.getInstance(), R.string.service_temporarily_unavailable, 1).show();
        }
    }
}
