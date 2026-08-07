package com.box.android.data.mappers.annotation;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class AnnotationDTOEntityMapper_Factory implements Factory<AnnotationDTOEntityMapper> {
    private final Provider<FileActivityStatusDTOEntityMapper> fileActivityStatusDTOEntityMapperProvider;
    private final Provider<Moshi> moshiProvider;

    private AnnotationDTOEntityMapper_Factory(Provider<Moshi> moshiProvider, Provider<FileActivityStatusDTOEntityMapper> fileActivityStatusDTOEntityMapperProvider) {
        this.moshiProvider = moshiProvider;
        this.fileActivityStatusDTOEntityMapperProvider = fileActivityStatusDTOEntityMapperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AnnotationDTOEntityMapper get() {
        return newInstance(this.moshiProvider.get(), this.fileActivityStatusDTOEntityMapperProvider.get());
    }

    public static AnnotationDTOEntityMapper_Factory create(Provider<Moshi> moshiProvider, Provider<FileActivityStatusDTOEntityMapper> fileActivityStatusDTOEntityMapperProvider) {
        return new AnnotationDTOEntityMapper_Factory(moshiProvider, fileActivityStatusDTOEntityMapperProvider);
    }

    public static AnnotationDTOEntityMapper newInstance(Moshi moshi, FileActivityStatusDTOEntityMapper fileActivityStatusDTOEntityMapper) {
        return new AnnotationDTOEntityMapper(moshi, fileActivityStatusDTOEntityMapper);
    }
}
