package com.microsoft.intune.mam.client.content.pm;

import android.content.pm.ArchivedPackageInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import java.io.File;
import java.io.IOException;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public interface PackageManagementBehaviorVanillaIceCream extends PackageManagementBehaviorTiramisu {
    ArchivedPackageInfo getArchivedPackage(PackageManager packageManager, String str);

    boolean isAppArchivable(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException;

    boolean isPackageStopped(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException;

    <T> T parseAndroidManifest(PackageManager packageManager, File file, Function<XmlResourceParser, T> function) throws IOException;
}
