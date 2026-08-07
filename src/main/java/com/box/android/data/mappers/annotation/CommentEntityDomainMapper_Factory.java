package com.box.android.data.mappers.annotation;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CommentEntityDomainMapper_Factory implements Factory<CommentEntityDomainMapper> {
    private final Provider<CommentDTODomainMapper> commentDTODomainMapperProvider;
    private final Provider<Moshi> moshiProvider;

    private CommentEntityDomainMapper_Factory(Provider<Moshi> moshiProvider, Provider<CommentDTODomainMapper> commentDTODomainMapperProvider) {
        this.moshiProvider = moshiProvider;
        this.commentDTODomainMapperProvider = commentDTODomainMapperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CommentEntityDomainMapper get() {
        return newInstance(this.moshiProvider.get(), this.commentDTODomainMapperProvider.get());
    }

    public static CommentEntityDomainMapper_Factory create(Provider<Moshi> moshiProvider, Provider<CommentDTODomainMapper> commentDTODomainMapperProvider) {
        return new CommentEntityDomainMapper_Factory(moshiProvider, commentDTODomainMapperProvider);
    }

    public static CommentEntityDomainMapper newInstance(Moshi moshi, CommentDTODomainMapper commentDTODomainMapper) {
        return new CommentEntityDomainMapper(moshi, commentDTODomainMapper);
    }
}
