package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class MarkForOfflineJob_Factory_Impl implements MarkForOfflineJob.Factory {
    private final C1333MarkForOfflineJob_Factory delegateFactory;

    MarkForOfflineJob_Factory_Impl(C1333MarkForOfflineJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.MarkForOfflineJob.Factory
    public MarkForOfflineJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<MarkForOfflineJob.Factory> create(C1333MarkForOfflineJob_Factory delegateFactory) {
        return InstanceFactory.create(new MarkForOfflineJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<MarkForOfflineJob.Factory> createFactoryProvider(C1333MarkForOfflineJob_Factory delegateFactory) {
        return InstanceFactory.create(new MarkForOfflineJob_Factory_Impl(delegateFactory));
    }
}
