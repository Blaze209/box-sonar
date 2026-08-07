package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeAnnotation;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl", f = "AnnotationProviderImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {206}, m = "loadAnnotations", n = {"oldAnnotations", "nativeAnnotations", "annotations", "$this$forEach$iv", "element$iv", "nativeAnnotation", "annotation", "pageIndex", "$i$f$forEach", "$i$a$-forEach-AnnotationProviderImpl$loadAnnotations$2"}, nl = {209}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 2)
public final class z3 extends ContinuationImpl {
    public int a;
    public int b;
    public List c;
    public Object d;
    public List e;
    public Object f;
    public Iterator g;
    public Object h;
    public NativeAnnotation i;
    public Object j;
    public /* synthetic */ Object k;
    public final /* synthetic */ o3 l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z3(o3 o3Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.l = o3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.k = obj;
        this.m |= Integer.MIN_VALUE;
        return this.l.a(0, (List) null, this);
    }
}
