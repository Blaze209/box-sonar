package com.google.android.play.integrity.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class ag {
    private static final q a = new q("PhoneskyVerificationUtils");

    public static boolean a(Context context) {
        try {
            if (MAMPackageManagement.getApplicationInfo(context.getPackageManager(), "com.android.vending", 0).enabled) {
                Signature[] signatureArr = MAMPackageManagement.getPackageInfo(context.getPackageManager(), "com.android.vending", 64).signatures;
                if (signatureArr == null || (signatureArr.length) == 0) {
                    a.d("Phonesky package is not signed -- possibly self-built package. Could not verify.", new Object[0]);
                } else {
                    for (Signature signature : signatureArr) {
                        String strA = af.a(signature.toByteArray());
                        if ("8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(strA)) {
                            return true;
                        }
                        if ((Build.TAGS.contains("dev-keys") || Build.TAGS.contains("test-keys")) && "GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(strA)) {
                            return true;
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
