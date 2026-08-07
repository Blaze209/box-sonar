package io.split.android.client;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface EventsTracker {
    void enableTracking(boolean enable);

    boolean track(String key, String trafficType, String eventType, double value, Map<String, Object> properties, boolean isSdkReady);
}
