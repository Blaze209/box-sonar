package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CreateFolderJob_Factory_Impl implements CreateFolderJob.Factory {
    private final C1242CreateFolderJob_Factory delegateFactory;

    CreateFolderJob_Factory_Impl(C1242CreateFolderJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.CreateFolderJob.Factory
    public CreateFolderJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<CreateFolderJob.Factory> create(C1242CreateFolderJob_Factory delegateFactory) {
        return InstanceFactory.create(new CreateFolderJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<CreateFolderJob.Factory> createFactoryProvider(C1242CreateFolderJob_Factory delegateFactory) {
        return InstanceFactory.create(new CreateFolderJob_Factory_Impl(delegateFactory));
    }
}
