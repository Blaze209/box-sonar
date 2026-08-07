package com.pspdfkit.internal;

import android.graphics.Matrix;
import com.pspdfkit.annotations.Annotation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.clipboard.CopyPasteManagerImpl", f = "CopyPasteManagerImpl.kt", i = {0, 0, 0, 0}, l = {275}, m = "pasteAnnotation", n = {"annotation", "transformation", "editRecorder", "pageIndex"}, nl = {278}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
public final class xb extends ContinuationImpl {
    public Annotation a;
    public Matrix b;
    public lf c;
    public /* synthetic */ Object d;
    public final /* synthetic */ wb e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xb(wb wbVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = wbVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return wb.a(this.e, null, 0, null, null, this);
    }
}
