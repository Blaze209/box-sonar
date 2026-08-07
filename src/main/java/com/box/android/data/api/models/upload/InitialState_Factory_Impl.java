package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.UploadFileJobV2;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class InitialState_Factory_Impl implements InitialState.Factory {
    private final C1071InitialState_Factory delegateFactory;

    InitialState_Factory_Impl(C1071InitialState_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.api.models.upload.InitialState.Factory
    public InitialState createState(UploadFileJobV2 job) {
        return this.delegateFactory.get(job);
    }

    public static Provider<InitialState.Factory> create(C1071InitialState_Factory delegateFactory) {
        return InstanceFactory.create(new InitialState_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<InitialState.Factory> createFactoryProvider(C1071InitialState_Factory delegateFactory) {
        return InstanceFactory.create(new InitialState_Factory_Impl(delegateFactory));
    }
}
