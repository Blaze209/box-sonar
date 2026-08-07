package com.margelo.nitro.core;

import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Promise.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.margelo.nitro.core.Promise$Companion$async$1", f = "Promise.kt", i = {}, l = {Token.XML}, m = "invokeSuspend", n = {}, s = {})
final class Promise$Companion$async$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Promise<T> $promise;
    final /* synthetic */ Function1<Continuation<? super T>, Object> $run;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Promise$Companion$async$1(Function1<? super Continuation<? super T>, ? extends Object> function1, Promise<T> promise, Continuation<? super Promise$Companion$async$1> continuation) {
        super(2, continuation);
        this.$run = function1;
        this.$promise = promise;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Promise$Companion$async$1(this.$run, this.$promise, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Promise$Companion$async$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.margelo.nitro.core.Promise$Companion$async$1 for r3v4 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r3.label
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L11
            kotlin.ResultKt.throwOnFailure(r4)     // Catch: java.lang.Throwable -> Lf
            goto L27
        Lf:
            r4 = move-exception
            goto L2d
        L11:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L19:
            kotlin.ResultKt.throwOnFailure(r4)
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super T>, java.lang.Object> r4 = r3.$run     // Catch: java.lang.Throwable -> Lf
            r3.label = r2     // Catch: java.lang.Throwable -> Lf
            java.lang.Object r4 = r4.invoke(r3)     // Catch: java.lang.Throwable -> Lf
            if (r4 != r0) goto L27
            return r0
        L27:
            com.margelo.nitro.core.Promise<T> r0 = r3.$promise     // Catch: java.lang.Throwable -> Lf
            r0.resolve(r4)     // Catch: java.lang.Throwable -> Lf
            goto L32
        L2d:
            com.margelo.nitro.core.Promise<T> r3 = r3.$promise
            r3.reject(r4)
        L32:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.margelo.nitro.core.Promise$Companion$async$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
