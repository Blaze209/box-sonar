package com.box.android.data.jobs;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class JobFactory_Factory implements Factory<JobFactory> {
    private final Provider<AutoUploadJob.Factory> autoUploadJobFactoryProvider;
    private final Provider<DownloadChunkJob.Factory> chunkDownloadJobFactoryProvider;
    private final Provider<ChunkUploadJob.Factory> chunkUploadJobFactoryProvider;
    private final Provider<CopyItemJob.Factory> copyItemJobFactoryProvider;
    private final Provider<CreateFolderJob.Factory> createFolderJobFactoryProvider;
    private final Provider<DeleteCollaborationJob.Factory> deleteCollaborationJobFactoryProvider;
    private final Provider<DeleteFileJob.Factory> deleteFileJobFactoryProvider;
    private final Provider<DownloadFileJob.Factory> downloadFileJobFactoryProvider;
    private final Provider<DownloadFolderJob.Factory> downloadFolderJobFactoryProvider;
    private final Provider<MarkForOfflineFolderJob.Factory> markOfflineFolderJobFactoryProvider;
    private final Provider<MarkForOfflineJob.Factory> markOfflineJobFactoryProvider;
    private final Provider<MoveItemJob.Factory> moveItemJobFactoryProvider;
    private final Provider<UploadFileJobV2.Factory> uploadFileJobV2FactoryProvider;
    private final Provider<UploadFolderJob.Factory> uploadFolderJobFactoryProvider;

    private JobFactory_Factory(Provider<CreateFolderJob.Factory> createFolderJobFactoryProvider, Provider<UploadFileJobV2.Factory> uploadFileJobV2FactoryProvider, Provider<DeleteFileJob.Factory> deleteFileJobFactoryProvider, Provider<ChunkUploadJob.Factory> chunkUploadJobFactoryProvider, Provider<DownloadFileJob.Factory> downloadFileJobFactoryProvider, Provider<DownloadChunkJob.Factory> chunkDownloadJobFactoryProvider, Provider<DeleteCollaborationJob.Factory> deleteCollaborationJobFactoryProvider, Provider<DownloadFolderJob.Factory> downloadFolderJobFactoryProvider, Provider<UploadFolderJob.Factory> uploadFolderJobFactoryProvider, Provider<MoveItemJob.Factory> moveItemJobFactoryProvider, Provider<CopyItemJob.Factory> copyItemJobFactoryProvider, Provider<AutoUploadJob.Factory> autoUploadJobFactoryProvider, Provider<MarkForOfflineJob.Factory> markOfflineJobFactoryProvider, Provider<MarkForOfflineFolderJob.Factory> markOfflineFolderJobFactoryProvider) {
        this.createFolderJobFactoryProvider = createFolderJobFactoryProvider;
        this.uploadFileJobV2FactoryProvider = uploadFileJobV2FactoryProvider;
        this.deleteFileJobFactoryProvider = deleteFileJobFactoryProvider;
        this.chunkUploadJobFactoryProvider = chunkUploadJobFactoryProvider;
        this.downloadFileJobFactoryProvider = downloadFileJobFactoryProvider;
        this.chunkDownloadJobFactoryProvider = chunkDownloadJobFactoryProvider;
        this.deleteCollaborationJobFactoryProvider = deleteCollaborationJobFactoryProvider;
        this.downloadFolderJobFactoryProvider = downloadFolderJobFactoryProvider;
        this.uploadFolderJobFactoryProvider = uploadFolderJobFactoryProvider;
        this.moveItemJobFactoryProvider = moveItemJobFactoryProvider;
        this.copyItemJobFactoryProvider = copyItemJobFactoryProvider;
        this.autoUploadJobFactoryProvider = autoUploadJobFactoryProvider;
        this.markOfflineJobFactoryProvider = markOfflineJobFactoryProvider;
        this.markOfflineFolderJobFactoryProvider = markOfflineFolderJobFactoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobFactory get() {
        return newInstance(this.createFolderJobFactoryProvider.get(), this.uploadFileJobV2FactoryProvider.get(), this.deleteFileJobFactoryProvider.get(), this.chunkUploadJobFactoryProvider.get(), this.downloadFileJobFactoryProvider.get(), this.chunkDownloadJobFactoryProvider.get(), this.deleteCollaborationJobFactoryProvider.get(), this.downloadFolderJobFactoryProvider.get(), this.uploadFolderJobFactoryProvider.get(), this.moveItemJobFactoryProvider.get(), this.copyItemJobFactoryProvider.get(), this.autoUploadJobFactoryProvider.get(), this.markOfflineJobFactoryProvider.get(), this.markOfflineFolderJobFactoryProvider.get());
    }

    public static JobFactory_Factory create(Provider<CreateFolderJob.Factory> createFolderJobFactoryProvider, Provider<UploadFileJobV2.Factory> uploadFileJobV2FactoryProvider, Provider<DeleteFileJob.Factory> deleteFileJobFactoryProvider, Provider<ChunkUploadJob.Factory> chunkUploadJobFactoryProvider, Provider<DownloadFileJob.Factory> downloadFileJobFactoryProvider, Provider<DownloadChunkJob.Factory> chunkDownloadJobFactoryProvider, Provider<DeleteCollaborationJob.Factory> deleteCollaborationJobFactoryProvider, Provider<DownloadFolderJob.Factory> downloadFolderJobFactoryProvider, Provider<UploadFolderJob.Factory> uploadFolderJobFactoryProvider, Provider<MoveItemJob.Factory> moveItemJobFactoryProvider, Provider<CopyItemJob.Factory> copyItemJobFactoryProvider, Provider<AutoUploadJob.Factory> autoUploadJobFactoryProvider, Provider<MarkForOfflineJob.Factory> markOfflineJobFactoryProvider, Provider<MarkForOfflineFolderJob.Factory> markOfflineFolderJobFactoryProvider) {
        return new JobFactory_Factory(createFolderJobFactoryProvider, uploadFileJobV2FactoryProvider, deleteFileJobFactoryProvider, chunkUploadJobFactoryProvider, downloadFileJobFactoryProvider, chunkDownloadJobFactoryProvider, deleteCollaborationJobFactoryProvider, downloadFolderJobFactoryProvider, uploadFolderJobFactoryProvider, moveItemJobFactoryProvider, copyItemJobFactoryProvider, autoUploadJobFactoryProvider, markOfflineJobFactoryProvider, markOfflineFolderJobFactoryProvider);
    }

    public static JobFactory newInstance(CreateFolderJob.Factory createFolderJobFactory, UploadFileJobV2.Factory uploadFileJobV2Factory, DeleteFileJob.Factory deleteFileJobFactory, ChunkUploadJob.Factory chunkUploadJobFactory, DownloadFileJob.Factory downloadFileJobFactory, DownloadChunkJob.Factory chunkDownloadJobFactory, DeleteCollaborationJob.Factory deleteCollaborationJobFactory, DownloadFolderJob.Factory downloadFolderJobFactory, UploadFolderJob.Factory uploadFolderJobFactory, MoveItemJob.Factory moveItemJobFactory, CopyItemJob.Factory copyItemJobFactory, AutoUploadJob.Factory autoUploadJobFactory, MarkForOfflineJob.Factory markOfflineJobFactory, MarkForOfflineFolderJob.Factory markOfflineFolderJobFactory) {
        return new JobFactory(createFolderJobFactory, uploadFileJobV2Factory, deleteFileJobFactory, chunkUploadJobFactory, downloadFileJobFactory, chunkDownloadJobFactory, deleteCollaborationJobFactory, downloadFolderJobFactory, uploadFolderJobFactory, moveItemJobFactory, copyItemJobFactory, autoUploadJobFactory, markOfflineJobFactory, markOfflineFolderJobFactory);
    }
}
