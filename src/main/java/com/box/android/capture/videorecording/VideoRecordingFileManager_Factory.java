package com.box.android.capture.videorecording;

import com.box.android.capture.CaptureUploadFileManager;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class VideoRecordingFileManager_Factory implements Factory<VideoRecordingFileManager> {
    private final Provider<CaptureUploadFileManager> uploadManagerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private VideoRecordingFileManager_Factory(Provider<IUserContextManager> provider, Provider<CaptureUploadFileManager> provider2) {
        this.userContextManagerProvider = provider;
        this.uploadManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public VideoRecordingFileManager get() {
        return newInstance(this.userContextManagerProvider.get(), this.uploadManagerProvider.get());
    }

    public static VideoRecordingFileManager_Factory create(Provider<IUserContextManager> provider, Provider<CaptureUploadFileManager> provider2) {
        return new VideoRecordingFileManager_Factory(provider, provider2);
    }

    public static VideoRecordingFileManager newInstance(IUserContextManager iUserContextManager, CaptureUploadFileManager captureUploadFileManager) {
        return new VideoRecordingFileManager(iUserContextManager, captureUploadFileManager);
    }
}
