package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes4.dex */
final class MetricStorageUtils {
    static final int MAX_ACCUMULATIONS = 2000;

    private MetricStorageUtils() {
    }

    static <T, U extends ExemplarData> void mergeInPlace(Map<Attributes, T> map, Map<Attributes, T> map2, Aggregator<T, U> aggregator) {
        Objects.requireNonNull(aggregator);
        blend(map, map2, false, new MetricStorageUtils$$ExternalSyntheticLambda2(aggregator));
    }

    static <T, U extends ExemplarData> void mergeAndPreserveInPlace(Map<Attributes, T> map, Map<Attributes, T> map2, Aggregator<T, U> aggregator) {
        Objects.requireNonNull(aggregator);
        blend(map, map2, true, new MetricStorageUtils$$ExternalSyntheticLambda2(aggregator));
    }

    static <T, U extends ExemplarData> void diffInPlace(Map<Attributes, T> map, Map<Attributes, T> map2, final Aggregator<T, U> aggregator) {
        Objects.requireNonNull(aggregator);
        blend(map, map2, false, new BiFunction() { // from class: io.opentelemetry.sdk.metrics.internal.state.MetricStorageUtils$$ExternalSyntheticLambda1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return aggregator.diff(obj, obj2);
            }
        });
    }

    private static <T> void blend(final Map<Attributes, T> map, Map<Attributes, T> map2, boolean z, final BiFunction<T, T, T> biFunction) {
        if (!z) {
            removeUnseen(map, map2);
        }
        map2.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.metrics.internal.state.MetricStorageUtils$$ExternalSyntheticLambda4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                map.compute((Attributes) obj, new BiFunction() { // from class: io.opentelemetry.sdk.metrics.internal.state.MetricStorageUtils$$ExternalSyntheticLambda3
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj3, Object obj4) {
                        return MetricStorageUtils.lambda$blend$0(biFunction, obj2, (Attributes) obj3, obj4);
                    }
                });
            }
        });
    }

    static /* synthetic */ Object lambda$blend$0(BiFunction biFunction, Object obj, Attributes attributes, Object obj2) {
        return obj2 != null ? biFunction.apply(obj2, obj) : obj;
    }

    static /* synthetic */ boolean lambda$removeUnseen$2(Map map, Map.Entry entry) {
        return !map.containsKey(entry.getKey());
    }

    public static <T> void removeUnseen(Map<Attributes, T> map, final Map<Attributes, T> map2) {
        map.entrySet().removeIf(new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.state.MetricStorageUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MetricStorageUtils.lambda$removeUnseen$2(map2, (Map.Entry) obj);
            }
        });
    }
}
