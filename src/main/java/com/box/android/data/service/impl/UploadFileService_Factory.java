package com.box.android.data.service.impl;

import com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource;
import com.box.android.data.datasource.files.UploadFileRemoteDataSource;
import com.box.android.domain.configuration.UserSessionInfo;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UploadFileService_Factory implements Factory<UploadFileService> {
    private final Provider<ChunkedFileUploadRemoteDataSource> chunkedFileUploadRemoteDataSourceProvider;
    private final Provider<CommonServiceUtils> commonServiceUtilsProvider;
    private final Provider<UploadFileRemoteDataSource> uploadFileRemoteDataSourceProvider;
    private final Provider<UserSessionInfo> userSessionInfoProvider;

    private UploadFileService_Factory(Provider<UploadFileRemoteDataSource> uploadFileRemoteDataSourceProvider, Provider<ChunkedFileUploadRemoteDataSource> chunkedFileUploadRemoteDataSourceProvider, Provider<UserSessionInfo> userSessionInfoProvider, Provider<CommonServiceUtils> commonServiceUtilsProvider) {
        this.uploadFileRemoteDataSourceProvider = uploadFileRemoteDataSourceProvider;
        this.chunkedFileUploadRemoteDataSourceProvider = chunkedFileUploadRemoteDataSourceProvider;
        this.userSessionInfoProvider = userSessionInfoProvider;
        this.commonServiceUtilsProvider = commonServiceUtilsProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UploadFileService get() {
        return newInstance(this.uploadFileRemoteDataSourceProvider.get(), this.chunkedFileUploadRemoteDataSourceProvider.get(), this.userSessionInfoProvider.get(), this.commonServiceUtilsProvider.get());
    }

    public static UploadFileService_Factory create(Provider<UploadFileRemoteDataSource> uploadFileRemoteDataSourceProvider, Provider<ChunkedFileUploadRemoteDataSource> chunkedFileUploadRemoteDataSourceProvider, Provider<UserSessionInfo> userSessionInfoProvider, Provider<CommonServiceUtils> commonServiceUtilsProvider) {
        return new UploadFileService_Factory(uploadFileRemoteDataSourceProvider, chunkedFileUploadRemoteDataSourceProvider, userSessionInfoProvider, commonServiceUtilsProvider);
    }

    public static UploadFileService newInstance(UploadFileRemoteDataSource uploadFileRemoteDataSource, ChunkedFileUploadRemoteDataSource chunkedFileUploadRemoteDataSource, UserSessionInfo userSessionInfo, CommonServiceUtils commonServiceUtils) {
        return new UploadFileService(uploadFileRemoteDataSource, chunkedFileUploadRemoteDataSource, userSessionInfo, commonServiceUtils);
    }
}
