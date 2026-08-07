package com.pspdfkit.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.PageLayout$bindPage$3", f = "PageLayout.kt", i = {}, l = {500, 501}, m = "invokeSuspend", n = {}, nl = {501, 504}, s = {}, v = 2)
public final class bu extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ au b;
    public final /* synthetic */ lm c;
    public final /* synthetic */ int d;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.PageLayout$bindPage$3$1", f = "PageLayout.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ au a;
        public final /* synthetic */ lm b;
        public final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(au auVar, lm lmVar, int i, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = auVar;
            this.b = lmVar;
            this.c = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            au auVar = this.a;
            lm lmVar = this.b;
            int i = this.c;
            int i2 = au.b0;
            auVar.a(lmVar, i);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(au auVar, lm lmVar, int i, Continuation<? super bu> continuation) {
        super(2, continuation);
        this.b = auVar;
        this.c = lmVar;
        this.d = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new bu(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((bu) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r8, r1, r7) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r8)
            goto L45
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L2c
        L1e:
            kotlin.ResultKt.throwOnFailure(r8)
            r7.a = r3
            r3 = 100
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r3, r7)
            if (r8 != r0) goto L2c
            goto L44
        L2c:
            kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
            com.pspdfkit.internal.bu$a r1 = new com.pspdfkit.internal.bu$a
            com.pspdfkit.internal.au r3 = r7.b
            com.pspdfkit.internal.lm r4 = r7.c
            int r5 = r7.d
            r6 = 0
            r1.<init>(r3, r4, r5, r6)
            r7.a = r2
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r7)
            if (r7 != r0) goto L45
        L44:
            return r0
        L45:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.bu.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
