package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.telemetry.events.BaseEvent;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class BrokerStartEvent extends BaseEvent {
    public BrokerStartEvent() {
        names(TelemetryEventStrings.Event.BROKER_START_EVENT);
        types(TelemetryEventStrings.EventType.BROKER_EVENT);
    }

    public BrokerStartEvent putAction(String str) {
        put(TelemetryEventStrings.Key.BROKER_ACTION, str);
        return this;
    }

    public BrokerStartEvent putStrategy(String str) {
        put(TelemetryEventStrings.Key.BROKER_STRATEGY, str);
        return this;
    }
}
