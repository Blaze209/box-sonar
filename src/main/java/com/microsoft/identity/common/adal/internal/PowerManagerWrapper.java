package com.microsoft.identity.common.adal.internal;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes14.dex */
public class PowerManagerWrapper {
    private static final String UNKNOWN_STATUS = "Unknown";
    private static PowerManagerWrapper sInstance;

    public static void setInstance(PowerManagerWrapper powerManagerWrapper) {
        sInstance = powerManagerWrapper;
    }

    public static synchronized PowerManagerWrapper getInstance() {
        if (sInstance == null) {
            sInstance = new PowerManagerWrapper();
        }
        return sInstance;
    }

    public boolean isDeviceIdleMode(Context context) {
        return ((PowerManager) context.getSystemService("power")).isDeviceIdleMode();
    }

    public String getDeviceIdleMode(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager.isDeviceIdleMode()) {
                return "Idle";
            }
            if (Build.VERSION.SDK_INT >= 33 && powerManager.isDeviceLightIdleMode()) {
                return "LightIdle";
            }
            return "";
        } catch (Exception unused) {
            return UNKNOWN_STATUS;
        }
    }

    public String getPowerOptimizationSettings(Context context) {
        try {
            if (((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName())) {
                return "OptOut";
            }
            return "";
        } catch (Exception unused) {
            return UNKNOWN_STATUS;
        }
    }

    public boolean isIgnoringBatteryOptimizations(Context context) {
        return ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
    }
}
