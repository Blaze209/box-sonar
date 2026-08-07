package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.datasource.PreviewDownloadRemoteDataSource;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.preview.PreviewerTypeResolver;
import com.box.android.domain.services.IAnnotationsService;
import com.box.android.domain.services.IFileActivitiesService;
import com.box.android.domain.services.IFileWithRepresentationsService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IRepresentationsService;
import com.squareup.moshi.Moshi;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1333MarkForOfflineJob_Factory {
    private final Provider<IAnnotationsService> annotationsServiceProvider;
    private final Provider<Context> appContextProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IFileActivitiesService> fileActivitiesServiceProvider;
    private final Provider<IFileWithRepresentationsService> fileWithRepresentationsServiceProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<PreviewDownloadRemoteDataSource> previewDownloadRemoteDataSourceProvider;
    private final Provider<PreviewerTypeResolver> previewerTypeResolverProvider;
    private final Provider<IRemoteItemService> remoteItemServiceProvider;
    private final Provider<IRepresentationsService> representationsServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private C1333MarkForOfflineJob_Factory(Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<IRemoteItemService> remoteItemServiceProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<IFileWithRepresentationsService> fileWithRepresentationsServiceProvider, Provider<IRepresentationsService> representationsServiceProvider, Provider<PreviewerTypeResolver> previewerTypeResolverProvider, Provider<PreviewDownloadRemoteDataSource> previewDownloadRemoteDataSourceProvider, Provider<IAnnotationsService> annotationsServiceProvider, Provider<IFileActivitiesService> fileActivitiesServiceProvider, Provider<FeatureFlips> featureFlipsProvider) {
        this.moshiProvider = moshiProvider;
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
        this.remoteItemServiceProvider = remoteItemServiceProvider;
        this.userContextManagerProvider = userContextManagerProvider;
        this.fileWithRepresentationsServiceProvider = fileWithRepresentationsServiceProvider;
        this.representationsServiceProvider = representationsServiceProvider;
        this.previewerTypeResolverProvider = previewerTypeResolverProvider;
        this.previewDownloadRemoteDataSourceProvider = previewDownloadRemoteDataSourceProvider;
        this.annotationsServiceProvider = annotationsServiceProvider;
        this.fileActivitiesServiceProvider = fileActivitiesServiceProvider;
        this.featureFlipsProvider = featureFlipsProvider;
    }

    public MarkForOfflineJob get(JobId jobId, Data inputData) {
        return newInstance(this.moshiProvider.get(), jobId, inputData, this.appContextProvider.get(), this.jobServiceProvider.get(), this.remoteItemServiceProvider.get(), this.userContextManagerProvider.get(), this.fileWithRepresentationsServiceProvider.get(), this.representationsServiceProvider.get(), this.previewerTypeResolverProvider.get(), this.previewDownloadRemoteDataSourceProvider.get(), this.annotationsServiceProvider.get(), this.fileActivitiesServiceProvider.get(), this.featureFlipsProvider.get());
    }

    public static C1333MarkForOfflineJob_Factory create(Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<IRemoteItemService> remoteItemServiceProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<IFileWithRepresentationsService> fileWithRepresentationsServiceProvider, Provider<IRepresentationsService> representationsServiceProvider, Provider<PreviewerTypeResolver> previewerTypeResolverProvider, Provider<PreviewDownloadRemoteDataSource> previewDownloadRemoteDataSourceProvider, Provider<IAnnotationsService> annotationsServiceProvider, Provider<IFileActivitiesService> fileActivitiesServiceProvider, Provider<FeatureFlips> featureFlipsProvider) {
        return new C1333MarkForOfflineJob_Factory(moshiProvider, appContextProvider, jobServiceProvider, remoteItemServiceProvider, userContextManagerProvider, fileWithRepresentationsServiceProvider, representationsServiceProvider, previewerTypeResolverProvider, previewDownloadRemoteDataSourceProvider, annotationsServiceProvider, fileActivitiesServiceProvider, featureFlipsProvider);
    }

    public static MarkForOfflineJob newInstance(Moshi moshi, JobId jobId, Data inputData, Context appContext, JobService jobService, IRemoteItemService remoteItemService, IUserContextManager userContextManager, IFileWithRepresentationsService fileWithRepresentationsService, IRepresentationsService representationsService, PreviewerTypeResolver previewerTypeResolver, PreviewDownloadRemoteDataSource previewDownloadRemoteDataSource, IAnnotationsService annotationsService, IFileActivitiesService fileActivitiesService, FeatureFlips featureFlips) {
        return new MarkForOfflineJob(moshi, jobId, inputData, appContext, jobService, remoteItemService, userContextManager, fileWithRepresentationsService, representationsService, previewerTypeResolver, previewDownloadRemoteDataSource, annotationsService, fileActivitiesService, featureFlips);
    }
}
