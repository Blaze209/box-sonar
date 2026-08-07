package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.telemetry.Properties;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class BaseEvent extends Properties {
    public BaseEvent() {
        occurs(Long.valueOf(System.currentTimeMillis()));
        correlationId(DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id"));
    }

    @Override // com.microsoft.identity.common.java.telemetry.Properties
    public Properties put(String str, String str2) {
        if (str != null) {
            return !StringUtil.isNullOrEmpty(str2) ? super.put(str, str2) : this;
        }
        throw new NullPointerException("key is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.telemetry.Properties
    public Properties remove(String str) {
        return super.remove(str);
    }

    @Override // com.microsoft.identity.common.java.telemetry.Properties
    public Properties remove(String str, String str2) {
        return super.remove(str, str2);
    }

    @Override // com.microsoft.identity.common.java.telemetry.Properties
    public Properties put(Properties properties) {
        return super.put(properties);
    }

    public BaseEvent names(String str) {
        put(TelemetryEventStrings.Key.EVENT_NAME, str);
        return this;
    }

    public BaseEvent types(String str) {
        if (str == null) {
            throw new NullPointerException("eventType is marked non-null but is null");
        }
        put(TelemetryEventStrings.Key.EVENT_TYPE, str);
        return this;
    }

    public BaseEvent occurs(Long l) {
        if (l == null) {
            put(TelemetryEventStrings.Key.OCCUR_TIME, String.valueOf(System.currentTimeMillis()));
            return this;
        }
        put(TelemetryEventStrings.Key.OCCUR_TIME, l.toString());
        return this;
    }

    public BaseEvent correlationId(String str) {
        if (!StringUtil.isNullOrEmpty(str)) {
            put("Microsoft.MSAL.correlation_id", str);
        }
        return this;
    }
}
