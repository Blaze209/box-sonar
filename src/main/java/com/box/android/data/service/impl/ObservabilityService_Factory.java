package com.box.android.data.service.impl;

import com.box.android.data.datasource.auth.AuthenticationRemoteDataSource;
import com.box.android.data.datasource.clientsettings.ClientSettingsRemoteDataSource;
import com.box.android.data.datasource.files.UploadFileRemoteDataSource;
import com.box.android.data.datasource.observability.LogsCacheDataSource;
import com.box.android.domain.services.IAuthenticationCredentialsProvider;
import com.box.android.domain.services.IAuthenticationService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ObservabilityService_Factory implements Factory<ObservabilityService> {
    private final Provider<IAuthenticationCredentialsProvider> authenticationCredentialsProvider;
    private final Provider<AuthenticationRemoteDataSource> authenticationRemoteDataSourceProvider;
    private final Provider<IAuthenticationService> authenticationServiceProvider;
    private final Provider<ClientSettingsRemoteDataSource> clientSettingsRemoteDataSourceProvider;
    private final Provider<LogsCacheDataSource> logsCacheDataSourceProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UploadFileRemoteDataSource> uploadFileRemoteDataSourceProvider;

    private ObservabilityService_Factory(Provider<IAuthenticationService> authenticationServiceProvider, Provider<AuthenticationRemoteDataSource> authenticationRemoteDataSourceProvider, Provider<ClientSettingsRemoteDataSource> clientSettingsRemoteDataSourceProvider, Provider<UploadFileRemoteDataSource> uploadFileRemoteDataSourceProvider, Provider<IAuthenticationCredentialsProvider> authenticationCredentialsProvider, Provider<LogsCacheDataSource> logsCacheDataSourceProvider, Provider<SessionManager> sessionManagerProvider) {
        this.authenticationServiceProvider = authenticationServiceProvider;
        this.authenticationRemoteDataSourceProvider = authenticationRemoteDataSourceProvider;
        this.clientSettingsRemoteDataSourceProvider = clientSettingsRemoteDataSourceProvider;
        this.uploadFileRemoteDataSourceProvider = uploadFileRemoteDataSourceProvider;
        this.authenticationCredentialsProvider = authenticationCredentialsProvider;
        this.logsCacheDataSourceProvider = logsCacheDataSourceProvider;
        this.sessionManagerProvider = sessionManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ObservabilityService get() {
        return newInstance(this.authenticationServiceProvider.get(), this.authenticationRemoteDataSourceProvider.get(), this.clientSettingsRemoteDataSourceProvider.get(), this.uploadFileRemoteDataSourceProvider.get(), this.authenticationCredentialsProvider.get(), this.logsCacheDataSourceProvider.get(), this.sessionManagerProvider.get());
    }

    public static ObservabilityService_Factory create(Provider<IAuthenticationService> authenticationServiceProvider, Provider<AuthenticationRemoteDataSource> authenticationRemoteDataSourceProvider, Provider<ClientSettingsRemoteDataSource> clientSettingsRemoteDataSourceProvider, Provider<UploadFileRemoteDataSource> uploadFileRemoteDataSourceProvider, Provider<IAuthenticationCredentialsProvider> authenticationCredentialsProvider, Provider<LogsCacheDataSource> logsCacheDataSourceProvider, Provider<SessionManager> sessionManagerProvider) {
        return new ObservabilityService_Factory(authenticationServiceProvider, authenticationRemoteDataSourceProvider, clientSettingsRemoteDataSourceProvider, uploadFileRemoteDataSourceProvider, authenticationCredentialsProvider, logsCacheDataSourceProvider, sessionManagerProvider);
    }

    public static ObservabilityService newInstance(IAuthenticationService authenticationService, AuthenticationRemoteDataSource authenticationRemoteDataSource, ClientSettingsRemoteDataSource clientSettingsRemoteDataSource, UploadFileRemoteDataSource uploadFileRemoteDataSource, IAuthenticationCredentialsProvider authenticationCredentialsProvider, LogsCacheDataSource logsCacheDataSource, SessionManager sessionManager) {
        return new ObservabilityService(authenticationService, authenticationRemoteDataSource, clientSettingsRemoteDataSource, uploadFileRemoteDataSource, authenticationCredentialsProvider, logsCacheDataSource, sessionManager);
    }
}
