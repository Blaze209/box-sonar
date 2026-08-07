package com.splunk.rum;

import java.time.Clock;
import java.util.ArrayDeque;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
class BandwidthTracker {
    private static final int DATAPOINTS_TO_TRACK = 6;
    private final Clock clock;
    private final ArrayDeque<Long> sizes;
    private final ArrayDeque<Long> times;

    BandwidthTracker() {
        this(Clock.systemUTC());
    }

    BandwidthTracker(Clock clock) {
        this.times = new ArrayDeque<>();
        this.sizes = new ArrayDeque<>();
        this.clock = clock;
    }

    void tick(List<byte[]> list) {
        if (this.times.size() > 6) {
            this.times.removeFirst();
        }
        this.times.add(Long.valueOf(this.clock.millis()));
        if (this.sizes.size() > 6) {
            this.sizes.removeFirst();
        }
        this.sizes.add(Long.valueOf(((Integer) list.stream().map(new Function() { // from class: com.splunk.rum.BandwidthTracker$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((byte[]) obj).length);
            }
        }).reduce(0, new BiFunction() { // from class: com.splunk.rum.BandwidthTracker$$ExternalSyntheticLambda1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Integer.valueOf(Integer.sum(((Integer) obj).intValue(), ((Integer) obj2).intValue()));
            }
        }, new BinaryOperator() { // from class: com.splunk.rum.BandwidthTracker$$ExternalSyntheticLambda2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Integer.valueOf(Integer.sum(((Integer) obj).intValue(), ((Integer) obj2).intValue()));
            }
        })).intValue()));
    }

    double totalSustainedRate() {
        if (this.sizes.size() < 2) {
            return 0.0d;
        }
        return ((Long) this.sizes.stream().skip(1L).reduce(0L, new BiFunction() { // from class: com.splunk.rum.BandwidthTracker$$ExternalSyntheticLambda3
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Long.valueOf(Long.sum(((Long) obj).longValue(), ((Long) obj2).longValue()));
            }
        }, new BinaryOperator() { // from class: com.splunk.rum.BandwidthTracker$$ExternalSyntheticLambda4
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Long.valueOf(Long.sum(((Long) obj).longValue(), ((Long) obj2).longValue()));
            }
        })).longValue() / ((this.times.getLast().longValue() - this.times.getFirst().longValue()) / 1000.0d);
    }
}
