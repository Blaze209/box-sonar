package androidx.biometric;

/* JADX INFO: loaded from: classes.dex */
class AuthenticatorUtils {
    private static final int BIOMETRIC_CLASS_MASK = 32767;

    static boolean isDeviceCredentialAllowed(int i) {
        return (i & 32768) != 0;
    }

    static boolean isSomeBiometricAllowed(int i) {
        return (i & 32767) != 0;
    }

    static boolean isSupportedCombination(int i) {
        return i == 15 || i == 255 || i == 32768 || i == 32783 || i == 33023 || i == 0;
    }

    static boolean isWeakBiometricAllowed(int i) {
        return (i & 255) == 255;
    }

    private AuthenticatorUtils() {
    }

    static String convertToString(int i) {
        if (i == 15) {
            return "BIOMETRIC_STRONG";
        }
        if (i == 255) {
            return "BIOMETRIC_WEAK";
        }
        if (i == 32768) {
            return "DEVICE_CREDENTIAL";
        }
        if (i == 32783) {
            return "BIOMETRIC_STRONG | DEVICE_CREDENTIAL";
        }
        if (i == 33023) {
            return "BIOMETRIC_WEAK | DEVICE_CREDENTIAL";
        }
        return String.valueOf(i);
    }

    static int getConsolidatedAuthenticators(BiometricPrompt.PromptInfo promptInfo, BiometricPrompt.CryptoObject cryptoObject) {
        if (promptInfo.getAllowedAuthenticators() != 0) {
            return promptInfo.getAllowedAuthenticators();
        }
        int i = cryptoObject != null ? 15 : 255;
        return promptInfo.isDeviceCredentialAllowed() ? 32768 | i : i;
    }
}
