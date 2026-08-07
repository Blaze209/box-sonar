package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class PivProviderStatusEvent extends BaseEvent {
    public PivProviderStatusEvent() {
        names(TelemetryEventStrings.Event.PIV_PROVIDER_STATUS_EVENT);
        types(TelemetryEventStrings.EventType.YUBIKEY_EVENT);
    }

    public PivProviderStatusEvent putIsExistingPivProviderPresent(boolean z) {
        put(TelemetryEventStrings.Key.IS_EXISTING_PIVPROVIDER_PRESENT, String.valueOf(z));
        return this;
    }

    public PivProviderStatusEvent putPivProviderRemoved(boolean z) {
        put(TelemetryEventStrings.Key.PIVPROVIDER_REMOVED, String.valueOf(z));
        return this;
    }
}
