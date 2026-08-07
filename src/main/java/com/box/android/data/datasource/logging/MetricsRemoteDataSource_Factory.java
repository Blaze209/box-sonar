package com.box.android.data.datasource.logging;

import com.box.android.data.api.requests.MetricsLoggingRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class MetricsRemoteDataSource_Factory implements Factory<MetricsRemoteDataSource> {
    private final Provider<MetricsLoggingRequest> metricsLoggingRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private MetricsRemoteDataSource_Factory(Provider<MetricsLoggingRequest> metricsLoggingRequestProvider, Provider<Moshi> moshiProvider) {
        this.metricsLoggingRequestProvider = metricsLoggingRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MetricsRemoteDataSource get() {
        return newInstance(this.metricsLoggingRequestProvider.get(), this.moshiProvider.get());
    }

    public static MetricsRemoteDataSource_Factory create(Provider<MetricsLoggingRequest> metricsLoggingRequestProvider, Provider<Moshi> moshiProvider) {
        return new MetricsRemoteDataSource_Factory(metricsLoggingRequestProvider, moshiProvider);
    }

    public static MetricsRemoteDataSource newInstance(MetricsLoggingRequest metricsLoggingRequest, Moshi moshi) {
        return new MetricsRemoteDataSource(metricsLoggingRequest, moshi);
    }
}
