package com.pspdfkit.internal;

import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.document.DocumentSaver", f = "DocumentSaver.kt", i = {1}, l = {126, Token.LOCAL_BLOCK}, m = "executeSave", n = {"saveOptions"}, nl = {Token.LABEL, Token.SET_REF_OP}, s = {"L$0"}, v = 2)
public final class ge extends ContinuationImpl {
    public Object a;
    public /* synthetic */ Object b;
    public final /* synthetic */ de c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge(de deVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = deVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return de.a(this.c, this);
    }
}
