package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ChunkUploadJob_Factory_Impl implements ChunkUploadJob.Factory {
    private final C1238ChunkUploadJob_Factory delegateFactory;

    ChunkUploadJob_Factory_Impl(C1238ChunkUploadJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.ChunkUploadJob.Factory
    public ChunkUploadJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<ChunkUploadJob.Factory> create(C1238ChunkUploadJob_Factory delegateFactory) {
        return InstanceFactory.create(new ChunkUploadJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<ChunkUploadJob.Factory> createFactoryProvider(C1238ChunkUploadJob_Factory delegateFactory) {
        return InstanceFactory.create(new ChunkUploadJob_Factory_Impl(delegateFactory));
    }
}
