package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.UploadFileJobV2;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CommitSessionState_Factory_Impl implements CommitSessionState.Factory {
    private final C1070CommitSessionState_Factory delegateFactory;

    CommitSessionState_Factory_Impl(C1070CommitSessionState_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.api.models.upload.CommitSessionState.Factory
    public CommitSessionState createState(UploadFileJobV2 job) {
        return this.delegateFactory.get(job);
    }

    public static Provider<CommitSessionState.Factory> create(C1070CommitSessionState_Factory delegateFactory) {
        return InstanceFactory.create(new CommitSessionState_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<CommitSessionState.Factory> createFactoryProvider(C1070CommitSessionState_Factory delegateFactory) {
        return InstanceFactory.create(new CommitSessionState_Factory_Impl(delegateFactory));
    }
}
