package com.splunk.rum;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* JADX INFO: loaded from: classes3.dex */
enum NetworkState {
    NO_NETWORK_AVAILABLE(SemanticAttributes.NetHostConnectionTypeValues.UNAVAILABLE),
    TRANSPORT_CELLULAR(SemanticAttributes.NetHostConnectionTypeValues.CELL),
    TRANSPORT_WIFI(SemanticAttributes.NetHostConnectionTypeValues.WIFI),
    TRANSPORT_UNKNOWN("unknown"),
    TRANSPORT_VPN("vpn");

    private final String humanName;

    NetworkState(String str) {
        this.humanName = str;
    }

    public String getHumanName() {
        return this.humanName;
    }
}
