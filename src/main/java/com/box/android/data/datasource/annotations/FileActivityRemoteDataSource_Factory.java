package com.box.android.data.datasource.annotations;

import com.box.android.data.api.requests.FileActivitiesRequest;
import com.box.android.domain.configuration.FeatureFlips;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FileActivityRemoteDataSource_Factory implements Factory<FileActivityRemoteDataSource> {
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<FileActivitiesRequest> fileActivitiesRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private FileActivityRemoteDataSource_Factory(Provider<FileActivitiesRequest> fileActivitiesRequestProvider, Provider<Moshi> moshiProvider, Provider<FeatureFlips> featureFlipsProvider) {
        this.fileActivitiesRequestProvider = fileActivitiesRequestProvider;
        this.moshiProvider = moshiProvider;
        this.featureFlipsProvider = featureFlipsProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileActivityRemoteDataSource get() {
        return newInstance(this.fileActivitiesRequestProvider.get(), this.moshiProvider.get(), this.featureFlipsProvider.get());
    }

    public static FileActivityRemoteDataSource_Factory create(Provider<FileActivitiesRequest> fileActivitiesRequestProvider, Provider<Moshi> moshiProvider, Provider<FeatureFlips> featureFlipsProvider) {
        return new FileActivityRemoteDataSource_Factory(fileActivitiesRequestProvider, moshiProvider, featureFlipsProvider);
    }

    public static FileActivityRemoteDataSource newInstance(FileActivitiesRequest fileActivitiesRequest, Moshi moshi, FeatureFlips featureFlips) {
        return new FileActivityRemoteDataSource(fileActivitiesRequest, moshi, featureFlips);
    }
}
