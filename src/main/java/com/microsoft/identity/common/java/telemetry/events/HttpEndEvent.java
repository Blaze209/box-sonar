package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class HttpEndEvent extends BaseEvent {
    public HttpEndEvent() {
        names(TelemetryEventStrings.Event.HTTP_END_EVENT);
        types(TelemetryEventStrings.EventType.HTTP_EVENT);
    }

    public HttpEndEvent putStatusCode(int i) {
        put(TelemetryEventStrings.Key.HTTP_RESPONSE_CODE, String.valueOf(i));
        return this;
    }
}
