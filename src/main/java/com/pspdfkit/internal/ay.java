package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.PdfDocumentLoader;
import com.pspdfkit.internal.jni.NativePageCache;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.Collections;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.rx3.RxAwaitKt;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.redaction.RedactionProcessorFragment$performRedactionInCurrentDocument$1", f = "RedactionProcessorFragment.kt", i = {0, 1, 1, 2}, l = {Token.SET_REF_OP, Token.LET, Token.LETEXPR}, m = "invokeSuspend", n = {"context", "context", "reopenedDocument", "exception"}, nl = {Token.LOCAL_BLOCK, Token.CONST, Token.DEBUGGER}, s = {"L$0", "L$0", "L$1", "L$0"}, v = 2)
public final class ay extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public Object b;
    public int c;
    public final /* synthetic */ gy d;
    public final /* synthetic */ lm e;
    public final /* synthetic */ DocumentSaveOptions f;

    @DebugMetadata(c = "com.pspdfkit.internal.ui.redaction.RedactionProcessorFragment$performRedactionInCurrentDocument$1$reopenedDocument$1", f = "RedactionProcessorFragment.kt", i = {2}, l = {Token.DOTDOT, Token.XML, Token.TO_DOUBLE}, m = "invokeSuspend", n = {"reopened"}, nl = {Token.XML, Token.TO_DOUBLE, Token.GET}, s = {"L$0"}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PdfDocument>, Object> {
        public PdfDocument a;
        public int b;
        public final /* synthetic */ lm c;
        public final /* synthetic */ DocumentSaveOptions d;
        public final /* synthetic */ Context e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lm lmVar, DocumentSaveOptions documentSaveOptions, Context context, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = lmVar;
            this.d = documentSaveOptions;
            this.e = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PdfDocument> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0061  */
        /* JADX WARN: Code duplicated, block: B:25:0x0088 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PdfDocument pdfDocument;
            ut utVar;
            Completable completableA;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Single<Boolean> singleB = this.c.b(this.d);
                this.b = 1;
                if (RxAwaitKt.await(singleB, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    PdfDocument pdfDocument2 = this.a;
                    ResultKt.throwOnFailure(obj);
                    return pdfDocument2;
                }
                ResultKt.throwOnFailure(obj);
            }
            obj.getClass();
            pdfDocument = (PdfDocument) obj;
            utVar = q10.b;
            if (utVar == null) {
                utVar = new ut(NativePageCache.create(15728640));
                q10.b = utVar;
            }
            completableA = utVar.a(pdfDocument.getUid(), pdfDocument.getPageCount());
            completableA.getClass();
            this.a = pdfDocument;
            this.b = 3;
            if (RxAwaitKt.await(completableA, this) != coroutine_suspended) {
                return coroutine_suspended;
            }
            return pdfDocument;
            Context context = this.e;
            List listUnmodifiableList = Collections.unmodifiableList(this.c.A);
            listUnmodifiableList.getClass();
            Single<PdfDocument> singleOpenDocumentsAsync = PdfDocumentLoader.openDocumentsAsync(context, listUnmodifiableList);
            singleOpenDocumentsAsync.getClass();
            this.b = 2;
            obj = RxAwaitKt.await(singleOpenDocumentsAsync, this);
            if (obj != coroutine_suspended) {
                obj.getClass();
                pdfDocument = (PdfDocument) obj;
                utVar = q10.b;
                if (utVar == null) {
                    utVar = new ut(NativePageCache.create(15728640));
                    q10.b = utVar;
                }
                completableA = utVar.a(pdfDocument.getUid(), pdfDocument.getPageCount());
                completableA.getClass();
                this.a = pdfDocument;
                this.b = 3;
                if (RxAwaitKt.await(completableA, this) != coroutine_suspended) {
                    return pdfDocument;
                }
            }
            return coroutine_suspended;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(gy gyVar, lm lmVar, DocumentSaveOptions documentSaveOptions, Continuation<? super ay> continuation) {
        super(2, continuation);
        this.d = gyVar;
        this.e = lmVar;
        this.f = documentSaveOptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ay(this.d, this.e, this.f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ay) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
    
        if (com.pspdfkit.internal.gy.a(r5, r6, r9) == r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
    
        if (com.pspdfkit.internal.gy.a(r1, r9) == r0) goto L26;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.c
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L37
            if (r1 == r5) goto L2f
            if (r1 == r4) goto L23
            if (r1 != r3) goto L1b
            java.lang.Object r9 = r9.a
            java.lang.Exception r9 = (java.lang.Exception) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L9c
        L1b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L23:
            java.lang.Object r1 = r9.b
            com.pspdfkit.document.PdfDocument r1 = (com.pspdfkit.document.PdfDocument) r1
            java.lang.Object r1 = r9.a
            android.content.Context r1 = (android.content.Context) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            goto L9c
        L2f:
            java.lang.Object r1 = r9.a
            android.content.Context r1 = (android.content.Context) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            goto L5f
        L37:
            kotlin.ResultKt.throwOnFailure(r10)
            com.pspdfkit.internal.gy r10 = r9.d     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            android.content.Context r1 = r10.requireContext()     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            r1.getClass()     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            kotlinx.coroutines.CoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            com.pspdfkit.internal.ay$a r6 = new com.pspdfkit.internal.ay$a     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            com.pspdfkit.internal.lm r7 = r9.e     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            com.pspdfkit.document.DocumentSaveOptions r8 = r9.f     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            r6.<init>(r7, r8, r1, r2)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            r9.a = r7     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            r9.c = r5     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r6, r9)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            if (r10 != r0) goto L5f
            goto L9b
        L5f:
            com.pspdfkit.document.PdfDocument r10 = (com.pspdfkit.document.PdfDocument) r10     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            com.pspdfkit.internal.gy r5 = r9.d     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            r10.getClass()     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            r6 = r10
            com.pspdfkit.internal.lm r6 = (com.pspdfkit.internal.lm) r6     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            r9.a = r1     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            r9.b = r10     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            r9.c = r4     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            java.lang.Object r9 = com.pspdfkit.internal.gy.a(r5, r6, r9)     // Catch: java.lang.Exception -> L7e java.util.concurrent.CancellationException -> L9f
            if (r9 != r0) goto L9c
            goto L9b
        L7e:
            r10 = move-exception
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r4 = "Nutri.RedactProcessFrag"
            java.lang.String r5 = "Document couldn't be redacted."
            com.pspdfkit.utils.PdfLog.w(r4, r10, r5, r1)
            com.pspdfkit.internal.gy r1 = r9.d
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r9.a = r10
            r9.b = r2
            r9.c = r3
            java.lang.Object r9 = com.pspdfkit.internal.gy.a(r1, r9)
            if (r9 != r0) goto L9c
        L9b:
            return r0
        L9c:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L9f:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.ay.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
