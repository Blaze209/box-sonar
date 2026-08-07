package com.microsoft.identity.common.internal.platform;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.platform.AbstractDeviceMetadata;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidDeviceMetadata extends AbstractDeviceMetadata {
    private static final String ANDROID_DEVICE_TYPE = "Android";
    private static final String DEVICE_TYPE = "DeviceType";
    private static final String MOBILE_DEVICE = "mobileDevice";
    private static final String TAG = "AndroidDeviceMetadata";
    private static final String UNKNOWN_DEVICE = "unknown";

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    public String getDeviceType() {
        return "Android";
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    public String getCpu() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null && strArr.length > 0) {
            return strArr[0];
        }
        return "UNKNOWN";
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    public String getOsForEsts() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    public String getOsForMats() {
        return getAndroidReleaseOs();
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    public String getOsForDrs() {
        return getAndroidReleaseOs();
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    public String getAndroidReleaseOs() {
        return Build.VERSION.RELEASE;
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    public String getDeviceModel() {
        return Build.MODEL;
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    public String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getAndroidDeviceTypeFromMetadata(Context context) {
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        String str = TAG + " :getDeviceType";
        try {
            String string = MAMPackageManagement.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData.getString(DEVICE_TYPE, MOBILE_DEVICE);
            Logger.verbose(str, "Setting the deviceType as " + string);
            return string;
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.warn(str, "Unable to find the app's package name from PackageManager.");
            return "unknown";
        }
    }
}
