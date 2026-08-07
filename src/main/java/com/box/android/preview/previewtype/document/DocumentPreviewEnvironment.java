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
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001Bi\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;", "", "annotationsEnvironment", "Lcom/box/android/preview/annotations/cpl/AnnotationsEnvironment;", "createAnnotationEnvironment", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "previewSettingsService", "Lcom/box/android/domain/services/IPreviewSettingsService;", "scrollableFileTypeResolver", "Lcom/box/android/preview/item/IScrollableFileTypeResolver;", "observability", "Lcom/box/android/domain/metrics/preview/PreviewObservability;", "boxAccountManagerHelper", "Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;", "copyTextEnvironment", "Lcom/box/android/preview/document/copytext/CopySelectedTextEnvironment;", "searchEnvironment", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchEnvironment;", "analytics", "Lcom/box/android/preview/preview/PreviewAnalytics;", "printEnvironment", "Lcom/box/android/preview/previewtype/document/print/PrintEnvironment;", "citationHighlightEnvironment", "Lcom/box/android/preview/previewtype/document/CitationHighlightEnvironment;", "<init>", "(Lcom/box/android/preview/annotations/cpl/AnnotationsEnvironment;Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/services/IPreviewSettingsService;Lcom/box/android/preview/item/IScrollableFileTypeResolver;Lcom/box/android/domain/metrics/preview/PreviewObservability;Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;Lcom/box/android/preview/document/copytext/CopySelectedTextEnvironment;Lcom/box/android/preview/previewtype/document/search/DocumentSearchEnvironment;Lcom/box/android/preview/preview/PreviewAnalytics;Lcom/box/android/preview/previewtype/document/print/PrintEnvironment;Lcom/box/android/preview/previewtype/document/CitationHighlightEnvironment;)V", "getAnnotationsEnvironment", "()Lcom/box/android/preview/annotations/cpl/AnnotationsEnvironment;", "getCreateAnnotationEnvironment", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "getPreviewSettingsService", "()Lcom/box/android/domain/services/IPreviewSettingsService;", "getScrollableFileTypeResolver", "()Lcom/box/android/preview/item/IScrollableFileTypeResolver;", "getObservability", "()Lcom/box/android/domain/metrics/preview/PreviewObservability;", "getBoxAccountManagerHelper", "()Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;", "getCopyTextEnvironment", "()Lcom/box/android/preview/document/copytext/CopySelectedTextEnvironment;", "getSearchEnvironment", "()Lcom/box/android/preview/previewtype/document/search/DocumentSearchEnvironment;", "getAnalytics", "()Lcom/box/android/preview/preview/PreviewAnalytics;", "getPrintEnvironment", "()Lcom/box/android/preview/previewtype/document/print/PrintEnvironment;", "getCitationHighlightEnvironment", "()Lcom/box/android/preview/previewtype/document/CitationHighlightEnvironment;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentPreviewEnvironment {
    public static final int $stable = 8;
    private final PreviewAnalytics analytics;
    private final AnnotationsEnvironment annotationsEnvironment;
    private final BoxAccountManagerHelper boxAccountManagerHelper;
    private final CitationHighlightEnvironment citationHighlightEnvironment;
    private final CopySelectedTextEnvironment copyTextEnvironment;
    private final CreateAnnotationEnvironment createAnnotationEnvironment;
    private final PreviewObservability observability;
    private final IPreviewSettingsService previewSettingsService;
    private final PrintEnvironment printEnvironment;
    private final IScrollableFileTypeResolver scrollableFileTypeResolver;
    private final DocumentSearchEnvironment searchEnvironment;
    private final IUserContextManager userContextManager;

    @Inject
    public DocumentPreviewEnvironment(AnnotationsEnvironment annotationsEnvironment, CreateAnnotationEnvironment createAnnotationEnvironment, IUserContextManager userContextManager, IPreviewSettingsService previewSettingsService, IScrollableFileTypeResolver scrollableFileTypeResolver, PreviewObservability observability, BoxAccountManagerHelper boxAccountManagerHelper, CopySelectedTextEnvironment copyTextEnvironment, DocumentSearchEnvironment searchEnvironment, PreviewAnalytics analytics, PrintEnvironment printEnvironment, CitationHighlightEnvironment citationHighlightEnvironment) {
        Intrinsics.checkNotNullParameter(annotationsEnvironment, "annotationsEnvironment");
        Intrinsics.checkNotNullParameter(createAnnotationEnvironment, "createAnnotationEnvironment");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(previewSettingsService, "previewSettingsService");
        Intrinsics.checkNotNullParameter(scrollableFileTypeResolver, "scrollableFileTypeResolver");
        Intrinsics.checkNotNullParameter(observability, "observability");
        Intrinsics.checkNotNullParameter(boxAccountManagerHelper, "boxAccountManagerHelper");
        Intrinsics.checkNotNullParameter(copyTextEnvironment, "copyTextEnvironment");
        Intrinsics.checkNotNullParameter(searchEnvironment, "searchEnvironment");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(printEnvironment, "printEnvironment");
        Intrinsics.checkNotNullParameter(citationHighlightEnvironment, "citationHighlightEnvironment");
        this.annotationsEnvironment = annotationsEnvironment;
        this.createAnnotationEnvironment = createAnnotationEnvironment;
        this.userContextManager = userContextManager;
        this.previewSettingsService = previewSettingsService;
        this.scrollableFileTypeResolver = scrollableFileTypeResolver;
        this.observability = observability;
        this.boxAccountManagerHelper = boxAccountManagerHelper;
        this.copyTextEnvironment = copyTextEnvironment;
        this.searchEnvironment = searchEnvironment;
        this.analytics = analytics;
        this.printEnvironment = printEnvironment;
        this.citationHighlightEnvironment = citationHighlightEnvironment;
    }

    public final AnnotationsEnvironment getAnnotationsEnvironment() {
        return this.annotationsEnvironment;
    }

    public final CreateAnnotationEnvironment getCreateAnnotationEnvironment() {
        return this.createAnnotationEnvironment;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final IPreviewSettingsService getPreviewSettingsService() {
        return this.previewSettingsService;
    }

    public final IScrollableFileTypeResolver getScrollableFileTypeResolver() {
        return this.scrollableFileTypeResolver;
    }

    public final PreviewObservability getObservability() {
        return this.observability;
    }

    public final BoxAccountManagerHelper getBoxAccountManagerHelper() {
        return this.boxAccountManagerHelper;
    }

    public final CopySelectedTextEnvironment getCopyTextEnvironment() {
        return this.copyTextEnvironment;
    }

    public final DocumentSearchEnvironment getSearchEnvironment() {
        return this.searchEnvironment;
    }

    public final PreviewAnalytics getAnalytics() {
        return this.analytics;
    }

    public final PrintEnvironment getPrintEnvironment() {
        return this.printEnvironment;
    }

    public final CitationHighlightEnvironment getCitationHighlightEnvironment() {
        return this.citationHighlightEnvironment;
    }
}
