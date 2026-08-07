package com.pspdfkit.internal;

import android.os.Handler;
import android.os.Looper;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.search.SearchResultHighlighter;

/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public PdfFragment b;
    public SearchResultHighlighter c;
    public final Handler a = new Handler(Looper.getMainLooper());
    public final Range d = new Range(0, 0);
    public final Runnable e = new Runnable() { // from class: com.pspdfkit.internal.u$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            u.a(this.f$0);
        }
    };

    public static final void a(u uVar) {
        SearchResultHighlighter searchResultHighlighter = uVar.c;
        if (searchResultHighlighter != null) {
            searchResultHighlighter.clearSearchResults();
            PdfFragment pdfFragment = uVar.b;
            if (pdfFragment != null) {
                pdfFragment.removeDrawableProvider(searchResultHighlighter);
            }
        }
    }
}
