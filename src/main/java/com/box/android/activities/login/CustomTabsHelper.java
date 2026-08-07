package com.box.android.activities.login;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public class CustomTabsHelper {
    private static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    static final String STABLE_PACKAGE = "com.android.chrome";
    private static final String TAG = "CustomTabsHelper";
    private static String sPackageNameToUse;
    static final String BETA_PACKAGE = "com.chrome.beta";
    static final String DEV_PACKAGE = "com.chrome.dev";
    static final String LOCAL_PACKAGE = "com.google.android.apps.chrome";
    static final String EDGE_PACKAGE = "com.microsoft.emmx";
    private static final Set<String> ACCEPTED_BROWSERS = Collections.unmodifiableSet(new HashSet(Arrays.asList("com.android.chrome", BETA_PACKAGE, DEV_PACKAGE, LOCAL_PACKAGE, EDGE_PACKAGE)));

    private CustomTabsHelper() {
    }

    public static boolean isAcceptedBrowser(String str) {
        return str != null && ACCEPTED_BROWSERS.contains(str);
    }

    public static String getPackageNameToUse(Context context) {
        String str = sPackageNameToUse;
        if (str != null) {
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        String str2 = resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 131072);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("android.support.customtabs.action.CustomTabsService");
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            sPackageNameToUse = null;
        } else if (arrayList.contains("com.android.chrome")) {
            sPackageNameToUse = "com.android.chrome";
        } else if (arrayList.size() == 1) {
            sPackageNameToUse = (String) arrayList.get(0);
        } else if (!TextUtils.isEmpty(str2) && !hasSpecializedHandlerIntents(context, intent) && arrayList.contains(str2)) {
            sPackageNameToUse = str2;
        } else if (arrayList.contains(BETA_PACKAGE)) {
            sPackageNameToUse = BETA_PACKAGE;
        } else if (arrayList.contains(DEV_PACKAGE)) {
            sPackageNameToUse = DEV_PACKAGE;
        } else if (arrayList.contains(LOCAL_PACKAGE)) {
            sPackageNameToUse = LOCAL_PACKAGE;
        } else if (arrayList.contains(EDGE_PACKAGE)) {
            sPackageNameToUse = EDGE_PACKAGE;
        }
        return sPackageNameToUse;
    }

    private static boolean hasSpecializedHandlerIntents(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            if (listQueryIntentActivities != null && listQueryIntentActivities.size() != 0) {
                for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                    IntentFilter intentFilter = resolveInfo.filter;
                    if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (RuntimeException unused) {
            Log.e(TAG, "Runtime exception while getting specialized handlers");
        }
    }

    static void resetCacheForTesting() {
        sPackageNameToUse = null;
    }
}
