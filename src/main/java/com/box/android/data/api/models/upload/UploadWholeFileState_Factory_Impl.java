package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.UploadFileJobV2;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UploadWholeFileState_Factory_Impl implements UploadWholeFileState.Factory {
    private final C1084UploadWholeFileState_Factory delegateFactory;

    UploadWholeFileState_Factory_Impl(C1084UploadWholeFileState_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.api.models.upload.UploadWholeFileState.Factory
    public UploadWholeFileState createState(UploadFileJobV2 job) {
        return this.delegateFactory.get(job);
    }

    public static Provider<UploadWholeFileState.Factory> create(C1084UploadWholeFileState_Factory delegateFactory) {
        return InstanceFactory.create(new UploadWholeFileState_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<UploadWholeFileState.Factory> createFactoryProvider(C1084UploadWholeFileState_Factory delegateFactory) {
        return InstanceFactory.create(new UploadWholeFileState_Factory_Impl(delegateFactory));
    }
}
