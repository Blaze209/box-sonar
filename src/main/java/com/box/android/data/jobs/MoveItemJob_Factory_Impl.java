package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class MoveItemJob_Factory_Impl implements MoveItemJob.Factory {
    private final C1334MoveItemJob_Factory delegateFactory;

    MoveItemJob_Factory_Impl(C1334MoveItemJob_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.MoveItemJob.Factory
    public MoveItemJob createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<MoveItemJob.Factory> create(C1334MoveItemJob_Factory delegateFactory) {
        return InstanceFactory.create(new MoveItemJob_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<MoveItemJob.Factory> createFactoryProvider(C1334MoveItemJob_Factory delegateFactory) {
        return InstanceFactory.create(new MoveItemJob_Factory_Impl(delegateFactory));
    }
}
