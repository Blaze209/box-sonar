package com.amplitude.api;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public enum AmplitudeServerZone {
    US,
    EU;

    private static Map<AmplitudeServerZone, String> amplitudeServerZoneEventLogApiMap = new HashMap<AmplitudeServerZone, String>() { // from class: com.amplitude.api.AmplitudeServerZone.1
        {
            put(AmplitudeServerZone.US, Constants.EVENT_LOG_URL);
            put(AmplitudeServerZone.EU, Constants.EVENT_LOG_EU_URL);
        }
    };
    private static Map<AmplitudeServerZone, String> amplitudeServerZoneDynamicConfigMap = new HashMap<AmplitudeServerZone, String>() { // from class: com.amplitude.api.AmplitudeServerZone.2
        {
            put(AmplitudeServerZone.US, Constants.DYNAMIC_CONFIG_URL);
            put(AmplitudeServerZone.EU, Constants.DYNAMIC_CONFIG_EU_URL);
        }
    };

    protected static String getEventLogApiForZone(AmplitudeServerZone amplitudeServerZone) {
        if (amplitudeServerZoneEventLogApiMap.containsKey(amplitudeServerZone)) {
            return amplitudeServerZoneEventLogApiMap.get(amplitudeServerZone);
        }
        return Constants.EVENT_LOG_URL;
    }

    protected static String getDynamicConfigApi(AmplitudeServerZone amplitudeServerZone) {
        if (amplitudeServerZoneDynamicConfigMap.containsKey(amplitudeServerZone)) {
            return amplitudeServerZoneDynamicConfigMap.get(amplitudeServerZone);
        }
        return Constants.DYNAMIC_CONFIG_URL;
    }

    public static AmplitudeServerZone getServerZone(String str) {
        AmplitudeServerZone amplitudeServerZone = US;
        str.hashCode();
        return !str.equals("EU") ? amplitudeServerZone : EU;
    }
}
