package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.UploadFileJobV2;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UploadChunksState_Factory_Impl implements UploadChunksState.Factory {
    private final C1082UploadChunksState_Factory delegateFactory;

    UploadChunksState_Factory_Impl(C1082UploadChunksState_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.api.models.upload.UploadChunksState.Factory
    public UploadChunksState createState(UploadFileJobV2 job) {
        return this.delegateFactory.get(job);
    }

    public static Provider<UploadChunksState.Factory> create(C1082UploadChunksState_Factory delegateFactory) {
        return InstanceFactory.create(new UploadChunksState_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<UploadChunksState.Factory> createFactoryProvider(C1082UploadChunksState_Factory delegateFactory) {
        return InstanceFactory.create(new UploadChunksState_Factory_Impl(delegateFactory));
    }
}
