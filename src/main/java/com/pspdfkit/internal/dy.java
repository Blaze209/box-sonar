package com.pspdfkit.internal;

import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.redaction.RedactionProcessorFragment", f = "RedactionProcessorFragment.kt", i = {0}, l = {Token.YIELD_STAR}, m = "reopenDocument", n = {"document"}, nl = {Token.LAST_TOKEN}, s = {"L$0"}, v = 2)
public final class dy extends ContinuationImpl {
    public lm a;
    public /* synthetic */ Object b;
    public final /* synthetic */ gy c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dy(gy gyVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = gyVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return gy.a(this.c, null, this);
    }
}
