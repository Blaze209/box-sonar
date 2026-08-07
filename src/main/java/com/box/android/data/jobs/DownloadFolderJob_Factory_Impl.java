package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DownloadFolderJob_Factory_Impl implements DownloadFolderJob.Factory {
    private final C1259DownloadFolderJob_Factory delegateFactory;

    DownloadFolderJob_Factory_Impl(C1259DownloadFolderJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.DownloadFolderJob.Factory
    public DownloadFolderJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<DownloadFolderJob.Factory> create(C1259DownloadFolderJob_Factory delegateFactory) {
        return InstanceFactory.create(new DownloadFolderJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<DownloadFolderJob.Factory> createFactoryProvider(C1259DownloadFolderJob_Factory delegateFactory) {
        return InstanceFactory.create(new DownloadFolderJob_Factory_Impl(delegateFactory));
    }
}
