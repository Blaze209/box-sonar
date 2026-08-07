package com.box.android.data.service.impl;

import com.box.android.data.datasource.annotations.FileActivityCacheDataSource;
import com.box.android.data.datasource.comment.CommentCacheDataSource;
import com.box.android.data.datasource.comment.CommentRemoteDataSource;
import com.box.android.data.mappers.annotation.CommentDTODomainMapper;
import com.box.android.data.mappers.annotation.CommentDTOEntityMapper;
import com.box.android.data.mappers.annotation.FileActivityDTOEntityMapper;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CommentService_Factory implements Factory<CommentService> {
    private final Provider<CommentCacheDataSource> commentCacheDataSourceProvider;
    private final Provider<CommentDTODomainMapper> commentDTODomainMapperProvider;
    private final Provider<CommentDTOEntityMapper> commentDTOEntityMapperProvider;
    private final Provider<CommentRemoteDataSource> commentRemoteDataSourceProvider;
    private final Provider<FileActivityCacheDataSource> fileActivitiesCacheDataSourceProvider;
    private final Provider<FileActivityDTOEntityMapper> fileActivityDTOEntityMapperProvider;

    private CommentService_Factory(Provider<CommentRemoteDataSource> commentRemoteDataSourceProvider, Provider<CommentCacheDataSource> commentCacheDataSourceProvider, Provider<CommentDTOEntityMapper> commentDTOEntityMapperProvider, Provider<CommentDTODomainMapper> commentDTODomainMapperProvider, Provider<FileActivityDTOEntityMapper> fileActivityDTOEntityMapperProvider, Provider<FileActivityCacheDataSource> fileActivitiesCacheDataSourceProvider) {
        this.commentRemoteDataSourceProvider = commentRemoteDataSourceProvider;
        this.commentCacheDataSourceProvider = commentCacheDataSourceProvider;
        this.commentDTOEntityMapperProvider = commentDTOEntityMapperProvider;
        this.commentDTODomainMapperProvider = commentDTODomainMapperProvider;
        this.fileActivityDTOEntityMapperProvider = fileActivityDTOEntityMapperProvider;
        this.fileActivitiesCacheDataSourceProvider = fileActivitiesCacheDataSourceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CommentService get() {
        return newInstance(this.commentRemoteDataSourceProvider.get(), this.commentCacheDataSourceProvider.get(), this.commentDTOEntityMapperProvider.get(), this.commentDTODomainMapperProvider.get(), this.fileActivityDTOEntityMapperProvider.get(), this.fileActivitiesCacheDataSourceProvider.get());
    }

    public static CommentService_Factory create(Provider<CommentRemoteDataSource> commentRemoteDataSourceProvider, Provider<CommentCacheDataSource> commentCacheDataSourceProvider, Provider<CommentDTOEntityMapper> commentDTOEntityMapperProvider, Provider<CommentDTODomainMapper> commentDTODomainMapperProvider, Provider<FileActivityDTOEntityMapper> fileActivityDTOEntityMapperProvider, Provider<FileActivityCacheDataSource> fileActivitiesCacheDataSourceProvider) {
        return new CommentService_Factory(commentRemoteDataSourceProvider, commentCacheDataSourceProvider, commentDTOEntityMapperProvider, commentDTODomainMapperProvider, fileActivityDTOEntityMapperProvider, fileActivitiesCacheDataSourceProvider);
    }

    public static CommentService newInstance(CommentRemoteDataSource commentRemoteDataSource, CommentCacheDataSource commentCacheDataSource, CommentDTOEntityMapper commentDTOEntityMapper, CommentDTODomainMapper commentDTODomainMapper, FileActivityDTOEntityMapper fileActivityDTOEntityMapper, FileActivityCacheDataSource fileActivitiesCacheDataSource) {
        return new CommentService(commentRemoteDataSource, commentCacheDataSource, commentDTOEntityMapper, commentDTODomainMapper, fileActivityDTOEntityMapper, fileActivitiesCacheDataSource);
    }
}
