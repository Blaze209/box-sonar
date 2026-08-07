package com.box.android.data.datasource.files;

import com.box.android.data.api.requests.PreflightCheckRequest;
import com.box.android.data.api.requests.UploadFileRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UploadFileRemoteDataSource_Factory implements Factory<UploadFileRemoteDataSource> {
    private final Provider<Moshi> moshiProvider;
    private final Provider<PreflightCheckRequest> preflightCheckRequestProvider;
    private final Provider<UploadFileRequest> uploadFileRequestProvider;

    private UploadFileRemoteDataSource_Factory(Provider<UploadFileRequest> uploadFileRequestProvider, Provider<PreflightCheckRequest> preflightCheckRequestProvider, Provider<Moshi> moshiProvider) {
        this.uploadFileRequestProvider = uploadFileRequestProvider;
        this.preflightCheckRequestProvider = preflightCheckRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UploadFileRemoteDataSource get() {
        return newInstance(this.uploadFileRequestProvider.get(), this.preflightCheckRequestProvider.get(), this.moshiProvider.get());
    }

    public static UploadFileRemoteDataSource_Factory create(Provider<UploadFileRequest> uploadFileRequestProvider, Provider<PreflightCheckRequest> preflightCheckRequestProvider, Provider<Moshi> moshiProvider) {
        return new UploadFileRemoteDataSource_Factory(uploadFileRequestProvider, preflightCheckRequestProvider, moshiProvider);
    }

    public static UploadFileRemoteDataSource newInstance(UploadFileRequest uploadFileRequest, PreflightCheckRequest preflightCheckRequest, Moshi moshi) {
        return new UploadFileRemoteDataSource(uploadFileRequest, preflightCheckRequest, moshi);
    }
}
