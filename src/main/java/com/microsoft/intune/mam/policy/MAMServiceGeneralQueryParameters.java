package com.microsoft.intune.mam.policy;

import android.content.Context;
import android.os.Build;
import com.microsoft.intune.mam.client.app.AppUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MAMServiceGeneralQueryParameters implements MAMServiceQueryParameters {
    private static final String ANDROIDMAMSDKVERSION_NAME = "AndroidMamSdkVersion";
    private static final String APPID_NAME = "AppId";
    private static final String APPVERSION_NAME = "AppVersion";
    private static final String DEVICEMANUFACTURER_NAME = "DeviceManufacturer";
    private static final String DEVICEMODEL_NAME = "DeviceModel";
    private static final String DEVICENAME_NAME = "DeviceName";
    private static final String DEVICETYPE_NAME = "DeviceType";
    private static final String MDMDEVICEHEALTH_NAME = "DeviceHealth";
    private static final String OSPATCHVERSION_NAME = "AndroidPatchVersion";
    private static final String OSVERSION_NAME = "OsVersion";
    private static final String OS_NAME = "Os";
    private static final String PLATFORM = "android";
    private static final String SDKVERSION_NAME = "SdkVersion";
    private Map<String, String> mQueryParameters;

    public MAMServiceGeneralQueryParameters() {
        this.mQueryParameters = new HashMap();
    }

    public MAMServiceGeneralQueryParameters(Context context, String str) {
        this();
        populateFromSystemProperties();
        setPackageName(str);
        setPackageVersion(AppUtils.getPackageVersion(context, str));
        setMAMSDKVersion(MAMServiceReleaseVersion.versionString());
    }

    public MAMServiceGeneralQueryParameters populateFromSystemProperties() {
        setOSName();
        setOSVersion(Build.VERSION.RELEASE);
        setOSPatchVersion(getOSPatchVersion());
        setDeviceType(Build.MODEL);
        setDeviceName(getDeviceName());
        setDeviceManufacturer(Build.MANUFACTURER);
        setDeviceModel(Build.MODEL);
        return this;
    }

    protected MAMServiceGeneralQueryParameters setPackageName(String str) {
        set(APPID_NAME, str);
        return this;
    }

    protected MAMServiceGeneralQueryParameters setPackageVersion(String str) {
        set(APPVERSION_NAME, str);
        return this;
    }

    protected MAMServiceGeneralQueryParameters setMAMSDKVersion(String str) {
        set(SDKVERSION_NAME, str);
        return this;
    }

    public MAMServiceGeneralQueryParameters setAndroidMamSDKVersion(String str) {
        set(ANDROIDMAMSDKVERSION_NAME, str);
        return this;
    }

    protected MAMServiceGeneralQueryParameters setOSName() {
        set(OS_NAME, "android");
        return this;
    }

    protected MAMServiceGeneralQueryParameters setOSVersion(String str) {
        set(OSVERSION_NAME, str);
        return this;
    }

    protected MAMServiceGeneralQueryParameters setOSPatchVersion(String str) {
        set(OSPATCHVERSION_NAME, str);
        return this;
    }

    protected MAMServiceGeneralQueryParameters setDeviceType(String str) {
        set(DEVICETYPE_NAME, str);
        return this;
    }

    protected MAMServiceGeneralQueryParameters setDeviceName(String str) {
        set(DEVICENAME_NAME, str);
        return this;
    }

    protected MAMServiceGeneralQueryParameters setDeviceManufacturer(String str) {
        set(DEVICEMANUFACTURER_NAME, str);
        return this;
    }

    protected MAMServiceGeneralQueryParameters setDeviceModel(String str) {
        set(DEVICEMODEL_NAME, str);
        return this;
    }

    protected MAMServiceGeneralQueryParameters setDeviceHealth(boolean z) {
        set(MDMDEVICEHEALTH_NAME, z ? "1" : "0");
        return this;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceQueryParameters
    public Map<String, String> get() {
        return this.mQueryParameters;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceQueryParameters
    public final void set(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return;
        }
        this.mQueryParameters.put(str, str2);
    }

    private String getOSPatchVersion() {
        return Build.VERSION.SECURITY_PATCH;
    }

    private String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2 == null) {
            return str != null ? str : "";
        }
        return (str == null || str2.startsWith(str)) ? str2 : str + " " + str2;
    }
}
