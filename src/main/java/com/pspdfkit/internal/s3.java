package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$getAnnotations$2", f = "AnnotationProviderImpl.kt", i = {0, 0, 1, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {1115, Token.SETCONSTVAR, Token.COMMENT, 1126, 1137}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "loadHandle", "loadHandle", "loadHandle", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "loadHandle", "annotations", "$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {1116, Token.DEBUGGER, Token.GENEXPR, 1127, 1138}, s = {"L$0", "I$1", "L$0", "L$0", "L$0", "L$1", "L$2", "I$1", "L$0", "L$1", "L$2", "I$1"}, v = 2)
public final class s3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
    public Object a;
    public Object b;
    public Mutex c;
    public o3 d;
    public int e;
    public int f;
    public final /* synthetic */ o3 g;
    public final /* synthetic */ int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s3(o3 o3Var, int i, Continuation<? super s3> continuation) {
        super(2, continuation);
        this.g = o3Var;
        this.h = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new s3(this.g, this.h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
        return new s3(this.g, this.h, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x011e  */
    /* JADX WARN: Code duplicated, block: B:58:0x016a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        o3 o3Var;
        Mutex mutex;
        int i;
        o3.a aVar;
        Object objA;
        Throwable th;
        o3 o3Var2;
        Mutex mutex2;
        int i2;
        o3.a aVar2;
        Throwable th2;
        o3 o3Var3;
        Mutex mutex3;
        int i3;
        List<Annotation> list;
        o3 o3Var4;
        Mutex mutex4;
        int i4;
        List<Annotation> list2;
        o3 o3Var5;
        o3.a aVar3;
        Mutex mutex5;
        int i5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.f;
        try {
            if (i6 == 0) {
                ResultKt.throwOnFailure(obj);
                this.g.a(this.h);
                o3Var = this.g;
                mutex = o3Var.j;
                i = this.h;
                this.a = mutex;
                this.b = o3Var;
                this.e = i;
                this.f = 1;
                if (mutex.lock(null, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i6 == 1) {
                i = this.e;
                o3Var = (o3) this.b;
                mutex = (Mutex) this.a;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i6 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                if (i6 == 3) {
                    o3.a aVar4 = (o3.a) this.a;
                    try {
                        ResultKt.throwOnFailure(obj);
                        objA = obj;
                        aVar = aVar4;
                        list = (List) objA;
                        o3Var4 = this.g;
                        mutex4 = o3Var4.j;
                        i4 = this.h;
                        this.a = aVar;
                        this.b = list;
                        this.c = mutex4;
                        this.d = o3Var4;
                        this.e = i4;
                        this.f = 5;
                        if (mutex4.lock(null, this) != coroutine_suspended) {
                            list2 = list;
                            o3Var5 = o3Var4;
                            aVar3 = aVar;
                            mutex5 = mutex4;
                            i5 = i4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        aVar = aVar4;
                        o3Var2 = this.g;
                        mutex2 = o3Var2.j;
                        i2 = this.h;
                        this.a = aVar;
                        this.b = th;
                        this.c = mutex2;
                        this.d = o3Var2;
                        this.e = i2;
                        this.f = 4;
                        if (mutex2.lock(null, this) != coroutine_suspended) {
                            aVar2 = aVar;
                            th2 = th;
                            o3Var3 = o3Var2;
                            mutex3 = mutex2;
                            i3 = i2;
                            mutex3.unlock(null);
                            aVar2.a.completeExceptionally(th2);
                            throw th2;
                        }
                    }
                    return coroutine_suspended;
                }
                if (i6 == 4) {
                    i3 = this.e;
                    o3Var3 = this.d;
                    mutex3 = this.c;
                    th2 = (Throwable) this.b;
                    aVar2 = (o3.a) this.a;
                    ResultKt.throwOnFailure(obj);
                    try {
                        mutex3.unlock(null);
                        aVar2.a.completeExceptionally(th2);
                        throw th2;
                    } catch (Throwable th4) {
                        mutex3.unlock(null);
                        throw th4;
                    }
                }
                if (i6 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i5 = this.e;
                o3Var5 = this.d;
                mutex5 = this.c;
                list2 = (List) this.b;
                aVar3 = (o3.a) this.a;
                ResultKt.throwOnFailure(obj);
            }
            try {
                o3Var5.b.put(Boxing.boxInt(i5), list2);
                o3Var5.c.remove(Boxing.boxInt(i5));
                mutex5.unlock(null);
                aVar3.a.complete(list2);
                return list2;
            } catch (Throwable th5) {
                mutex5.unlock(null);
                throw th5;
            }
            List<Annotation> list3 = o3Var.b.get(Boxing.boxInt(i));
            if (!o3Var.c.contains(Boxing.boxInt(i)) && list3 != null) {
                mutex.unlock(null);
                return list3;
            }
            CompletableDeferred completableDeferred = (CompletableDeferred) o3Var.k.get(Boxing.boxInt(i));
            if (completableDeferred != null) {
                aVar = new o3.a(completableDeferred, false, null);
            } else {
                CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                o3Var.k.put(Boxing.boxInt(i), completableDeferredCompletableDeferred$default);
                aVar = new o3.a(completableDeferredCompletableDeferred$default, true, list3);
            }
            mutex.unlock(null);
            if (aVar.b) {
                try {
                    o3 o3Var6 = this.g;
                    int i7 = this.h;
                    List<Annotation> list4 = aVar.c;
                    this.a = aVar;
                    this.b = null;
                    this.f = 3;
                    objA = o3Var6.a(i7, list4, this);
                    if (objA != coroutine_suspended) {
                        list = (List) objA;
                        o3Var4 = this.g;
                        mutex4 = o3Var4.j;
                        i4 = this.h;
                        this.a = aVar;
                        this.b = list;
                        this.c = mutex4;
                        this.d = o3Var4;
                        this.e = i4;
                        this.f = 5;
                        if (mutex4.lock(null, this) != coroutine_suspended) {
                            list2 = list;
                            o3Var5 = o3Var4;
                            aVar3 = aVar;
                            mutex5 = mutex4;
                            i5 = i4;
                            o3Var5.b.put(Boxing.boxInt(i5), list2);
                            o3Var5.c.remove(Boxing.boxInt(i5));
                            mutex5.unlock(null);
                            aVar3.a.complete(list2);
                            return list2;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    o3Var2 = this.g;
                    mutex2 = o3Var2.j;
                    i2 = this.h;
                    this.a = aVar;
                    this.b = th;
                    this.c = mutex2;
                    this.d = o3Var2;
                    this.e = i2;
                    this.f = 4;
                    if (mutex2.lock(null, this) != coroutine_suspended) {
                        aVar2 = aVar;
                        th2 = th;
                        o3Var3 = o3Var2;
                        mutex3 = mutex2;
                        i3 = i2;
                        mutex3.unlock(null);
                        aVar2.a.completeExceptionally(th2);
                        throw th2;
                    }
                }
            } else {
                CompletableDeferred<List<Annotation>> completableDeferred2 = aVar.a;
                this.a = SpillingKt.nullOutSpilledVariable(aVar);
                this.b = null;
                this.f = 2;
                Object objAwait = completableDeferred2.await(this);
                if (objAwait != coroutine_suspended) {
                    return objAwait;
                }
            }
            return coroutine_suspended;
        } catch (Throwable th7) {
            mutex.unlock(null);
            throw th7;
        }
    }
}
