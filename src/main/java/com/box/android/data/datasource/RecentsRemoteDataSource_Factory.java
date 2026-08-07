package com.box.android.data.datasource;

import com.box.android.data.api.requests.RecentsRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class RecentsRemoteDataSource_Factory implements Factory<RecentsRemoteDataSource> {
    private final Provider<Moshi> moshiProvider;
    private final Provider<RecentsRequest> recentsRequestProvider;

    private RecentsRemoteDataSource_Factory(Provider<RecentsRequest> recentsRequestProvider, Provider<Moshi> moshiProvider) {
        this.recentsRequestProvider = recentsRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecentsRemoteDataSource get() {
        return newInstance(this.recentsRequestProvider.get(), this.moshiProvider.get());
    }

    public static RecentsRemoteDataSource_Factory create(Provider<RecentsRequest> recentsRequestProvider, Provider<Moshi> moshiProvider) {
        return new RecentsRemoteDataSource_Factory(recentsRequestProvider, moshiProvider);
    }

    public static RecentsRemoteDataSource newInstance(RecentsRequest recentsRequest, Moshi moshi) {
        return new RecentsRemoteDataSource(recentsRequest, moshi);
    }
}
