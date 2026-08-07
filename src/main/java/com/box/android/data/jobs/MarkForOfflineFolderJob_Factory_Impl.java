package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class MarkForOfflineFolderJob_Factory_Impl implements MarkForOfflineFolderJob.Factory {
    private final C1310MarkForOfflineFolderJob_Factory delegateFactory;

    MarkForOfflineFolderJob_Factory_Impl(C1310MarkForOfflineFolderJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.MarkForOfflineFolderJob.Factory
    public MarkForOfflineFolderJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<MarkForOfflineFolderJob.Factory> create(C1310MarkForOfflineFolderJob_Factory delegateFactory) {
        return InstanceFactory.create(new MarkForOfflineFolderJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<MarkForOfflineFolderJob.Factory> createFactoryProvider(C1310MarkForOfflineFolderJob_Factory delegateFactory) {
        return InstanceFactory.create(new MarkForOfflineFolderJob_Factory_Impl(delegateFactory));
    }
}
