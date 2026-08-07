package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class BrokerEvent extends BaseEvent {
    public BrokerEvent(String str) {
        types(TelemetryEventStrings.EventType.BROKER_EVENT);
        names(str);
    }

    public BrokerEvent() {
        this(null);
    }

    public BrokerEvent putIPCStrategy(String str) {
        if (str == null) {
            throw new NullPointerException("ipcStrategy is marked non-null but is null");
        }
        put(TelemetryEventStrings.Key.IPC_STRATEGY, str);
        return this;
    }
}
