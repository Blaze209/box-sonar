package com.box.android.capture.viewmodel;

import com.box.android.capture.CaptureUploadFileManager;
import com.box.android.capture.cpl.CaptureEnvironment;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureViewModel_Factory implements Factory<CaptureViewModel> {
    private final Provider<CaptureEnvironment> captureEnvironmentProvider;
    private final Provider<CaptureUploadFileManager> captureUploadFileManagerProvider;
    private final Provider<IStoreFactory> factoryProvider;

    private CaptureViewModel_Factory(Provider<CaptureUploadFileManager> provider, Provider<CaptureEnvironment> provider2, Provider<IStoreFactory> provider3) {
        this.captureUploadFileManagerProvider = provider;
        this.captureEnvironmentProvider = provider2;
        this.factoryProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureViewModel get() {
        return newInstance(this.captureUploadFileManagerProvider.get(), this.captureEnvironmentProvider.get(), this.factoryProvider.get());
    }

    public static CaptureViewModel_Factory create(Provider<CaptureUploadFileManager> provider, Provider<CaptureEnvironment> provider2, Provider<IStoreFactory> provider3) {
        return new CaptureViewModel_Factory(provider, provider2, provider3);
    }

    public static CaptureViewModel newInstance(CaptureUploadFileManager captureUploadFileManager, CaptureEnvironment captureEnvironment, IStoreFactory iStoreFactory) {
        return new CaptureViewModel(captureUploadFileManager, captureEnvironment, iStoreFactory);
    }
}
