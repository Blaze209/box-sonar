package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class ContentProviderCallEvent extends BaseEvent {
    public ContentProviderCallEvent(String str) {
        if (str == null) {
            throw new NullPointerException("contentUri is marked non-null but is null");
        }
        types(TelemetryEventStrings.EventType.CONTENT_PROVIDER_EVENT);
        names(TelemetryEventStrings.Event.CONTENT_PROVIDER_CALL_EVENT);
        put(TelemetryEventStrings.Key.CONTENT_PROVIDER_URI, str);
    }
}
