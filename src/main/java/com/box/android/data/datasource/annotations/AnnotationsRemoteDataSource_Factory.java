package com.box.android.data.datasource.annotations;

import com.box.android.data.api.requests.AnnotationsRequest;
import com.box.android.domain.configuration.FeatureFlips;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class AnnotationsRemoteDataSource_Factory implements Factory<AnnotationsRemoteDataSource> {
    private final Provider<AnnotationsRequest> annotationsRequestProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<Moshi> moshiProvider;

    private AnnotationsRemoteDataSource_Factory(Provider<AnnotationsRequest> annotationsRequestProvider, Provider<Moshi> moshiProvider, Provider<FeatureFlips> featureFlipsProvider) {
        this.annotationsRequestProvider = annotationsRequestProvider;
        this.moshiProvider = moshiProvider;
        this.featureFlipsProvider = featureFlipsProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AnnotationsRemoteDataSource get() {
        return newInstance(this.annotationsRequestProvider.get(), this.moshiProvider.get(), this.featureFlipsProvider.get());
    }

    public static AnnotationsRemoteDataSource_Factory create(Provider<AnnotationsRequest> annotationsRequestProvider, Provider<Moshi> moshiProvider, Provider<FeatureFlips> featureFlipsProvider) {
        return new AnnotationsRemoteDataSource_Factory(annotationsRequestProvider, moshiProvider, featureFlipsProvider);
    }

    public static AnnotationsRemoteDataSource newInstance(AnnotationsRequest annotationsRequest, Moshi moshi, FeatureFlips featureFlips) {
        return new AnnotationsRemoteDataSource(annotationsRequest, moshi, featureFlips);
    }
}
