package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.UploadFileJobV2;
import com.box.android.data.service.impl.CommonServiceUtils;
import com.box.android.data.service.impl.UploadFileService;
import com.squareup.moshi.Moshi;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadChunksState_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1082UploadChunksState_Factory {
    private final Provider<CommonServiceUtils> commonServiceUtilsProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<UploadFileService> uploadFileServiceProvider;

    private C1082UploadChunksState_Factory(Provider<JobService> jobServiceProvider, Provider<UploadFileService> uploadFileServiceProvider, Provider<Moshi> moshiProvider, Provider<CommonServiceUtils> commonServiceUtilsProvider) {
        this.jobServiceProvider = jobServiceProvider;
        this.uploadFileServiceProvider = uploadFileServiceProvider;
        this.moshiProvider = moshiProvider;
        this.commonServiceUtilsProvider = commonServiceUtilsProvider;
    }

    public UploadChunksState get(UploadFileJobV2 job) {
        return newInstance(this.jobServiceProvider.get(), job, this.uploadFileServiceProvider.get(), this.moshiProvider.get(), this.commonServiceUtilsProvider.get());
    }

    public static C1082UploadChunksState_Factory create(Provider<JobService> jobServiceProvider, Provider<UploadFileService> uploadFileServiceProvider, Provider<Moshi> moshiProvider, Provider<CommonServiceUtils> commonServiceUtilsProvider) {
        return new C1082UploadChunksState_Factory(jobServiceProvider, uploadFileServiceProvider, moshiProvider, commonServiceUtilsProvider);
    }

    public static UploadChunksState newInstance(JobService jobService, UploadFileJobV2 job, UploadFileService uploadFileService, Moshi moshi, CommonServiceUtils commonServiceUtils) {
        return new UploadChunksState(jobService, job, uploadFileService, moshi, commonServiceUtils);
    }
}
