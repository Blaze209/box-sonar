package com.box.android.preview.integration.nutrient;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.preview.annotations.PdfAnnotationScaleValueProvider;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.managers.BoxPdfAnnotationManager;
import com.box.android.preview.annotations.managers.CreateAnnotationsManager;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.listeners.DocumentListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxBaseDocumentListener.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B3\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J6\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0014H\u0002R\"\u0010\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/box/android/preview/integration/nutrient/BoxBaseDocumentListener;", "Lcom/pspdfkit/listeners/DocumentListener;", "getAnnotationStore", "Lkotlin/Function0;", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "boxAnnotationManager", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "createAnnotationsManager", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;)V", "onDocumentLoaded", "", "document", "Lcom/pspdfkit/document/PdfDocument;", "onPageClick", "", "pageIndex", "", "event", "Landroid/view/MotionEvent;", "pagePosition", "Landroid/graphics/PointF;", "clickedAnnotation", "Lcom/pspdfkit/annotations/Annotation;", "getClickedAnnotation", "Lcom/box/android/preview/annotations/model/Annotation;", "point", "pageNumber", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class BoxBaseDocumentListener implements DocumentListener {
    public static final int $stable = 8;
    private final BoxPdfAnnotationManager boxAnnotationManager;
    private final CreateAnnotationsManager createAnnotationsManager;
    private final Function0<Store<AnnotationsReducer.State, AnnotationsReducer.Action>> getAnnotationStore;

    public BoxBaseDocumentListener(Function0<Store<AnnotationsReducer.State, AnnotationsReducer.Action>> getAnnotationStore, BoxPdfAnnotationManager boxAnnotationManager, CreateAnnotationsManager createAnnotationsManager) {
        Intrinsics.checkNotNullParameter(getAnnotationStore, "getAnnotationStore");
        Intrinsics.checkNotNullParameter(boxAnnotationManager, "boxAnnotationManager");
        Intrinsics.checkNotNullParameter(createAnnotationsManager, "createAnnotationsManager");
        this.getAnnotationStore = getAnnotationStore;
        this.boxAnnotationManager = boxAnnotationManager;
        this.createAnnotationsManager = createAnnotationsManager;
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoaded(PdfDocument document) {
        Intrinsics.checkNotNullParameter(document, "document");
        PdfAnnotationScaleValueProvider pdfAnnotationScaleValueProvider = new PdfAnnotationScaleValueProvider();
        pdfAnnotationScaleValueProvider.setPdfDocument(document);
        this.boxAnnotationManager.setPdfAnnotationScaleValueProvider(pdfAnnotationScaleValueProvider);
        this.createAnnotationsManager.setDefaultConfigurations();
        this.createAnnotationsManager.setPdfAnnotationScaleValueProvider(pdfAnnotationScaleValueProvider);
        super.onDocumentLoaded(document);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public boolean onPageClick(PdfDocument document, int pageIndex, MotionEvent event, PointF pagePosition, Annotation clickedAnnotation) {
        Intrinsics.checkNotNullParameter(document, "document");
        if (pagePosition != null) {
            com.box.android.preview.annotations.model.Annotation clickedAnnotation2 = getClickedAnnotation(pagePosition, pageIndex + 1);
            AnnotationsReducer.State state = (AnnotationsReducer.State) StoreKt.stateValue(this.getAnnotationStore.invoke());
            boolean z = (state != null ? state.getSelectedAnnotation() : null) != null;
            if (clickedAnnotation2 != null) {
                this.getAnnotationStore.invoke().send(new AnnotationsReducer.Action.AnnotationSelected(clickedAnnotation2, new AnnotationsReducer.AnnotationPopupLocation(pagePosition, pageIndex)));
                return true;
            }
            if (z) {
                this.getAnnotationStore.invoke().send(AnnotationsReducer.Action.UnselectAnnotation.INSTANCE);
                return true;
            }
        }
        return false;
    }

    private final com.box.android.preview.annotations.model.Annotation getClickedAnnotation(PointF point, int pageNumber) {
        if (this.boxAnnotationManager.getAnnotationVisibility()) {
            return this.boxAnnotationManager.selectAnnotationContainingPoint(point, new AnnotationLocationModel.Page(pageNumber));
        }
        return null;
    }
}
