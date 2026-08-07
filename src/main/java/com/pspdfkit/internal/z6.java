package com.pspdfkit.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.audio.AudioState", f = "AudioState.kt", i = {0}, l = {56}, m = "getAnnotation", n = {"document"}, nl = {57}, s = {"L$0"}, v = 2)
public final class z6 extends ContinuationImpl {
    public Object a;
    public /* synthetic */ Object b;
    public final /* synthetic */ y6 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z6(y6 y6Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = y6Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(null, this);
    }
}
