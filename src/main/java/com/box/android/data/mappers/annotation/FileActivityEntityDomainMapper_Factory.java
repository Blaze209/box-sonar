package com.box.android.data.mappers.annotation;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FileActivityEntityDomainMapper_Factory implements Factory<FileActivityEntityDomainMapper> {
    private final Provider<AnnotationEntityDomainMapper> annotationEntityDomainMapperProvider;
    private final Provider<CommentEntityDomainMapper> commentEntityDomainMapperProvider;
    private final Provider<GroupedFileVersionEntitiesDomainMapper> groupedFileVersionEntitiesDomainMapperProvider;

    private FileActivityEntityDomainMapper_Factory(Provider<CommentEntityDomainMapper> commentEntityDomainMapperProvider, Provider<GroupedFileVersionEntitiesDomainMapper> groupedFileVersionEntitiesDomainMapperProvider, Provider<AnnotationEntityDomainMapper> annotationEntityDomainMapperProvider) {
        this.commentEntityDomainMapperProvider = commentEntityDomainMapperProvider;
        this.groupedFileVersionEntitiesDomainMapperProvider = groupedFileVersionEntitiesDomainMapperProvider;
        this.annotationEntityDomainMapperProvider = annotationEntityDomainMapperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileActivityEntityDomainMapper get() {
        return newInstance(this.commentEntityDomainMapperProvider.get(), this.groupedFileVersionEntitiesDomainMapperProvider.get(), this.annotationEntityDomainMapperProvider.get());
    }

    public static FileActivityEntityDomainMapper_Factory create(Provider<CommentEntityDomainMapper> commentEntityDomainMapperProvider, Provider<GroupedFileVersionEntitiesDomainMapper> groupedFileVersionEntitiesDomainMapperProvider, Provider<AnnotationEntityDomainMapper> annotationEntityDomainMapperProvider) {
        return new FileActivityEntityDomainMapper_Factory(commentEntityDomainMapperProvider, groupedFileVersionEntitiesDomainMapperProvider, annotationEntityDomainMapperProvider);
    }

    public static FileActivityEntityDomainMapper newInstance(CommentEntityDomainMapper commentEntityDomainMapper, GroupedFileVersionEntitiesDomainMapper groupedFileVersionEntitiesDomainMapper, AnnotationEntityDomainMapper annotationEntityDomainMapper) {
        return new FileActivityEntityDomainMapper(commentEntityDomainMapper, groupedFileVersionEntitiesDomainMapper, annotationEntityDomainMapper);
    }
}
