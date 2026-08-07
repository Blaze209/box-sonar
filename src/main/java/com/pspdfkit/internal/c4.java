package com.pspdfkit.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl", f = "AnnotationProviderImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {830}, m = "refreshCachedAnnotationsForPages$suspendImpl", n = {"$this", "pageIndexes", "$this$flatMap$iv", "$this$flatMapTo$iv$iv", "destination$iv$iv", "element$iv$iv", "$i$f$flatMap", "$i$f$flatMapTo", "pageIndex", "$i$a$-flatMap-AnnotationProviderImpl$refreshCachedAnnotationsForPages$2"}, nl = {1112}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "I$0", "I$1", "I$2", "I$3"}, v = 2)
public final class c4 extends ContinuationImpl {
    public o3 a;
    public Object b;
    public Object c;
    public Object d;
    public Collection e;
    public Iterator f;
    public Object g;
    public int h;
    public int i;
    public /* synthetic */ Object j;
    public final /* synthetic */ o3 k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c4(o3 o3Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.k = o3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.j = obj;
        this.l |= Integer.MIN_VALUE;
        return o3.a(this.k, (Set) null, (ContinuationImpl) this);
    }
}
