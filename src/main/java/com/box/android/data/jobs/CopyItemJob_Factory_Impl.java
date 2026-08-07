package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CopyItemJob_Factory_Impl implements CopyItemJob.Factory {
    private final C1239CopyItemJob_Factory delegateFactory;

    CopyItemJob_Factory_Impl(C1239CopyItemJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.CopyItemJob.Factory
    public CopyItemJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<CopyItemJob.Factory> create(C1239CopyItemJob_Factory delegateFactory) {
        return InstanceFactory.create(new CopyItemJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<CopyItemJob.Factory> createFactoryProvider(C1239CopyItemJob_Factory delegateFactory) {
        return InstanceFactory.create(new CopyItemJob_Factory_Impl(delegateFactory));
    }
}
