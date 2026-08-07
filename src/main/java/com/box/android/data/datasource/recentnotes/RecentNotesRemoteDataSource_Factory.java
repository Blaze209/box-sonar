package com.box.android.data.datasource.recentnotes;

import com.box.android.data.api.requests.RecentNotesRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class RecentNotesRemoteDataSource_Factory implements Factory<RecentNotesRemoteDataSource> {
    private final Provider<Moshi> moshiProvider;
    private final Provider<RecentNotesRequest> recentNotesRequestProvider;

    private RecentNotesRemoteDataSource_Factory(Provider<RecentNotesRequest> recentNotesRequestProvider, Provider<Moshi> moshiProvider) {
        this.recentNotesRequestProvider = recentNotesRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecentNotesRemoteDataSource get() {
        return newInstance(this.recentNotesRequestProvider.get(), this.moshiProvider.get());
    }

    public static RecentNotesRemoteDataSource_Factory create(Provider<RecentNotesRequest> recentNotesRequestProvider, Provider<Moshi> moshiProvider) {
        return new RecentNotesRemoteDataSource_Factory(recentNotesRequestProvider, moshiProvider);
    }

    public static RecentNotesRemoteDataSource newInstance(RecentNotesRequest recentNotesRequest, Moshi moshi) {
        return new RecentNotesRemoteDataSource(recentNotesRequest, moshi);
    }
}
