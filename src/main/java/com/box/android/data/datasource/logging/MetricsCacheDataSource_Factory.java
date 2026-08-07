package com.box.android.data.datasource.logging;

import com.box.android.data.persistence.ObservabilityDatabaseProvider;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class MetricsCacheDataSource_Factory implements Factory<MetricsCacheDataSource> {
    private final Provider<ObservabilityDatabaseProvider> observabilityDatabaseProvider;

    private MetricsCacheDataSource_Factory(Provider<ObservabilityDatabaseProvider> observabilityDatabaseProvider) {
        this.observabilityDatabaseProvider = observabilityDatabaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MetricsCacheDataSource get() {
        return newInstance(this.observabilityDatabaseProvider.get());
    }

    public static MetricsCacheDataSource_Factory create(Provider<ObservabilityDatabaseProvider> observabilityDatabaseProvider) {
        return new MetricsCacheDataSource_Factory(observabilityDatabaseProvider);
    }

    public static MetricsCacheDataSource newInstance(ObservabilityDatabaseProvider observabilityDatabaseProvider) {
        return new MetricsCacheDataSource(observabilityDatabaseProvider);
    }
}
