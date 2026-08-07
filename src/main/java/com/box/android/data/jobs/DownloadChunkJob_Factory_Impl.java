package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DownloadChunkJob_Factory_Impl implements DownloadChunkJob.Factory {
    private final C1245DownloadChunkJob_Factory delegateFactory;

    DownloadChunkJob_Factory_Impl(C1245DownloadChunkJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.DownloadChunkJob.Factory
    public DownloadChunkJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<DownloadChunkJob.Factory> create(C1245DownloadChunkJob_Factory delegateFactory) {
        return InstanceFactory.create(new DownloadChunkJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<DownloadChunkJob.Factory> createFactoryProvider(C1245DownloadChunkJob_Factory delegateFactory) {
        return InstanceFactory.create(new DownloadChunkJob_Factory_Impl(delegateFactory));
    }
}
