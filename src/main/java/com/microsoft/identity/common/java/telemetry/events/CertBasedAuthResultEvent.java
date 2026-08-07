package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class CertBasedAuthResultEvent extends BaseEvent {
    public CertBasedAuthResultEvent(String str) {
        names(str);
        types(TelemetryEventStrings.EventType.CERT_BASED_AUTH_EVENT);
    }

    public CertBasedAuthResultEvent putResponseCode(String str) {
        put(TelemetryEventStrings.Key.RESULT_CODE, str);
        return this;
    }
}
