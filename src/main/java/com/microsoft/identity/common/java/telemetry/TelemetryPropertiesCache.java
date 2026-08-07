package com.microsoft.identity.common.java.telemetry;

import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class TelemetryPropertiesCache {
    private static final String DEVICE_ID_GUID = "device_id_guid";
    private final INameValueStorage<String> mStorage;

    public TelemetryPropertiesCache(INameValueStorage<String> iNameValueStorage) {
        if (iNameValueStorage == null) {
            throw new NullPointerException("storage is marked non-null but is null");
        }
        this.mStorage = iNameValueStorage;
    }

    synchronized String getOrCreateRandomStableDeviceId() {
        String string;
        string = this.mStorage.get(DEVICE_ID_GUID);
        if (StringUtil.isNullOrEmpty(string)) {
            string = UUID.randomUUID().toString();
            this.mStorage.put(DEVICE_ID_GUID, string);
        }
        return string;
    }
}
