package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.document.AnnotationEditorController$OnAnnotationEditorDismissedListener$onAnnotationEditorDismissed$1", f = "AnnotationEditorController.kt", i = {0, 1, 1, 2, 2}, l = {60, 67, 70}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "annotation", "$this$launch", "annotation"}, nl = {61, 70, 75}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 2)
public final class y1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ x1 d;
    public final /* synthetic */ lm e;
    public final /* synthetic */ z1 f;

    @DebugMetadata(c = "com.pspdfkit.internal.views.document.AnnotationEditorController$OnAnnotationEditorDismissedListener$onAnnotationEditorDismissed$1$1", f = "AnnotationEditorController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        public final /* synthetic */ z1 a;
        public final /* synthetic */ Annotation b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(z1 z1Var, Annotation annotation, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = z1Var;
            this.b = annotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return new a(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            vt pageEditor;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            au auVarB = this.a.a.b(this.b.getPageIndex());
            if (auVarB == null || (pageEditor = auVarB.getPageEditor()) == null) {
                return null;
            }
            return Boxing.boxBoolean(vt.a(pageEditor, false, false, 15));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1(x1 x1Var, lm lmVar, z1 z1Var, Continuation continuation) {
        super(2, continuation);
        this.d = x1Var;
        this.e = lmVar;
        this.f = z1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        y1 y1Var = new y1(this.d, this.e, this.f, continuation);
        y1Var.c = obj;
        return y1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((y1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
    
        if (r10 == r1) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.c
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.b
            r3 = 0
            java.lang.String r4 = "Nutri.AnnotEditorCtrl"
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L56
            if (r2 == r6) goto L50
            r6 = 2
            r7 = 3
            if (r2 == r6) goto L29
            if (r2 != r7) goto L21
            java.lang.Object r9 = r9.a
            com.pspdfkit.annotations.Annotation r9 = (com.pspdfkit.annotations.Annotation) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L54
            goto L88
        L21:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L29:
            java.lang.Object r2 = r9.a
            com.pspdfkit.annotations.Annotation r2 = (com.pspdfkit.annotations.Annotation) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L54
            kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L54
            com.pspdfkit.internal.y1$a r6 = new com.pspdfkit.internal.y1$a     // Catch: java.lang.Exception -> L54
            com.pspdfkit.internal.z1 r8 = r9.f     // Catch: java.lang.Exception -> L54
            r6.<init>(r8, r2, r3)     // Catch: java.lang.Exception -> L54
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Exception -> L54
            r9.c = r0     // Catch: java.lang.Exception -> L54
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)     // Catch: java.lang.Exception -> L54
            r9.a = r0     // Catch: java.lang.Exception -> L54
            r9.b = r7     // Catch: java.lang.Exception -> L54
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r10, r6, r9)     // Catch: java.lang.Exception -> L54
            if (r9 != r1) goto L88
            goto L72
        L50:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L54
            goto L73
        L54:
            r9 = move-exception
            goto L81
        L56:
            kotlin.ResultKt.throwOnFailure(r10)
            com.pspdfkit.internal.x1 r10 = r9.d     // Catch: java.lang.Exception -> L54
            com.pspdfkit.internal.lm r2 = r9.e     // Catch: java.lang.Exception -> L54
            r9.c = r0     // Catch: java.lang.Exception -> L54
            r9.b = r6     // Catch: java.lang.Exception -> L54
            com.pspdfkit.internal.c2 r10 = r10.a     // Catch: java.lang.Exception -> L54
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L54
            com.pspdfkit.internal.a2 r6 = new com.pspdfkit.internal.a2     // Catch: java.lang.Exception -> L54
            r6.<init>(r10, r2, r3)     // Catch: java.lang.Exception -> L54
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r0, r6, r9)     // Catch: java.lang.Exception -> L54
            if (r10 != r1) goto L73
        L72:
            return r1
        L73:
            com.pspdfkit.annotations.Annotation r10 = (com.pspdfkit.annotations.Annotation) r10     // Catch: java.lang.Exception -> L54
            if (r10 != 0) goto L88
            java.lang.String r9 = "Annotation to remove was not found!"
            java.lang.Object[] r10 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L54
            com.pspdfkit.utils.PdfLog.d(r4, r9, r10)     // Catch: java.lang.Exception -> L54
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L54
            return r9
        L81:
            java.lang.Object[] r10 = new java.lang.Object[r5]
            java.lang.String r0 = "Error handling annotation editor dismissal"
            com.pspdfkit.utils.PdfLog.d(r4, r9, r0, r10)
        L88:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.y1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
