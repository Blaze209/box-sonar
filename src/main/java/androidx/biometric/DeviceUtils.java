package androidx.biometric;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
class DeviceUtils {
    static boolean canAssumeStrongBiometrics(Context context, String str) {
        return false;
    }

    static boolean shouldDelayShowingPrompt(Context context, String str) {
        return false;
    }

    static boolean shouldHideFingerprintDialog(Context context, String str) {
        return false;
    }

    static boolean shouldUseFingerprintForCrypto(Context context, String str, String str2) {
        return false;
    }

    private DeviceUtils() {
    }

    private static boolean isVendorInList(Context context, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i)) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isModelInPrefixList(Context context, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i)) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isModelInList(Context context, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i)) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
