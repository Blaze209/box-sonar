package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import io.split.android.client.dtos.DataType;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class GreaterThanOrEqualToMatcher implements Matcher {
    private final long _compareTo;
    private final DataType _dataType;
    private final long _normalizedCompareTo;

    public GreaterThanOrEqualToMatcher(long compareTo, DataType dataType) {
        this._compareTo = compareTo;
        this._dataType = dataType;
        if (dataType == DataType.DATETIME) {
            this._normalizedCompareTo = Transformers.asDateHourMinute(Long.valueOf(compareTo)).longValue();
        } else {
            this._normalizedCompareTo = compareTo;
        }
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object matchValue, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        Long lAsLong;
        if (this._dataType == DataType.DATETIME) {
            lAsLong = Transformers.asDateHourMinute(matchValue);
        } else {
            lAsLong = Transformers.asLong(matchValue);
        }
        return lAsLong != null && lAsLong.longValue() >= this._normalizedCompareTo;
    }

    public String toString() {
        return ">= " + this._compareTo;
    }

    public int hashCode() {
        long j = this._compareTo;
        return 527 + ((int) (j ^ (j >>> 32)));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof GreaterThanOrEqualToMatcher) && this._compareTo == ((GreaterThanOrEqualToMatcher) obj)._compareTo;
    }
}
