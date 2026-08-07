package io.split.android.client.storage.mysegments;

import io.split.android.client.utils.Utils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsStorageContainerImpl implements MySegmentsStorageContainer {
    private final PersistentMySegmentsStorage mPersistentMySegmentsStorage;
    private final ConcurrentMap<String, MySegmentsStorage> mStorageMap = new ConcurrentHashMap();
    private final Object lock = new Object();

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void loadLocal() {
    }

    public MySegmentsStorageContainerImpl(PersistentMySegmentsStorage persistentMySegmentsStorage) {
        this.mPersistentMySegmentsStorage = (PersistentMySegmentsStorage) Utils.checkNotNull(persistentMySegmentsStorage);
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorageContainer
    public MySegmentsStorage getStorageForKey(String matchingKey) {
        MySegmentsStorage mySegmentsStorage;
        synchronized (this.lock) {
            if (this.mStorageMap.get(matchingKey) == null) {
                this.mStorageMap.put(matchingKey, new MySegmentsStorageImpl(matchingKey, this.mPersistentMySegmentsStorage));
            }
            mySegmentsStorage = this.mStorageMap.get(matchingKey);
        }
        return mySegmentsStorage;
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorageContainer
    public long getUniqueAmount() {
        HashSet hashSet = new HashSet();
        Iterator<MySegmentsStorage> it = this.mStorageMap.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().getAll());
        }
        return hashSet.size();
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void clear() {
        synchronized (this.lock) {
            Iterator<MySegmentsStorage> it = this.mStorageMap.values().iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
        }
    }
}
