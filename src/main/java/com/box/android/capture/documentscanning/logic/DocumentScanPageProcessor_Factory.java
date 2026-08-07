package com.box.android.capture.documentscanning.logic;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class DocumentScanPageProcessor_Factory implements Factory<DocumentScanPageProcessor> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DocumentScanPageProcessor_Factory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DocumentScanPageProcessor get() {
        return newInstance(this.userContextManagerProvider.get());
    }

    public static DocumentScanPageProcessor_Factory create(Provider<IUserContextManager> provider) {
        return new DocumentScanPageProcessor_Factory(provider);
    }

    public static DocumentScanPageProcessor newInstance(IUserContextManager iUserContextManager) {
        return new DocumentScanPageProcessor(iUserContextManager);
    }
}
