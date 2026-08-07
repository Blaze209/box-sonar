package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;

/* JADX INFO: loaded from: classes14.dex */
class InstallerPackageNameProvider {
    private static final String NO_INSTALLER_PACKAGE_NAME = "";
    private String installerPackageName;

    InstallerPackageNameProvider() {
    }

    synchronized String getInstallerPackageName(Context context) {
        if (this.installerPackageName == null) {
            this.installerPackageName = loadInstallerPackageName(context);
        }
        return "".equals(this.installerPackageName) ? null : this.installerPackageName;
    }

    private static String loadInstallerPackageName(Context context) {
        String installerPackageName = MAMPackageManagement.getInstallerPackageName(context.getPackageManager(), context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }
}
