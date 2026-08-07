package com.microsoft.intune.mam.client.content.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ArchivedPackageInfo;
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
import android.os.Build;
import com.microsoft.intune.mam.client.CachedBehaviorProvider;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMPackageManagement {
    private static CachedBehaviorProvider<PackageManagementBehavior> sCachedBehavior = new CachedBehaviorProvider<>(PackageManagementBehavior.class);
    private static CachedBehaviorProvider<PackageManagementBehaviorTiramisu> sCachedBehaviorTiramisu;
    private static CachedBehaviorProvider<PackageManagementBehaviorVanillaIceCream> sCachedBehaviorVanillaIceCream;

    static {
        sCachedBehaviorTiramisu = Build.VERSION.SDK_INT >= 33 ? new CachedBehaviorProvider<>(PackageManagementBehaviorTiramisu.class) : null;
        sCachedBehaviorVanillaIceCream = Build.VERSION.SDK_INT >= 35 ? new CachedBehaviorProvider<>(PackageManagementBehaviorVanillaIceCream.class) : null;
    }

    public static int checkPermission(PackageManager packageManager, String str, String str2) {
        return getBehavior().checkPermission(packageManager, str, str2);
    }

    public static int checkSignatures(PackageManager packageManager, String str, String str2) {
        return getBehavior().checkSignatures(packageManager, str, str2);
    }

    public static int checkSignatures(PackageManager packageManager, int i, int i2) {
        return getBehavior().checkSignatures(packageManager, i, i2);
    }

    public static Drawable getActivityIcon(PackageManager packageManager, ComponentName componentName) throws PackageManager.NameNotFoundException {
        return getBehavior().getActivityIcon(packageManager, componentName);
    }

    public static Drawable getActivityIcon(PackageManager packageManager, Intent intent) throws PackageManager.NameNotFoundException {
        return getBehavior().getActivityIcon(packageManager, intent);
    }

    public static ActivityInfo getActivityInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return getBehavior().getActivityInfo(packageManager, componentName, i);
    }

    public static ActivityInfo getActivityInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        return getBehaviorTiramisu().getActivityInfo(packageManager, componentName, componentInfoFlags);
    }

    public static Drawable getActivityLogo(PackageManager packageManager, ComponentName componentName) throws PackageManager.NameNotFoundException {
        return getBehavior().getActivityLogo(packageManager, componentName);
    }

    public static Drawable getActivityLogo(PackageManager packageManager, Intent intent) throws PackageManager.NameNotFoundException {
        return getBehavior().getActivityLogo(packageManager, intent);
    }

    public static int getApplicationEnabledSetting(PackageManager packageManager, String str) {
        return getBehavior().getApplicationEnabledSetting(packageManager, str);
    }

    public static Drawable getApplicationIcon(PackageManager packageManager, ApplicationInfo applicationInfo) {
        return getBehavior().getApplicationIcon(packageManager, applicationInfo);
    }

    public static Drawable getApplicationIcon(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return getBehavior().getApplicationIcon(packageManager, str);
    }

    public static ApplicationInfo getApplicationInfo(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
        return getBehavior().getApplicationInfo(packageManager, str, i);
    }

    public static ApplicationInfo getApplicationInfo(PackageManager packageManager, String str, PackageManager.ApplicationInfoFlags applicationInfoFlags) throws PackageManager.NameNotFoundException {
        return getBehaviorTiramisu().getApplicationInfo(packageManager, str, applicationInfoFlags);
    }

    public static CharSequence getApplicationLabel(PackageManager packageManager, ApplicationInfo applicationInfo) {
        return getBehavior().getApplicationLabel(packageManager, applicationInfo);
    }

    public static Drawable getApplicationLogo(PackageManager packageManager, ApplicationInfo applicationInfo) {
        return getBehavior().getApplicationLogo(packageManager, applicationInfo);
    }

    public static Drawable getApplicationLogo(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return getBehavior().getApplicationLogo(packageManager, str);
    }

    public static int getComponentEnabledSetting(PackageManager packageManager, ComponentName componentName) {
        return getBehavior().getComponentEnabledSetting(packageManager, componentName);
    }

    public static Drawable getDrawable(PackageManager packageManager, String str, int i, ApplicationInfo applicationInfo) {
        return getBehavior().getDrawable(packageManager, str, i, applicationInfo);
    }

    public static List<ApplicationInfo> getInstalledApplications(PackageManager packageManager, int i) {
        return getBehavior().getInstalledApplications(packageManager, i);
    }

    public static List<ApplicationInfo> getInstalledApplications(PackageManager packageManager, PackageManager.ApplicationInfoFlags applicationInfoFlags) {
        return getBehaviorTiramisu().getInstalledApplications(packageManager, applicationInfoFlags);
    }

    public static List<PackageInfo> getInstalledPackages(PackageManager packageManager, int i) {
        return getBehavior().getInstalledPackages(packageManager, i);
    }

    public static List<PackageInfo> getInstalledPackages(PackageManager packageManager, PackageManager.PackageInfoFlags packageInfoFlags) {
        return getBehaviorTiramisu().getInstalledPackages(packageManager, packageInfoFlags);
    }

    public static String getInstallerPackageName(PackageManager packageManager, String str) {
        return getBehavior().getInstallerPackageName(packageManager, str);
    }

    public static Intent getLaunchIntentForPackage(PackageManager packageManager, String str) {
        return getBehavior().getLaunchIntentsForPackage(packageManager, str);
    }

    public static IntentSender getLaunchIntentSenderForPackage(PackageManager packageManager, String str) {
        return getBehaviorTiramisu().getLaunchIntentSenderForPackage(packageManager, str);
    }

    public static String getNameForUid(PackageManager packageManager, int i) {
        return getBehavior().getNameForUid(packageManager, i);
    }

    public static int[] getPackageGids(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return getBehavior().getPackageGids(packageManager, str);
    }

    public static int[] getPackageGids(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
        return getBehavior().getPackageGids(packageManager, str, i);
    }

    public static int[] getPackageGids(PackageManager packageManager, String str, PackageManager.PackageInfoFlags packageInfoFlags) throws PackageManager.NameNotFoundException {
        return getBehaviorTiramisu().getPackageGids(packageManager, str, packageInfoFlags);
    }

    public static int getPackageUid(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
        return getBehavior().getPackageUid(packageManager, str, i);
    }

    public static int getPackageUid(PackageManager packageManager, String str, PackageManager.PackageInfoFlags packageInfoFlags) throws PackageManager.NameNotFoundException {
        return getBehaviorTiramisu().getPackageUid(packageManager, str, packageInfoFlags);
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
        return getBehavior().getPackageInfo(packageManager, str, i);
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, VersionedPackage versionedPackage, int i) throws PackageManager.NameNotFoundException {
        return getBehavior().getPackageInfo(packageManager, versionedPackage, i);
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, String str, PackageManager.PackageInfoFlags packageInfoFlags) throws PackageManager.NameNotFoundException {
        return getBehaviorTiramisu().getPackageInfo(packageManager, str, packageInfoFlags);
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, VersionedPackage versionedPackage, PackageManager.PackageInfoFlags packageInfoFlags) throws PackageManager.NameNotFoundException {
        return getBehaviorTiramisu().getPackageInfo(packageManager, versionedPackage, packageInfoFlags);
    }

    public static String[] getPackagesForUid(PackageManager packageManager, int i) {
        return getBehavior().getPackagesForUid(packageManager, i);
    }

    public static List<PackageInfo> getPackagesHoldingPermissions(PackageManager packageManager, String[] strArr, int i) {
        return getBehavior().getPackagesHoldingPermissions(packageManager, strArr, i);
    }

    public static List<PackageInfo> getPackagesHoldingPermissions(PackageManager packageManager, String[] strArr, PackageManager.PackageInfoFlags packageInfoFlags) {
        return getBehaviorTiramisu().getPackagesHoldingPermissions(packageManager, strArr, packageInfoFlags);
    }

    public static List<PackageInfo> getPreferredPackages(PackageManager packageManager, int i) {
        return getBehavior().getPreferredPackages(packageManager, i);
    }

    public static ProviderInfo getProviderInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return getBehavior().getProviderInfo(packageManager, componentName, i);
    }

    public static ProviderInfo getProviderInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        return getBehaviorTiramisu().getProviderInfo(packageManager, componentName, componentInfoFlags);
    }

    public static ActivityInfo getReceiverInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return getBehavior().getReceiverInfo(packageManager, componentName, i);
    }

    public static ActivityInfo getReceiverInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        return getBehaviorTiramisu().getReceiverInfo(packageManager, componentName, componentInfoFlags);
    }

    public static Resources getResourcesForActivity(PackageManager packageManager, ComponentName componentName) throws PackageManager.NameNotFoundException {
        return getBehavior().getResourcesForActivity(packageManager, componentName);
    }

    public static Resources getResourcesForApplication(PackageManager packageManager, ApplicationInfo applicationInfo) throws PackageManager.NameNotFoundException {
        return getBehavior().getResourcesForApplication(packageManager, applicationInfo);
    }

    public static Resources getResourcesForApplication(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return getBehavior().getResourcesForApplication(packageManager, str);
    }

    public static ServiceInfo getServiceInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return getBehavior().getServiceInfo(packageManager, componentName, i);
    }

    public static ServiceInfo getServiceInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        return getBehaviorTiramisu().getServiceInfo(packageManager, componentName, componentInfoFlags);
    }

    public static CharSequence getText(PackageManager packageManager, String str, int i, ApplicationInfo applicationInfo) {
        return getBehavior().getText(packageManager, str, i, applicationInfo);
    }

    public static XmlResourceParser getXml(PackageManager packageManager, String str, int i, ApplicationInfo applicationInfo) {
        return getBehavior().getXml(packageManager, str, i, applicationInfo);
    }

    public static List<ResolveInfo> queryBroadcastReceivers(PackageManager packageManager, Intent intent, int i) {
        return getBehavior().queryBroadcastReceivers(packageManager, intent, i);
    }

    public static List<ResolveInfo> queryBroadcastReceivers(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return getBehaviorTiramisu().queryBroadcastReceivers(packageManager, intent, resolveInfoFlags);
    }

    public static List<ProviderInfo> queryContentProviders(PackageManager packageManager, String str, int i, int i2) {
        return getBehavior().queryContentProviders(packageManager, str, i, i2);
    }

    public static List<ProviderInfo> queryContentProviders(PackageManager packageManager, String str, int i, PackageManager.ComponentInfoFlags componentInfoFlags) {
        return getBehaviorTiramisu().queryContentProviders(packageManager, str, i, componentInfoFlags);
    }

    public static List<InstrumentationInfo> queryInstrumentation(PackageManager packageManager, String str, int i) {
        return getBehavior().queryInstrumentation(packageManager, str, i);
    }

    public static List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent, int i) {
        return getBehavior().queryIntentActivities(packageManager, intent, i);
    }

    public static List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return getBehaviorTiramisu().queryIntentActivities(packageManager, intent, resolveInfoFlags);
    }

    public static List<ResolveInfo> queryIntentActivityOptions(PackageManager packageManager, ComponentName componentName, Intent[] intentArr, Intent intent, int i) {
        return getBehavior().queryIntentActivityOptions(packageManager, componentName, intentArr, intent, i);
    }

    public static List<ResolveInfo> queryIntentActivityOptions(PackageManager packageManager, ComponentName componentName, List<Intent> list, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return getBehaviorTiramisu().queryIntentActivityOptions(packageManager, componentName, list, intent, resolveInfoFlags);
    }

    public static List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, int i) {
        return getBehavior().queryIntentContentProviders(packageManager, intent, i);
    }

    public static List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return getBehaviorTiramisu().queryIntentContentProviders(packageManager, intent, resolveInfoFlags);
    }

    public static List<ResolveInfo> queryIntentServices(PackageManager packageManager, Intent intent, int i) {
        return getBehavior().queryIntentServices(packageManager, intent, i);
    }

    public static List<ResolveInfo> queryIntentServices(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return getBehaviorTiramisu().queryIntentServices(packageManager, intent, resolveInfoFlags);
    }

    public static ResolveInfo resolveActivity(PackageManager packageManager, Intent intent, int i) {
        return getBehavior().resolveActivity(packageManager, intent, i);
    }

    public static ResolveInfo resolveActivity(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return getBehaviorTiramisu().resolveActivity(packageManager, intent, resolveInfoFlags);
    }

    public static ProviderInfo resolveContentProvider(PackageManager packageManager, String str, int i) {
        return getBehavior().resolveContentProvider(packageManager, str, i);
    }

    public static ProviderInfo resolveContentProvider(PackageManager packageManager, String str, PackageManager.ComponentInfoFlags componentInfoFlags) {
        return getBehaviorTiramisu().resolveContentProvider(packageManager, str, componentInfoFlags);
    }

    public static ResolveInfo resolveService(PackageManager packageManager, Intent intent, int i) {
        return getBehavior().resolveService(packageManager, intent, i);
    }

    public static ResolveInfo resolveService(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return getBehaviorTiramisu().resolveService(packageManager, intent, resolveInfoFlags);
    }

    public static void setApplicationEnabledSetting(PackageManager packageManager, String str, int i, int i2) {
        getBehavior().setApplicationEnabledSetting(packageManager, str, i, i2);
    }

    public static void setComponentEnabledSetting(PackageManager packageManager, ComponentName componentName, int i, int i2) {
        getBehavior().setComponentEnabledSetting(packageManager, componentName, i, i2);
    }

    public static void setComponentEnabledSettings(PackageManager packageManager, List<PackageManager.ComponentEnabledSetting> list) {
        getBehaviorTiramisu().setComponentEnabledSettings(packageManager, list);
    }

    public static ArchivedPackageInfo getArchivedPackage(PackageManager packageManager, String str) {
        return getBehaviorVanillaIceCream().getArchivedPackage(packageManager, str);
    }

    public static boolean isAppArchivable(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return getBehaviorVanillaIceCream().isAppArchivable(packageManager, str);
    }

    public static boolean isPackageStopped(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return getBehaviorVanillaIceCream().isPackageStopped(packageManager, str);
    }

    public static <T> T parseAndroidManifest(PackageManager packageManager, File file, Function<XmlResourceParser, T> function) throws IOException {
        return (T) getBehaviorVanillaIceCream().parseAndroidManifest(packageManager, file, function);
    }

    private static PackageManagementBehavior getBehavior() {
        return sCachedBehavior.get();
    }

    private static PackageManagementBehaviorTiramisu getBehaviorTiramisu() {
        return sCachedBehaviorTiramisu.get();
    }

    private static PackageManagementBehaviorVanillaIceCream getBehaviorVanillaIceCream() {
        return sCachedBehaviorVanillaIceCream.get();
    }

    private MAMPackageManagement() {
    }
}
