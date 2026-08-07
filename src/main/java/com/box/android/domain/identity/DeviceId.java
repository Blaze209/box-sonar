package com.box.android.domain.identity;

import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.UUID;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes11.dex */
public class DeviceId {
    private static final String CONCAT_DELIMITER = "___boxandroid___";
    private static final int HASH_ITERATIONS = 10;
    public static final String[] INVALID_ANDROID_IDS = {"0123456789ABCDEF", "9774d56d682e549c"};
    private String mAndroidId;
    private String mDeviceId;
    private String mInstallationId;
    private final IDeviceIdStorage mStorage;

    @Inject
    public DeviceId(IDeviceIdStorage iDeviceIdStorage) {
        this.mStorage = iDeviceIdStorage;
    }

    public synchronized String getDeviceId() {
        boolean zUpdateCachedInstallationId = updateCachedInstallationId();
        boolean zUpdateCachedAndroidId = updateCachedAndroidId();
        if (this.mDeviceId == null || zUpdateCachedInstallationId || zUpdateCachedAndroidId) {
            this.mDeviceId = calculateDeviceId(this.mAndroidId, this.mInstallationId);
        }
        return this.mDeviceId;
    }

    private boolean updateCachedAndroidId() {
        String androidId = this.mStorage.getAndroidId();
        String str = this.mAndroidId;
        boolean z = true;
        boolean z2 = (str == null || str.equals(androidId)) ? false : true;
        if (isValidAndroidId(androidId)) {
            z = z2;
        } else {
            androidId = generateRandomAndroidId();
            this.mStorage.setAndroidId(androidId);
        }
        this.mAndroidId = androidId;
        return z;
    }

    private boolean updateCachedInstallationId() {
        String strGenerateInstallationId;
        try {
            strGenerateInstallationId = this.mStorage.getInstallationId();
        } catch (Exception e) {
            BoxLogUtils.logException("updateCachedInstallationId fail", "Failed to read installation id from shared pref or external storage", e);
            strGenerateInstallationId = null;
        }
        String str = this.mInstallationId;
        boolean z = true;
        boolean z2 = (str == null || str.equals(strGenerateInstallationId)) ? false : true;
        if (isValidInstallationId(strGenerateInstallationId)) {
            z = z2;
        } else {
            strGenerateInstallationId = generateInstallationId();
            try {
                this.mStorage.setInstallationId(strGenerateInstallationId);
            } catch (Exception e2) {
                BoxLogUtils.logException("updateCachedInstallationId fail", "Failed to save installation id to shared pref or external storage", e2);
            }
        }
        this.mInstallationId = strGenerateInstallationId;
        return z;
    }

    private boolean isValidInstallationId(String str) {
        return !StringUtils.isEmpty(str) && str.length() == 36 && str.matches("[\\dA-Fa-f\\-]+");
    }

    private boolean isValidAndroidId(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        for (String str2 : INVALID_ANDROID_IDS) {
            if (str.equals(str2)) {
                return false;
            }
        }
        return true;
    }

    private String generateInstallationId() {
        return UUID.randomUUID().toString();
    }

    private String generateRandomAndroidId() {
        return UUID.randomUUID().toString();
    }

    private String calculateDeviceId(String str, String str2) {
        return Crypto.sha256(str + CONCAT_DELIMITER + str2, 10);
    }
}
