package io.opentelemetry.sdk.metrics.internal.aggregator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.ToDoubleFunction;

/* JADX INFO: loaded from: classes4.dex */
public final class ExplicitBucketHistogramUtils {
    public static final List<Double> DEFAULT_HISTOGRAM_BUCKET_BOUNDARIES = Collections.unmodifiableList(Arrays.asList(Double.valueOf(0.0d), Double.valueOf(5.0d), Double.valueOf(10.0d), Double.valueOf(25.0d), Double.valueOf(50.0d), Double.valueOf(75.0d), Double.valueOf(100.0d), Double.valueOf(250.0d), Double.valueOf(500.0d), Double.valueOf(750.0d), Double.valueOf(1000.0d), Double.valueOf(2500.0d), Double.valueOf(5000.0d), Double.valueOf(7500.0d), Double.valueOf(10000.0d)));

    private ExplicitBucketHistogramUtils() {
    }

    public static double[] createBoundaryArray(List<Double> list) {
        return validateBucketBoundaries(list.stream().mapToDouble(new ToDoubleFunction() { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                return ((Double) obj).doubleValue();
            }
        }).toArray());
    }

    public static int findBucketIndex(double[] dArr, double d) {
        for (int i = 0; i < dArr.length; i++) {
            if (d <= dArr[i]) {
                return i;
            }
        }
        return dArr.length;
    }

    public static double[] validateBucketBoundaries(double[] dArr) {
        for (double d : dArr) {
            if (Double.isNaN(d)) {
                throw new IllegalArgumentException("invalid bucket boundary: NaN");
            }
        }
        for (int i = 1; i < dArr.length; i++) {
            int i2 = i - 1;
            if (dArr[i2] >= dArr[i]) {
                throw new IllegalArgumentException("Bucket boundaries must be in increasing order: " + dArr[i2] + " >= " + dArr[i]);
            }
        }
        if (dArr.length > 0) {
            if (dArr[0] == Double.NEGATIVE_INFINITY) {
                throw new IllegalArgumentException("invalid bucket boundary: -Inf");
            }
            if (dArr[dArr.length - 1] == Double.POSITIVE_INFINITY) {
                throw new IllegalArgumentException("invalid bucket boundary: +Inf");
            }
        }
        return dArr;
    }
}
