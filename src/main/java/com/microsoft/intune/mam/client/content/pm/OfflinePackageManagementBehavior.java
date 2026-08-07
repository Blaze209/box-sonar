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
public class OfflinePackageManagementBehavior implements PackageManagementBehavior {
    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Drawable getActivityIcon(PackageManager packageManager, ComponentName componentName) throws PackageManager.NameNotFoundException {
        return packageManager.getActivityIcon(componentName);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Drawable getActivityIcon(PackageManager packageManager, Intent intent) throws PackageManager.NameNotFoundException {
        return packageManager.getActivityIcon(intent);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public ActivityInfo getActivityInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return packageManager.getActivityInfo(componentName, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Drawable getActivityLogo(PackageManager packageManager, ComponentName componentName) throws PackageManager.NameNotFoundException {
        return packageManager.getActivityLogo(componentName);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Drawable getActivityLogo(PackageManager packageManager, Intent intent) throws PackageManager.NameNotFoundException {
        return packageManager.getActivityLogo(intent);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public int checkPermission(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public int checkSignatures(PackageManager packageManager, String str, String str2) {
        return packageManager.checkSignatures(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public int checkSignatures(PackageManager packageManager, int i, int i2) {
        return packageManager.checkSignatures(i, i2);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public int getApplicationEnabledSetting(PackageManager packageManager, String str) {
        return packageManager.getApplicationEnabledSetting(str);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Drawable getApplicationIcon(PackageManager packageManager, ApplicationInfo applicationInfo) {
        return packageManager.getApplicationIcon(applicationInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Drawable getApplicationIcon(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return packageManager.getApplicationIcon(str);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public ApplicationInfo getApplicationInfo(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
        return packageManager.getApplicationInfo(str, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public CharSequence getApplicationLabel(PackageManager packageManager, ApplicationInfo applicationInfo) {
        return packageManager.getApplicationLabel(applicationInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Drawable getApplicationLogo(PackageManager packageManager, ApplicationInfo applicationInfo) {
        return packageManager.getApplicationLogo(applicationInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Drawable getApplicationLogo(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return packageManager.getApplicationLogo(str);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public int getComponentEnabledSetting(PackageManager packageManager, ComponentName componentName) {
        return packageManager.getComponentEnabledSetting(componentName);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Drawable getDrawable(PackageManager packageManager, String str, int i, ApplicationInfo applicationInfo) {
        return packageManager.getDrawable(str, i, applicationInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public List<ApplicationInfo> getInstalledApplications(PackageManager packageManager, int i) {
        return packageManager.getInstalledApplications(i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public List<PackageInfo> getInstalledPackages(PackageManager packageManager, int i) {
        return packageManager.getInstalledPackages(i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public String getInstallerPackageName(PackageManager packageManager, String str) {
        return packageManager.getInstallerPackageName(str);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Intent getLaunchIntentsForPackage(PackageManager packageManager, String str) {
        return packageManager.getLaunchIntentForPackage(str);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public String getNameForUid(PackageManager packageManager, int i) {
        return packageManager.getNameForUid(i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public int[] getPackageGids(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageGids(str);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public int[] getPackageGids(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageGids(str, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public int getPackageUid(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageUid(str, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public PackageInfo getPackageInfo(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageInfo(str, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public PackageInfo getPackageInfo(PackageManager packageManager, VersionedPackage versionedPackage, int i) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageInfo(versionedPackage, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public String[] getPackagesForUid(PackageManager packageManager, int i) {
        return packageManager.getPackagesForUid(i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public List<PackageInfo> getPackagesHoldingPermissions(PackageManager packageManager, String[] strArr, int i) {
        return packageManager.getPackagesHoldingPermissions(strArr, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public List<PackageInfo> getPreferredPackages(PackageManager packageManager, int i) {
        return packageManager.getPreferredPackages(i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public ProviderInfo getProviderInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return packageManager.getProviderInfo(componentName, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public ActivityInfo getReceiverInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return packageManager.getReceiverInfo(componentName, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Resources getResourcesForActivity(PackageManager packageManager, ComponentName componentName) throws PackageManager.NameNotFoundException {
        return packageManager.getResourcesForActivity(componentName);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Resources getResourcesForApplication(PackageManager packageManager, ApplicationInfo applicationInfo) throws PackageManager.NameNotFoundException {
        return packageManager.getResourcesForApplication(applicationInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public Resources getResourcesForApplication(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return packageManager.getResourcesForApplication(str);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public ServiceInfo getServiceInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return packageManager.getServiceInfo(componentName, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public CharSequence getText(PackageManager packageManager, String str, int i, ApplicationInfo applicationInfo) {
        return packageManager.getText(str, i, applicationInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public XmlResourceParser getXml(PackageManager packageManager, String str, int i, ApplicationInfo applicationInfo) {
        return packageManager.getXml(str, i, applicationInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public List<ResolveInfo> queryBroadcastReceivers(PackageManager packageManager, Intent intent, int i) {
        return packageManager.queryBroadcastReceivers(intent, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public List<ProviderInfo> queryContentProviders(PackageManager packageManager, String str, int i, int i2) {
        return packageManager.queryContentProviders(str, i, i2);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public List<InstrumentationInfo> queryInstrumentation(PackageManager packageManager, String str, int i) {
        return packageManager.queryInstrumentation(str, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent, int i) {
        return packageManager.queryIntentActivities(intent, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public List<ResolveInfo> queryIntentActivityOptions(PackageManager packageManager, ComponentName componentName, Intent[] intentArr, Intent intent, int i) {
        return packageManager.queryIntentActivityOptions(componentName, intentArr, intent, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, int i) {
        return packageManager.queryIntentContentProviders(intent, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public List<ResolveInfo> queryIntentServices(PackageManager packageManager, Intent intent, int i) {
        return packageManager.queryIntentServices(intent, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public ResolveInfo resolveActivity(PackageManager packageManager, Intent intent, int i) {
        return packageManager.resolveActivity(intent, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public ProviderInfo resolveContentProvider(PackageManager packageManager, String str, int i) {
        return packageManager.resolveContentProvider(str, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public ResolveInfo resolveService(PackageManager packageManager, Intent intent, int i) {
        return packageManager.resolveService(intent, i);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public void setApplicationEnabledSetting(PackageManager packageManager, String str, int i, int i2) {
        packageManager.setApplicationEnabledSetting(str, i, i2);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior
    public void setComponentEnabledSetting(PackageManager packageManager, ComponentName componentName, int i, int i2) {
        packageManager.setComponentEnabledSetting(componentName, i, i2);
    }
}
