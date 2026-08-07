package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import io.split.android.client.dtos.DataType;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class BetweenMatcher implements Matcher {
    private final DataType _dataType;
    private final long _end;
    private final long _normalizedEnd;
    private final long _normalizedStart;
    private final long _start;

    public BetweenMatcher(long start, long end, DataType dataType) {
        this._start = start;
        this._end = end;
        this._dataType = dataType;
        if (dataType == DataType.DATETIME) {
            this._normalizedStart = Transformers.asDateHourMinute(Long.valueOf(start)).longValue();
            this._normalizedEnd = Transformers.asDateHourMinute(Long.valueOf(end)).longValue();
        } else {
            this._normalizedStart = start;
            this._normalizedEnd = end;
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
        return lAsLong != null && lAsLong.longValue() >= this._normalizedStart && lAsLong.longValue() <= this._normalizedEnd;
    }

    public String toString() {
        return "between " + this._start + " and " + this._end;
    }

    public int hashCode() {
        long j = this._start;
        int i = (527 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this._end;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BetweenMatcher)) {
            return false;
        }
        BetweenMatcher betweenMatcher = (BetweenMatcher) obj;
        return this._start == betweenMatcher._start && this._end == betweenMatcher._end;
    }
}
