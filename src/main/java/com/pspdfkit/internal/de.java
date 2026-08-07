package com.pspdfkit.internal;

import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.rx3.RxSingleKt;

/* JADX INFO: loaded from: classes3.dex */
public final class de {
    public final lm a;
    public final PdfFragment b;
    public volatile boolean c;

    public interface a {
        boolean onDocumentSave(PdfDocument pdfDocument, DocumentSaveOptions documentSaveOptions);

        void onDocumentSaveCancelled(PdfDocument pdfDocument);

        void onDocumentSaveFailed(PdfDocument pdfDocument, Throwable th);

        void onDocumentSaved(PdfDocument pdfDocument);
    }

    @DebugMetadata(c = "com.pspdfkit.internal.document.DocumentSaver$saveAsync$1$2", f = "DocumentSaver.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        public int a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return de.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return de.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
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
            de deVar = de.this;
            this.a = 1;
            Object objA = de.a(deVar, this);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        }
    }

    public de(lm lmVar, PdfFragment pdfFragment) {
        lmVar.getClass();
        this.a = lmVar;
        this.b = pdfFragment;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ac, code lost:
    
        if (r7 == r1) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(com.pspdfkit.internal.de r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r6.getClass()
            boolean r0 = r7 instanceof com.pspdfkit.internal.ge
            if (r0 == 0) goto L16
            r0 = r7
            com.pspdfkit.internal.ge r0 = (com.pspdfkit.internal.ge) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.d = r1
            goto L1b
        L16:
            com.pspdfkit.internal.ge r0 = new com.pspdfkit.internal.ge
            r0.<init>(r6, r7)
        L1b:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r0 = r0.a
            com.pspdfkit.document.DocumentSaveOptions r0 = (com.pspdfkit.document.DocumentSaveOptions) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto Laf
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L56
        L40:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getDefault()
            com.pspdfkit.internal.he r2 = new com.pspdfkit.internal.he
            r5 = 0
            r2.<init>(r6, r5)
            r0.d = r4
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L56
            goto Lae
        L56:
            com.pspdfkit.document.DocumentSaveOptions r7 = (com.pspdfkit.document.DocumentSaveOptions) r7
            com.pspdfkit.ui.PdfFragment r2 = r6.b
            com.pspdfkit.internal.lm r5 = r6.a
            boolean r2 = r2.onDocumentSave(r5, r7)
            if (r2 != 0) goto L78
            com.pspdfkit.ui.PdfFragment r7 = r6.b
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.String r0 = "Nutri.DocumentSaver"
            java.lang.String r1 = "Document save has been cancelled by %s"
            com.pspdfkit.utils.PdfLog.d(r0, r1, r7)
            r7 = 0
            r6.a(r7)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r6
        L78:
            com.pspdfkit.internal.lm r2 = r6.a
            io.reactivex.rxjava3.core.Single r2 = r2.saveIfModifiedAsync(r7)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.a = r7
            r0.d = r3
            kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r7.<init>(r3, r4)
            r7.initCancellability()
            com.pspdfkit.internal.ee r3 = new com.pspdfkit.internal.ee
            r3.<init>(r7)
            com.pspdfkit.internal.fe r4 = new com.pspdfkit.internal.fe
            r4.<init>(r7)
            r2.subscribe(r3, r4)
            java.lang.Object r7 = r7.getResult()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r2) goto Lac
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        Lac:
            if (r7 != r1) goto Laf
        Lae:
            return r1
        Laf:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r6.a(r7)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.de.a(com.pspdfkit.internal.de, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final synchronized Single<Boolean> a() {
        Single<Boolean> singleDefer;
        singleDefer = Single.defer(new Supplier() { // from class: com.pspdfkit.internal.de$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return de.a(this.f$0);
            }
        });
        singleDefer.getClass();
        return singleDefer;
    }

    public static final SingleSource a(de deVar) {
        boolean z;
        synchronized (deVar) {
            if (deVar.c) {
                z = false;
            } else {
                z = true;
                deVar.c = true;
            }
        }
        return !z ? Single.just(Boolean.FALSE) : RxSingleKt.rxSingle(Dispatchers.getMain(), deVar.new b(null)).doOnError(new Consumer() { // from class: com.pspdfkit.internal.de.c
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                th.getClass();
                de.this.a(th);
            }
        });
    }

    public final void a(final boolean z) {
        if (this.c) {
            this.c = false;
            h60.a(new Runnable() { // from class: com.pspdfkit.internal.de$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    de.a(z, this);
                }
            });
        }
    }

    public static final void a(boolean z, de deVar) {
        if (z) {
            PdfLog.d("Nutri.DocumentSaver", "Document has been saved.", new Object[0]);
            deVar.b.onDocumentSaved(deVar.a);
        } else {
            deVar.b.onDocumentSaveCancelled(deVar.a);
        }
    }

    public final void a(final Throwable th) {
        if (this.c) {
            this.c = false;
            PdfLog.e("Nutri.DocumentSaver", th, "Document save has failed.", new Object[0]);
            h60.a(new Runnable() { // from class: com.pspdfkit.internal.de$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    de.a(this.f$0, th);
                }
            });
        }
    }

    public static final void a(de deVar, Throwable th) {
        deVar.b.onDocumentSaveFailed(deVar.a, th);
    }
}
