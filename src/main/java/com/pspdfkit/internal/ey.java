package com.pspdfkit.internal;

import android.net.Uri;
import com.pspdfkit.document.PdfDocument;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.redaction.RedactionProcessorFragment", f = "RedactionProcessorFragment.kt", i = {0, 0}, l = {125}, m = "showDocumentInNewTab", n = {"document", "uri"}, nl = {126}, s = {"L$0", "L$1"}, v = 2)
public final class ey extends ContinuationImpl {
    public PdfDocument a;
    public Uri b;
    public /* synthetic */ Object c;
    public final /* synthetic */ gy d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ey(gy gyVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = gyVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return gy.a(this.d, null, null, this);
    }
}
