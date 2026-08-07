package com.box.android.data.datasource.files;

import com.box.android.data.api.requests.DeleteItemRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DeleteFileRemoteDataSource_Factory implements Factory<DeleteFileRemoteDataSource> {
    private final Provider<DeleteItemRequest> deleteItemRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private DeleteFileRemoteDataSource_Factory(Provider<DeleteItemRequest> deleteItemRequestProvider, Provider<Moshi> moshiProvider) {
        this.deleteItemRequestProvider = deleteItemRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteFileRemoteDataSource get() {
        return newInstance(this.deleteItemRequestProvider.get(), this.moshiProvider.get());
    }

    public static DeleteFileRemoteDataSource_Factory create(Provider<DeleteItemRequest> deleteItemRequestProvider, Provider<Moshi> moshiProvider) {
        return new DeleteFileRemoteDataSource_Factory(deleteItemRequestProvider, moshiProvider);
    }

    public static DeleteFileRemoteDataSource newInstance(DeleteItemRequest deleteItemRequest, Moshi moshi) {
        return new DeleteFileRemoteDataSource(deleteItemRequest, moshi);
    }
}
