package com.box.android.data.api.requests;

import com.box.android.data.observability.RumInstrumentation;
import com.box.android.domain.configuration.FeatureFlips;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;
import java.util.List;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: classes11.dex */
public final class RequestFactory_Factory implements Factory<RequestFactory> {
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<List<Interceptor>> interceptorsProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<RumInstrumentation> rumInstrumentationProvider;

    private RequestFactory_Factory(Provider<List<Interceptor>> interceptorsProvider, Provider<Moshi> moshiProvider, Provider<FeatureFlips> featureFlipsProvider, Provider<RumInstrumentation> rumInstrumentationProvider) {
        this.interceptorsProvider = interceptorsProvider;
        this.moshiProvider = moshiProvider;
        this.featureFlipsProvider = featureFlipsProvider;
        this.rumInstrumentationProvider = rumInstrumentationProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RequestFactory get() {
        return newInstance(this.interceptorsProvider.get(), this.moshiProvider.get(), this.featureFlipsProvider.get(), this.rumInstrumentationProvider.get());
    }

    public static RequestFactory_Factory create(Provider<List<Interceptor>> interceptorsProvider, Provider<Moshi> moshiProvider, Provider<FeatureFlips> featureFlipsProvider, Provider<RumInstrumentation> rumInstrumentationProvider) {
        return new RequestFactory_Factory(interceptorsProvider, moshiProvider, featureFlipsProvider, rumInstrumentationProvider);
    }

    public static RequestFactory newInstance(List<Interceptor> interceptors, Moshi moshi, FeatureFlips featureFlips, RumInstrumentation rumInstrumentation) {
        return new RequestFactory(interceptors, moshi, featureFlips, rumInstrumentation);
    }
}
