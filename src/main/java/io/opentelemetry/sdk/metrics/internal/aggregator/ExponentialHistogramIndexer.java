package io.opentelemetry.sdk.metrics.internal.aggregator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
final class ExponentialHistogramIndexer {
    private static final int EXPONENT_BIAS = 1023;
    private static final long EXPONENT_BIT_MASK = 9218868437227405312L;
    private static final int EXPONENT_WIDTH = 11;
    private static final long SIGNIFICAND_BIT_MASK = 4503599627370495L;
    private static final int SIGNIFICAND_WIDTH = 52;
    private final int scale;
    private final double scaleFactor;
    private static final Map<Integer, ExponentialHistogramIndexer> cache = new ConcurrentHashMap();
    private static final double LOG_BASE2_E = 1.0d / Math.log(2.0d);

    private ExponentialHistogramIndexer(int i) {
        this.scale = i;
        this.scaleFactor = computeScaleFactor(i);
    }

    static ExponentialHistogramIndexer get(final int i) {
        return cache.computeIfAbsent(Integer.valueOf(i), new Function() { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramIndexer$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ExponentialHistogramIndexer.lambda$get$0(i, (Integer) obj);
            }
        });
    }

    static /* synthetic */ ExponentialHistogramIndexer lambda$get$0(int i, Integer num) {
        return new ExponentialHistogramIndexer(i);
    }

    int computeIndex(double d) {
        double dAbs = Math.abs(d);
        int i = this.scale;
        if (i > 0) {
            return getIndexByLogarithm(dAbs);
        }
        if (i == 0) {
            return mapToIndexScaleZero(dAbs);
        }
        return mapToIndexScaleZero(dAbs) >> (-this.scale);
    }

    private int getIndexByLogarithm(double d) {
        return ((int) Math.ceil(Math.log(d) * this.scaleFactor)) - 1;
    }

    private static int mapToIndexScaleZero(double d) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        long jNumberOfLeadingZeros = (EXPONENT_BIT_MASK & jDoubleToLongBits) >> 52;
        long j = jDoubleToLongBits & SIGNIFICAND_BIT_MASK;
        if (jNumberOfLeadingZeros == 0) {
            jNumberOfLeadingZeros -= (long) (Long.numberOfLeadingZeros(j - 1) - 12);
        }
        int i = (int) (jNumberOfLeadingZeros - 1023);
        return j == 0 ? i - 1 : i;
    }

    private static double computeScaleFactor(int i) {
        return Math.scalb(LOG_BASE2_E, i);
    }
}
