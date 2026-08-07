package com.box.android.preview.previewtype.document;

import com.box.android.coreservices.utilities.BoxAccountManagerHelper;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.domain.services.IPreviewSettingsService;
import com.box.android.preview.annotations.cpl.AnnotationsEnvironment;
import com.box.android.preview.annotations.cpl.CreateAnnotationEnvironment;
import com.box.android.preview.document.copytext.CopySelectedTextEnvironment;
import com.box.android.preview.item.IScrollableFileTypeResolver;
import com.box.android.preview.preview.PreviewAnalytics;
import com.box.android.preview.previewtype.document.print.PrintEnvironment;
import com.box.android.preview.previewtype.document.search.DocumentSearchEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class DocumentPreviewEnvironment_Factory implements Factory<DocumentPreviewEnvironment> {
    private final Provider<PreviewAnalytics> analyticsProvider;
    private final Provider<AnnotationsEnvironment> annotationsEnvironmentProvider;
    private final Provider<BoxAccountManagerHelper> boxAccountManagerHelperProvider;
    private final Provider<CitationHighlightEnvironment> citationHighlightEnvironmentProvider;
    private final Provider<CopySelectedTextEnvironment> copyTextEnvironmentProvider;
    private final Provider<CreateAnnotationEnvironment> createAnnotationEnvironmentProvider;
    private final Provider<PreviewObservability> observabilityProvider;
    private final Provider<IPreviewSettingsService> previewSettingsServiceProvider;
    private final Provider<PrintEnvironment> printEnvironmentProvider;
    private final Provider<IScrollableFileTypeResolver> scrollableFileTypeResolverProvider;
    private final Provider<DocumentSearchEnvironment> searchEnvironmentProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DocumentPreviewEnvironment_Factory(Provider<AnnotationsEnvironment> provider, Provider<CreateAnnotationEnvironment> provider2, Provider<IUserContextManager> provider3, Provider<IPreviewSettingsService> provider4, Provider<IScrollableFileTypeResolver> provider5, Provider<PreviewObservability> provider6, Provider<BoxAccountManagerHelper> provider7, Provider<CopySelectedTextEnvironment> provider8, Provider<DocumentSearchEnvironment> provider9, Provider<PreviewAnalytics> provider10, Provider<PrintEnvironment> provider11, Provider<CitationHighlightEnvironment> provider12) {
        this.annotationsEnvironmentProvider = provider;
        this.createAnnotationEnvironmentProvider = provider2;
        this.userContextManagerProvider = provider3;
        this.previewSettingsServiceProvider = provider4;
        this.scrollableFileTypeResolverProvider = provider5;
        this.observabilityProvider = provider6;
        this.boxAccountManagerHelperProvider = provider7;
        this.copyTextEnvironmentProvider = provider8;
        this.searchEnvironmentProvider = provider9;
        this.analyticsProvider = provider10;
        this.printEnvironmentProvider = provider11;
        this.citationHighlightEnvironmentProvider = provider12;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DocumentPreviewEnvironment get() {
        return newInstance(this.annotationsEnvironmentProvider.get(), this.createAnnotationEnvironmentProvider.get(), this.userContextManagerProvider.get(), this.previewSettingsServiceProvider.get(), this.scrollableFileTypeResolverProvider.get(), this.observabilityProvider.get(), this.boxAccountManagerHelperProvider.get(), this.copyTextEnvironmentProvider.get(), this.searchEnvironmentProvider.get(), this.analyticsProvider.get(), this.printEnvironmentProvider.get(), this.citationHighlightEnvironmentProvider.get());
    }

    public static DocumentPreviewEnvironment_Factory create(Provider<AnnotationsEnvironment> provider, Provider<CreateAnnotationEnvironment> provider2, Provider<IUserContextManager> provider3, Provider<IPreviewSettingsService> provider4, Provider<IScrollableFileTypeResolver> provider5, Provider<PreviewObservability> provider6, Provider<BoxAccountManagerHelper> provider7, Provider<CopySelectedTextEnvironment> provider8, Provider<DocumentSearchEnvironment> provider9, Provider<PreviewAnalytics> provider10, Provider<PrintEnvironment> provider11, Provider<CitationHighlightEnvironment> provider12) {
        return new DocumentPreviewEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static DocumentPreviewEnvironment newInstance(AnnotationsEnvironment annotationsEnvironment, CreateAnnotationEnvironment createAnnotationEnvironment, IUserContextManager iUserContextManager, IPreviewSettingsService iPreviewSettingsService, IScrollableFileTypeResolver iScrollableFileTypeResolver, PreviewObservability previewObservability, BoxAccountManagerHelper boxAccountManagerHelper, CopySelectedTextEnvironment copySelectedTextEnvironment, DocumentSearchEnvironment documentSearchEnvironment, PreviewAnalytics previewAnalytics, PrintEnvironment printEnvironment, CitationHighlightEnvironment citationHighlightEnvironment) {
        return new DocumentPreviewEnvironment(annotationsEnvironment, createAnnotationEnvironment, iUserContextManager, iPreviewSettingsService, iScrollableFileTypeResolver, previewObservability, boxAccountManagerHelper, copySelectedTextEnvironment, documentSearchEnvironment, previewAnalytics, printEnvironment, citationHighlightEnvironment);
    }
}
