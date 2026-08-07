package com.box.android.data.mappers.annotation;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FileActivityDTOEntityMapper_Factory implements Factory<FileActivityDTOEntityMapper> {
    private final Provider<AnnotationDTOEntityMapper> annotationDTOEntityMapperProvider;
    private final Provider<CommentDTOEntityMapper> commentDTOEntityMapperProvider;
    private final Provider<VersionsDTOGroupedFileVersionEntitiesMapper> versionsDTOGroupedFileVersionEntitiesMapperProvider;

    private FileActivityDTOEntityMapper_Factory(Provider<AnnotationDTOEntityMapper> annotationDTOEntityMapperProvider, Provider<CommentDTOEntityMapper> commentDTOEntityMapperProvider, Provider<VersionsDTOGroupedFileVersionEntitiesMapper> versionsDTOGroupedFileVersionEntitiesMapperProvider) {
        this.annotationDTOEntityMapperProvider = annotationDTOEntityMapperProvider;
        this.commentDTOEntityMapperProvider = commentDTOEntityMapperProvider;
        this.versionsDTOGroupedFileVersionEntitiesMapperProvider = versionsDTOGroupedFileVersionEntitiesMapperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileActivityDTOEntityMapper get() {
        return newInstance(this.annotationDTOEntityMapperProvider.get(), this.commentDTOEntityMapperProvider.get(), this.versionsDTOGroupedFileVersionEntitiesMapperProvider.get());
    }

    public static FileActivityDTOEntityMapper_Factory create(Provider<AnnotationDTOEntityMapper> annotationDTOEntityMapperProvider, Provider<CommentDTOEntityMapper> commentDTOEntityMapperProvider, Provider<VersionsDTOGroupedFileVersionEntitiesMapper> versionsDTOGroupedFileVersionEntitiesMapperProvider) {
        return new FileActivityDTOEntityMapper_Factory(annotationDTOEntityMapperProvider, commentDTOEntityMapperProvider, versionsDTOGroupedFileVersionEntitiesMapperProvider);
    }

    public static FileActivityDTOEntityMapper newInstance(AnnotationDTOEntityMapper annotationDTOEntityMapper, CommentDTOEntityMapper commentDTOEntityMapper, VersionsDTOGroupedFileVersionEntitiesMapper versionsDTOGroupedFileVersionEntitiesMapper) {
        return new FileActivityDTOEntityMapper(annotationDTOEntityMapper, commentDTOEntityMapper, versionsDTOGroupedFileVersionEntitiesMapper);
    }
}
