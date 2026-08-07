package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationZIndexMove;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.inspector.AnnotationEditingInspectorFactory$addZIndexPicker$zIndexEditingPicker$1$1", f = "AnnotationEditingInspectorFactory.kt", i = {2, 3, 4, 4}, l = {371, 375, 376, 377, 379}, m = "invokeSuspend", n = {"previousZIndex", "previousZIndex", "previousZIndex", "updatedZIndex"}, nl = {375, 376, 377, 379, 383}, s = {"I$0", "I$0", "I$0", "I$1"}, v = 2)
public final class v1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public int b;
    public final /* synthetic */ AnnotationProvider c;
    public final /* synthetic */ Annotation d;
    public final /* synthetic */ AnnotationZIndexMove e;
    public final /* synthetic */ u1 f;

    @DebugMetadata(c = "com.pspdfkit.internal.views.inspector.AnnotationEditingInspectorFactory$addZIndexPicker$zIndexEditingPicker$1$1$1", f = "AnnotationEditingInspectorFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ u1 a;
        public final /* synthetic */ Annotation b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u1 u1Var, Annotation annotation, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = u1Var;
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
            this.a.b.showEditedAnnotationPositionOnThePage(this.b.getPageIndex());
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.inspector.AnnotationEditingInspectorFactory$addZIndexPicker$zIndexEditingPicker$1$1$2", f = "AnnotationEditingInspectorFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ u1 a;
        public final /* synthetic */ Annotation b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(u1 u1Var, Annotation annotation, int i, int i2, Continuation<? super b> continuation) {
            super(2, continuation);
            this.a = u1Var;
            this.b = annotation;
            this.c = i;
            this.d = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.a, this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            this.a.a(this.b);
            this.a.b.recordAnnotationZIndexEdit(this.b, this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v1(AnnotationProvider annotationProvider, Annotation annotation, AnnotationZIndexMove annotationZIndexMove, u1 u1Var, Continuation<? super v1> continuation) {
        super(2, continuation);
        this.c = annotationProvider;
        this.d = annotation;
        this.e = annotationZIndexMove;
        this.f = u1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new v1(this.c, this.d, this.e, this.f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((v1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0029 A[PHI: r1 r11
      0x0029: PHI (r1v7 int) = (r1v6 int), (r1v9 int) binds: [B:33:0x0087, B:14:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x0029: PHI (r11v11 java.lang.Object) = (r11v10 java.lang.Object), (r11v0 java.lang.Object) binds: [B:33:0x0087, B:14:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x0079  */
    /* JADX WARN: Code duplicated, block: B:31:0x007a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0089  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a6, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r11, r3, r10) == r0) goto L37;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.b
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L39
            if (r1 == r6) goto L35
            if (r1 == r5) goto L31
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L24
            if (r1 != r2) goto L1c
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> La9
            goto Lb6
        L1c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L24:
            int r1 = r10.a
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> La9
        L29:
            r6 = r1
            goto L8a
        L2b:
            int r1 = r10.a
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> La9
            goto L7b
        L31:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> La9
            goto L60
        L35:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> La9
            goto L53
        L39:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> La9
            com.pspdfkit.internal.v1$a r1 = new com.pspdfkit.internal.v1$a     // Catch: java.lang.Throwable -> La9
            com.pspdfkit.internal.u1 r7 = r10.f     // Catch: java.lang.Throwable -> La9
            com.pspdfkit.annotations.Annotation r8 = r10.d     // Catch: java.lang.Throwable -> La9
            r9 = 0
            r1.<init>(r7, r8, r9)     // Catch: java.lang.Throwable -> La9
            r10.b = r6     // Catch: java.lang.Throwable -> La9
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r1, r10)     // Catch: java.lang.Throwable -> La9
            if (r11 != r0) goto L53
            goto La8
        L53:
            com.pspdfkit.annotations.AnnotationProvider r11 = r10.c     // Catch: java.lang.Throwable -> La9
            com.pspdfkit.annotations.Annotation r1 = r10.d     // Catch: java.lang.Throwable -> La9
            r10.b = r5     // Catch: java.lang.Throwable -> La9
            java.lang.Object r11 = r11.getZIndex(r1, r10)     // Catch: java.lang.Throwable -> La9
            if (r11 != r0) goto L60
            goto La8
        L60:
            java.lang.Number r11 = (java.lang.Number) r11     // Catch: java.lang.Throwable -> La9
            int r11 = r11.intValue()     // Catch: java.lang.Throwable -> La9
            com.pspdfkit.annotations.AnnotationProvider r1 = r10.c     // Catch: java.lang.Throwable -> La9
            com.pspdfkit.annotations.Annotation r5 = r10.d     // Catch: java.lang.Throwable -> La9
            com.pspdfkit.annotations.AnnotationZIndexMove r6 = r10.e     // Catch: java.lang.Throwable -> La9
            r6.getClass()     // Catch: java.lang.Throwable -> La9
            r10.a = r11     // Catch: java.lang.Throwable -> La9
            r10.b = r4     // Catch: java.lang.Throwable -> La9
            java.lang.Object r1 = r1.moveAnnotation(r5, r6, r10)     // Catch: java.lang.Throwable -> La9
            if (r1 != r0) goto L7a
            goto La8
        L7a:
            r1 = r11
        L7b:
            com.pspdfkit.annotations.AnnotationProvider r11 = r10.c     // Catch: java.lang.Throwable -> La9
            com.pspdfkit.annotations.Annotation r4 = r10.d     // Catch: java.lang.Throwable -> La9
            r10.a = r1     // Catch: java.lang.Throwable -> La9
            r10.b = r3     // Catch: java.lang.Throwable -> La9
            java.lang.Object r11 = r11.getZIndex(r4, r10)     // Catch: java.lang.Throwable -> La9
            if (r11 != r0) goto L29
            goto La8
        L8a:
            java.lang.Number r11 = (java.lang.Number) r11     // Catch: java.lang.Throwable -> La9
            int r7 = r11.intValue()     // Catch: java.lang.Throwable -> La9
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> La9
            com.pspdfkit.internal.v1$b r3 = new com.pspdfkit.internal.v1$b     // Catch: java.lang.Throwable -> La9
            com.pspdfkit.internal.u1 r4 = r10.f     // Catch: java.lang.Throwable -> La9
            com.pspdfkit.annotations.Annotation r5 = r10.d     // Catch: java.lang.Throwable -> La9
            r8 = 0
            r3.<init>(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La9
            r10.a = r6     // Catch: java.lang.Throwable -> La9
            r10.b = r2     // Catch: java.lang.Throwable -> La9
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r11, r3, r10)     // Catch: java.lang.Throwable -> La9
            if (r10 != r0) goto Lb6
        La8:
            return r0
        La9:
            r0 = move-exception
            r10 = r0
            java.lang.Object[] r10 = new java.lang.Object[]{r10}
            java.lang.String r11 = "Nutri.AnnotEditIFactory"
            java.lang.String r0 = "Annotation z-index reordering action could not be performed"
            com.pspdfkit.utils.PdfLog.e(r11, r0, r10)
        Lb6:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.v1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
