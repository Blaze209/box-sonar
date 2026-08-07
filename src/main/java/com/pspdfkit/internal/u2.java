package com.pspdfkit.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.outline.annotations.AnnotationListProvider", f = "AnnotationListProvider.kt", i = {0, 0}, l = {90}, m = "getAnnotationListItemsForPage", n = {"document", "pageIndex"}, nl = {91}, s = {"L$0", "I$0"}, v = 2)
public final class u2 extends ContinuationImpl {
    public lm a;
    public /* synthetic */ Object b;
    public final /* synthetic */ x2 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u2(x2 x2Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = x2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return x2.a(this.c, null, 0, this);
    }
}
