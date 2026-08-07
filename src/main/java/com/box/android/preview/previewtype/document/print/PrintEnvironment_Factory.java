package com.box.android.preview.previewtype.document.print;

import com.box.android.coreservices.utilities.FileActionsManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PrintEnvironment_Factory implements Factory<PrintEnvironment> {
    private final Provider<FileActionsManager> fileActionsManagerProvider;

    private PrintEnvironment_Factory(Provider<FileActionsManager> provider) {
        this.fileActionsManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PrintEnvironment get() {
        return newInstance(this.fileActionsManagerProvider.get());
    }

    public static PrintEnvironment_Factory create(Provider<FileActionsManager> provider) {
        return new PrintEnvironment_Factory(provider);
    }

    public static PrintEnvironment newInstance(FileActionsManager fileActionsManager) {
        return new PrintEnvironment(fileActionsManager);
    }
}
