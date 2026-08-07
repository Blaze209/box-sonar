package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UploadFolderJob_Factory_Impl implements UploadFolderJob.Factory {
    private final C1360UploadFolderJob_Factory delegateFactory;

    UploadFolderJob_Factory_Impl(C1360UploadFolderJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.UploadFolderJob.Factory
    public UploadFolderJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<UploadFolderJob.Factory> create(C1360UploadFolderJob_Factory delegateFactory) {
        return InstanceFactory.create(new UploadFolderJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<UploadFolderJob.Factory> createFactoryProvider(C1360UploadFolderJob_Factory delegateFactory) {
        return InstanceFactory.create(new UploadFolderJob_Factory_Impl(delegateFactory));
    }
}
