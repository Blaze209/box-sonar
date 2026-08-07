package com.pspdfkit.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.redaction.RedactionProcessorFragment", f = "RedactionProcessorFragment.kt", i = {}, l = {190}, m = "showErrorDialog", n = {}, nl = {191}, s = {}, v = 2)
public final class fy extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ gy b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fy(gy gyVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.b = gyVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return gy.a(this.b, this);
    }
}
