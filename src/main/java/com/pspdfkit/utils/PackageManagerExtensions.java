package com.pspdfkit.utils;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\u00022\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"getSupportPackageInfo", "Landroid/content/pm/PackageInfo;", "Landroid/content/pm/PackageManager;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "flags", "", "getMetaData", "Landroid/os/Bundle;", "queryIntentActivities", "", "Landroid/content/pm/ResolveInfo;", "fileIntent", "Landroid/content/Intent;", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PackageManagerExtensions {
    public static final Bundle getMetaData(PackageManager packageManager, String str) {
        packageManager.getClass();
        str.getClass();
        return Build.VERSION.SDK_INT >= 33 ? MAMPackageManagement.getApplicationInfo(packageManager, str, PackageManager.ApplicationInfoFlags.of(128L)).metaData : MAMPackageManagement.getApplicationInfo(packageManager, str, 128).metaData;
    }

    public static final PackageInfo getSupportPackageInfo(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
        packageManager.getClass();
        str.getClass();
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = MAMPackageManagement.getPackageInfo(packageManager, str, PackageManager.PackageInfoFlags.of(i));
            packageInfo.getClass();
            return packageInfo;
        }
        PackageInfo packageInfo2 = MAMPackageManagement.getPackageInfo(packageManager, str, i);
        packageInfo2.getClass();
        return packageInfo2;
    }

    public static final List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent) {
        packageManager.getClass();
        intent.getClass();
        if (Build.VERSION.SDK_INT >= 33) {
            List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(packageManager, intent, PackageManager.ResolveInfoFlags.of(0L));
            listQueryIntentActivities.getClass();
            return listQueryIntentActivities;
        }
        List<ResolveInfo> listQueryIntentActivities2 = MAMPackageManagement.queryIntentActivities(packageManager, intent, 0);
        listQueryIntentActivities2.getClass();
        return listQueryIntentActivities2;
    }
}
