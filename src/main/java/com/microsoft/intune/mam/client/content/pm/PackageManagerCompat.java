package com.microsoft.intune.mam.client.content.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.VersionedPackage;
import android.os.Build;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PackageManagerCompat {
    private PackageManagerCompat() {
    }

    public static ActivityInfo getActivityInfo(PackageManager packageManager, ComponentName componentName, long j) throws PackageManager.NameNotFoundException {
        if (isAndroidTOrHigher()) {
            return packageManager.getActivityInfo(componentName, PackageManager.ComponentInfoFlags.of(j));
        }
        return packageManager.getActivityInfo(componentName, (int) j);
    }

    public static ApplicationInfo getApplicationInfo(PackageManager packageManager, String str, long j) throws PackageManager.NameNotFoundException {
        if (isAndroidTOrHigher()) {
            return packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(j));
        }
        return packageManager.getApplicationInfo(str, (int) j);
    }

    public static List<ApplicationInfo> getInstalledApplications(PackageManager packageManager, long j) {
        if (isAndroidTOrHigher()) {
            return packageManager.getInstalledApplications(PackageManager.ApplicationInfoFlags.of(j));
        }
        return packageManager.getInstalledApplications((int) j);
    }

    public static List<PackageInfo> getInstalledPackages(PackageManager packageManager, long j) {
        if (isAndroidTOrHigher()) {
            return packageManager.getInstalledPackages(PackageManager.PackageInfoFlags.of(j));
        }
        return packageManager.getInstalledPackages((int) j);
    }

    public static int[] getPackageGids(PackageManager packageManager, String str, long j) throws PackageManager.NameNotFoundException {
        if (isAndroidTOrHigher()) {
            return packageManager.getPackageGids(str, PackageManager.PackageInfoFlags.of(j));
        }
        return packageManager.getPackageGids(str, (int) j);
    }

    public static int getPackageUid(PackageManager packageManager, String str, long j) throws PackageManager.NameNotFoundException {
        if (isAndroidTOrHigher()) {
            return packageManager.getPackageUid(str, PackageManager.PackageInfoFlags.of(j));
        }
        return packageManager.getPackageUid(str, (int) j);
    }

    public static List<PackageInfo> getPackagesHoldingPermissions(PackageManager packageManager, String[] strArr, long j) {
        if (isAndroidTOrHigher()) {
            return packageManager.getPackagesHoldingPermissions(strArr, PackageManager.PackageInfoFlags.of(j));
        }
        return packageManager.getPackagesHoldingPermissions(strArr, (int) j);
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, String str, long j) throws PackageManager.NameNotFoundException {
        if (isAndroidTOrHigher()) {
            return packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(j));
        }
        return packageManager.getPackageInfo(str, (int) j);
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, VersionedPackage versionedPackage, long j) throws PackageManager.NameNotFoundException {
        if (isAndroidTOrHigher()) {
            return packageManager.getPackageInfo(versionedPackage, PackageManager.PackageInfoFlags.of(j));
        }
        return packageManager.getPackageInfo(versionedPackage, (int) j);
    }

    public static ProviderInfo getProviderInfo(PackageManager packageManager, ComponentName componentName, long j) throws PackageManager.NameNotFoundException {
        if (isAndroidTOrHigher()) {
            return packageManager.getProviderInfo(componentName, PackageManager.ComponentInfoFlags.of(j));
        }
        return packageManager.getProviderInfo(componentName, (int) j);
    }

    public static ActivityInfo getReceiverInfo(PackageManager packageManager, ComponentName componentName, long j) throws PackageManager.NameNotFoundException {
        if (isAndroidTOrHigher()) {
            return packageManager.getReceiverInfo(componentName, PackageManager.ComponentInfoFlags.of(j));
        }
        return packageManager.getReceiverInfo(componentName, (int) j);
    }

    public static ServiceInfo getServiceInfo(PackageManager packageManager, ComponentName componentName, long j) throws PackageManager.NameNotFoundException {
        if (isAndroidTOrHigher()) {
            return packageManager.getServiceInfo(componentName, PackageManager.ComponentInfoFlags.of(j));
        }
        return packageManager.getServiceInfo(componentName, (int) j);
    }

    public static List<ResolveInfo> queryBroadcastReceivers(PackageManager packageManager, Intent intent, long j) {
        if (isAndroidTOrHigher()) {
            return packageManager.queryBroadcastReceivers(intent, PackageManager.ResolveInfoFlags.of(j));
        }
        return packageManager.queryBroadcastReceivers(intent, (int) j);
    }

    public static List<ProviderInfo> queryContentProviders(PackageManager packageManager, String str, int i, long j) {
        if (isAndroidTOrHigher()) {
            return packageManager.queryContentProviders(str, i, PackageManager.ComponentInfoFlags.of(j));
        }
        return packageManager.queryContentProviders(str, i, (int) j);
    }

    public static List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent, long j) {
        if (isAndroidTOrHigher()) {
            return packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(j));
        }
        return packageManager.queryIntentActivities(intent, (int) j);
    }

    public static List<ResolveInfo> queryIntentActivityOptions(PackageManager packageManager, ComponentName componentName, Intent[] intentArr, Intent intent, long j) {
        if (isAndroidTOrHigher()) {
            return packageManager.queryIntentActivityOptions(componentName, Arrays.asList(intentArr), intent, PackageManager.ResolveInfoFlags.of(j));
        }
        return packageManager.queryIntentActivityOptions(componentName, intentArr, intent, (int) j);
    }

    public static List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, long j) {
        if (isAndroidTOrHigher()) {
            return packageManager.queryIntentContentProviders(intent, PackageManager.ResolveInfoFlags.of(j));
        }
        return packageManager.queryIntentContentProviders(intent, (int) j);
    }

    public static List<ResolveInfo> queryIntentServices(PackageManager packageManager, Intent intent, long j) {
        if (isAndroidTOrHigher()) {
            return packageManager.queryIntentServices(intent, PackageManager.ResolveInfoFlags.of(j));
        }
        return packageManager.queryIntentServices(intent, (int) j);
    }

    public static ResolveInfo resolveActivity(PackageManager packageManager, Intent intent, long j) {
        if (isAndroidTOrHigher()) {
            return packageManager.resolveActivity(intent, PackageManager.ResolveInfoFlags.of(j));
        }
        return packageManager.resolveActivity(intent, (int) j);
    }

    public static ProviderInfo resolveContentProvider(PackageManager packageManager, String str, long j) {
        if (isAndroidTOrHigher()) {
            return packageManager.resolveContentProvider(str, PackageManager.ComponentInfoFlags.of(j));
        }
        return packageManager.resolveContentProvider(str, (int) j);
    }

    public static ResolveInfo resolveService(PackageManager packageManager, Intent intent, long j) {
        if (isAndroidTOrHigher()) {
            return packageManager.resolveService(intent, PackageManager.ResolveInfoFlags.of(j));
        }
        return packageManager.resolveService(intent, (int) j);
    }

    private static boolean isAndroidTOrHigher() {
        return Build.VERSION.SDK_INT >= 33;
    }
}
