package com.google.androidbrowserhelper.trusted;

import android.content.pm.PackageManager;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class ChromeLegacyUtils {
    private static final String CHROME_STABLE_PACKAGE = "com.android.chrome";
    private static final int VERSION_SUPPORTS_CUSTOM_COLOR = 380900000;
    private static final int VERSION_SUPPORTS_NO_PREWARM = 368300000;
    private static final int VERSION_SUPPORTS_SIMPLIFIED_MANAGE_DATA = 389000000;
    static final int VERSION_SUPPORTS_TRUSTED_WEB_ACTIVITIES = 362600000;
    private static final String CHROME_LOCAL_BUILD_PACKAGE = "com.google.android.apps.chrome";
    private static final String CHROMIUM_LOCAL_BUILD_PACKAGE = "org.chromium.chrome";
    private static final String CHROME_CANARY_PACKAGE = "com.chrome.canary";
    private static final String CHROME_DEV_PACKAGE = "com.chrome.dev";
    private static final String CHROME_BETA_PACKAGE = "com.chrome.beta";
    private static final List<String> SUPPORTED_CHROME_PACKAGES = Arrays.asList(CHROME_LOCAL_BUILD_PACKAGE, CHROMIUM_LOCAL_BUILD_PACKAGE, CHROME_CANARY_PACKAGE, CHROME_DEV_PACKAGE, CHROME_BETA_PACKAGE, "com.android.chrome");
    static final List<String> VERSION_CHECK_CHROME_PACKAGES = Arrays.asList(CHROME_BETA_PACKAGE, "com.android.chrome");
    private static final List<String> LOCAL_BUILD_PACKAGES = Arrays.asList(CHROME_LOCAL_BUILD_PACKAGE, CHROMIUM_LOCAL_BUILD_PACKAGE);

    private ChromeLegacyUtils() {
    }

    public static boolean usesWhiteNavbar(String str) {
        return SUPPORTED_CHROME_PACKAGES.contains(str);
    }

    public static boolean supportsNavbarAndColorCustomization(PackageManager packageManager, String str) {
        if (SUPPORTED_CHROME_PACKAGES.contains(str)) {
            return checkChromeVersion(packageManager, str, VERSION_SUPPORTS_CUSTOM_COLOR);
        }
        return false;
    }

    public static boolean supportsTrustedWebActivities(PackageManager packageManager, String str) {
        if (SUPPORTED_CHROME_PACKAGES.contains(str)) {
            return checkChromeVersion(packageManager, str, VERSION_SUPPORTS_TRUSTED_WEB_ACTIVITIES);
        }
        return false;
    }

    public static boolean supportsSiteSettings(PackageManager packageManager, String str) {
        return supportsTrustedWebActivities(packageManager, str);
    }

    public static boolean supportsLaunchWithoutWarmup(PackageManager packageManager, String str) {
        if (SUPPORTED_CHROME_PACKAGES.contains(str)) {
            return checkChromeVersion(packageManager, str, VERSION_SUPPORTS_NO_PREWARM);
        }
        return true;
    }

    public static boolean supportsManageSpaceWithoutWarmupAndValidation(PackageManager packageManager, String str) {
        if (SUPPORTED_CHROME_PACKAGES.contains(str)) {
            return checkChromeVersion(packageManager, str, VERSION_SUPPORTS_SIMPLIFIED_MANAGE_DATA);
        }
        return false;
    }

    private static boolean checkChromeVersion(PackageManager packageManager, String str, int i) {
        return LOCAL_BUILD_PACKAGES.contains(str) || getVersionCode(packageManager, str) >= i;
    }

    static int getVersionCode(PackageManager packageManager, String str) {
        try {
            return (int) MAMPackageManagement.getPackageInfo(packageManager, str, 0).getLongVersionCode();
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }
}
