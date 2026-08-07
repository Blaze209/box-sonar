package com.microsoft.intune.mam.client.content.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.VersionedPackage;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface PackageManagementBehaviorTiramisu extends PackageManagementBehavior {
    ActivityInfo getActivityInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException;

    ApplicationInfo getApplicationInfo(PackageManager packageManager, String str, PackageManager.ApplicationInfoFlags applicationInfoFlags) throws PackageManager.NameNotFoundException;

    List<ApplicationInfo> getInstalledApplications(PackageManager packageManager, PackageManager.ApplicationInfoFlags applicationInfoFlags);

    List<PackageInfo> getInstalledPackages(PackageManager packageManager, PackageManager.PackageInfoFlags packageInfoFlags);

    IntentSender getLaunchIntentSenderForPackage(PackageManager packageManager, String str);

    int[] getPackageGids(PackageManager packageManager, String str, PackageManager.PackageInfoFlags packageInfoFlags) throws PackageManager.NameNotFoundException;

    PackageInfo getPackageInfo(PackageManager packageManager, VersionedPackage versionedPackage, PackageManager.PackageInfoFlags packageInfoFlags) throws PackageManager.NameNotFoundException;

    PackageInfo getPackageInfo(PackageManager packageManager, String str, PackageManager.PackageInfoFlags packageInfoFlags) throws PackageManager.NameNotFoundException;

    int getPackageUid(PackageManager packageManager, String str, PackageManager.PackageInfoFlags packageInfoFlags) throws PackageManager.NameNotFoundException;

    List<PackageInfo> getPackagesHoldingPermissions(PackageManager packageManager, String[] strArr, PackageManager.PackageInfoFlags packageInfoFlags);

    ProviderInfo getProviderInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException;

    ActivityInfo getReceiverInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException;

    ServiceInfo getServiceInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException;

    List<ResolveInfo> queryBroadcastReceivers(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags);

    List<ProviderInfo> queryContentProviders(PackageManager packageManager, String str, int i, PackageManager.ComponentInfoFlags componentInfoFlags);

    List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags);

    List<ResolveInfo> queryIntentActivityOptions(PackageManager packageManager, ComponentName componentName, List<Intent> list, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags);

    List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags);

    List<ResolveInfo> queryIntentServices(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags);

    ResolveInfo resolveActivity(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags);

    ProviderInfo resolveContentProvider(PackageManager packageManager, String str, PackageManager.ComponentInfoFlags componentInfoFlags);

    ResolveInfo resolveService(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags);

    void setComponentEnabledSettings(PackageManager packageManager, List<PackageManager.ComponentEnabledSetting> list);
}
