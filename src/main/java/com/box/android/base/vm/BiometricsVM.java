package com.box.android.base.vm;

import android.app.Application;
import android.security.keystore.KeyGenParameterSpec;
import androidx.biometric.BiometricPrompt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.box.android.base.presentation.presenters.BiometricsPresenter;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.ProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.concurrent.ThreadPoolExecutor;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.inject.Inject;
import javax.inject.Named;

/* JADX INFO: loaded from: classes9.dex */
public class BiometricsVM extends AndroidViewModel {
    private static final String CREATE_CIPHER_STEP = "create cipher - ";
    public static final String FINGERPRINT_ENABLED_KEY = "fingerprint_enabled";
    private static final String INIT_CIPHER_STEP = "init cipher - ";
    private static final String KEY_DEFAULT_NAME = "defaultKey";
    private static final String KEY_SECRET = "KeyValidation";
    private MutableLiveData<BiometricResponse> mBiometricResponse;
    private Cipher mCipher;
    private final ThreadPoolExecutor mExecutor;
    private KeyStore mKeyStore;
    private final IUserContextManager mUserContextManager;

    @Inject
    public BiometricsVM(Application application, IUserContextManager iUserContextManager, @Named("biometrics-executor") ThreadPoolExecutor threadPoolExecutor) {
        super(application);
        this.mUserContextManager = iUserContextManager;
        this.mExecutor = threadPoolExecutor;
        this.mBiometricResponse = new MutableLiveData<>();
    }

    public static void setBiometricsEnabled(IUserContextManager iUserContextManager, boolean z) {
        iUserContextManager.getUserSharedPrefs().edit().putBoolean(FINGERPRINT_ENABLED_KEY, z).commit();
    }

    public static boolean isBiometricsEnabled(IUserContextManager iUserContextManager) {
        return iUserContextManager.getUserSharedPrefs().getBoolean(FINGERPRINT_ENABLED_KEY, false);
    }

    private boolean initCipher(Cipher cipher, String str) {
        try {
            this.mKeyStore.load(null);
            cipher.init(1, (SecretKey) this.mKeyStore.getKey(str, null));
            return true;
        } catch (IOException | InvalidKeyException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_CREATE_CIPHER, INIT_CIPHER_STEP + e.getClass().getName());
            BoxLogUtils.logException(BoxAnalyticsParams.ACTION_CREATE_CIPHER, "Error initializing cipher", e);
            return false;
        }
    }

    public void checkBiometric(final BiometricsPresenter biometricsPresenter) {
        if (isBiometricsEnabled(this.mUserContextManager)) {
            this.mBiometricResponse.postValue(new BiometricResponse(true, null));
            if (!createCipherAndKey() || !initCipher(this.mCipher, KEY_DEFAULT_NAME)) {
                this.mBiometricResponse.postValue(new BiometricResponse(false, false));
                return;
            } else {
                biometricsPresenter.showPrompt(new BiometricPrompt.AuthenticationCallback() { // from class: com.box.android.base.vm.BiometricsVM.1
                    @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
                    public void onAuthenticationError(int i, CharSequence charSequence) {
                        super.onAuthenticationError(i, charSequence);
                        biometricsPresenter.displayError(i, charSequence);
                        String string = charSequence.toString();
                        BoxLogUtils.e("BiometricsError", string);
                        BoxAmplitudeAnalytics.createEventBuilder().setError("AuthenticationError ", string, Integer.toString(i)).logEvent(BoxAnalyticsParams.EVENT_BIOMETRIC_AUTHENTICATION_ERROR);
                    }

                    @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
                    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                        super.onAuthenticationSucceeded(authenticationResult);
                        BiometricsVM.this.reportResult(authenticationResult);
                    }
                }, this.mExecutor, new BiometricPrompt.CryptoObject(this.mCipher));
                return;
            }
        }
        this.mBiometricResponse.postValue(new BiometricResponse(false, null));
    }

    public LiveData<BiometricResponse> getHasPassedBiometrics() {
        return this.mBiometricResponse;
    }

    protected void reportResult(BiometricPrompt.AuthenticationResult authenticationResult) {
        this.mBiometricResponse.postValue(new BiometricResponse(true, Boolean.valueOf((authenticationResult == null || authenticationResult.getCryptoObject().getCipher() == null || !validateCipher(authenticationResult.getCryptoObject().getCipher())) ? false : true)));
        BoxAmplitudeAnalytics.createEventBuilder().setFlow("biometric").logEvent(BoxAnalyticsParams.EVENT_BIOMETRIC_AUTHENTICATION_SUCCEEDED);
    }

    private boolean validateCipher(Cipher cipher) {
        try {
            cipher.doFinal(KEY_SECRET.getBytes());
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_FINAL_CIPHER, "success");
            return true;
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            BoxLogUtils.logException(e);
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_FINAL_CIPHER, e.getClass().getName());
            BoxLogUtils.logException(BoxAnalyticsParams.ACTION_FINAL_CIPHER, "Error validating fingerprint encryption", e);
            return false;
        }
    }

    private boolean createCipherAndKey() {
        try {
            this.mKeyStore = KeyStore.getInstance("AndroidKeyStore");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            this.mCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            this.mKeyStore.load(null);
            keyGenerator.init(new KeyGenParameterSpec.Builder(KEY_DEFAULT_NAME, 3).setBlockModes("CBC").setUserAuthenticationRequired(true).setEncryptionPaddings("PKCS7Padding").build());
            keyGenerator.generateKey();
            return true;
        } catch (IOException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | ProviderException | CertificateException | NoSuchPaddingException e) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_EXPERIMENTS, BoxAnalyticsParams.ACTION_CREATE_CIPHER, CREATE_CIPHER_STEP + e.getClass().getName());
            BoxLogUtils.logException(BoxAnalyticsParams.ACTION_CREATE_CIPHER, "Error Creating cipher and key", e);
            return false;
        }
    }

    public static class BiometricResponse {
        private boolean mBiometricsEnabled;
        private Boolean mBiometricsPassed;

        public BiometricResponse(boolean z, Boolean bool) {
            this.mBiometricsEnabled = z;
            this.mBiometricsPassed = bool;
        }

        public boolean isEnabled() {
            return this.mBiometricsEnabled;
        }

        public Boolean getPassed() {
            return this.mBiometricsPassed;
        }

        public String toString() {
            return "enabled" + this.mBiometricsEnabled + " passed " + this.mBiometricsPassed;
        }
    }
}
