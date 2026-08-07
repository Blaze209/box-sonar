package com.pspdfkit.ui.toolbar.popup;

import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PopupToolbar;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/pspdfkit/ui/toolbar/popup/AnnotationPopupToolbar;", "Lcom/pspdfkit/ui/PopupToolbar;", "pdfFragment", "Lcom/pspdfkit/ui/PdfFragment;", "annotations", "", "Lcom/pspdfkit/annotations/Annotation;", "<init>", "(Lcom/pspdfkit/ui/PdfFragment;Ljava/util/List;)V", "getAnnotations", "()Ljava/util/List;", "viewId", "", "getViewId", "()I", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnnotationPopupToolbar extends PopupToolbar {
    public static final int $stable = 8;
    private final List<Annotation> annotations;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AnnotationPopupToolbar(PdfFragment pdfFragment, List<? extends Annotation> list) {
        super(pdfFragment);
        pdfFragment.getClass();
        list.getClass();
        this.annotations = list;
    }

    public final List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override // com.pspdfkit.ui.PopupToolbar
    public int getViewId() {
        return R.id.pspdf__annotation_selection_toolbar;
    }
}
