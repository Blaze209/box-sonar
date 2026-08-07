package com.box.android.data.mappers.representations;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class RepresentationDTOEntityMapper_Factory implements Factory<RepresentationDTOEntityMapper> {
    private final Provider<Moshi> moshiProvider;

    private RepresentationDTOEntityMapper_Factory(Provider<Moshi> moshiProvider) {
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RepresentationDTOEntityMapper get() {
        return newInstance(this.moshiProvider.get());
    }

    public static RepresentationDTOEntityMapper_Factory create(Provider<Moshi> moshiProvider) {
        return new RepresentationDTOEntityMapper_Factory(moshiProvider);
    }

    public static RepresentationDTOEntityMapper newInstance(Moshi moshi) {
        return new RepresentationDTOEntityMapper(moshi);
    }
}
