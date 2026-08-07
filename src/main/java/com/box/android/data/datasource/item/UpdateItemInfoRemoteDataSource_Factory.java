package com.box.android.data.datasource.item;

import com.box.android.data.api.requests.UpdateItemInfoRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UpdateItemInfoRemoteDataSource_Factory implements Factory<UpdateItemInfoRemoteDataSource> {
    private final Provider<Moshi> moshiProvider;
    private final Provider<UpdateItemInfoRequest> updateItemInfoRequestProvider;

    private UpdateItemInfoRemoteDataSource_Factory(Provider<UpdateItemInfoRequest> updateItemInfoRequestProvider, Provider<Moshi> moshiProvider) {
        this.updateItemInfoRequestProvider = updateItemInfoRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateItemInfoRemoteDataSource get() {
        return newInstance(this.updateItemInfoRequestProvider.get(), this.moshiProvider.get());
    }

    public static UpdateItemInfoRemoteDataSource_Factory create(Provider<UpdateItemInfoRequest> updateItemInfoRequestProvider, Provider<Moshi> moshiProvider) {
        return new UpdateItemInfoRemoteDataSource_Factory(updateItemInfoRequestProvider, moshiProvider);
    }

    public static UpdateItemInfoRemoteDataSource newInstance(UpdateItemInfoRequest updateItemInfoRequest, Moshi moshi) {
        return new UpdateItemInfoRemoteDataSource(updateItemInfoRequest, moshi);
    }
}
