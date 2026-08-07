package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class AutoUploadJob_Factory_Impl implements AutoUploadJob.Factory {
    private final C1237AutoUploadJob_Factory delegateFactory;

    AutoUploadJob_Factory_Impl(C1237AutoUploadJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.AutoUploadJob.Factory
    public AutoUploadJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<AutoUploadJob.Factory> create(C1237AutoUploadJob_Factory delegateFactory) {
        return InstanceFactory.create(new AutoUploadJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<AutoUploadJob.Factory> createFactoryProvider(C1237AutoUploadJob_Factory delegateFactory) {
        return InstanceFactory.create(new AutoUploadJob_Factory_Impl(delegateFactory));
    }
}
