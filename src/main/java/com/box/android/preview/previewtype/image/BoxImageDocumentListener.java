package com.box.android.preview.previewtype.image;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.box.android.cpl.Store;
import com.box.android.domain.models.FilePreviewDomainError;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.managers.BoxPdfAnnotationManager;
import com.box.android.preview.annotations.managers.CreateAnnotationsManager;
import com.box.android.preview.annotations.model.DocumentSize;
import com.box.android.preview.integration.nutrient.BoxBaseDocumentListener;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.utils.Size;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxImageDocumentListener.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u00030\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J6\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/preview/previewtype/image/BoxImageDocumentListener;", "Lcom/box/android/preview/integration/nutrient/BoxBaseDocumentListener;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$State;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "getAnnotationStore", "Lkotlin/Function0;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "boxAnnotationManager", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "createAnnotationsManager", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "<init>", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function0;Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;)V", "onDocumentLoaded", "", "document", "Lcom/pspdfkit/document/PdfDocument;", "onDocumentLoadFailed", "exception", "", "onPageClick", "", "pageIndex", "", "event", "Landroid/view/MotionEvent;", "pagePosition", "Landroid/graphics/PointF;", "clickedAnnotation", "Lcom/pspdfkit/annotations/Annotation;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxImageDocumentListener extends BoxBaseDocumentListener {
    public static final int $stable = 8;
    private final Store<ImagePreviewReducer.State, ImagePreviewReducer.Action> store;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxImageDocumentListener(Store<ImagePreviewReducer.State, ImagePreviewReducer.Action> store, Function0<Store<AnnotationsReducer.State, AnnotationsReducer.Action>> getAnnotationStore, BoxPdfAnnotationManager boxAnnotationManager, CreateAnnotationsManager createAnnotationsManager) {
        super(getAnnotationStore, boxAnnotationManager, createAnnotationsManager);
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(getAnnotationStore, "getAnnotationStore");
        Intrinsics.checkNotNullParameter(boxAnnotationManager, "boxAnnotationManager");
        Intrinsics.checkNotNullParameter(createAnnotationsManager, "createAnnotationsManager");
        this.store = store;
    }

    @Override // com.box.android.preview.integration.nutrient.BoxBaseDocumentListener, com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoaded(PdfDocument document) {
        Intrinsics.checkNotNullParameter(document, "document");
        super.onDocumentLoaded(document);
        if (document.getPageCount() == 0) {
            return;
        }
        Size pageSize = document.getPageSize(0);
        Intrinsics.checkNotNullExpressionValue(pageSize, "getPageSize(...)");
        this.store.send(new ImagePreviewReducer.Action.ImageLoaded(new DocumentSize(pageSize.width, pageSize.height)));
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoadFailed(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        super.onDocumentLoadFailed(exception);
        Store<ImagePreviewReducer.State, ImagePreviewReducer.Action> store = this.store;
        String message = exception.getMessage();
        if (message == null) {
            message = "";
        }
        store.send(new ImagePreviewReducer.Action.Error(new FilePreviewDomainError.NutrientError(message)));
    }

    @Override // com.box.android.preview.integration.nutrient.BoxBaseDocumentListener, com.pspdfkit.listeners.DocumentListener
    public boolean onPageClick(PdfDocument document, int pageIndex, MotionEvent event, PointF pagePosition, Annotation clickedAnnotation) {
        Intrinsics.checkNotNullParameter(document, "document");
        if (super.onPageClick(document, pageIndex, event, pagePosition, clickedAnnotation) || pagePosition == null) {
            return false;
        }
        this.store.send(ImagePreviewReducer.Action.ImageClicked.INSTANCE);
        return true;
    }
}
