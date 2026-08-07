package com.pspdfkit.internal;

import androidx.media3.extractor.ts.PsExtractor;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.redaction.RedactionProcessorFragment", f = "RedactionProcessorFragment.kt", i = {}, l = {PsExtractor.VIDEO_STREAM_MASK}, m = "awaitPdfUi", n = {}, nl = {241}, s = {}, v = 2)
public final class zx extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ gy b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zx(gy gyVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.b = gyVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        gy gyVar = this.b;
        int i = gy.h;
        return gyVar.a(this);
    }
}
