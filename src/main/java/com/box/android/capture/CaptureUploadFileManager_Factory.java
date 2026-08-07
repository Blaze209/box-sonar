package com.box.android.capture;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureUploadFileManager_Factory implements Factory<CaptureUploadFileManager> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private CaptureUploadFileManager_Factory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureUploadFileManager get() {
        return newInstance(this.userContextManagerProvider.get());
    }

    public static CaptureUploadFileManager_Factory create(Provider<IUserContextManager> provider) {
        return new CaptureUploadFileManager_Factory(provider);
    }

    public static CaptureUploadFileManager newInstance(IUserContextManager iUserContextManager) {
        return new CaptureUploadFileManager(iUserContextManager);
    }
}
