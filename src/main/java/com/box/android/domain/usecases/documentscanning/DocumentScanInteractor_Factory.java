package com.box.android.domain.usecases.documentscanning;

import com.box.android.domain.services.IDocumentScanPageProcessor;
import com.box.android.domain.services.IDocumentScanService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DocumentScanInteractor_Factory implements Factory<DocumentScanInteractor> {
    private final Provider<IDocumentScanService> documentScanServiceProvider;
    private final Provider<IDocumentScanPageProcessor> scanPageProcessorProvider;

    private DocumentScanInteractor_Factory(Provider<IDocumentScanService> provider, Provider<IDocumentScanPageProcessor> provider2) {
        this.documentScanServiceProvider = provider;
        this.scanPageProcessorProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DocumentScanInteractor get() {
        return newInstance(this.documentScanServiceProvider.get(), this.scanPageProcessorProvider.get());
    }

    public static DocumentScanInteractor_Factory create(Provider<IDocumentScanService> provider, Provider<IDocumentScanPageProcessor> provider2) {
        return new DocumentScanInteractor_Factory(provider, provider2);
    }

    public static DocumentScanInteractor newInstance(IDocumentScanService iDocumentScanService, IDocumentScanPageProcessor iDocumentScanPageProcessor) {
        return new DocumentScanInteractor(iDocumentScanService, iDocumentScanPageProcessor);
    }
}
