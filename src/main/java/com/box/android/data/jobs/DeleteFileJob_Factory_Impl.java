package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DeleteFileJob_Factory_Impl implements DeleteFileJob.Factory {
    private final C1244DeleteFileJob_Factory delegateFactory;

    DeleteFileJob_Factory_Impl(C1244DeleteFileJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.DeleteFileJob.Factory
    public DeleteFileJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<DeleteFileJob.Factory> create(C1244DeleteFileJob_Factory delegateFactory) {
        return InstanceFactory.create(new DeleteFileJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<DeleteFileJob.Factory> createFactoryProvider(C1244DeleteFileJob_Factory delegateFactory) {
        return InstanceFactory.create(new DeleteFileJob_Factory_Impl(delegateFactory));
    }
}
