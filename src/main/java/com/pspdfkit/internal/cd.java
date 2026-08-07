package com.pspdfkit.internal;

import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.jetpack.compose.interactors.DocumentConnection;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.ui.PdfUi;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class cd implements DocumentConnection {
    public final Function1<Boolean, Unit> a = new Function1() { // from class: com.pspdfkit.internal.cd$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return cd.a(((Boolean) obj).booleanValue());
        }
    };

    public static final Unit a(boolean z) {
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void addAnnotationToPage(Annotation annotation, boolean z) {
        annotation.getClass();
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void addDrawableProvider(SearchResultHighlighter searchResultHighlighter) {
        searchResultHighlighter.getClass();
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final AnnotationConfigurationRegistry getAnnotationConfigurationRegistry() {
        throw new IllegalStateException("UI is not initialized yet.");
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final PSPDFKitViews getPdfActivityViews() {
        throw new IllegalStateException("UI is not initialized yet.");
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final PdfUi getPdfUI() {
        throw new IllegalStateException("UI is not initialized yet.");
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final PdfUi getPdfUi() {
        throw new IllegalStateException("UI is not initialized yet.");
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final Function1<Boolean, Unit> getShowToolbarMenu() {
        return this.a;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void highlight(int i, List<? extends RectF> list) {
        list.getClass();
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void save(String str, DocumentSaveOptions documentSaveOptions) {
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void setPageIndex(int i) {
    }
}
