package com.box.android.preview.fileactions.openin;

import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.preview.wopi.IWopiService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class OpenInEnvironment_Factory implements Factory<OpenInEnvironment> {
    private final Provider<FileActionsManager> fileActionsManagerProvider;
    private final Provider<IWopiService> wopiServiceProvider;

    private OpenInEnvironment_Factory(Provider<FileActionsManager> provider, Provider<IWopiService> provider2) {
        this.fileActionsManagerProvider = provider;
        this.wopiServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OpenInEnvironment get() {
        return newInstance(this.fileActionsManagerProvider.get(), this.wopiServiceProvider.get());
    }

    public static OpenInEnvironment_Factory create(Provider<FileActionsManager> provider, Provider<IWopiService> provider2) {
        return new OpenInEnvironment_Factory(provider, provider2);
    }

    public static OpenInEnvironment newInstance(FileActionsManager fileActionsManager, IWopiService iWopiService) {
        return new OpenInEnvironment(fileActionsManager, iWopiService);
    }
}
