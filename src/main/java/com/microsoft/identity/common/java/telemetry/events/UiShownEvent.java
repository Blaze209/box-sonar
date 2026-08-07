package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class UiShownEvent extends BaseEvent {
    public UiShownEvent() {
        names(TelemetryEventStrings.Event.UI_SHOWN_EVENT);
        types(TelemetryEventStrings.EventType.UI_EVENT);
    }

    public UiShownEvent putVisible(String str) {
        put(TelemetryEventStrings.Key.UI_VISIBLE, str);
        return this;
    }
}
