package com.geniusscansdk.scanflow;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.box.android.data.api.models.annotations.Location;
import com.geniusscansdk.ocr.OcrConfiguration;
import com.geniusscansdk.ocr.OcrProcessor;
import com.geniusscansdk.ocr.OcrResult;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: OcrBackgroundProcessor.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0014J\u001a\u0010\u001c\u001a\u00020\u00112\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fJ\u000e\u0010\u001e\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0011H\u0002J\u000e\u0010!\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u001fJ\b\u0010\"\u001a\u00020\u0011H\u0002J\u0018\u0010#\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u001e\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00100\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00100\u00100\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/geniusscansdk/scanflow/OcrBackgroundProcessor;", "", "context", "Landroid/content/Context;", "ocrConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration$OcrConfiguration;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lcom/geniusscansdk/scanflow/ScanConfiguration$OcrConfiguration;Lkotlinx/coroutines/CoroutineScope;)V", "ocrProcessor", "Lcom/geniusscansdk/ocr/OcrProcessor;", "backgroundJob", "Lkotlinx/coroutines/Job;", "progressListener", "Lkotlin/Function1;", "", "", "pendingPages", "Ljava/util/Queue;", "Lcom/geniusscansdk/scanflow/Page;", "completedPages", "", "pageProgress", "Landroid/util/Pair;", "kotlin.jvm.PlatformType", "addPage", Location.TYPE_PAGE, "setProgressListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "waitForCompletion", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startBackground", "runOcrOnPendingPages", "updatePageProgress", "createOcrProcessor", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OcrBackgroundProcessor {
    private static final String TAG = "OcrBackgroundProcessor";
    private Job backgroundJob;
    private final List<Page> completedPages;
    private final OcrProcessor ocrProcessor;
    private Pair<Integer, Integer> pageProgress;
    private final Queue<Page> pendingPages;
    private Function1<? super Integer, Unit> progressListener;
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.OcrBackgroundProcessor$runOcrOnPendingPages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OcrBackgroundProcessor.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.OcrBackgroundProcessor", f = "OcrBackgroundProcessor.kt", i = {0, 0}, l = {85, 95}, m = "runOcrOnPendingPages", n = {"this", "pendingPage"}, s = {"L$0", "L$1"})
    static final class C17821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C17821(Continuation<? super C17821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OcrBackgroundProcessor.this.runOcrOnPendingPages(this);
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.OcrBackgroundProcessor$waitForCompletion$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OcrBackgroundProcessor.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.OcrBackgroundProcessor", f = "OcrBackgroundProcessor.kt", i = {}, l = {57}, m = "waitForCompletion", n = {}, s = {})
    static final class C17841 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C17841(Continuation<? super C17841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OcrBackgroundProcessor.this.waitForCompletion(this);
        }
    }

    public OcrBackgroundProcessor(Context context, ScanConfiguration.OcrConfiguration ocrConfiguration, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ocrConfiguration, "ocrConfiguration");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.pendingPages = new LinkedList();
        this.completedPages = new ArrayList();
        this.pageProgress = new Pair<>(0, 1);
        this.ocrProcessor = createOcrProcessor(context, ocrConfiguration);
        BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO().plus(new OcrBackgroundProcessor$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE)), null, new AnonymousClass1(null), 2, null);
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.OcrBackgroundProcessor$1, reason: invalid class name */
    /* JADX INFO: compiled from: OcrBackgroundProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.OcrBackgroundProcessor$1", f = "OcrBackgroundProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OcrBackgroundProcessor.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws InterruptedException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                OcrBackgroundProcessor.this.ocrProcessor.preloadModels();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void addPage(Page page) {
        Intrinsics.checkNotNullParameter(page, "page");
        this.pendingPages.add(page);
        updatePageProgress();
        startBackground();
    }

    public final void setProgressListener(Function1<? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.progressListener = listener;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object waitForCompletion(Continuation<? super Unit> continuation) {
        C17841 c17841;
        if (continuation instanceof C17841) {
            c17841 = (C17841) continuation;
            if ((c17841.label & Integer.MIN_VALUE) != 0) {
                c17841.label -= Integer.MIN_VALUE;
            } else {
                c17841 = new C17841(continuation);
            }
        } else {
            c17841 = new C17841(continuation);
        }
        Object obj = c17841.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c17841.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Job job = this.backgroundJob;
            if (job != null) {
                c17841.label = 1;
                if (job.join(c17841) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    private final void startBackground() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new RuntimeException("This method must be called from the main thread");
        }
        if (this.backgroundJob != null) {
            return;
        }
        this.backgroundJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C17831(null), 3, null);
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.OcrBackgroundProcessor$startBackground$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OcrBackgroundProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.OcrBackgroundProcessor$startBackground$1", f = "OcrBackgroundProcessor.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    static final class C17831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17831(Continuation<? super C17831> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OcrBackgroundProcessor.this.new C17831(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v3, types: [com.geniusscansdk.scanflow.OcrBackgroundProcessor] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (OcrBackgroundProcessor.this.runOcrOnPendingPages(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (CancellationException unused) {
                Log.d(OcrBackgroundProcessor.TAG, "Ocr has been cancelled");
            } catch (Exception e) {
                Log.e(OcrBackgroundProcessor.TAG, "Error processing ocr", e);
            } finally {
                OcrBackgroundProcessor.this.backgroundJob = null;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00be, code lost:
    
        if (r6.runOcrOnPendingPages(r0) == r1) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runOcrOnPendingPages(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.geniusscansdk.scanflow.OcrBackgroundProcessor.C17821
            if (r0 == 0) goto L14
            r0 = r10
            com.geniusscansdk.scanflow.OcrBackgroundProcessor$runOcrOnPendingPages$1 r0 = (com.geniusscansdk.scanflow.OcrBackgroundProcessor.C17821) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.geniusscansdk.scanflow.OcrBackgroundProcessor$runOcrOnPendingPages$1 r0 = new com.geniusscansdk.scanflow.OcrBackgroundProcessor$runOcrOnPendingPages$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lc1
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            java.lang.Object r9 = r0.L$3
            com.geniusscansdk.scanflow.Page r9 = (com.geniusscansdk.scanflow.Page) r9
            java.lang.Object r2 = r0.L$2
            com.geniusscansdk.scanflow.Page r2 = (com.geniusscansdk.scanflow.Page) r2
            java.lang.Object r4 = r0.L$1
            com.geniusscansdk.scanflow.Page r4 = (com.geniusscansdk.scanflow.Page) r4
            java.lang.Object r6 = r0.L$0
            com.geniusscansdk.scanflow.OcrBackgroundProcessor r6 = (com.geniusscansdk.scanflow.OcrBackgroundProcessor) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L4b
            goto L80
        L4b:
            r9 = move-exception
            goto L88
        L4d:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.Queue<com.geniusscansdk.scanflow.Page> r10 = r9.pendingPages
            java.lang.Object r10 = r10.peek()
            com.geniusscansdk.scanflow.Page r10 = (com.geniusscansdk.scanflow.Page) r10
            if (r10 != 0) goto L5d
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L5d:
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L83
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2     // Catch: java.lang.Exception -> L83
            com.geniusscansdk.scanflow.OcrBackgroundProcessor$runOcrOnPendingPages$2 r6 = new com.geniusscansdk.scanflow.OcrBackgroundProcessor$runOcrOnPendingPages$2     // Catch: java.lang.Exception -> L83
            r6.<init>(r10, r5)     // Catch: java.lang.Exception -> L83
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Exception -> L83
            r0.L$0 = r9     // Catch: java.lang.Exception -> L83
            r0.L$1 = r10     // Catch: java.lang.Exception -> L83
            r0.L$2 = r10     // Catch: java.lang.Exception -> L83
            r0.L$3 = r10     // Catch: java.lang.Exception -> L83
            r0.label = r4     // Catch: java.lang.Exception -> L83
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r2, r6, r0)     // Catch: java.lang.Exception -> L83
            if (r2 != r1) goto L7b
            goto Lc0
        L7b:
            r6 = r9
            r9 = r10
            r4 = r9
            r10 = r2
            r2 = r4
        L80:
            com.geniusscansdk.ocr.OcrResult r10 = (com.geniusscansdk.ocr.OcrResult) r10     // Catch: java.lang.Exception -> L4b
            goto La0
        L83:
            r2 = move-exception
            r6 = r9
            r4 = r10
            r9 = r2
            r2 = r4
        L88:
            java.lang.String r10 = com.geniusscansdk.scanflow.OcrBackgroundProcessor.TAG
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Error processing ocr for page "
            r7.<init>(r8)
            java.lang.StringBuilder r7 = r7.append(r4)
            java.lang.String r7 = r7.toString()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            android.util.Log.e(r10, r7, r9)
            r9 = r2
            r10 = r5
        La0:
            r9.setOcrResult(r10)
            java.util.Queue<com.geniusscansdk.scanflow.Page> r9 = r6.pendingPages
            r9.remove()
            java.util.List<com.geniusscansdk.scanflow.Page> r9 = r6.completedPages
            r9.add(r4)
            r6.updatePageProgress()
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.L$3 = r5
            r0.label = r3
            java.lang.Object r9 = r6.runOcrOnPendingPages(r0)
            if (r9 != r1) goto Lc1
        Lc0:
            return r1
        Lc1:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.scanflow.OcrBackgroundProcessor.runOcrOnPendingPages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.OcrBackgroundProcessor$runOcrOnPendingPages$2, reason: invalid class name */
    /* JADX INFO: compiled from: OcrBackgroundProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/geniusscansdk/ocr/OcrResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.OcrBackgroundProcessor$runOcrOnPendingPages$2", f = "OcrBackgroundProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OcrResult>, Object> {
        final /* synthetic */ Page $pendingPage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Page page, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$pendingPage = page;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OcrBackgroundProcessor.this.new AnonymousClass2(this.$pendingPage, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OcrResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return OcrBackgroundProcessor.this.ocrProcessor.processImage(PageKt.toOcrInput(this.$pendingPage));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void updatePageProgress() {
        this.pageProgress = new Pair<>(Integer.valueOf(this.completedPages.size()), Integer.valueOf(this.completedPages.size() + this.pendingPages.size()));
    }

    private final OcrProcessor createOcrProcessor(Context context, ScanConfiguration.OcrConfiguration ocrConfiguration) {
        List<String> list = ocrConfiguration.languages;
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            throw new IllegalArgumentException("Please specify at least one OCR language in the scan configuration".toString());
        }
        return new OcrProcessor(context, new OcrConfiguration(list), new OcrProcessor.ProgressListener() { // from class: com.geniusscansdk.scanflow.OcrBackgroundProcessor$createOcrProcessor$progressListener$1
            @Override // com.geniusscansdk.ocr.OcrProcessor.ProgressListener
            public void onProgressUpdate(int progress) {
                int iIntValue = (((Number) this.this$0.pageProgress.first).intValue() * 100) + progress;
                Object second = this.this$0.pageProgress.second;
                Intrinsics.checkNotNullExpressionValue(second, "second");
                int iMax = iIntValue / Math.max(((Number) second).intValue(), 1);
                Log.d(OcrBackgroundProcessor.TAG, "Full progress: " + iMax);
                Function1 function1 = this.this$0.progressListener;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(iMax));
                }
            }
        });
    }
}
