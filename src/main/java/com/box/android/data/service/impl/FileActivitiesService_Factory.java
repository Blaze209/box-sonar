package com.box.android.data.service.impl;

import com.box.android.data.datasource.annotations.FileActivityCacheDataSource;
import com.box.android.data.datasource.annotations.FileActivityRemoteDataSource;
import com.box.android.data.mappers.annotation.CommentDTOEntityMapper;
import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import com.box.android.data.mappers.annotation.FileActivityDTOEntityMapper;
import com.box.android.data.mappers.annotation.FileActivityEntityDomainMapper;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FileActivitiesService_Factory implements Factory<FileActivitiesService> {
    private final Provider<CommentDTOEntityMapper> commentDTOEntityMapperProvider;
    private final Provider<CommentEntityDomainMapper> commentEntityDomainMapperProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<FileActivityCacheDataSource> fileActivitiesCacheDataSourceProvider;
    private final Provider<FileActivityDTOEntityMapper> fileActivitiesDTOEntityMapperProvider;
    private final Provider<FileActivityRemoteDataSource> fileActivitiesRemoteDataSourceProvider;
    private final Provider<FileActivityEntityDomainMapper> fileActivityEntityDomainMapperProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<LocalItemService> itemServiceProvider;

    private FileActivitiesService_Factory(Provider<FileActivityRemoteDataSource> fileActivitiesRemoteDataSourceProvider, Provider<FileActivityCacheDataSource> fileActivitiesCacheDataSourceProvider, Provider<LocalItemService> itemServiceProvider, Provider<FileActivityDTOEntityMapper> fileActivitiesDTOEntityMapperProvider, Provider<FileActivityEntityDomainMapper> fileActivityEntityDomainMapperProvider, Provider<CommentDTOEntityMapper> commentDTOEntityMapperProvider, Provider<CommentEntityDomainMapper> commentEntityDomainMapperProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<FeatureFlips> featureFlipsProvider) {
        this.fileActivitiesRemoteDataSourceProvider = fileActivitiesRemoteDataSourceProvider;
        this.fileActivitiesCacheDataSourceProvider = fileActivitiesCacheDataSourceProvider;
        this.itemServiceProvider = itemServiceProvider;
        this.fileActivitiesDTOEntityMapperProvider = fileActivitiesDTOEntityMapperProvider;
        this.fileActivityEntityDomainMapperProvider = fileActivityEntityDomainMapperProvider;
        this.commentDTOEntityMapperProvider = commentDTOEntityMapperProvider;
        this.commentEntityDomainMapperProvider = commentEntityDomainMapperProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.featureFlipsProvider = featureFlipsProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileActivitiesService get() {
        return newInstance(this.fileActivitiesRemoteDataSourceProvider.get(), this.fileActivitiesCacheDataSourceProvider.get(), this.itemServiceProvider.get(), this.fileActivitiesDTOEntityMapperProvider.get(), this.fileActivityEntityDomainMapperProvider.get(), this.commentDTOEntityMapperProvider.get(), this.commentEntityDomainMapperProvider.get(), this.idMappingServiceProvider.get(), this.featureFlipsProvider.get());
    }

    public static FileActivitiesService_Factory create(Provider<FileActivityRemoteDataSource> fileActivitiesRemoteDataSourceProvider, Provider<FileActivityCacheDataSource> fileActivitiesCacheDataSourceProvider, Provider<LocalItemService> itemServiceProvider, Provider<FileActivityDTOEntityMapper> fileActivitiesDTOEntityMapperProvider, Provider<FileActivityEntityDomainMapper> fileActivityEntityDomainMapperProvider, Provider<CommentDTOEntityMapper> commentDTOEntityMapperProvider, Provider<CommentEntityDomainMapper> commentEntityDomainMapperProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<FeatureFlips> featureFlipsProvider) {
        return new FileActivitiesService_Factory(fileActivitiesRemoteDataSourceProvider, fileActivitiesCacheDataSourceProvider, itemServiceProvider, fileActivitiesDTOEntityMapperProvider, fileActivityEntityDomainMapperProvider, commentDTOEntityMapperProvider, commentEntityDomainMapperProvider, idMappingServiceProvider, featureFlipsProvider);
    }

    public static FileActivitiesService newInstance(FileActivityRemoteDataSource fileActivitiesRemoteDataSource, FileActivityCacheDataSource fileActivitiesCacheDataSource, LocalItemService itemService, FileActivityDTOEntityMapper fileActivitiesDTOEntityMapper, FileActivityEntityDomainMapper fileActivityEntityDomainMapper, CommentDTOEntityMapper commentDTOEntityMapper, CommentEntityDomainMapper commentEntityDomainMapper, IdMappingService idMappingService, FeatureFlips featureFlips) {
        return new FileActivitiesService(fileActivitiesRemoteDataSource, fileActivitiesCacheDataSource, itemService, fileActivitiesDTOEntityMapper, fileActivityEntityDomainMapper, commentDTOEntityMapper, commentEntityDomainMapper, idMappingService, featureFlips);
    }
}
