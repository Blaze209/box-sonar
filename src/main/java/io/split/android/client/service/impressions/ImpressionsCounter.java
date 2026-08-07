package io.split.android.client.service.impressions;

import io.split.android.client.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsCounter {
    private final ConcurrentHashMap<Key, AtomicInteger> mCounts = new ConcurrentHashMap<>();
    private final long mDedupeTimeIntervalInMs;

    public static class Key {
        private final String featureName;
        private final long timeFrame;

        public Key(String featureName, long timeframe) {
            this.featureName = (String) Utils.checkNotNull(featureName);
            this.timeFrame = timeframe;
        }

        public String featureName() {
            return this.featureName;
        }

        public long timeFrame() {
            return this.timeFrame;
        }

        public int hashCode() {
            return String.format("%s%d", this.featureName, Long.valueOf(this.timeFrame)).hashCode();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o != null && getClass() == o.getClass()) {
                Key key = (Key) o;
                if (this.featureName.equals(key.featureName) && this.timeFrame == key.timeFrame) {
                    return true;
                }
            }
            return false;
        }
    }

    public ImpressionsCounter(long dedupeTimeIntervalInMs) {
        this.mDedupeTimeIntervalInMs = dedupeTimeIntervalInMs;
    }

    public void inc(String featureName, long timeFrame, int amount) {
        AtomicInteger atomicIntegerPutIfAbsent;
        Key key = new Key(featureName, ImpressionUtils.truncateTimeframe(timeFrame, this.mDedupeTimeIntervalInMs));
        AtomicInteger atomicInteger = this.mCounts.get(key);
        if (atomicInteger == null && (atomicIntegerPutIfAbsent = this.mCounts.putIfAbsent(key, (atomicInteger = new AtomicInteger()))) != null) {
            atomicInteger = atomicIntegerPutIfAbsent;
        }
        atomicInteger.addAndGet(amount);
    }

    public List<ImpressionsCountPerFeature> popAll() {
        ArrayList arrayList = new ArrayList();
        for (Key key : new ArrayList(this.mCounts.keySet())) {
            AtomicInteger atomicIntegerRemove = this.mCounts.remove(key);
            if (atomicIntegerRemove != null) {
                arrayList.add(new ImpressionsCountPerFeature(key.featureName, key.timeFrame, atomicIntegerRemove.get()));
            }
        }
        return arrayList;
    }

    public boolean isEmpty() {
        return this.mCounts.isEmpty();
    }
}
