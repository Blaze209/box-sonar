package com.microsoft.identity.common.java.telemetry.adapter;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.telemetry.observers.ITelemetryAggregatedObserver;
import com.microsoft.identity.common.java.telemetry.rules.TelemetryAggregationRules;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class TelemetryAggregationAdapter implements ITelemetryAdapter<List<Map<String, String>>> {
    private static final String END = "end";
    private static final String START = "start";
    private ITelemetryAggregatedObserver mObserver;

    public TelemetryAggregationAdapter(ITelemetryAggregatedObserver iTelemetryAggregatedObserver) {
        if (iTelemetryAggregatedObserver == null) {
            throw new NullPointerException("observer is marked non-null but is null");
        }
        this.mObserver = iTelemetryAggregatedObserver;
    }

    public ITelemetryAggregatedObserver getObserver() {
        return this.mObserver;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.identity.common.java.telemetry.adapter.ITelemetryAdapter
    public void process(List<Map<String, String>> list) {
        if (list == null) {
            throw new NullPointerException("rawData is marked non-null but is null");
        }
        this.mObserver.onReceived(aggregateEvent(list));
    }

    protected Map<String, String> aggregateEvent(List<Map<String, String>> list) {
        if (list == null) {
            throw new NullPointerException("rawData is marked non-null but is null");
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (Map<String, String> map3 : list) {
            String str = map3.get(TelemetryEventStrings.Key.EVENT_NAME);
            String str2 = map3.get(TelemetryEventStrings.Key.EVENT_TYPE);
            if (StringUtil.isNullOrEmpty(str)) {
                map.putAll(applyAggregationRule(map3));
            } else {
                if (str.contains("start")) {
                    String str3 = str2 + "_count";
                    String str4 = map.get(str3);
                    if (str4 == null) {
                        str4 = "0";
                    }
                    map.put(str3, String.valueOf(Integer.parseInt(str4) + 1));
                }
                String str5 = map3.containsKey(TelemetryEventStrings.Key.IS_SUCCESSFUL) ? map3.get(TelemetryEventStrings.Key.IS_SUCCESSFUL) : "false";
                map.put(str2 + TelemetryEventStrings.Key.IS_SUCCESSFUL, StringUtil.isNullOrEmpty(str5) ? "false" : str5);
                trackEventResponseTime(map2, map3);
                map.putAll(applyAggregationRule(map3));
            }
        }
        calculateEventResponseTime(map2, map);
        return map;
    }

    protected Map<String, String> applyAggregationRule(Map<String, String> map) {
        if (map == null) {
            throw new NullPointerException("properties is marked non-null but is null");
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!StringUtil.isNullOrEmpty(entry.getValue()) && !TelemetryAggregationRules.getInstance().isRedundant(entry.getKey())) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

    private void trackEventResponseTime(Map<String, String> map, Map<String, String> map2) {
        if (map == null) {
            throw new NullPointerException("responseTimeMap is marked non-null but is null");
        }
        if (map2 == null) {
            throw new NullPointerException("event is marked non-null but is null");
        }
        String str = map2.get(TelemetryEventStrings.Key.EVENT_NAME);
        String str2 = map2.get(TelemetryEventStrings.Key.EVENT_TYPE);
        if (str != null && str.contains("start")) {
            map.put(str2 + "_start_time", map2.get(TelemetryEventStrings.Key.OCCUR_TIME));
        }
        if (str == null || !str.contains("end")) {
            return;
        }
        map.put(str2 + "_end_time", map2.get(TelemetryEventStrings.Key.OCCUR_TIME));
    }

    private void calculateEventResponseTime(Map<String, String> map, Map<String, String> map2) {
        String str;
        if (map == null) {
            throw new NullPointerException("responseTimeMap is marked non-null but is null");
        }
        if (map2 == null) {
            throw new NullPointerException("aggregatedData is marked non-null but is null");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.contains("start") && (str = map.get(key.replace("start", "end"))) != null) {
                map2.put(key.replace("start", "response"), String.valueOf(Long.parseLong(str) - Long.parseLong(entry.getValue())));
            }
        }
    }
}
