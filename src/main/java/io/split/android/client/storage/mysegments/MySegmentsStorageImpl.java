package io.split.android.client.storage.mysegments;

import io.split.android.client.dtos.Segment;
import io.split.android.client.dtos.SegmentsChange;
import io.split.android.client.utils.Utils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
class MySegmentsStorageImpl implements MySegmentsStorage {
    public static final int DEFAULT_CHANGE_NUMBER = -1;
    private final String mMatchingKey;
    private final PersistentMySegmentsStorage mPersistentStorage;
    private final Set<String> mInMemoryMySegments = Collections.newSetFromMap(new ConcurrentHashMap());
    private final AtomicLong mTill = new AtomicLong(-1);

    public MySegmentsStorageImpl(String matchingKey, PersistentMySegmentsStorage persistentStorage) {
        this.mPersistentStorage = (PersistentMySegmentsStorage) Utils.checkNotNull(persistentStorage);
        this.mMatchingKey = (String) Utils.checkNotNull(matchingKey);
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void loadLocal() {
        SegmentsChange snapshot = this.mPersistentStorage.getSnapshot(this.mMatchingKey);
        this.mInMemoryMySegments.addAll(toNames(snapshot.getSegments()));
        this.mTill.set(getOrDefault(snapshot.getChangeNumber()).longValue());
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public Set<String> getAll() {
        return this.mInMemoryMySegments;
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public void set(SegmentsChange segmentsChange) {
        if (segmentsChange == null) {
            return;
        }
        this.mInMemoryMySegments.clear();
        this.mInMemoryMySegments.addAll(toNames(segmentsChange.getSegments()));
        this.mTill.set(getOrDefault(segmentsChange.getChangeNumber()).longValue());
        this.mPersistentStorage.set(this.mMatchingKey, segmentsChange);
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public long getChangeNumber() {
        return this.mTill.get();
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void clear() {
        this.mInMemoryMySegments.clear();
        this.mTill.set(-1L);
        this.mPersistentStorage.set(this.mMatchingKey, SegmentsChange.createEmpty());
    }

    private static Set<String> toNames(Set<Segment> segments) {
        if (segments == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        Iterator<Segment> it = segments.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getName());
        }
        return hashSet;
    }

    private static Long getOrDefault(Long changeNumber) {
        return Long.valueOf(changeNumber == null ? -1L : changeNumber.longValue());
    }
}
