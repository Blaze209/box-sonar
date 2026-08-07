package com.microsoft.intune.mam.client.app;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.UserManager;
import com.microsoft.intune.mam.client.content.pm.PackageManagerCompat;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class DirectBootUtils {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(DirectBootUtils.class);
    private static final List<String> OFFLINE_SHARED_PREFS = OfflineSharedPreferencesConstants.getSharedPrefsNames();

    private DirectBootUtils() {
    }

    public static Context getDirectBootAwareContext(Context context) {
        return (AppUtils.isToDoPackage(context) && new DirectBootStatusStore(context.createDeviceProtectedStorageContext()).isAllDirectBootStorageMigrated()) ? context.createDeviceProtectedStorageContext() : context;
    }

    public static boolean isUserUnlocked(Context context) {
        return ((UserManager) context.getSystemService("user")).isUserUnlocked();
    }

    public static void migrateSharedPrefsToDeviceProtectedStorageIfNeeded(Context context) {
        if (AppUtils.isToDoPackage(context)) {
            DirectBootStatusStore directBootStatusStore = new DirectBootStatusStore(context.createDeviceProtectedStorageContext());
            if (directBootStatusStore.hasDirectBootAwareComponent() == DirectBootStatusStore.AppContainsDirectBootAwareComponents.FALSE || directBootStatusStore.isAllDirectBootStorageMigrated()) {
                return;
            }
            if (!isUserUnlocked(context)) {
                LOGGER.warning("Unable to migrate shared preferences when user is not unlocked.", new Object[0]);
                return;
            }
            if (!hasDirectBootAwareComponents(context)) {
                directBootStatusStore.setHasDirectBootAwareComponent(DirectBootStatusStore.AppContainsDirectBootAwareComponents.FALSE);
                return;
            }
            for (String str : OFFLINE_SHARED_PREFS) {
                if (!directBootStatusStore.isDirectBootStorageMigrated(str)) {
                    context.createDeviceProtectedStorageContext().moveSharedPreferencesFrom(context, str);
                    directBootStatusStore.setDirectBootStorageMigrated(str);
                    LOGGER.info(String.format("Migrating shared preferences %s from credential protected storage to device protected storage.", str), new Object[0]);
                }
            }
            directBootStatusStore.setAllDirectBootStorageMigrated();
            directBootStatusStore.setHasDirectBootAwareComponent(DirectBootStatusStore.AppContainsDirectBootAwareComponents.TRUE);
            LOGGER.info("Migrating shared preferences finished.", new Object[0]);
        }
    }

    private static boolean hasDirectBootAwareComponents(Context context) {
        try {
            PackageInfo packageInfo = PackageManagerCompat.getPackageInfo(context.getPackageManager(), context.getPackageName(), 6L);
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            for (ActivityInfo activityInfo : packageInfo.receivers) {
                if (activityInfo.directBootAware) {
                    LOGGER.info(String.format("App's %s is direct boot aware.", activityInfo.name), new Object[0]);
                    return true;
                }
            }
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.directBootAware) {
                    LOGGER.info(String.format("App's %s is direct boot aware.", serviceInfo.name), new Object[0]);
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
