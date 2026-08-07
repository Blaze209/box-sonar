package com.pspdfkit.internal;

import android.content.Context;
import android.net.Uri;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.processor.PdfProcessor;
import com.pspdfkit.document.processor.PdfProcessorTask;
import io.reactivex.rxjava3.core.Completable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.Arrays;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.rx3.RxAwaitKt;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.redaction.RedactionProcessorFragment$performRedactionToNewFile$1", f = "RedactionProcessorFragment.kt", i = {0, 1, 2}, l = {93, 113, 118}, m = "invokeSuspend", n = {"context", "context", "exception"}, nl = {113, 114, 120}, s = {"L$0", "L$0", "L$0"}, v = 2)
public final class cy extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public int b;
    public final /* synthetic */ gy c;
    public final /* synthetic */ PdfDocument d;
    public final /* synthetic */ Uri e;

    @DebugMetadata(c = "com.pspdfkit.internal.ui.redaction.RedactionProcessorFragment$performRedactionToNewFile$1$1", f = "RedactionProcessorFragment.kt", i = {0, 0}, l = {101}, m = "invokeSuspend", n = {"tempFile", "task"}, nl = {102}, s = {"L$0", "L$1"}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        public File a;
        public Object b;
        public int c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ Uri e;
        public final /* synthetic */ PdfDocument f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, Uri uri, PdfDocument pdfDocument, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = context;
            this.e = uri;
            this.f = pdfDocument;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            File file;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                wg.a(this.d, true, Arrays.asList(this.e));
                File fileA = wg.a(this.d, "pdf");
                if (fileA == null) {
                    throw new IllegalStateException("Failed to create temporary file.");
                }
                try {
                    PdfProcessorTask pdfProcessorTaskApplyRedactions = PdfProcessorTask.fromDocument(this.f).applyRedactions();
                    Completable completableIgnoreElements = PdfProcessor.processDocumentAsync(pdfProcessorTaskApplyRedactions, fileA).ignoreElements();
                    completableIgnoreElements.getClass();
                    this.a = fileA;
                    this.b = SpillingKt.nullOutSpilledVariable(pdfProcessorTaskApplyRedactions);
                    this.c = 1;
                    if (RxAwaitKt.await(completableIgnoreElements, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    file = fileA;
                } catch (Throwable th) {
                    th = th;
                    file = fileA;
                    file.delete();
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                file = this.a;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th2) {
                    th = th2;
                    file.delete();
                    throw th;
                }
            }
            OutputStream outputStreamOpenOutputStream = MAMContentResolverManagement.openOutputStream(this.d.getContentResolver(), this.e, "w");
            if (outputStreamOpenOutputStream == null) {
                throw new FileNotFoundException("Failed to open output stream for " + this.e);
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    long jA = wg.a(fileInputStream, outputStreamOpenOutputStream);
                    CloseableKt.closeFinally(fileInputStream, null);
                    CloseableKt.closeFinally(outputStreamOpenOutputStream, null);
                    file.delete();
                    return Boxing.boxLong(jA);
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(fileInputStream, th3);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(outputStreamOpenOutputStream, th5);
                    throw th6;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cy(gy gyVar, PdfDocument pdfDocument, Uri uri, Continuation<? super cy> continuation) {
        super(2, continuation);
        this.c = gyVar;
        this.d = pdfDocument;
        this.e = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new cy(this.c, this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((cy) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        if (com.pspdfkit.internal.gy.a(r10, r4, r5, r9) == r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0089, code lost:
    
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
            int r1 = r9.b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L32
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r9 = r9.a
            java.lang.Exception r9 = (java.lang.Exception) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L8c
        L1a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L22:
            java.lang.Object r1 = r9.a
            android.content.Context r1 = (android.content.Context) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            goto L8c
        L2a:
            java.lang.Object r1 = r9.a
            android.content.Context r1 = (android.content.Context) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            goto L5b
        L32:
            kotlin.ResultKt.throwOnFailure(r10)
            com.pspdfkit.internal.gy r10 = r9.c     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            android.content.Context r1 = r10.requireContext()     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            r1.getClass()     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            kotlinx.coroutines.CoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            com.pspdfkit.internal.cy$a r5 = new com.pspdfkit.internal.cy$a     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            android.net.Uri r6 = r9.e     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            com.pspdfkit.document.PdfDocument r7 = r9.d     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            r8 = 0
            r5.<init>(r1, r6, r7, r8)     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            r9.a = r6     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            r9.b = r4     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r5, r9)     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            if (r10 != r0) goto L5b
            goto L8b
        L5b:
            com.pspdfkit.internal.gy r10 = r9.c     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            com.pspdfkit.document.PdfDocument r4 = r9.d     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            android.net.Uri r5 = r9.e     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            r9.a = r1     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            r9.b = r3     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            java.lang.Object r9 = com.pspdfkit.internal.gy.a(r10, r4, r5, r9)     // Catch: java.lang.Exception -> L70 java.util.concurrent.CancellationException -> L8f
            if (r9 != r0) goto L8c
            goto L8b
        L70:
            r10 = move-exception
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r3 = "Nutri.RedactProcessFrag"
            java.lang.String r4 = "Document couldn't be redacted."
            com.pspdfkit.utils.PdfLog.w(r3, r10, r4, r1)
            com.pspdfkit.internal.gy r1 = r9.c
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r9.a = r10
            r9.b = r2
            java.lang.Object r9 = com.pspdfkit.internal.gy.a(r1, r9)
            if (r9 != r0) goto L8c
        L8b:
            return r0
        L8c:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L8f:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.cy.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
