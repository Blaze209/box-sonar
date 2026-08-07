package com.google.androidbrowserhelper.trusted;

import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes13.dex */
public class ChromeOsSupport {
    public static final String ARC_FEATURE = "org.chromium.arc";
    public static final String ARC_PAYMENT_APP = "org.chromium.arc.payment_app";

    public static boolean isRunningOnArc(PackageManager packageManager) {
        return packageManager.hasSystemFeature(ARC_FEATURE);
    }
}
