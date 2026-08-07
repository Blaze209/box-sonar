package com.box.android.data.service.impl;

import com.box.android.data.datasource.logging.MetricsCacheDataSource;
import com.box.android.data.datasource.logging.MetricsRemoteDataSource;
import com.box.android.data.mappers.observability.MetricsEntityDTOMapper;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class MetricsLoggingService_Factory implements Factory<MetricsLoggingService> {
    private final Provider<MetricsCacheDataSource> metricsCacheDataSourceProvider;
    private final Provider<MetricsEntityDTOMapper> metricsEntityDTOMapperProvider;
    private final Provider<MetricsRemoteDataSource> metricsRemoteDataSourceProvider;

    private MetricsLoggingService_Factory(Provider<MetricsCacheDataSource> metricsCacheDataSourceProvider, Provider<MetricsRemoteDataSource> metricsRemoteDataSourceProvider, Provider<MetricsEntityDTOMapper> metricsEntityDTOMapperProvider) {
        this.metricsCacheDataSourceProvider = metricsCacheDataSourceProvider;
        this.metricsRemoteDataSourceProvider = metricsRemoteDataSourceProvider;
        this.metricsEntityDTOMapperProvider = metricsEntityDTOMapperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MetricsLoggingService get() {
        return newInstance(this.metricsCacheDataSourceProvider.get(), this.metricsRemoteDataSourceProvider.get(), this.metricsEntityDTOMapperProvider.get());
    }

    public static MetricsLoggingService_Factory create(Provider<MetricsCacheDataSource> metricsCacheDataSourceProvider, Provider<MetricsRemoteDataSource> metricsRemoteDataSourceProvider, Provider<MetricsEntityDTOMapper> metricsEntityDTOMapperProvider) {
        return new MetricsLoggingService_Factory(metricsCacheDataSourceProvider, metricsRemoteDataSourceProvider, metricsEntityDTOMapperProvider);
    }

    public static MetricsLoggingService newInstance(MetricsCacheDataSource metricsCacheDataSource, MetricsRemoteDataSource metricsRemoteDataSource, MetricsEntityDTOMapper metricsEntityDTOMapper) {
        return new MetricsLoggingService(metricsCacheDataSource, metricsRemoteDataSource, metricsEntityDTOMapper);
    }
}
