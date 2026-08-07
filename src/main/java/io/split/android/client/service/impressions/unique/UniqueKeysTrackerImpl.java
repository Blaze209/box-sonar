package io.split.android.client.service.impressions.unique;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class UniqueKeysTrackerImpl implements UniqueKeysTracker {
    private final Object mLock = new Object();
    private final Map<String, Set<String>> mCache = new ConcurrentHashMap();

    @Override // io.split.android.client.service.impressions.unique.UniqueKeysTracker
    public boolean track(String key, String featureName) {
        if (key == null || featureName == null) {
            return false;
        }
        synchronized (this.mLock) {
            if (!this.mCache.containsKey(key)) {
                this.mCache.put(key, new HashSet());
            }
            this.mCache.get(key).add(featureName);
        }
        return true;
    }

    @Override // io.split.android.client.service.impressions.unique.UniqueKeysTracker
    public Map<String, Set<String>> popAll() {
        HashMap map;
        synchronized (this.mLock) {
            map = new HashMap(this.mCache);
            this.mCache.clear();
        }
        return map;
    }

    @Override // io.split.android.client.service.impressions.unique.UniqueKeysTracker
    public boolean isFull() {
        return this.mCache.size() >= 30000;
    }
}
