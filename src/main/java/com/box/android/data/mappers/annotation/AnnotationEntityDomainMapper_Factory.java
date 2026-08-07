package com.box.android.data.mappers.annotation;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class AnnotationEntityDomainMapper_Factory implements Factory<AnnotationEntityDomainMapper> {
    private final Provider<CommentEntityDomainMapper> commentEntityDomainMapperProvider;
    private final Provider<Moshi> moshiProvider;

    private AnnotationEntityDomainMapper_Factory(Provider<Moshi> moshiProvider, Provider<CommentEntityDomainMapper> commentEntityDomainMapperProvider) {
        this.moshiProvider = moshiProvider;
        this.commentEntityDomainMapperProvider = commentEntityDomainMapperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AnnotationEntityDomainMapper get() {
        return newInstance(this.moshiProvider.get(), this.commentEntityDomainMapperProvider.get());
    }

    public static AnnotationEntityDomainMapper_Factory create(Provider<Moshi> moshiProvider, Provider<CommentEntityDomainMapper> commentEntityDomainMapperProvider) {
        return new AnnotationEntityDomainMapper_Factory(moshiProvider, commentEntityDomainMapperProvider);
    }

    public static AnnotationEntityDomainMapper newInstance(Moshi moshi, CommentEntityDomainMapper commentEntityDomainMapper) {
        return new AnnotationEntityDomainMapper(moshi, commentEntityDomainMapper);
    }
}
