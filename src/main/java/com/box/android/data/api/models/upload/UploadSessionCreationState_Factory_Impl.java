package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.UploadFileJobV2;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UploadSessionCreationState_Factory_Impl implements UploadSessionCreationState.Factory {
    private final C1083UploadSessionCreationState_Factory delegateFactory;

    UploadSessionCreationState_Factory_Impl(C1083UploadSessionCreationState_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.api.models.upload.UploadSessionCreationState.Factory
    public UploadSessionCreationState createState(UploadFileJobV2 job) {
        return this.delegateFactory.get(job);
    }

    public static Provider<UploadSessionCreationState.Factory> create(C1083UploadSessionCreationState_Factory delegateFactory) {
        return InstanceFactory.create(new UploadSessionCreationState_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<UploadSessionCreationState.Factory> createFactoryProvider(C1083UploadSessionCreationState_Factory delegateFactory) {
        return InstanceFactory.create(new UploadSessionCreationState_Factory_Impl(delegateFactory));
    }
}
