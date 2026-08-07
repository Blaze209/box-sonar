package com.box.android.capture.audiorecording;

import com.box.android.capture.CaptureUploadFileManager;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class RecordingFileManager_Factory implements Factory<RecordingFileManager> {
    private final Provider<CaptureUploadFileManager> uploadManagerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private RecordingFileManager_Factory(Provider<IUserContextManager> provider, Provider<CaptureUploadFileManager> provider2) {
        this.userContextManagerProvider = provider;
        this.uploadManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecordingFileManager get() {
        return newInstance(this.userContextManagerProvider.get(), this.uploadManagerProvider.get());
    }

    public static RecordingFileManager_Factory create(Provider<IUserContextManager> provider, Provider<CaptureUploadFileManager> provider2) {
        return new RecordingFileManager_Factory(provider, provider2);
    }

    public static RecordingFileManager newInstance(IUserContextManager iUserContextManager, CaptureUploadFileManager captureUploadFileManager) {
        return new RecordingFileManager(iUserContextManager, captureUploadFileManager);
    }
}
