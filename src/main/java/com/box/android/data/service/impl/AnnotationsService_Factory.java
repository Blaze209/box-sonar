package com.box.android.data.service.impl;

import com.box.android.data.datasource.annotations.AnnotationsCacheDataSource;
import com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource;
import com.box.android.data.mappers.annotation.AnnotationDTOEntityMapper;
import com.box.android.data.mappers.annotation.AnnotationEntityDomainMapper;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class AnnotationsService_Factory implements Factory<AnnotationsService> {
    private final Provider<AnnotationEntityDomainMapper> annotationEntityDomainMapperProvider;
    private final Provider<AnnotationsCacheDataSource> annotationsCacheDataSourceProvider;
    private final Provider<AnnotationDTOEntityMapper> annotationsDTOEntityMapperProvider;
    private final Provider<AnnotationsRemoteDataSource> annotationsRemoteDataSourceProvider;
    private final Provider<Moshi> moshiProvider;

    private AnnotationsService_Factory(Provider<AnnotationsRemoteDataSource> annotationsRemoteDataSourceProvider, Provider<AnnotationsCacheDataSource> annotationsCacheDataSourceProvider, Provider<AnnotationDTOEntityMapper> annotationsDTOEntityMapperProvider, Provider<AnnotationEntityDomainMapper> annotationEntityDomainMapperProvider, Provider<Moshi> moshiProvider) {
        this.annotationsRemoteDataSourceProvider = annotationsRemoteDataSourceProvider;
        this.annotationsCacheDataSourceProvider = annotationsCacheDataSourceProvider;
        this.annotationsDTOEntityMapperProvider = annotationsDTOEntityMapperProvider;
        this.annotationEntityDomainMapperProvider = annotationEntityDomainMapperProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AnnotationsService get() {
        return newInstance(this.annotationsRemoteDataSourceProvider.get(), this.annotationsCacheDataSourceProvider.get(), this.annotationsDTOEntityMapperProvider.get(), this.annotationEntityDomainMapperProvider.get(), this.moshiProvider.get());
    }

    public static AnnotationsService_Factory create(Provider<AnnotationsRemoteDataSource> annotationsRemoteDataSourceProvider, Provider<AnnotationsCacheDataSource> annotationsCacheDataSourceProvider, Provider<AnnotationDTOEntityMapper> annotationsDTOEntityMapperProvider, Provider<AnnotationEntityDomainMapper> annotationEntityDomainMapperProvider, Provider<Moshi> moshiProvider) {
        return new AnnotationsService_Factory(annotationsRemoteDataSourceProvider, annotationsCacheDataSourceProvider, annotationsDTOEntityMapperProvider, annotationEntityDomainMapperProvider, moshiProvider);
    }

    public static AnnotationsService newInstance(AnnotationsRemoteDataSource annotationsRemoteDataSource, AnnotationsCacheDataSource annotationsCacheDataSource, AnnotationDTOEntityMapper annotationsDTOEntityMapper, AnnotationEntityDomainMapper annotationEntityDomainMapper, Moshi moshi) {
        return new AnnotationsService(annotationsRemoteDataSource, annotationsCacheDataSource, annotationsDTOEntityMapper, annotationEntityDomainMapper, moshi);
    }
}
