package com.pspdfkit.internal;

import com.facebook.imageutils.JfifUtil;
import com.pspdfkit.annotations.Annotation;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.editors.AnnotationEditorFragment$internalRestore$1", f = "AnnotationEditorFragment.kt", i = {1}, l = {JfifUtil.MARKER_RST7, JfifUtil.MARKER_EOI}, m = "invokeSuspend", n = {"resolved"}, nl = {JfifUtil.MARKER_SOI, 221}, s = {"L$0"}, v = 2)
public final class b2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public int b;
    public final /* synthetic */ wu c;
    public final /* synthetic */ lm d;
    public final /* synthetic */ c2 e;

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.editors.AnnotationEditorFragment$internalRestore$1$1", f = "AnnotationEditorFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ c2 a;
        public final /* synthetic */ Annotation b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c2 c2Var, Annotation annotation, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = c2Var;
            this.b = annotation;
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
            this.a.a(this.b);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b2(wu wuVar, lm lmVar, c2 c2Var, Continuation<? super b2> continuation) {
        super(2, continuation);
        this.c = wuVar;
        this.d = lmVar;
        this.e = c2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b2(this.c, this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((b2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r1, r3, r6) == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r6 = r6.a
            com.pspdfkit.annotations.Annotation r6 = (com.pspdfkit.annotations.Annotation) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L51
            goto L5c
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L51
            goto L32
        L22:
            kotlin.ResultKt.throwOnFailure(r7)
            com.pspdfkit.internal.wu r7 = r6.c     // Catch: java.lang.Exception -> L51
            com.pspdfkit.internal.lm r1 = r6.d     // Catch: java.lang.Exception -> L51
            r6.b = r3     // Catch: java.lang.Exception -> L51
            java.lang.Object r7 = r7.a(r1, r6)     // Catch: java.lang.Exception -> L51
            if (r7 != r0) goto L32
            goto L50
        L32:
            com.pspdfkit.annotations.Annotation r7 = (com.pspdfkit.annotations.Annotation) r7     // Catch: java.lang.Exception -> L51
            if (r7 == 0) goto L5c
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L51
            com.pspdfkit.internal.b2$a r3 = new com.pspdfkit.internal.b2$a     // Catch: java.lang.Exception -> L51
            com.pspdfkit.internal.c2 r4 = r6.e     // Catch: java.lang.Exception -> L51
            r5 = 0
            r3.<init>(r4, r7, r5)     // Catch: java.lang.Exception -> L51
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch: java.lang.Exception -> L51
            r6.a = r7     // Catch: java.lang.Exception -> L51
            r6.b = r2     // Catch: java.lang.Exception -> L51
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r6)     // Catch: java.lang.Exception -> L51
            if (r6 != r0) goto L5c
        L50:
            return r0
        L51:
            r6 = move-exception
            r7 = 0
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r0 = "Nutri.AnnotEditorFrag"
            java.lang.String r1 = "Could not restore annotation from instance state."
            com.pspdfkit.utils.PdfLog.w(r0, r6, r1, r7)
        L5c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.b2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
