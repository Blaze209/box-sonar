package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DeleteCollaborationJob_Factory_Impl implements DeleteCollaborationJob.Factory {
    private final C1243DeleteCollaborationJob_Factory delegateFactory;

    DeleteCollaborationJob_Factory_Impl(C1243DeleteCollaborationJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.DeleteCollaborationJob.Factory
    public DeleteCollaborationJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<DeleteCollaborationJob.Factory> create(C1243DeleteCollaborationJob_Factory delegateFactory) {
        return InstanceFactory.create(new DeleteCollaborationJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<DeleteCollaborationJob.Factory> createFactoryProvider(C1243DeleteCollaborationJob_Factory delegateFactory) {
        return InstanceFactory.create(new DeleteCollaborationJob_Factory_Impl(delegateFactory));
    }
}
