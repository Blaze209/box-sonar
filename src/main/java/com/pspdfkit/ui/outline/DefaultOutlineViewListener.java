package com.pspdfkit.ui.outline;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.FileAnnotation;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.GoToEmbeddedAction;
import com.pspdfkit.document.OutlineElement;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfOutlineView;
import com.pspdfkit.utils.PdfLog;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0015B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/pspdfkit/ui/outline/DefaultOutlineViewListener;", "Lcom/pspdfkit/ui/PdfOutlineView$OnOutlineElementTapListener;", "Lcom/pspdfkit/ui/PdfOutlineView$OnAnnotationTapListener;", "Lcom/pspdfkit/ui/PdfOutlineView$OnEmbeddedFileTapListener;", "pdfFragment", "Lcom/pspdfkit/ui/PdfFragment;", "<init>", "(Lcom/pspdfkit/ui/PdfFragment;)V", "onAnnotationTap", "", "self", "Lcom/pspdfkit/ui/PdfOutlineView;", "annotation", "Lcom/pspdfkit/annotations/Annotation;", "onOutlineElementTap", "outlineElement", "Lcom/pspdfkit/document/OutlineElement;", "onEmbeddedFileTap", "embeddedFile", "Lcom/pspdfkit/document/files/EmbeddedFile;", "openEmbeddedDocument", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultOutlineViewListener implements PdfOutlineView.OnOutlineElementTapListener, PdfOutlineView.OnAnnotationTapListener, PdfOutlineView.OnEmbeddedFileTapListener {
    private static final String LOG_TAG = "PSPDFKIT.DefaultOutlineViewListener";
    private static final String PDF_SUFFIX = ".pdf";
    private final PdfFragment pdfFragment;
    public static final int $stable = 8;

    public DefaultOutlineViewListener(PdfFragment pdfFragment) {
        pdfFragment.getClass();
        this.pdfFragment = pdfFragment;
    }

    private final void openEmbeddedDocument(EmbeddedFile embeddedFile) {
        try {
            this.pdfFragment.executeAction(new GoToEmbeddedAction(embeddedFile.getFileName(), 0, true, null, null, 24, null));
        } catch (Exception e) {
            PdfLog.e(LOG_TAG, "Cannot open embedded document", e);
        }
    }

    @Override // com.pspdfkit.ui.PdfOutlineView.OnAnnotationTapListener
    public void onAnnotationTap(PdfOutlineView self, Annotation annotation) {
        self.getClass();
        annotation.getClass();
        int pageIndex = annotation.getPageIndex();
        if (pageIndex < 0) {
            return;
        }
        PdfFragment pdfFragment = this.pdfFragment;
        pdfFragment.beginNavigation();
        pdfFragment.setPageIndex(pageIndex, false);
        pdfFragment.setSelectedAnnotation(annotation);
        pdfFragment.endNavigation();
    }

    @Override // com.pspdfkit.ui.PdfOutlineView.OnEmbeddedFileTapListener
    public void onEmbeddedFileTap(PdfOutlineView self, EmbeddedFile embeddedFile) {
        self.getClass();
        embeddedFile.getClass();
        String fileName = embeddedFile.getFileName();
        fileName.getClass();
        if (StringsKt.endsWith$default(fileName, PDF_SUFFIX, false, 2, (Object) null)) {
            openEmbeddedDocument(embeddedFile);
            return;
        }
        FileAnnotation annotation = embeddedFile.getAnnotation();
        if (annotation != null) {
            self.hide();
            onAnnotationTap(self, annotation);
        }
    }

    @Override // com.pspdfkit.ui.PdfOutlineView.OnOutlineElementTapListener
    public void onOutlineElementTap(PdfOutlineView self, OutlineElement outlineElement) {
        self.getClass();
        outlineElement.getClass();
        Action action = outlineElement.getAction();
        if (action != null) {
            this.pdfFragment.executeAction(action);
        }
    }
}
