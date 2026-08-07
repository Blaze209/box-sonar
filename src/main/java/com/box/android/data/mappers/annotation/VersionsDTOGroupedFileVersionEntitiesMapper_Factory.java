package com.box.android.data.mappers.annotation;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class VersionsDTOGroupedFileVersionEntitiesMapper_Factory implements Factory<VersionsDTOGroupedFileVersionEntitiesMapper> {
    private final Provider<FileVersionDTOV1EntityMapper> fileVersionDTOV1EntityMapperProvider;
    private final Provider<VersionsDTOGroupedFileVersionsEntityMapper> versionsDTOGroupedFileVersionsEntityMapperProvider;

    private VersionsDTOGroupedFileVersionEntitiesMapper_Factory(Provider<FileVersionDTOV1EntityMapper> fileVersionDTOV1EntityMapperProvider, Provider<VersionsDTOGroupedFileVersionsEntityMapper> versionsDTOGroupedFileVersionsEntityMapperProvider) {
        this.fileVersionDTOV1EntityMapperProvider = fileVersionDTOV1EntityMapperProvider;
        this.versionsDTOGroupedFileVersionsEntityMapperProvider = versionsDTOGroupedFileVersionsEntityMapperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public VersionsDTOGroupedFileVersionEntitiesMapper get() {
        return newInstance(this.fileVersionDTOV1EntityMapperProvider.get(), this.versionsDTOGroupedFileVersionsEntityMapperProvider.get());
    }

    public static VersionsDTOGroupedFileVersionEntitiesMapper_Factory create(Provider<FileVersionDTOV1EntityMapper> fileVersionDTOV1EntityMapperProvider, Provider<VersionsDTOGroupedFileVersionsEntityMapper> versionsDTOGroupedFileVersionsEntityMapperProvider) {
        return new VersionsDTOGroupedFileVersionEntitiesMapper_Factory(fileVersionDTOV1EntityMapperProvider, versionsDTOGroupedFileVersionsEntityMapperProvider);
    }

    public static VersionsDTOGroupedFileVersionEntitiesMapper newInstance(FileVersionDTOV1EntityMapper fileVersionDTOV1EntityMapper, VersionsDTOGroupedFileVersionsEntityMapper versionsDTOGroupedFileVersionsEntityMapper) {
        return new VersionsDTOGroupedFileVersionEntitiesMapper(fileVersionDTOV1EntityMapper, versionsDTOGroupedFileVersionsEntityMapper);
    }
}
