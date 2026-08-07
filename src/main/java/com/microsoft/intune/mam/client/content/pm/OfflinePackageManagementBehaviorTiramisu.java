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
public class OfflinePackageManagementBehaviorTiramisu extends OfflinePackageManagementBehavior implements PackageManagementBehaviorTiramisu {
    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public ActivityInfo getActivityInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getActivityInfo(componentName, componentInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public ApplicationInfo getApplicationInfo(PackageManager packageManager, String str, PackageManager.ApplicationInfoFlags applicationInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getApplicationInfo(str, applicationInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public List<ApplicationInfo> getInstalledApplications(PackageManager packageManager, PackageManager.ApplicationInfoFlags applicationInfoFlags) {
        return packageManager.getInstalledApplications(applicationInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public List<PackageInfo> getInstalledPackages(PackageManager packageManager, PackageManager.PackageInfoFlags packageInfoFlags) {
        return packageManager.getInstalledPackages(packageInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public IntentSender getLaunchIntentSenderForPackage(PackageManager packageManager, String str) {
        return packageManager.getLaunchIntentSenderForPackage(str);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public int[] getPackageGids(PackageManager packageManager, String str, PackageManager.PackageInfoFlags packageInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageGids(str, packageInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public int getPackageUid(PackageManager packageManager, String str, PackageManager.PackageInfoFlags packageInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageUid(str, packageInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public PackageInfo getPackageInfo(PackageManager packageManager, String str, PackageManager.PackageInfoFlags packageInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageInfo(str, packageInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public PackageInfo getPackageInfo(PackageManager packageManager, VersionedPackage versionedPackage, PackageManager.PackageInfoFlags packageInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageInfo(versionedPackage, packageInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public List<PackageInfo> getPackagesHoldingPermissions(PackageManager packageManager, String[] strArr, PackageManager.PackageInfoFlags packageInfoFlags) {
        return packageManager.getPackagesHoldingPermissions(strArr, packageInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public ActivityInfo getReceiverInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getReceiverInfo(componentName, componentInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public ProviderInfo getProviderInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getProviderInfo(componentName, componentInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public ServiceInfo getServiceInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getServiceInfo(componentName, componentInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public List<ResolveInfo> queryBroadcastReceivers(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return packageManager.queryBroadcastReceivers(intent, resolveInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public List<ProviderInfo> queryContentProviders(PackageManager packageManager, String str, int i, PackageManager.ComponentInfoFlags componentInfoFlags) {
        return packageManager.queryContentProviders(str, i, componentInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return packageManager.queryIntentActivities(intent, resolveInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public List<ResolveInfo> queryIntentActivityOptions(PackageManager packageManager, ComponentName componentName, List<Intent> list, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return packageManager.queryIntentActivityOptions(componentName, list, intent, resolveInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return packageManager.queryIntentContentProviders(intent, resolveInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public List<ResolveInfo> queryIntentServices(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return packageManager.queryIntentServices(intent, resolveInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public ResolveInfo resolveActivity(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return packageManager.resolveActivity(intent, resolveInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public ProviderInfo resolveContentProvider(PackageManager packageManager, String str, PackageManager.ComponentInfoFlags componentInfoFlags) {
        return packageManager.resolveContentProvider(str, componentInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public ResolveInfo resolveService(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return packageManager.resolveService(intent, resolveInfoFlags);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu
    public void setComponentEnabledSettings(PackageManager packageManager, List<PackageManager.ComponentEnabledSetting> list) {
        packageManager.setComponentEnabledSettings(list);
    }
}
