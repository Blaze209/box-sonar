package io.split.android.client.shared;

import io.split.android.client.SplitClient;
import io.split.android.client.api.Key;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseSplitClientContainer implements SplitClientContainer {
    private final ConcurrentMap<Key, SplitClient> mClientInstances = new ConcurrentHashMap();
    private final Object mClientCreationLock = new Object();

    protected abstract void createNewClient(Key key);

    @Override // io.split.android.client.shared.SplitClientContainer
    public SplitClient getClient(Key key) {
        return getOrCreateClientForKey(key);
    }

    @Override // io.split.android.client.shared.SplitClientContainer
    public void remove(Key key) {
        this.mClientInstances.remove(key);
    }

    @Override // io.split.android.client.shared.SplitClientContainer
    public Set<SplitClient> getAll() {
        return new HashSet(this.mClientInstances.values());
    }

    private SplitClient getOrCreateClientForKey(Key key) {
        synchronized (this.mClientCreationLock) {
            if (this.mClientInstances.get(key) != null) {
                return this.mClientInstances.get(key);
            }
            createNewClient(key);
            return this.mClientInstances.get(key);
        }
    }

    protected Set<String> getKeySet() {
        Set<Key> setKeySet = this.mClientInstances.keySet();
        HashSet hashSet = new HashSet();
        Iterator<Key> it = setKeySet.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().matchingKey());
        }
        return hashSet;
    }

    protected void trackNewClient(Key key, SplitClient client) {
        this.mClientInstances.put(key, client);
    }
}
