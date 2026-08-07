package com.microsoft.intune.mam.client.telemetry;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.client.telemetry.scrubbing.CustomerContentProperty;
import com.microsoft.intune.mam.client.telemetry.scrubbing.CustomerContentType;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AriaTelemetryEvent extends TelemetryEvent {
    private static final List<CustomerContentProperty> CUSTOMER_CONTENT_PROPERTIES;
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(AriaTelemetryEvent.class);
    String mEventName;
    private AriaBundle mEventProperties;
    Set<String> mKeys;

    static {
        ArrayList arrayList = new ArrayList();
        for (CommonKeys commonKeys : CommonKeys.values()) {
            if (!commonKeys.getCustomerContentTypes().isEmpty()) {
                arrayList.add(commonKeys);
            }
        }
        CUSTOMER_CONTENT_PROPERTIES = Collections.unmodifiableList(arrayList);
    }

    enum CommonKeys implements CustomerContentProperty {
        MAM_APP_ID(CustomerContentType.LOB_APP_PACKAGE_ID),
        MAM_APP_VERSION(new CustomerContentType[0]),
        DEVICE_BRAND(new CustomerContentType[0]),
        AAD_TENANT_ID(new CustomerContentType[0]),
        DEVICE_SDK_INT(new CustomerContentType[0]),
        DEVICE_SDK_PREVIEW_INT(new CustomerContentType[0]);

        private List<CustomerContentType> mCustomerContentTypes;

        @Override // com.microsoft.intune.mam.client.telemetry.scrubbing.CustomerContentProperty
        public Enum getKey() {
            return this;
        }

        CommonKeys(CustomerContentType... customerContentTypeArr) {
            this.mCustomerContentTypes = Arrays.asList(customerContentTypeArr);
        }

        @Override // com.microsoft.intune.mam.client.telemetry.scrubbing.CustomerContentProperty
        public List<CustomerContentType> getCustomerContentTypes() {
            return new ArrayList(this.mCustomerContentTypes);
        }
    }

    protected AriaTelemetryEvent(JSONObject jSONObject, String str, Enum[] enumArr) throws JSONException {
        this(str, enumArr, (PackageInfo) null);
        readDetailsFromJSON(jSONObject);
    }

    protected AriaTelemetryEvent(String str, Enum[] enumArr, String str2, PackageInfo packageInfo) {
        this(str, enumArr, packageInfo);
        if (packageInfo != null || str2 == null) {
            return;
        }
        setProperty(CommonKeys.MAM_APP_ID, str2);
    }

    protected AriaTelemetryEvent(String str, Enum[] enumArr, PackageInfo packageInfo) {
        this.mEventProperties = new AriaBundle();
        this.mKeys = new HashSet();
        this.mEventName = str;
        for (Enum r0 : enumArr) {
            this.mKeys.add(r0.toString());
        }
        for (CommonKeys commonKeys : CommonKeys.values()) {
            this.mKeys.add(commonKeys.toString());
        }
        if (packageInfo != null) {
            setProperty(CommonKeys.MAM_APP_ID, packageInfo.packageName);
            setProperty(CommonKeys.MAM_APP_VERSION, packageInfo.versionName);
        }
        setProperty(CommonKeys.DEVICE_BRAND, Build.BRAND);
        setProperty((Enum) CommonKeys.DEVICE_SDK_INT, Build.VERSION.SDK_INT);
        setProperty((Enum) CommonKeys.DEVICE_SDK_PREVIEW_INT, Build.VERSION.PREVIEW_SDK_INT);
    }

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryEvent
    protected void readDetailsFromJSON(JSONObject jSONObject) throws JSONException {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!this.mKeys.contains(next)) {
                LOGGER.warning("Unknown key encountered when reading from JSON: " + next, new Object[0]);
            } else {
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    this.mEventProperties.setProperty(next, (String) obj);
                } else if (obj instanceof Double) {
                    this.mEventProperties.setProperty(next, ((Double) obj).doubleValue());
                } else if (obj instanceof Long) {
                    this.mEventProperties.setProperty(next, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    this.mEventProperties.setProperty(next, ((Integer) obj).intValue());
                } else if (obj instanceof Boolean) {
                    this.mEventProperties.setProperty(next, ((Boolean) obj).booleanValue());
                } else {
                    LOGGER.error(MAMInterfaceError.TELEMETRY_INVALID_PROPERTY_TYPE, "Unsupported type encountered when reading from JSON.", new Object[0]);
                }
            }
        }
    }

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryEvent
    protected void writeDetailsToMap(Map<String, Object> map) {
        Bundle bundle = this.mEventProperties.getBundle();
        for (String str : bundle.keySet()) {
            map.put(str, bundle.get(str));
        }
    }

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryEvent
    public String getProperty(Enum r1) {
        return getBundle().getString(r1.toString());
    }

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryEvent
    public void setProperty(Enum r1, String str) {
        this.mEventProperties.setProperty(r1.toString(), str);
    }

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryEvent
    public void setProperty(Enum r1, double d) {
        this.mEventProperties.setProperty(r1.toString(), d);
    }

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryEvent
    public void setProperty(Enum r1, long j) {
        this.mEventProperties.setProperty(r1.toString(), j);
    }

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryEvent
    public void setProperty(Enum r1, boolean z) {
        this.mEventProperties.setProperty(r1.toString(), z);
    }

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryEvent
    public void setProperty(Enum r2, Map<String, String> map) {
        setProperty(r2, new JSONObject(map).toString());
    }

    public final String getEventName() {
        return this.mEventName;
    }

    public final Bundle getBundle() {
        return this.mEventProperties.getBundle();
    }

    private class AriaBundle {
        private Bundle mBundle;

        private AriaBundle() {
            this.mBundle = new Bundle();
        }

        void setProperty(String str, String str2) {
            this.mBundle.putString(str, str2);
        }

        void setProperty(String str, double d) {
            this.mBundle.putDouble(str, d);
        }

        void setProperty(String str, long j) {
            this.mBundle.putLong(str, j);
        }

        void setProperty(String str, boolean z) {
            this.mBundle.putBoolean(str, z);
        }

        Bundle getBundle() {
            return this.mBundle;
        }
    }

    public void setAADTenantID(String str) {
        setProperty(CommonKeys.AAD_TENANT_ID, str);
    }

    public boolean hasAADTenantID() {
        return getProperty(CommonKeys.AAD_TENANT_ID) != null;
    }

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryEvent
    public List<CustomerContentProperty> getCustomerContentProperties() {
        return new ArrayList(CUSTOMER_CONTENT_PROPERTIES);
    }
}
