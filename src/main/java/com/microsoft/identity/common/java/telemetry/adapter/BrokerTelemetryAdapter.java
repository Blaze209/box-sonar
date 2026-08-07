package com.microsoft.identity.common.java.telemetry.adapter;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.telemetry.observers.IBrokerTelemetryObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class BrokerTelemetryAdapter extends TelemetryAggregationAdapter {
    public BrokerTelemetryAdapter(IBrokerTelemetryObserver iBrokerTelemetryObserver) {
        super(iBrokerTelemetryObserver);
        if (iBrokerTelemetryObserver == null) {
            throw new NullPointerException("observer is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.telemetry.adapter.TelemetryAggregationAdapter, com.microsoft.identity.common.java.telemetry.adapter.ITelemetryAdapter
    public void process(List<Map<String, String>> list) {
        if (list == null) {
            throw new NullPointerException("rawData is marked non-null but is null");
        }
        Map<String, String> mapAggregateEvent = aggregateEvent(list);
        Iterator<Map<String, String>> it = countErrors(filterErrorEvents(list, mapAggregateEvent)).iterator();
        while (it.hasNext()) {
            getObserver().onReceived(it.next());
        }
        getObserver().onReceived(mapAggregateEvent);
    }

    private List<Map<String, String>> filterErrorEvents(List<Map<String, String>> list, Map<String, String> map) {
        if (list == null) {
            throw new NullPointerException("rawData is marked non-null but is null");
        }
        if (map == null) {
            throw new NullPointerException("aggregatedMap is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        for (Map<String, String> map2 : list) {
            if (TelemetryEventStrings.EventType.ERROR_EVENT.equals(map2.get(TelemetryEventStrings.Key.EVENT_TYPE))) {
                HashMap map3 = new HashMap(map);
                map3.putAll(map2);
                map3.put(TelemetryEventStrings.Key.IS_ERROR_EVENT, TelemetryEventStrings.Value.TRUE);
                arrayList.add(map3);
            }
        }
        return arrayList;
    }

    private List<Map<String, String>> countErrors(List<Map<String, String>> list) {
        if (list == null) {
            throw new NullPointerException("errorEvents is marked non-null but is null");
        }
        HashMap map = new HashMap();
        for (Map<String, String> map2 : list) {
            String str = map2.get(TelemetryEventStrings.Key.ERROR_TAG);
            Map<String, String> mapApplyAggregationRule = map.containsKey(str) ? (Map) map.get(str) : applyAggregationRule(map2);
            int i = 1;
            if (map.containsKey(str)) {
                i = 1 + Integer.parseInt(mapApplyAggregationRule.get(TelemetryEventStrings.Key.ERROR_COUNT));
            } else {
                map.put(str, mapApplyAggregationRule);
            }
            mapApplyAggregationRule.put(TelemetryEventStrings.Key.ERROR_COUNT, String.valueOf(i));
        }
        return new ArrayList(map.values());
    }
}
