package io.opentelemetry.sdk.metrics.internal.aggregator;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
final class AdaptingCircularBufferCounter {
    private static final int NULL_INDEX = Integer.MIN_VALUE;
    private final AdaptingIntegerArray backing;
    private int baseIndex;
    private int endIndex;
    private int startIndex;

    AdaptingCircularBufferCounter(int i) {
        this.endIndex = Integer.MIN_VALUE;
        this.startIndex = Integer.MIN_VALUE;
        this.baseIndex = Integer.MIN_VALUE;
        this.backing = new AdaptingIntegerArray(i);
    }

    AdaptingCircularBufferCounter(AdaptingCircularBufferCounter adaptingCircularBufferCounter) {
        this.endIndex = Integer.MIN_VALUE;
        this.startIndex = Integer.MIN_VALUE;
        this.baseIndex = Integer.MIN_VALUE;
        this.backing = adaptingCircularBufferCounter.backing.copy();
        this.startIndex = adaptingCircularBufferCounter.getIndexStart();
        this.endIndex = adaptingCircularBufferCounter.getIndexEnd();
        this.baseIndex = adaptingCircularBufferCounter.baseIndex;
    }

    int getIndexStart() {
        return this.startIndex;
    }

    int getIndexEnd() {
        return this.endIndex;
    }

    boolean increment(int i, long j) {
        if (this.baseIndex == Integer.MIN_VALUE) {
            this.startIndex = i;
            this.endIndex = i;
            this.baseIndex = i;
            this.backing.increment(0, j);
            return true;
        }
        int i2 = this.endIndex;
        if (i > i2) {
            if ((((long) i) - ((long) this.startIndex)) + 1 > this.backing.length()) {
                return false;
            }
            this.endIndex = i;
        } else if (i < this.startIndex) {
            if ((((long) i2) - ((long) i)) + 1 > this.backing.length()) {
                return false;
            }
            this.startIndex = i;
        }
        this.backing.increment(toBufferIndex(i), j);
        return true;
    }

    long get(int i) {
        if (i < this.startIndex || i > this.endIndex) {
            return 0L;
        }
        return this.backing.get(toBufferIndex(i));
    }

    boolean isEmpty() {
        return this.baseIndex == Integer.MIN_VALUE;
    }

    int getMaxSize() {
        return this.backing.length();
    }

    void clear() {
        this.backing.clear();
        this.baseIndex = Integer.MIN_VALUE;
        this.endIndex = Integer.MIN_VALUE;
        this.startIndex = Integer.MIN_VALUE;
    }

    private int toBufferIndex(int i) {
        int i2 = i - this.baseIndex;
        if (i2 >= this.backing.length()) {
            return i2 - this.backing.length();
        }
        return i2 < 0 ? i2 + this.backing.length() : i2;
    }

    public String toString() {
        int i;
        StringBuilder sb = new StringBuilder("{");
        for (int i2 = this.startIndex; i2 <= this.endIndex && (i = this.startIndex) != Integer.MIN_VALUE; i2++) {
            if (i2 != i) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(i2).append('=').append(get(i2));
        }
        return sb.append("}").toString();
    }
}
