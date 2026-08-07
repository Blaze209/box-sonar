package io.split.android.client.storage.rbs;

import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.utils.Utils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class RuleBasedSegmentStorageProducerImpl implements RuleBasedSegmentStorageProducer {
    private final AtomicLong mChangeNumberRef;
    private final ConcurrentHashMap<String, RuleBasedSegment> mInMemorySegments;
    private final PersistentRuleBasedSegmentStorage mPersistentStorage;

    public RuleBasedSegmentStorageProducerImpl(PersistentRuleBasedSegmentStorage persistentStorage, ConcurrentHashMap<String, RuleBasedSegment> segments, AtomicLong changeNumberRef) {
        this.mPersistentStorage = (PersistentRuleBasedSegmentStorage) Utils.checkNotNull(persistentStorage);
        this.mInMemorySegments = (ConcurrentHashMap) Utils.checkNotNull(segments);
        this.mChangeNumberRef = (AtomicLong) Utils.checkNotNull(changeNumberRef);
    }

    @Override // io.split.android.client.storage.rbs.RuleBasedSegmentStorageProducer
    public boolean update(Set<RuleBasedSegment> toAdd, Set<RuleBasedSegment> toRemove, long changeNumber) {
        boolean z = false;
        if (toAdd != null) {
            if (!toAdd.isEmpty()) {
                for (RuleBasedSegment ruleBasedSegment : toAdd) {
                    this.mInMemorySegments.put(ruleBasedSegment.getName(), ruleBasedSegment);
                }
                z = true;
            }
        } else {
            toAdd = new HashSet<>();
        }
        if (toRemove != null) {
            if (!toRemove.isEmpty()) {
                Iterator<RuleBasedSegment> it = toRemove.iterator();
                while (it.hasNext()) {
                    this.mInMemorySegments.remove(it.next().getName());
                }
            }
        } else {
            toRemove = new HashSet<>();
        }
        this.mChangeNumberRef.set(changeNumber);
        this.mPersistentStorage.update(toAdd, toRemove, changeNumber);
        return z;
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void loadLocal() {
        RuleBasedSegmentSnapshot snapshot = this.mPersistentStorage.getSnapshot();
        Map<String, RuleBasedSegment> segments = snapshot.getSegments();
        this.mChangeNumberRef.set(snapshot.getChangeNumber());
        this.mInMemorySegments.putAll(segments);
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void clear() {
        this.mInMemorySegments.clear();
        this.mChangeNumberRef.set(-1L);
        this.mPersistentStorage.clear();
    }

    @Override // io.split.android.client.storage.rbs.RuleBasedSegmentStorageProducer
    public long getChangeNumber() {
        return this.mChangeNumberRef.get();
    }
}
