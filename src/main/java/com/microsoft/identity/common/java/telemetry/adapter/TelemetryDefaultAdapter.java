package com.microsoft.identity.common.java.telemetry.adapter;

import com.microsoft.identity.common.java.telemetry.observers.ITelemetryDefaultObserver;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public final class TelemetryDefaultAdapter implements ITelemetryAdapter<List<Map<String, String>>> {
    private ITelemetryDefaultObserver mObserver;

    public TelemetryDefaultAdapter(ITelemetryDefaultObserver iTelemetryDefaultObserver) {
        if (iTelemetryDefaultObserver == null) {
            throw new NullPointerException("observer is marked non-null but is null");
        }
        this.mObserver = iTelemetryDefaultObserver;
    }

    public ITelemetryDefaultObserver getObserver() {
        return this.mObserver;
    }

    @Override // com.microsoft.identity.common.java.telemetry.adapter.ITelemetryAdapter
    public void process(List<Map<String, String>> list) {
        if (list == null) {
            throw new NullPointerException("rawData is marked non-null but is null");
        }
        ITelemetryDefaultObserver iTelemetryDefaultObserver = this.mObserver;
        if (iTelemetryDefaultObserver == null) {
            return;
        }
        iTelemetryDefaultObserver.onReceived(list);
    }
}
