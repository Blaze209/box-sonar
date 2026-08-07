package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.internal.view.ExponentialHistogramAggregation;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class AggregationUtil {
    private static final String AGGREGATION_DEFAULT = "default";
    private static final String AGGREGATION_DROP = "drop";
    private static final String AGGREGATION_EXPLICIT_BUCKET_HISTOGRAM = "explicit_bucket_histogram";
    private static final String AGGREGATION_EXPONENTIAL_HISTOGRAM = "exponential_bucket_histogram";
    private static final String AGGREGATION_LAST_VALUE = "last_value";
    private static final String AGGREGATION_SUM = "sum";
    private static final Map<String, Aggregation> aggregationByName;
    private static final Map<Class<? extends Aggregation>, String> nameByAggregation;

    static {
        HashMap map = new HashMap();
        aggregationByName = map;
        map.put("default", Aggregation.defaultAggregation());
        map.put(AGGREGATION_SUM, Aggregation.sum());
        map.put(AGGREGATION_LAST_VALUE, Aggregation.lastValue());
        map.put(AGGREGATION_DROP, Aggregation.drop());
        map.put(AGGREGATION_EXPLICIT_BUCKET_HISTOGRAM, Aggregation.explicitBucketHistogram());
        map.put(AGGREGATION_EXPONENTIAL_HISTOGRAM, ExponentialHistogramAggregation.getDefault());
        HashMap map2 = new HashMap();
        nameByAggregation = map2;
        map2.put(Aggregation.defaultAggregation().getClass(), "default");
        map2.put(Aggregation.sum().getClass(), AGGREGATION_SUM);
        map2.put(Aggregation.lastValue().getClass(), AGGREGATION_LAST_VALUE);
        map2.put(Aggregation.drop().getClass(), AGGREGATION_DROP);
        map2.put(Aggregation.explicitBucketHistogram().getClass(), AGGREGATION_EXPLICIT_BUCKET_HISTOGRAM);
        map2.put(ExponentialHistogramAggregation.getDefault().getClass(), AGGREGATION_EXPONENTIAL_HISTOGRAM);
    }

    private AggregationUtil() {
    }

    public static Aggregation forName(String str) {
        Aggregation aggregation = aggregationByName.get(str.toLowerCase());
        if (aggregation != null) {
            return aggregation;
        }
        throw new IllegalArgumentException("Unrecognized aggregation name " + str);
    }

    public static String aggregationName(Aggregation aggregation) {
        String str = nameByAggregation.get(aggregation.getClass());
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Unrecognized aggregation " + aggregation.getClass().getName());
    }
}
