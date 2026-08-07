package com.box.android.data.mappers.annotation;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CommentDTOEntityMapper_Factory implements Factory<CommentDTOEntityMapper> {
    private final Provider<FileActivityStatusDTOEntityMapper> activityStatusDTOEntityMapperProvider;
    private final Provider<Moshi> moshiProvider;

    private CommentDTOEntityMapper_Factory(Provider<Moshi> moshiProvider, Provider<FileActivityStatusDTOEntityMapper> activityStatusDTOEntityMapperProvider) {
        this.moshiProvider = moshiProvider;
        this.activityStatusDTOEntityMapperProvider = activityStatusDTOEntityMapperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CommentDTOEntityMapper get() {
        return newInstance(this.moshiProvider.get(), this.activityStatusDTOEntityMapperProvider.get());
    }

    public static CommentDTOEntityMapper_Factory create(Provider<Moshi> moshiProvider, Provider<FileActivityStatusDTOEntityMapper> activityStatusDTOEntityMapperProvider) {
        return new CommentDTOEntityMapper_Factory(moshiProvider, activityStatusDTOEntityMapperProvider);
    }

    public static CommentDTOEntityMapper newInstance(Moshi moshi, FileActivityStatusDTOEntityMapper activityStatusDTOEntityMapper) {
        return new CommentDTOEntityMapper(moshi, activityStatusDTOEntityMapper);
    }
}
