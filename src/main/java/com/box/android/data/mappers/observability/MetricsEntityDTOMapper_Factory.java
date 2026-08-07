package com.box.android.data.mappers.observability;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class MetricsEntityDTOMapper_Factory implements Factory<MetricsEntityDTOMapper> {
    private final Provider<Moshi> moshiProvider;

    private MetricsEntityDTOMapper_Factory(Provider<Moshi> moshiProvider) {
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MetricsEntityDTOMapper get() {
        return newInstance(this.moshiProvider.get());
    }

    public static MetricsEntityDTOMapper_Factory create(Provider<Moshi> moshiProvider) {
        return new MetricsEntityDTOMapper_Factory(moshiProvider);
    }

    public static MetricsEntityDTOMapper newInstance(Moshi moshi) {
        return new MetricsEntityDTOMapper(moshi);
    }
}
