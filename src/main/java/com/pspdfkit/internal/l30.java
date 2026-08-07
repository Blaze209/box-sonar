package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.ui.PdfFragment;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l30 {
    public final Context a;
    public final m30 b;
    public final at c;

    public l30(Context context, PdfFragment pdfFragment, at atVar) {
        this.a = context;
        this.b = pdfFragment;
        this.c = atVar;
    }

    public final void exitActiveMode() {
        this.b.exitCurrentlyActiveMode();
    }
}
