package com.microsoft.identity.common.java.telemetry.rules;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class TelemetryAggregationRules {
    private static TelemetryAggregationRules sInstance;
    private final String[] aggregatedArray;
    private Set<String> aggregatedPropertiesSet;

    private TelemetryAggregationRules() {
        String[] strArr = {TelemetryEventStrings.Key.EVENT_NAME, TelemetryEventStrings.Key.OCCUR_TIME, TelemetryEventStrings.Key.EVENT_TYPE, TelemetryEventStrings.Key.IS_SUCCESSFUL};
        this.aggregatedArray = strArr;
        this.aggregatedPropertiesSet = new HashSet(Arrays.asList(strArr));
    }

    public static synchronized TelemetryAggregationRules getInstance() {
        if (sInstance == null) {
            sInstance = new TelemetryAggregationRules();
        }
        return sInstance;
    }

    public boolean isRedundant(String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return false;
        }
        return this.aggregatedPropertiesSet.contains(str);
    }
}
