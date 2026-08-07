package com.pspdfkit.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.pspdfkit.utils.PackageManagerExtensions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class hw {
    public final Context a;

    public hw(Context context) {
        context.getClass();
        this.a = context.getApplicationContext();
    }

    public final boolean a(String str) {
        try {
            PackageManager packageManager = this.a.getPackageManager();
            packageManager.getClass();
            String packageName = this.a.getPackageName();
            packageName.getClass();
            String[] strArr = PackageManagerExtensions.getSupportPackageInfo(packageManager, packageName, 4096).requestedPermissions;
            if (strArr == null) {
                return false;
            }
            for (String str2 : strArr) {
                if (Intrinsics.areEqual(str2, str)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
