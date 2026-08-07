package com.pspdfkit.annotations.links;

import android.content.Context;
import com.pspdfkit.annotations.LinkAnnotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.eo;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ0\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/pspdfkit/annotations/links/LinkAnnotationHighlighter;", "Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/pspdfkit/annotations/LinkAnnotation;", "linkAnnotation", "", "setLinkAnnotation", "(Lcom/pspdfkit/annotations/LinkAnnotation;)V", "Lcom/pspdfkit/document/PdfDocument;", "document", "", "pageIndex", "", "Lcom/pspdfkit/ui/drawable/PdfDrawable;", "getDrawablesForPage", "(Landroid/content/Context;Lcom/pspdfkit/document/PdfDocument;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/pspdfkit/internal/eo;", "themeConfiguration", "Lcom/pspdfkit/internal/eo;", "Lcom/pspdfkit/annotations/links/HighlightedLinkAnnotationDrawable;", "highlighted", "Lcom/pspdfkit/annotations/links/HighlightedLinkAnnotationDrawable;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LinkAnnotationHighlighter extends PdfDrawableProvider {
    public static final int $stable = 8;
    private HighlightedLinkAnnotationDrawable highlighted;
    private final eo themeConfiguration;

    public LinkAnnotationHighlighter(Context context) {
        context.getClass();
        this.themeConfiguration = new eo(context);
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawableProvider
    public Object getDrawablesForPage(Context context, PdfDocument pdfDocument, int i, Continuation<? super List<? extends PdfDrawable>> continuation) {
        HighlightedLinkAnnotationDrawable highlightedLinkAnnotationDrawable = this.highlighted;
        return (highlightedLinkAnnotationDrawable == null || highlightedLinkAnnotationDrawable.getLinkAnnotation().getPageIndex() != i) ? CollectionsKt.emptyList() : CollectionsKt.listOf(highlightedLinkAnnotationDrawable);
    }

    public final void setLinkAnnotation(LinkAnnotation linkAnnotation) {
        HighlightedLinkAnnotationDrawable highlightedLinkAnnotationDrawable;
        if (linkAnnotation == null) {
            highlightedLinkAnnotationDrawable = null;
        } else {
            HighlightedLinkAnnotationDrawable highlightedLinkAnnotationDrawable2 = new HighlightedLinkAnnotationDrawable(linkAnnotation);
            highlightedLinkAnnotationDrawable2.applyTheme(this.themeConfiguration);
            highlightedLinkAnnotationDrawable = highlightedLinkAnnotationDrawable2;
        }
        this.highlighted = highlightedLinkAnnotationDrawable;
        notifyDrawablesChanged();
    }
}
