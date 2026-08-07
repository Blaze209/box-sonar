package com.google.androidbrowserhelper.trusted;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsService;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class TwaProviderPicker {
    private static final String TAG = "TWAProviderPicker";
    private static String sPackageNameForTesting;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LaunchMode {
        public static final int BROWSER = 2;
        public static final int CUSTOM_TAB = 1;
        public static final int TRUSTED_WEB_ACTIVITY = 0;
    }

    public static class Action {
        public final int launchMode;
        public final String provider;

        public Action(int i, String str) {
            this.launchMode = i;
            this.provider = str;
        }
    }

    public static Action pickProvider(PackageManager packageManager) {
        String str = null;
        Intent data = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts("http", "", null));
        String str2 = sPackageNameForTesting;
        if (str2 != null) {
            data.setPackage(str2);
        }
        List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(packageManager, data, 65536);
        listQueryIntentActivities.addAll(MAMPackageManagement.queryIntentActivities(packageManager, data, 131072));
        Map<String, Integer> launchModesForCustomTabsServices = getLaunchModesForCustomTabsServices(packageManager);
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        String str3 = null;
        while (it.hasNext()) {
            String str4 = it.next().activityInfo.packageName;
            int iIntValue = launchModesForCustomTabsServices.containsKey(str4) ? launchModesForCustomTabsServices.get(str4).intValue() : 2;
            if (iIntValue == 0) {
                Log.d(TAG, "Found TWA provider, finishing search: " + str4);
                return new Action(0, str4);
            }
            if (iIntValue == 1) {
                Log.d(TAG, "Found Custom Tabs provider: " + str4);
                if (str == null) {
                    str = str4;
                }
            } else if (iIntValue == 2) {
                Log.d(TAG, "Found browser: " + str4);
                if (str3 == null) {
                    str3 = str4;
                }
            }
        }
        if (str != null) {
            Log.d(TAG, "Found no TWA providers, using first Custom Tabs provider: " + str);
            return new Action(1, str);
        }
        Log.d(TAG, "Found no TWA providers, using first browser: " + str3);
        return new Action(2, str3);
    }

    static void restrictToPackageForTesting(String str) {
        sPackageNameForTesting = str;
    }

    private static Map<String, Integer> getLaunchModesForCustomTabsServices(PackageManager packageManager) {
        List<ResolveInfo> listQueryIntentServices = MAMPackageManagement.queryIntentServices(packageManager, new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 64);
        HashMap map = new HashMap();
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            String str = resolveInfo.serviceInfo.packageName;
            int i = 0;
            if (ChromeLegacyUtils.supportsTrustedWebActivities(packageManager, str)) {
                map.put(str, 0);
            } else {
                if (resolveInfo.filter != null && resolveInfo.filter.hasCategory(CustomTabsService.TRUSTED_WEB_ACTIVITY_CATEGORY)) {
                    i = 1;
                }
                map.put(str, Integer.valueOf(i ^ 1));
            }
        }
        return map;
    }
}
