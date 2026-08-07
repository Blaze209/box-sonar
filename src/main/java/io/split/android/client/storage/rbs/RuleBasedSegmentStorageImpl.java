package io.split.android.client.storage.rbs;

import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.utils.Utils;
import io.split.android.engine.experiments.ParsedRuleBasedSegment;
import io.split.android.engine.experiments.RuleBasedSegmentParser;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class RuleBasedSegmentStorageImpl implements RuleBasedSegmentStorage {
    private final ConcurrentHashMap<String, RuleBasedSegment> mInMemorySegments;
    private final RuleBasedSegmentParser mParser;
    private final RuleBasedSegmentStorageProducer mProducer;

    public RuleBasedSegmentStorageImpl(PersistentRuleBasedSegmentStorage persistentStorage, RuleBasedSegmentParser parser) {
        ConcurrentHashMap<String, RuleBasedSegment> concurrentHashMap = new ConcurrentHashMap<>();
        this.mInMemorySegments = concurrentHashMap;
        this.mParser = (RuleBasedSegmentParser) Utils.checkNotNull(parser);
        this.mProducer = new RuleBasedSegmentStorageProducerImpl(persistentStorage, concurrentHashMap, new AtomicLong(-1L));
    }

    RuleBasedSegmentStorageImpl(RuleBasedSegmentStorageProducer producer, RuleBasedSegmentParser parser, ConcurrentHashMap<String, RuleBasedSegment> inMemorySegmentsMap) {
        this.mInMemorySegments = (ConcurrentHashMap) Utils.checkNotNull(inMemorySegmentsMap);
        this.mParser = (RuleBasedSegmentParser) Utils.checkNotNull(parser);
        this.mProducer = (RuleBasedSegmentStorageProducer) Utils.checkNotNull(producer);
    }

    @Override // io.split.android.client.storage.rbs.RuleBasedSegmentStorageConsumer
    public ParsedRuleBasedSegment get(String segmentName, String matchingKey) {
        RuleBasedSegment ruleBasedSegment = this.mInMemorySegments.get(segmentName);
        if (ruleBasedSegment == null) {
            return null;
        }
        return this.mParser.parse(ruleBasedSegment, matchingKey);
    }

    @Override // io.split.android.client.storage.rbs.RuleBasedSegmentStorageProducer
    public synchronized boolean update(Set<RuleBasedSegment> toAdd, Set<RuleBasedSegment> toRemove, long changeNumber) {
        return this.mProducer.update(toAdd, toRemove, changeNumber);
    }

    @Override // io.split.android.client.storage.rbs.RuleBasedSegmentStorageProducer
    public long getChangeNumber() {
        return this.mProducer.getChangeNumber();
    }

    @Override // io.split.android.client.storage.rbs.RuleBasedSegmentStorageConsumer
    public boolean contains(Set<String> segmentNames) {
        if (segmentNames == null) {
            return false;
        }
        Iterator<String> it = segmentNames.iterator();
        while (it.hasNext()) {
            if (!this.mInMemorySegments.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public synchronized void loadLocal() {
        this.mProducer.loadLocal();
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void clear() {
        this.mProducer.clear();
    }
}
