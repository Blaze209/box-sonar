package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.UploadFileJobV2;
import com.box.android.data.service.impl.CommonServiceUtils;
import com.box.android.data.service.impl.FileMetadataService;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.UploadFileService;
import com.box.android.domain.configuration.FeatureFlips;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.api.models.upload.CommitSessionState_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1070CommitSessionState_Factory {
    private final Provider<CommonServiceUtils> commonServiceUtilsProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<FileMetadataService> fileMetadataServiceProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<LocalItemService> localItemServiceProvider;
    private final Provider<UploadFileService> uploadFileServiceProvider;

    private C1070CommitSessionState_Factory(Provider<JobService> jobServiceProvider, Provider<UploadFileService> uploadFileServiceProvider, Provider<LocalItemService> localItemServiceProvider, Provider<CommonServiceUtils> commonServiceUtilsProvider, Provider<FileMetadataService> fileMetadataServiceProvider, Provider<FeatureFlips> featureFlipsProvider) {
        this.jobServiceProvider = jobServiceProvider;
        this.uploadFileServiceProvider = uploadFileServiceProvider;
        this.localItemServiceProvider = localItemServiceProvider;
        this.commonServiceUtilsProvider = commonServiceUtilsProvider;
        this.fileMetadataServiceProvider = fileMetadataServiceProvider;
        this.featureFlipsProvider = featureFlipsProvider;
    }

    public CommitSessionState get(UploadFileJobV2 job) {
        return newInstance(this.jobServiceProvider.get(), job, this.uploadFileServiceProvider.get(), this.localItemServiceProvider.get(), this.commonServiceUtilsProvider.get(), this.fileMetadataServiceProvider.get(), DoubleCheck.lazy((Provider) this.featureFlipsProvider));
    }

    public static C1070CommitSessionState_Factory create(Provider<JobService> jobServiceProvider, Provider<UploadFileService> uploadFileServiceProvider, Provider<LocalItemService> localItemServiceProvider, Provider<CommonServiceUtils> commonServiceUtilsProvider, Provider<FileMetadataService> fileMetadataServiceProvider, Provider<FeatureFlips> featureFlipsProvider) {
        return new C1070CommitSessionState_Factory(jobServiceProvider, uploadFileServiceProvider, localItemServiceProvider, commonServiceUtilsProvider, fileMetadataServiceProvider, featureFlipsProvider);
    }

    public static CommitSessionState newInstance(JobService jobService, UploadFileJobV2 job, UploadFileService uploadFileService, LocalItemService localItemService, CommonServiceUtils commonServiceUtils, FileMetadataService fileMetadataService, Lazy<FeatureFlips> featureFlips) {
        return new CommitSessionState(jobService, job, uploadFileService, localItemService, commonServiceUtils, fileMetadataService, featureFlips);
    }
}
