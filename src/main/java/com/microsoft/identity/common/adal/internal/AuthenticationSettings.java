package com.microsoft.identity.common.adal.internal;

import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.logging.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes14.dex */
public enum AuthenticationSettings {
    INSTANCE;

    private static final int DEFAULT_EXPIRATION_BUFFER = 300;
    private static final int DEFAULT_READ_CONNECT_TIMEOUT = 30000;
    private static final int SECRET_RAW_KEY_LENGTH = 32;
    private static final String TAG = "AuthenticationSettings";
    private String mActivityPackageName;
    private String mSharedPrefPackageName;
    private final Map<String, byte[]> mBrokerSecretKeys = new HashMap(2);
    private AtomicReference<byte[]> mSecretKeyData = new AtomicReference<>();
    private String mBrokerPackageName = "com.microsoft.windowsintune.companyportal";
    private String mBrokerSignature = "jPpMoaNvcxSLMX4yG4C3Gf86rtTqh33SqpuRKg4WOP+MnnpA52zZgvKLW76U4Cqqf68iaBk9W7k/jhciiSAtgQ==";
    private boolean mEnableHardwareAcceleration = true;
    private boolean mUseBroker = false;
    private int mExpirationBuffer = 300;
    private int mConnectTimeOut = 30000;
    private int mReadTimeOut = 30000;
    private boolean mIgnoreKeyLoaderNotFoundError = false;

    AuthenticationSettings() {
    }

    public byte[] getSecretKeyData() {
        return this.mSecretKeyData.get();
    }

    public Map<String, byte[]> getBrokerSecretKeys() {
        return Collections.unmodifiableMap(this.mBrokerSecretKeys);
    }

    public void setSecretKey(byte[] bArr) {
        String str = TAG + ":setSecretKey";
        if (bArr == null || bArr.length != 32) {
            throw new IllegalArgumentException("rawKey");
        }
        Logger.warn(str, "You're using setSecretKey in a version of android that supports keyStore functionality.  Consider not doing this, as it only exists for devices with an SDK lower than 18");
        this.mSecretKeyData.set(bArr);
    }

    public void setBrokerSecretKeys(Map<String, byte[]> map) {
        if (map == null) {
            throw new IllegalArgumentException("The passed in secret key map is null.");
        }
        if (map.size() != 2) {
            throw new IllegalArgumentException("Expect two keys are passed in.");
        }
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            if (entry.getValue() == null || entry.getValue().length != 32) {
                throw new IllegalArgumentException("Passed in raw key is null or length is not as expected. ");
            }
            this.mBrokerSecretKeys.put(entry.getKey(), entry.getValue());
        }
    }

    public void clearBrokerSecretKeys() {
        this.mBrokerSecretKeys.clear();
    }

    public void clearLegacySecretKeyConfiguration() {
        Logger.info(TAG + ":clearLegacySecretKeyConfiguration", "Clearing legacy secret key configuration.");
        this.mBrokerSecretKeys.clear();
        this.mSecretKeyData.set(null);
    }

    public void clearSecretKeysForTestCases() {
        clearLegacySecretKeyConfiguration();
    }

    public String getBrokerPackageName() {
        return this.mBrokerPackageName;
    }

    public void setBrokerPackageName(String str) {
        if (StringExtensions.isNullOrBlank(str)) {
            throw new IllegalArgumentException("packageName cannot be empty or null");
        }
        this.mBrokerPackageName = str;
    }

    public String getBrokerSignature() {
        return this.mBrokerSignature;
    }

    public void setBrokerSignature(String str) {
        if (StringExtensions.isNullOrBlank(str)) {
            throw new IllegalArgumentException("brokerSignature cannot be empty or null");
        }
        this.mBrokerSignature = str;
    }

    public String getActivityPackageName() {
        return this.mActivityPackageName;
    }

    public void setActivityPackageName(String str) {
        if (StringExtensions.isNullOrBlank(str)) {
            throw new IllegalArgumentException("activityPackageName cannot be empty or null");
        }
        this.mActivityPackageName = str;
    }

    @Deprecated
    public boolean getSkipBroker() {
        return !this.mUseBroker;
    }

    @Deprecated
    public void setSkipBroker(boolean z) {
        this.mUseBroker = !z;
    }

    public boolean getUseBroker() {
        return this.mUseBroker;
    }

    public void setUseBroker(boolean z) {
        this.mUseBroker = z;
    }

    public void setSharedPrefPackageName(String str) {
        this.mSharedPrefPackageName = str;
    }

    public String getSharedPrefPackageName() {
        return this.mSharedPrefPackageName;
    }

    public int getExpirationBuffer() {
        return this.mExpirationBuffer;
    }

    public void setExpirationBuffer(int i) {
        this.mExpirationBuffer = i;
    }

    public int getConnectTimeOut() {
        return this.mConnectTimeOut;
    }

    public void setConnectTimeOut(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid timeOutMillis");
        }
        this.mConnectTimeOut = i;
    }

    public int getReadTimeOut() {
        return this.mReadTimeOut;
    }

    public void setReadTimeOut(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid timeOutMillis");
        }
        this.mReadTimeOut = i;
    }

    public void setDisableWebViewHardwareAcceleration(boolean z) {
        this.mEnableHardwareAcceleration = z;
    }

    public boolean getDisableWebViewHardwareAcceleration() {
        return this.mEnableHardwareAcceleration;
    }

    public void setIgnoreKeyProviderNotFoundError(boolean z) {
        this.mIgnoreKeyLoaderNotFoundError = z;
    }

    public boolean shouldIgnoreKeyLoaderNotFoundError() {
        return this.mIgnoreKeyLoaderNotFoundError;
    }
}
