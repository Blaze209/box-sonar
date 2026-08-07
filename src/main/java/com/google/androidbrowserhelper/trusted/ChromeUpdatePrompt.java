package com.google.androidbrowserhelper.trusted;

import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

/* JADX INFO: loaded from: classes13.dex */
public class ChromeUpdatePrompt {
    private static final String UPDATE_CHROME_MESSAGE_RESOURCE_ID = "string/update_chrome_toast";

    private ChromeUpdatePrompt() {
    }

    public static void promptIfNeeded(Context context, String str) {
        if (ChromeLegacyUtils.VERSION_CHECK_CHROME_PACKAGES.contains(str) && chromeNeedsUpdate(context.getPackageManager(), str)) {
            showToastIfResourceExists(context, UPDATE_CHROME_MESSAGE_RESOURCE_ID);
        }
    }

    private static boolean chromeNeedsUpdate(PackageManager packageManager, String str) {
        int versionCode = ChromeLegacyUtils.getVersionCode(packageManager, str);
        return versionCode != 0 && versionCode < 362600000;
    }

    private static void showToastIfResourceExists(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, null, context.getPackageName());
        if (identifier == 0) {
            return;
        }
        Toast.makeText(context, identifier, 1).show();
    }
}
