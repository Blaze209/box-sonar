package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.UploadFileJobV2;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PreflightCheckState_Factory_Impl implements PreflightCheckState.Factory {
    private final C1072PreflightCheckState_Factory delegateFactory;

    PreflightCheckState_Factory_Impl(C1072PreflightCheckState_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.api.models.upload.PreflightCheckState.Factory
    public PreflightCheckState createState(UploadFileJobV2 job) {
        return this.delegateFactory.get(job);
    }

    public static Provider<PreflightCheckState.Factory> create(C1072PreflightCheckState_Factory delegateFactory) {
        return InstanceFactory.create(new PreflightCheckState_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<PreflightCheckState.Factory> createFactoryProvider(C1072PreflightCheckState_Factory delegateFactory) {
        return InstanceFactory.create(new PreflightCheckState_Factory_Impl(delegateFactory));
    }
}
