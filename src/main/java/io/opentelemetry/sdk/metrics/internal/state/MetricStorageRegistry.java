package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class MetricStorageRegistry {
    private static final Logger logger = Logger.getLogger(MetricStorageRegistry.class.getName());
    private final Object lock = new Object();
    private final Map<MetricDescriptor, MetricStorage> registry = new HashMap();

    static /* synthetic */ MetricStorage lambda$register$0(MetricStorage metricStorage, MetricDescriptor metricDescriptor) {
        return metricStorage;
    }

    public Collection<MetricStorage> getStorages() {
        Collection<MetricStorage> collectionUnmodifiableCollection;
        synchronized (this.lock) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(new ArrayList(this.registry.values()));
        }
        return collectionUnmodifiableCollection;
    }

    public <I extends MetricStorage> I register(final I i) {
        MetricDescriptor metricDescriptor = i.getMetricDescriptor();
        synchronized (this.lock) {
            I i2 = (I) this.registry.computeIfAbsent(metricDescriptor, new Function() { // from class: io.opentelemetry.sdk.metrics.internal.state.MetricStorageRegistry$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return MetricStorageRegistry.lambda$register$0(i, (MetricDescriptor) obj);
                }
            });
            if (i == i2 && logger.isLoggable(Level.WARNING)) {
                for (MetricStorage metricStorage : new ArrayList(this.registry.values())) {
                    if (metricStorage != i) {
                        MetricDescriptor metricDescriptor2 = metricStorage.getMetricDescriptor();
                        if (metricDescriptor2.getName().equalsIgnoreCase(metricDescriptor.getName()) && !metricDescriptor2.isCompatibleWith(metricDescriptor)) {
                            logger.log(Level.WARNING, DebugUtils.duplicateMetricErrorMessage(metricDescriptor2, metricDescriptor));
                            break;
                        }
                    }
                }
                return i2;
            }
            return i2;
        }
    }

    void resetForTest() {
        synchronized (this.lock) {
            this.registry.clear();
        }
    }
}
