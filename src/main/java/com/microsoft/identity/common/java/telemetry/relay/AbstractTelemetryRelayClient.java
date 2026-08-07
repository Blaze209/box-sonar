package com.microsoft.identity.common.java.telemetry.relay;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.telemetry.observers.ITelemetryObserver;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public abstract class AbstractTelemetryRelayClient<T> implements ITelemetryObserver<T> {
    private static final String TAG = "AbstractTelemetryRelayClient";
    private ITelemetryEventFilter<T> mEventFilter = null;

    public abstract void flush();

    public abstract void relayEvent(T t) throws TelemetryRelayException;

    @Override // com.microsoft.identity.common.java.telemetry.observers.ITelemetryObserver
    public void onReceived(T t) {
        String str = TAG + ":onReceived";
        ITelemetryEventFilter<T> iTelemetryEventFilter = this.mEventFilter;
        if (iTelemetryEventFilter != null) {
            t = iTelemetryEventFilter.apply(t);
        }
        if (t != null) {
            try {
                relayEvent(t);
            } catch (TelemetryRelayException e) {
                Logger.error(str, "Error relaying telemetry data", e);
            }
        }
    }

    public void setFilter(ITelemetryEventFilter<T> iTelemetryEventFilter) {
        this.mEventFilter = iTelemetryEventFilter;
    }
}
