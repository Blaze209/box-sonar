package com.box.android.data.jobs;

import com.box.android.data.api.models.upload.CommitSessionState;
import com.box.android.data.api.models.upload.InitialState;
import com.box.android.data.api.models.upload.PreflightCheckState;
import com.box.android.data.api.models.upload.UploadChunksState;
import com.box.android.data.api.models.upload.UploadSessionCreationState;
import com.box.android.data.api.models.upload.UploadWholeFileState;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UploadStatesFactory_Factory implements Factory<UploadStatesFactory> {
    private final Provider<CommitSessionState.Factory> commitSessionStateFactoryProvider;
    private final Provider<InitialState.Factory> initialStateFactoryProvider;
    private final Provider<PreflightCheckState.Factory> preflightCheckStateFactoryProvider;
    private final Provider<UploadChunksState.Factory> uploadChunksStateFactoryProvider;
    private final Provider<UploadSessionCreationState.Factory> uploadSessionCreationStateFactoryProvider;
    private final Provider<UploadWholeFileState.Factory> uploadWholeFileStateFactoryProvider;

    private UploadStatesFactory_Factory(Provider<InitialState.Factory> initialStateFactoryProvider, Provider<PreflightCheckState.Factory> preflightCheckStateFactoryProvider, Provider<UploadWholeFileState.Factory> uploadWholeFileStateFactoryProvider, Provider<UploadSessionCreationState.Factory> uploadSessionCreationStateFactoryProvider, Provider<UploadChunksState.Factory> uploadChunksStateFactoryProvider, Provider<CommitSessionState.Factory> commitSessionStateFactoryProvider) {
        this.initialStateFactoryProvider = initialStateFactoryProvider;
        this.preflightCheckStateFactoryProvider = preflightCheckStateFactoryProvider;
        this.uploadWholeFileStateFactoryProvider = uploadWholeFileStateFactoryProvider;
        this.uploadSessionCreationStateFactoryProvider = uploadSessionCreationStateFactoryProvider;
        this.uploadChunksStateFactoryProvider = uploadChunksStateFactoryProvider;
        this.commitSessionStateFactoryProvider = commitSessionStateFactoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UploadStatesFactory get() {
        return newInstance(this.initialStateFactoryProvider.get(), this.preflightCheckStateFactoryProvider.get(), this.uploadWholeFileStateFactoryProvider.get(), this.uploadSessionCreationStateFactoryProvider.get(), this.uploadChunksStateFactoryProvider.get(), this.commitSessionStateFactoryProvider.get());
    }

    public static UploadStatesFactory_Factory create(Provider<InitialState.Factory> initialStateFactoryProvider, Provider<PreflightCheckState.Factory> preflightCheckStateFactoryProvider, Provider<UploadWholeFileState.Factory> uploadWholeFileStateFactoryProvider, Provider<UploadSessionCreationState.Factory> uploadSessionCreationStateFactoryProvider, Provider<UploadChunksState.Factory> uploadChunksStateFactoryProvider, Provider<CommitSessionState.Factory> commitSessionStateFactoryProvider) {
        return new UploadStatesFactory_Factory(initialStateFactoryProvider, preflightCheckStateFactoryProvider, uploadWholeFileStateFactoryProvider, uploadSessionCreationStateFactoryProvider, uploadChunksStateFactoryProvider, commitSessionStateFactoryProvider);
    }

    public static UploadStatesFactory newInstance(InitialState.Factory initialStateFactory, PreflightCheckState.Factory preflightCheckStateFactory, UploadWholeFileState.Factory uploadWholeFileStateFactory, UploadSessionCreationState.Factory uploadSessionCreationStateFactory, UploadChunksState.Factory uploadChunksStateFactory, CommitSessionState.Factory commitSessionStateFactory) {
        return new UploadStatesFactory(initialStateFactory, preflightCheckStateFactory, uploadWholeFileStateFactory, uploadSessionCreationStateFactory, uploadChunksStateFactory, commitSessionStateFactory);
    }
}
