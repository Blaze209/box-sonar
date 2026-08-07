package com.microsoft.identity.common.java.flighting;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public interface IFlightsProvider {
    boolean getBooleanValue(IFlightConfig iFlightConfig);

    double getDoubleValue(IFlightConfig iFlightConfig);

    int getIntValue(IFlightConfig iFlightConfig);

    JSONObject getJsonValue(IFlightConfig iFlightConfig);

    String getStringValue(IFlightConfig iFlightConfig);

    boolean isFlightEnabled(IFlightConfig iFlightConfig);
}
