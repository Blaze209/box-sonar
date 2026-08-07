package com.box.android.data.datasource.notes;

import com.box.android.data.api.requests.DefaultNoteFolderRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultNoteFolderRemoteDataSource_Factory implements Factory<DefaultNoteFolderRemoteDataSource> {
    private final Provider<DefaultNoteFolderRequest> defaultNoteFolderRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private DefaultNoteFolderRemoteDataSource_Factory(Provider<DefaultNoteFolderRequest> defaultNoteFolderRequestProvider, Provider<Moshi> moshiProvider) {
        this.defaultNoteFolderRequestProvider = defaultNoteFolderRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DefaultNoteFolderRemoteDataSource get() {
        return newInstance(this.defaultNoteFolderRequestProvider.get(), this.moshiProvider.get());
    }

    public static DefaultNoteFolderRemoteDataSource_Factory create(Provider<DefaultNoteFolderRequest> defaultNoteFolderRequestProvider, Provider<Moshi> moshiProvider) {
        return new DefaultNoteFolderRemoteDataSource_Factory(defaultNoteFolderRequestProvider, moshiProvider);
    }

    public static DefaultNoteFolderRemoteDataSource newInstance(DefaultNoteFolderRequest defaultNoteFolderRequest, Moshi moshi) {
        return new DefaultNoteFolderRemoteDataSource(defaultNoteFolderRequest, moshi);
    }
}
