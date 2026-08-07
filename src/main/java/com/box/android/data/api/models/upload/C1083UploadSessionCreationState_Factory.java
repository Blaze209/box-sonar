package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.UploadFileJobV2;
import com.box.android.data.service.impl.CommonServiceUtils;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.UploadFileService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadSessionCreationState_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1083UploadSessionCreationState_Factory {
    private final Provider<CommonServiceUtils> commonServiceUtilsProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<LocalItemService> localItemServiceProvider;
    private final Provider<UploadFileService> uploadFileServiceProvider;

    private C1083UploadSessionCreationState_Factory(Provider<JobService> jobServiceProvider, Provider<UploadFileService> uploadFileServiceProvider, Provider<LocalItemService> localItemServiceProvider, Provider<CommonServiceUtils> commonServiceUtilsProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.jobServiceProvider = jobServiceProvider;
        this.uploadFileServiceProvider = uploadFileServiceProvider;
        this.localItemServiceProvider = localItemServiceProvider;
        this.commonServiceUtilsProvider = commonServiceUtilsProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    public UploadSessionCreationState get(UploadFileJobV2 job) {
        return newInstance(this.jobServiceProvider.get(), job, this.uploadFileServiceProvider.get(), this.localItemServiceProvider.get(), this.commonServiceUtilsProvider.get(), this.idMappingServiceProvider.get());
    }

    public static C1083UploadSessionCreationState_Factory create(Provider<JobService> jobServiceProvider, Provider<UploadFileService> uploadFileServiceProvider, Provider<LocalItemService> localItemServiceProvider, Provider<CommonServiceUtils> commonServiceUtilsProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new C1083UploadSessionCreationState_Factory(jobServiceProvider, uploadFileServiceProvider, localItemServiceProvider, commonServiceUtilsProvider, idMappingServiceProvider);
    }

    public static UploadSessionCreationState newInstance(JobService jobService, UploadFileJobV2 job, UploadFileService uploadFileService, LocalItemService localItemService, CommonServiceUtils commonServiceUtils, IdMappingService idMappingService) {
        return new UploadSessionCreationState(jobService, job, uploadFileService, localItemService, commonServiceUtils, idMappingService);
    }
}
