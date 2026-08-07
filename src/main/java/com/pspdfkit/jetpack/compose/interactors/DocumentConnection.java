package com.pspdfkit.jetpack.compose.interactors;

import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.ui.PdfUi;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u001e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H&R\u001e\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020 X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0012\u0010'\u001a\u00020(X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006+À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/jetpack/compose/interactors/DocumentConnection;", "", "addAnnotationToPage", "", "annotation", "Lcom/pspdfkit/annotations/Annotation;", "selectImmediately", "", "setPageIndex", "pageIndex", "", "addDrawableProvider", "highlighter", "Lcom/pspdfkit/ui/search/SearchResultHighlighter;", "save", "path", "", "options", "Lcom/pspdfkit/document/DocumentSaveOptions;", "highlight", "documentRect", "", "Landroid/graphics/RectF;", "showToolbarMenu", "Lkotlin/Function1;", "getShowToolbarMenu", "()Lkotlin/jvm/functions/Function1;", "annotationConfigurationRegistry", "Lcom/pspdfkit/annotations/configuration/AnnotationConfigurationRegistry;", "getAnnotationConfigurationRegistry", "()Lcom/pspdfkit/annotations/configuration/AnnotationConfigurationRegistry;", "pdfUI", "Lcom/pspdfkit/ui/PdfUi;", "getPdfUI$annotations", "()V", "getPdfUI", "()Lcom/pspdfkit/ui/PdfUi;", "pdfUi", "getPdfUi", "pdfActivityViews", "Lcom/pspdfkit/ui/PSPDFKitViews;", "getPdfActivityViews", "()Lcom/pspdfkit/ui/PSPDFKitViews;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface DocumentConnection {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(message = "v2024.9: Will be removed in 2025.", replaceWith = @ReplaceWith(expression = "pdfUi ", imports = {}))
        public static /* synthetic */ void getPdfUI$annotations() {
        }
    }

    static /* synthetic */ void save$default(DocumentConnection documentConnection, String str, DocumentSaveOptions documentSaveOptions, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: save");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            documentSaveOptions = null;
        }
        documentConnection.save(str, documentSaveOptions);
    }

    void addAnnotationToPage(Annotation annotation, boolean selectImmediately);

    void addDrawableProvider(SearchResultHighlighter highlighter);

    AnnotationConfigurationRegistry getAnnotationConfigurationRegistry();

    PSPDFKitViews getPdfActivityViews();

    PdfUi getPdfUI();

    PdfUi getPdfUi();

    Function1<Boolean, Unit> getShowToolbarMenu();

    void highlight(int pageIndex, List<? extends RectF> documentRect);

    void save(String path, DocumentSaveOptions options);

    void setPageIndex(int pageIndex);
}
