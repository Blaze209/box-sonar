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
@DebugMetadata(c = "com.pspdfkit.internal.views.page.PageEditor$initialiseMeasurementSnapper$1", f = "PageEditor.kt", i = {2}, l = {324, 327, 333}, m = "invokeSuspend", n = {"snapper"}, nl = {326, 333, 336}, s = {"L$0"}, v = 2)
public final class xt extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public int b;
    public final /* synthetic */ vt c;
    public final /* synthetic */ int d;
    public final /* synthetic */ lm e;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.PageEditor$initialiseMeasurementSnapper$1$1", f = "PageEditor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ vt a;
        public final /* synthetic */ aq b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vt vtVar, aq aqVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = vtVar;
            this.b = aqVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new a(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            this.a.p = this.b;
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xt(vt vtVar, int i, lm lmVar, Continuation<? super xt> continuation) {
        super(2, continuation);
        this.c = vtVar;
        this.d = i;
        this.e = lmVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new xt(this.c, this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((xt) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r1, r5, r13) == r0) goto L27;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.b
            java.lang.String r2 = "Nutri.PageEditor"
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L33
            if (r1 == r6) goto L2f
            if (r1 == r5) goto L25
            if (r1 != r4) goto L1d
            java.lang.Object r13 = r13.a
            com.pspdfkit.internal.aq r13 = (com.pspdfkit.internal.aq) r13
            kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            goto L9f
        L1d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L25:
            kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            goto L73
        L29:
            r0 = move-exception
            r13 = r0
            goto L90
        L2c:
            r0 = move-exception
            r13 = r0
            goto L98
        L2f:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L41
        L33:
            kotlin.ResultKt.throwOnFailure(r14)
            r13.b = r6
            r6 = 300(0x12c, double:1.48E-321)
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r6, r13)
            if (r14 != r0) goto L41
            goto L8f
        L41:
            com.pspdfkit.internal.vt r14 = r13.c     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            com.pspdfkit.internal.au r14 = r14.a     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            android.content.Context r9 = r14.getContext()     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            r9.getClass()     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            int r8 = r13.d     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            com.pspdfkit.internal.lm r7 = r13.e     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            android.graphics.Matrix r10 = new android.graphics.Matrix     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            com.pspdfkit.internal.vt r14 = r13.c     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            android.graphics.Matrix r14 = r14.o     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            r10.<init>(r14)     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            r13.b = r5     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            com.pspdfkit.preferences.PSPDFKitPreferences r11 = com.pspdfkit.preferences.PSPDFKitPreferences.get(r9)     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            r11.getClass()     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            kotlinx.coroutines.CoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            com.pspdfkit.internal.zp r6 = new com.pspdfkit.internal.zp     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            r12 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r14, r6, r13)     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            if (r14 != r0) goto L73
            goto L8f
        L73:
            com.pspdfkit.internal.aq r14 = (com.pspdfkit.internal.aq) r14     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            com.pspdfkit.internal.xt$a r5 = new com.pspdfkit.internal.xt$a     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            com.pspdfkit.internal.vt r6 = r13.c     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            r7 = 0
            r5.<init>(r6, r14, r7)     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            r13.a = r14     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            r13.b = r4     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.withContext(r1, r5, r13)     // Catch: java.lang.Exception -> L29 java.lang.IllegalStateException -> L2c java.util.concurrent.CancellationException -> L9f
            if (r13 != r0) goto L9f
        L8f:
            return r0
        L90:
            java.lang.Object[] r14 = new java.lang.Object[r3]
            java.lang.String r0 = "Unexpected error initialising MeasurementSnappingHandler."
            com.pspdfkit.utils.PdfLog.e(r2, r13, r0, r14)
            goto L9f
        L98:
            java.lang.Object[] r14 = new java.lang.Object[r3]
            java.lang.String r0 = "Failed to initialise MeasurementSnappingHandler."
            com.pspdfkit.utils.PdfLog.e(r2, r13, r0, r14)
        L9f:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.xt.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
