package com.box.android.data.mappers.annotation;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class VersionsDTOGroupedFileVersionsEntityMapper_Factory implements Factory<VersionsDTOGroupedFileVersionsEntityMapper> {
    private final Provider<Moshi> moshiProvider;

    private VersionsDTOGroupedFileVersionsEntityMapper_Factory(Provider<Moshi> moshiProvider) {
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public VersionsDTOGroupedFileVersionsEntityMapper get() {
        return newInstance(this.moshiProvider.get());
    }

    public static VersionsDTOGroupedFileVersionsEntityMapper_Factory create(Provider<Moshi> moshiProvider) {
        return new VersionsDTOGroupedFileVersionsEntityMapper_Factory(moshiProvider);
    }

    public static VersionsDTOGroupedFileVersionsEntityMapper newInstance(Moshi moshi) {
        return new VersionsDTOGroupedFileVersionsEntityMapper(moshi);
    }
}
