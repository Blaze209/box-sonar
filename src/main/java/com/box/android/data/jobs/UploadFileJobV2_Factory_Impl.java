package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UploadFileJobV2_Factory_Impl implements UploadFileJobV2.Factory {
    private final C1347UploadFileJobV2_Factory delegateFactory;

    UploadFileJobV2_Factory_Impl(C1347UploadFileJobV2_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.jobs.UploadFileJobV2.Factory
    public UploadFileJobV2 createJob(JobId jobId, Data inputData) {
        return this.delegateFactory.get(jobId, inputData);
    }

    public static Provider<UploadFileJobV2.Factory> create(C1347UploadFileJobV2_Factory delegateFactory) {
        return InstanceFactory.create(new UploadFileJobV2_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<UploadFileJobV2.Factory> createFactoryProvider(C1347UploadFileJobV2_Factory delegateFactory) {
        return InstanceFactory.create(new UploadFileJobV2_Factory_Impl(delegateFactory));
    }
}
