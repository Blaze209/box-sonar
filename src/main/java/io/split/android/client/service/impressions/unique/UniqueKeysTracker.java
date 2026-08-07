package io.split.android.client.service.impressions.unique;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface UniqueKeysTracker {
    boolean isFull();

    Map<String, Set<String>> popAll();

    boolean track(String key, String featureName);
}
