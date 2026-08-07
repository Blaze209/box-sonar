package com.microsoft.identity.common.internal.util;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.os.UserManager;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public final class AccountManagerUtil {
    private static final String MANIFEST_PERMISSION_MANAGE_ACCOUNTS = "android.permission.MANAGE_ACCOUNTS";
    private static final String TAG = "AccountManagerUtil";

    private AccountManagerUtil() {
    }

    public static boolean canUseAccountManagerOperation(Context context, Set<String> set) {
        String[] accountTypesWithManagementDisabled;
        String str = TAG + ":canUseAccountManagerOperation:";
        if (((UserManager) context.getSystemService("user")).hasUserRestriction("no_modify_accounts")) {
            Logger.verbose(str, "UserManager.DISALLOW_MODIFY_ACCOUNTS is enabled for this user.");
            return false;
        }
        DevicePolicyManager devicePolicyManager = getDevicePolicyManager(context);
        if (devicePolicyManager == null || (accountTypesWithManagementDisabled = devicePolicyManager.getAccountTypesWithManagementDisabled()) == null) {
            return true;
        }
        for (String str2 : accountTypesWithManagementDisabled) {
            if (set.contains(str2)) {
                Logger.info(str, "Account type " + str2 + " is disabled by MDM.");
                return false;
            }
        }
        return true;
    }

    private static DevicePolicyManager getDevicePolicyManager(Context context) {
        try {
            return (DevicePolicyManager) context.getSystemService("device_policy");
        } catch (Throwable unused) {
            Logger.verbose(TAG + ":getDevicePolicyManager", "Cannot get DevicePolicyManager.");
            return null;
        }
    }

    public static boolean isPermissionGranted(Context context, String str) {
        String str2 = TAG + ":isPermissionGranted";
        boolean z = MAMPackageManagement.checkPermission(context.getPackageManager(), str, context.getPackageName()) == 0;
        Logger.verbose(str2, "is " + str + " granted? [" + z + "]");
        return z;
    }
}
