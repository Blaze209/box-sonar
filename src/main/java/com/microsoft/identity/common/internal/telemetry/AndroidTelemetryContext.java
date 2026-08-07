package com.microsoft.identity.common.internal.telemetry;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.pm.PackageInfoCompat;
import com.microsoft.identity.common.java.telemetry.AbstractTelemetryContext;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class AndroidTelemetryContext extends AbstractTelemetryContext {
    private static final String TAG = "AndroidTelemetryContext";

    public AndroidTelemetryContext(Context context) {
        super(new AndroidTelemetryPropertiesCache(context));
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        addApplicationInfo(context);
        addDeviceInfo(Build.MANUFACTURER, Build.MODEL, Build.DEVICE);
        addOsInfo();
    }

    private void addApplicationInfo(Context context) {
        String str;
        String string;
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        String str2 = TAG + ":addApplicationInfo";
        try {
            PackageInfo packageInfo = MAMPackageManagement.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            long longVersionCode = PackageInfoCompat.getLongVersionCode(packageInfo);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                str = "";
            } else {
                str = applicationInfo.packageName;
                if (applicationInfo.labelRes == 0) {
                    if (applicationInfo.nonLocalizedLabel != null) {
                        string = applicationInfo.nonLocalizedLabel.toString();
                    }
                } else {
                    string = context.getString(applicationInfo.labelRes);
                }
                super.addApplicationInfo(str, string, packageInfo.versionName, String.valueOf(longVersionCode));
            }
            string = str;
            super.addApplicationInfo(str, string, packageInfo.versionName, String.valueOf(longVersionCode));
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.warn(str2, "Unable to find the app's package name from PackageManager.");
        }
    }

    private void addOsInfo() {
        super.addOsInfo("android", Build.VERSION.RELEASE);
        put(com.microsoft.identity.common.java.telemetry.TelemetryEventStrings.Os.SECURITY_PATCH, Build.VERSION.SECURITY_PATCH);
    }

    public void isNetworkDisabledFromOptimizations(boolean z) {
        put(com.microsoft.identity.common.java.telemetry.TelemetryEventStrings.Key.POWER_OPTIMIZATION, String.valueOf(z));
    }

    public void isNetworkConnected(boolean z) {
        put(com.microsoft.identity.common.java.telemetry.TelemetryEventStrings.Key.NETWORK_CONNECTION, String.valueOf(z));
    }
}
