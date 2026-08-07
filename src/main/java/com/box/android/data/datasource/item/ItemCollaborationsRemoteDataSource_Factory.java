package com.box.android.data.datasource.item;

import com.box.android.data.api.requests.ItemCollaborationsRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ItemCollaborationsRemoteDataSource_Factory implements Factory<ItemCollaborationsRemoteDataSource> {
    private final Provider<ItemCollaborationsRequest> itemCollaborationsRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private ItemCollaborationsRemoteDataSource_Factory(Provider<ItemCollaborationsRequest> itemCollaborationsRequestProvider, Provider<Moshi> moshiProvider) {
        this.itemCollaborationsRequestProvider = itemCollaborationsRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemCollaborationsRemoteDataSource get() {
        return newInstance(this.itemCollaborationsRequestProvider.get(), this.moshiProvider.get());
    }

    public static ItemCollaborationsRemoteDataSource_Factory create(Provider<ItemCollaborationsRequest> itemCollaborationsRequestProvider, Provider<Moshi> moshiProvider) {
        return new ItemCollaborationsRemoteDataSource_Factory(itemCollaborationsRequestProvider, moshiProvider);
    }

    public static ItemCollaborationsRemoteDataSource newInstance(ItemCollaborationsRequest itemCollaborationsRequest, Moshi moshi) {
        return new ItemCollaborationsRemoteDataSource(itemCollaborationsRequest, moshi);
    }
}
