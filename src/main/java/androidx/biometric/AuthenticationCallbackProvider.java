package androidx.biometric;

import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

/* JADX INFO: loaded from: classes.dex */
class AuthenticationCallbackProvider {
    private android.hardware.biometrics.BiometricPrompt.AuthenticationCallback mBiometricCallback;
    private FingerprintManagerCompat.AuthenticationCallback mFingerprintCallback;
    final Listener mListener;

    static class Listener {
        void onError(int i, CharSequence charSequence) {
        }

        void onFailure() {
        }

        void onHelp(CharSequence charSequence) {
        }

        void onSuccess(BiometricPrompt.AuthenticationResult authenticationResult) {
        }

        Listener() {
        }
    }

    AuthenticationCallbackProvider(Listener listener) {
        this.mListener = listener;
    }

    android.hardware.biometrics.BiometricPrompt.AuthenticationCallback getBiometricCallback() {
        if (this.mBiometricCallback == null) {
            this.mBiometricCallback = Api28Impl.createCallback(this.mListener);
        }
        return this.mBiometricCallback;
    }

    FingerprintManagerCompat.AuthenticationCallback getFingerprintCallback() {
        if (this.mFingerprintCallback == null) {
            this.mFingerprintCallback = new FingerprintManagerCompat.AuthenticationCallback() { // from class: androidx.biometric.AuthenticationCallbackProvider.1
                @Override // androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                public void onAuthenticationError(int i, CharSequence charSequence) {
                    AuthenticationCallbackProvider.this.mListener.onError(i, charSequence);
                }

                @Override // androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                public void onAuthenticationHelp(int i, CharSequence charSequence) {
                    AuthenticationCallbackProvider.this.mListener.onHelp(charSequence);
                }

                @Override // androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult authenticationResult) {
                    AuthenticationCallbackProvider.this.mListener.onSuccess(new BiometricPrompt.AuthenticationResult(authenticationResult != null ? CryptoObjectUtils.unwrapFromFingerprintManager(authenticationResult.getCryptoObject()) : null, 2));
                }

                @Override // androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                public void onAuthenticationFailed() {
                    AuthenticationCallbackProvider.this.mListener.onFailure();
                }
            };
        }
        return this.mFingerprintCallback;
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static int getAuthenticationType(android.hardware.biometrics.BiometricPrompt.AuthenticationResult authenticationResult) {
            return authenticationResult.getAuthenticationType();
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static android.hardware.biometrics.BiometricPrompt.AuthenticationCallback createCallback(final Listener listener) {
            return new android.hardware.biometrics.BiometricPrompt.AuthenticationCallback() { // from class: androidx.biometric.AuthenticationCallbackProvider.Api28Impl.1
                @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
                public void onAuthenticationHelp(int i, CharSequence charSequence) {
                }

                @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
                public void onAuthenticationError(int i, CharSequence charSequence) {
                    listener.onError(i, charSequence);
                }

                @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
                public void onAuthenticationSucceeded(android.hardware.biometrics.BiometricPrompt.AuthenticationResult authenticationResult) {
                    listener.onSuccess(new BiometricPrompt.AuthenticationResult(authenticationResult != null ? CryptoObjectUtils.unwrapFromBiometricPrompt(authenticationResult.getCryptoObject()) : null, authenticationResult != null ? Api30Impl.getAuthenticationType(authenticationResult) : -1));
                }

                @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
                public void onAuthenticationFailed() {
                    listener.onFailure();
                }
            };
        }
    }
}
