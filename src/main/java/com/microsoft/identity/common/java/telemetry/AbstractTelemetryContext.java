package com.microsoft.identity.common.java.telemetry;

import java.util.TimeZone;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public abstract class AbstractTelemetryContext extends Properties {
    private TelemetryPropertiesCache mTelemetryPropsCache;

    protected AbstractTelemetryContext(TelemetryPropertiesCache telemetryPropertiesCache) {
        if (telemetryPropertiesCache == null) {
            throw new NullPointerException("telemetryPropertiesCache is marked non-null but is null");
        }
        this.mTelemetryPropsCache = telemetryPropertiesCache;
        put(TelemetryEventStrings.Device.ID, telemetryPropertiesCache.getOrCreateRandomStableDeviceId());
        put(TelemetryEventStrings.Device.TIMEZONE, TimeZone.getDefault().getID());
    }

    protected void addApplicationInfo(String str, String str2, String str3, String str4) {
        put(TelemetryEventStrings.App.NAME, str2);
        put(TelemetryEventStrings.App.PACKAGE, str);
        put(TelemetryEventStrings.App.VERSION, str3);
        put(TelemetryEventStrings.App.BUILD, str4);
    }

    protected void addDeviceInfo(String str, String str2, String str3) {
        put(TelemetryEventStrings.Device.MANUFACTURER, str);
        put(TelemetryEventStrings.Device.MODEL, str2);
        put(TelemetryEventStrings.Device.NAME, str3);
    }

    protected void addOsInfo(String str, String str2) {
        put(TelemetryEventStrings.Os.NAME, str);
        put(TelemetryEventStrings.Os.VERSION, str2);
    }
}
