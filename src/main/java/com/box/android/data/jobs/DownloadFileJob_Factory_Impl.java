package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DownloadFileJob_Factory_Impl implements DownloadFileJob.Factory {
    private final C1254DownloadFileJob_Factory delegateFactory;

    DownloadFileJob_Factory_Impl(C1254DownloadFileJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.DownloadFileJob.Factory
    public DownloadFileJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<DownloadFileJob.Factory> create(C1254DownloadFileJob_Factory delegateFactory) {
        return InstanceFactory.create(new DownloadFileJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<DownloadFileJob.Factory> createFactoryProvider(C1254DownloadFileJob_Factory delegateFactory) {
        return InstanceFactory.create(new DownloadFileJob_Factory_Impl(delegateFactory));
    }
}
