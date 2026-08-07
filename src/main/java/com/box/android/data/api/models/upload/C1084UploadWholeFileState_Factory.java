package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.UploadFileJobV2;
import com.box.android.data.service.impl.FileMetadataService;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.UploadFileService;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.services.IdMappingService;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadWholeFileState_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1084UploadWholeFileState_Factory {
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<FileMetadataService> fileMetadataServiceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<LocalItemService> localItemServiceProvider;
    private final Provider<UploadFileService> uploadFileServiceProvider;

    private C1084UploadWholeFileState_Factory(Provider<JobService> jobServiceProvider, Provider<UploadFileService> uploadFileServiceProvider, Provider<LocalItemService> localItemServiceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<FileMetadataService> fileMetadataServiceProvider, Provider<FeatureFlips> featureFlipsProvider) {
        this.jobServiceProvider = jobServiceProvider;
        this.uploadFileServiceProvider = uploadFileServiceProvider;
        this.localItemServiceProvider = localItemServiceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.fileMetadataServiceProvider = fileMetadataServiceProvider;
        this.featureFlipsProvider = featureFlipsProvider;
    }

    public UploadWholeFileState get(UploadFileJobV2 job) {
        return newInstance(this.jobServiceProvider.get(), job, this.uploadFileServiceProvider.get(), this.localItemServiceProvider.get(), this.idMappingServiceProvider.get(), this.fileMetadataServiceProvider.get(), DoubleCheck.lazy((Provider) this.featureFlipsProvider));
    }

    public static C1084UploadWholeFileState_Factory create(Provider<JobService> jobServiceProvider, Provider<UploadFileService> uploadFileServiceProvider, Provider<LocalItemService> localItemServiceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<FileMetadataService> fileMetadataServiceProvider, Provider<FeatureFlips> featureFlipsProvider) {
        return new C1084UploadWholeFileState_Factory(jobServiceProvider, uploadFileServiceProvider, localItemServiceProvider, idMappingServiceProvider, fileMetadataServiceProvider, featureFlipsProvider);
    }

    public static UploadWholeFileState newInstance(JobService jobService, UploadFileJobV2 job, UploadFileService uploadFileService, LocalItemService localItemService, IdMappingService idMappingService, FileMetadataService fileMetadataService, Lazy<FeatureFlips> featureFlips) {
        return new UploadWholeFileState(jobService, job, uploadFileService, localItemService, idMappingService, fileMetadataService, featureFlips);
    }
}
