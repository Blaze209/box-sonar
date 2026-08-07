package com.microsoft.intune.mam.client.content.pm;

import android.content.pm.ArchivedPackageInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import java.io.File;
import java.io.IOException;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class OfflinePackageManagementBehaviorVanillaIceCream extends OfflinePackageManagementBehaviorTiramisu implements PackageManagementBehaviorVanillaIceCream {
    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorVanillaIceCream
    public ArchivedPackageInfo getArchivedPackage(PackageManager packageManager, String str) {
        return packageManager.getArchivedPackage(str);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorVanillaIceCream
    public boolean isAppArchivable(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return packageManager.isAppArchivable(str);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorVanillaIceCream
    public boolean isPackageStopped(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return packageManager.isPackageStopped(str);
    }

    @Override // com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorVanillaIceCream
    public <T> T parseAndroidManifest(PackageManager packageManager, File file, Function<XmlResourceParser, T> function) throws IOException {
        return (T) packageManager.parseAndroidManifest(file, function);
    }
}
