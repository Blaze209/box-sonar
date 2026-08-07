package com.pspdfkit.internal;

import com.facebook.imageutils.JfifUtil;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.forms.SignatureFormElement;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.signatures.SignatureFormSigningHandler$showSignatureDialog$1", f = "SignatureFormSigningHandler.kt", i = {1, 1}, l = {203, JfifUtil.MARKER_EOI}, m = "invokeSuspend", n = {"pageAnnotations", "overlappingSignatures"}, nl = {202, JfifUtil.MARKER_SOI}, s = {"L$0", "L$1"}, v = 2)
public final class c20 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public Object b;
    public int c;
    public final /* synthetic */ WidgetAnnotation d;
    public final /* synthetic */ b20 e;
    public final /* synthetic */ SignatureFormElement f;
    public final /* synthetic */ PdfDocument g;

    @DebugMetadata(c = "com.pspdfkit.internal.signatures.SignatureFormSigningHandler$showSignatureDialog$1$ourSignatureAnnotation$1", f = "SignatureFormSigningHandler.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, nl = {221}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Annotation>, Object> {
        public int a;
        public final /* synthetic */ b20 b;
        public final /* synthetic */ SignatureFormElement c;
        public final /* synthetic */ List<Annotation> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(b20 b20Var, SignatureFormElement signatureFormElement, List<? extends Annotation> list, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = b20Var;
            this.c = signatureFormElement;
            this.d = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Annotation> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            b20 b20Var = this.b;
            SignatureFormElement signatureFormElement = this.c;
            List<Annotation> list = this.d;
            this.a = 1;
            Object objA = b20.a(b20Var, signatureFormElement, list, this);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.signatures.SignatureFormSigningHandler$showSignatureDialog$1$pageAnnotations$1", f = "SignatureFormSigningHandler.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
        public int a;
        public final /* synthetic */ PdfDocument b;
        public final /* synthetic */ WidgetAnnotation c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PdfDocument pdfDocument, WidgetAnnotation widgetAnnotation, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = pdfDocument;
            this.c = widgetAnnotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
            return new b(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            AnnotationProvider annotationProvider = this.b.getAnnotationProvider();
            int pageIndex = this.c.getPageIndex();
            this.a = 1;
            Object annotations = annotationProvider.getAnnotations(pageIndex, this);
            return annotations == coroutine_suspended ? coroutine_suspended : annotations;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c20(WidgetAnnotation widgetAnnotation, b20 b20Var, SignatureFormElement signatureFormElement, PdfDocument pdfDocument, Continuation<? super c20> continuation) {
        super(2, continuation);
        this.d = widgetAnnotation;
        this.e = b20Var;
        this.f = signatureFormElement;
        this.g = pdfDocument;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c20(this.d, this.e, this.f, this.g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((c20) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
    
        if (r9 == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.c
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L27
            if (r1 == r4) goto L23
            if (r1 != r3) goto L1b
            java.lang.Object r0 = r8.b
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r8.a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L92
            goto L7c
        L1b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L23:
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L92
            goto L40
        L27:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.CoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.internal.c20$b r1 = new com.pspdfkit.internal.c20$b     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.document.PdfDocument r5 = r8.g     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.annotations.WidgetAnnotation r6 = r8.d     // Catch: java.lang.Throwable -> L92
            r1.<init>(r5, r6, r2)     // Catch: java.lang.Throwable -> L92
            r8.c = r4     // Catch: java.lang.Throwable -> L92
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r1, r8)     // Catch: java.lang.Throwable -> L92
            if (r9 != r0) goto L40
            goto L7b
        L40:
            java.util.List r9 = (java.util.List) r9     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.annotations.WidgetAnnotation r1 = r8.d     // Catch: java.lang.Throwable -> L92
            java.util.List r1 = com.pspdfkit.internal.h2.a(r9, r1)     // Catch: java.lang.Throwable -> L92
            boolean r4 = r1.isEmpty()     // Catch: java.lang.Throwable -> L92
            if (r4 == 0) goto L5a
            com.pspdfkit.internal.b20 r9 = r8.e     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.forms.SignatureFormElement r0 = r8.f     // Catch: java.lang.Throwable -> L92
            r9.d = r0     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.ui.PdfFragment r0 = r9.a     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.internal.d20.a(r0, r9)     // Catch: java.lang.Throwable -> L92
            goto La9
        L5a:
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.internal.c20$a r5 = new com.pspdfkit.internal.c20$a     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.internal.b20 r6 = r8.e     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.forms.SignatureFormElement r7 = r8.f     // Catch: java.lang.Throwable -> L92
            r5.<init>(r6, r7, r1, r2)     // Catch: java.lang.Throwable -> L92
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)     // Catch: java.lang.Throwable -> L92
            r8.a = r9     // Catch: java.lang.Throwable -> L92
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)     // Catch: java.lang.Throwable -> L92
            r8.b = r9     // Catch: java.lang.Throwable -> L92
            r8.c = r3     // Catch: java.lang.Throwable -> L92
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r8)     // Catch: java.lang.Throwable -> L92
            if (r9 != r0) goto L7c
        L7b:
            return r0
        L7c:
            com.pspdfkit.annotations.Annotation r9 = (com.pspdfkit.annotations.Annotation) r9     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.internal.b20 r0 = r8.e
            if (r9 == 0) goto L88
            com.pspdfkit.ui.PdfFragment r0 = r0.a     // Catch: java.lang.Throwable -> L92
            r0.setSelectedAnnotation(r9)     // Catch: java.lang.Throwable -> L92
            goto La9
        L88:
            com.pspdfkit.forms.SignatureFormElement r9 = r8.f     // Catch: java.lang.Throwable -> L92
            r0.d = r9     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.ui.PdfFragment r9 = r0.a     // Catch: java.lang.Throwable -> L92
            com.pspdfkit.internal.d20.a(r9, r0)     // Catch: java.lang.Throwable -> L92
            goto La9
        L92:
            r9 = move-exception
            java.lang.Object[] r9 = new java.lang.Object[]{r9}
            java.lang.String r0 = "Nutri.SignFormHandler"
            java.lang.String r1 = "Error getting annotations for overlap detection"
            com.pspdfkit.utils.PdfLog.w(r0, r1, r9)
            com.pspdfkit.internal.b20 r9 = r8.e
            com.pspdfkit.forms.SignatureFormElement r8 = r8.f
            r9.d = r8
            com.pspdfkit.ui.PdfFragment r8 = r9.a
            com.pspdfkit.internal.d20.a(r8, r9)
        La9:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.c20.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
