package com.microsoft.intune.mam.client.content.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.VersionedPackage;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface PackageManagementBehavior {
    int checkPermission(PackageManager packageManager, String str, String str2);

    int checkSignatures(PackageManager packageManager, int i, int i2);

    int checkSignatures(PackageManager packageManager, String str, String str2);

    Drawable getActivityIcon(PackageManager packageManager, ComponentName componentName) throws PackageManager.NameNotFoundException;

    Drawable getActivityIcon(PackageManager packageManager, Intent intent) throws PackageManager.NameNotFoundException;

    ActivityInfo getActivityInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException;

    Drawable getActivityLogo(PackageManager packageManager, ComponentName componentName) throws PackageManager.NameNotFoundException;

    Drawable getActivityLogo(PackageManager packageManager, Intent intent) throws PackageManager.NameNotFoundException;

    int getApplicationEnabledSetting(PackageManager packageManager, String str);

    Drawable getApplicationIcon(PackageManager packageManager, ApplicationInfo applicationInfo);

    Drawable getApplicationIcon(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException;

    ApplicationInfo getApplicationInfo(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException;

    CharSequence getApplicationLabel(PackageManager packageManager, ApplicationInfo applicationInfo);

    Drawable getApplicationLogo(PackageManager packageManager, ApplicationInfo applicationInfo);

    Drawable getApplicationLogo(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException;

    int getComponentEnabledSetting(PackageManager packageManager, ComponentName componentName);

    Drawable getDrawable(PackageManager packageManager, String str, int i, ApplicationInfo applicationInfo);

    List<ApplicationInfo> getInstalledApplications(PackageManager packageManager, int i);

    List<PackageInfo> getInstalledPackages(PackageManager packageManager, int i);

    String getInstallerPackageName(PackageManager packageManager, String str);

    Intent getLaunchIntentsForPackage(PackageManager packageManager, String str);

    String getNameForUid(PackageManager packageManager, int i);

    int[] getPackageGids(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException;

    int[] getPackageGids(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException;

    PackageInfo getPackageInfo(PackageManager packageManager, VersionedPackage versionedPackage, int i) throws PackageManager.NameNotFoundException;

    PackageInfo getPackageInfo(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException;

    int getPackageUid(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException;

    String[] getPackagesForUid(PackageManager packageManager, int i);

    List<PackageInfo> getPackagesHoldingPermissions(PackageManager packageManager, String[] strArr, int i);

    List<PackageInfo> getPreferredPackages(PackageManager packageManager, int i);

    ProviderInfo getProviderInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException;

    ActivityInfo getReceiverInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException;

    Resources getResourcesForActivity(PackageManager packageManager, ComponentName componentName) throws PackageManager.NameNotFoundException;

    Resources getResourcesForApplication(PackageManager packageManager, ApplicationInfo applicationInfo) throws PackageManager.NameNotFoundException;

    Resources getResourcesForApplication(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException;

    ServiceInfo getServiceInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException;

    CharSequence getText(PackageManager packageManager, String str, int i, ApplicationInfo applicationInfo);

    XmlResourceParser getXml(PackageManager packageManager, String str, int i, ApplicationInfo applicationInfo);

    List<ResolveInfo> queryBroadcastReceivers(PackageManager packageManager, Intent intent, int i);

    List<ProviderInfo> queryContentProviders(PackageManager packageManager, String str, int i, int i2);

    List<InstrumentationInfo> queryInstrumentation(PackageManager packageManager, String str, int i);

    List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent, int i);

    List<ResolveInfo> queryIntentActivityOptions(PackageManager packageManager, ComponentName componentName, Intent[] intentArr, Intent intent, int i);

    List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, int i);

    List<ResolveInfo> queryIntentServices(PackageManager packageManager, Intent intent, int i);

    ResolveInfo resolveActivity(PackageManager packageManager, Intent intent, int i);

    ProviderInfo resolveContentProvider(PackageManager packageManager, String str, int i);

    ResolveInfo resolveService(PackageManager packageManager, Intent intent, int i);

    void setApplicationEnabledSetting(PackageManager packageManager, String str, int i, int i2);

    void setComponentEnabledSetting(PackageManager packageManager, ComponentName componentName, int i, int i2);
}
