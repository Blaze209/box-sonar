package com.box.android.base.presentation.presenters;

import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;
import com.box.android.base.R;
import com.box.android.base.presentation.BoxPresentationUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes9.dex */
public class BiometricsPresenter {
    private FragmentActivity mContext;

    public BiometricsPresenter(FragmentActivity fragmentActivity) {
        this.mContext = fragmentActivity;
    }

    public BiometricPrompt.PromptInfo.Builder createBuilder() {
        BiometricPrompt.PromptInfo.Builder builder = new BiometricPrompt.PromptInfo.Builder();
        builder.setTitle(this.mContext.getString(R.string.sign_in)).setConfirmationRequired(true).setNegativeButtonText(this.mContext.getString(R.string.fingerprint_use_passcode)).setDeviceCredentialAllowed(false);
        return builder;
    }

    public void displayError(int i, CharSequence charSequence) {
        BoxPresentationUtils.displayToast(R.string.Error_unable_biometrics_failed_please_enter_passcode_manually, this.mContext, new String[0]);
    }

    public void showPrompt(BiometricPrompt.AuthenticationCallback authenticationCallback, Executor executor, BiometricPrompt.CryptoObject cryptoObject) {
        new BiometricPrompt(this.mContext, executor, authenticationCallback).authenticate(createBuilder().build(), cryptoObject);
    }
}
