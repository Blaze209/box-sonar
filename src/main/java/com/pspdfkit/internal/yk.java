package com.pspdfkit.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.instant.annotations.InstantAnnotationProviderImpl", f = "InstantAnnotationProviderImpl.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {361, 64}, m = "withAddRemoveLock", n = {"block", "$this$withLock_u24default$iv", "$i$f$withLock", "block", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-InstantAnnotationProviderImpl$withAddRemoveLock$2"}, nl = {362, 363}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1"}, v = 2)
public final class yk<T> extends ContinuationImpl {
    public Object a;
    public Mutex b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ wk e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yk(wk wkVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = wkVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a((bl) null, this);
    }
}
