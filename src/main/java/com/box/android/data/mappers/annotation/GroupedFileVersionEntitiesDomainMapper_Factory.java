package com.box.android.data.mappers.annotation;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GroupedFileVersionEntitiesDomainMapper_Factory implements Factory<GroupedFileVersionEntitiesDomainMapper> {
    private final Provider<Moshi> moshiProvider;

    private GroupedFileVersionEntitiesDomainMapper_Factory(Provider<Moshi> moshiProvider) {
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GroupedFileVersionEntitiesDomainMapper get() {
        return newInstance(this.moshiProvider.get());
    }

    public static GroupedFileVersionEntitiesDomainMapper_Factory create(Provider<Moshi> moshiProvider) {
        return new GroupedFileVersionEntitiesDomainMapper_Factory(moshiProvider);
    }

    public static GroupedFileVersionEntitiesDomainMapper newInstance(Moshi moshi) {
        return new GroupedFileVersionEntitiesDomainMapper(moshi);
    }
}
