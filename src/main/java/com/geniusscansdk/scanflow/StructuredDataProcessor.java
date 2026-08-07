package com.geniusscansdk.scanflow;

import android.content.Context;
import com.box.android.data.api.models.annotations.Location;
import com.geniusscansdk.ocr.OcrConfiguration;
import com.geniusscansdk.ocr.OcrProcessor;
import com.geniusscansdk.structureddata.ReadableCodeDetector;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: StructuredDataProcessor.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/geniusscansdk/scanflow/StructuredDataProcessor;", "", "context", "Landroid/content/Context;", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "<init>", "(Landroid/content/Context;Lcom/geniusscansdk/scanflow/ScanConfiguration;)V", "ocrProcessor", "Lcom/geniusscansdk/ocr/OcrProcessor;", "getOcrProcessor", "()Lcom/geniusscansdk/ocr/OcrProcessor;", "ocrProcessor$delegate", "Lkotlin/Lazy;", "readableCodeDetector", "Lcom/geniusscansdk/structureddata/ReadableCodeDetector;", "getReadableCodeDetector", "()Lcom/geniusscansdk/structureddata/ReadableCodeDetector;", "readableCodeDetector$delegate", SemanticAttributes.MessagingOperationValues.PROCESS, "", Location.TYPE_PAGE, "Lcom/geniusscansdk/scanflow/Page;", "(Lcom/geniusscansdk/scanflow/Page;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadModelsIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StructuredDataProcessor {
    private final Context context;

    /* JADX INFO: renamed from: ocrProcessor$delegate, reason: from kotlin metadata */
    private final Lazy ocrProcessor;

    /* JADX INFO: renamed from: readableCodeDetector$delegate, reason: from kotlin metadata */
    private final Lazy readableCodeDetector;
    private final ScanConfiguration scanConfiguration;

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.StructuredDataProcessor$preloadModelsIfNeeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: StructuredDataProcessor.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.StructuredDataProcessor", f = "StructuredDataProcessor.kt", i = {0}, l = {46, 49}, m = "preloadModelsIfNeeded", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StructuredDataProcessor.this.preloadModelsIfNeeded(this);
        }
    }

    public StructuredDataProcessor(Context context, ScanConfiguration scanConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
        this.context = context;
        this.scanConfiguration = scanConfiguration;
        this.ocrProcessor = LazyKt.lazy(new Function0() { // from class: com.geniusscansdk.scanflow.StructuredDataProcessor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StructuredDataProcessor.ocrProcessor_delegate$lambda$0(this.f$0);
            }
        });
        this.readableCodeDetector = LazyKt.lazy(new Function0() { // from class: com.geniusscansdk.scanflow.StructuredDataProcessor$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StructuredDataProcessor.readableCodeDetector_delegate$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OcrProcessor getOcrProcessor() {
        return (OcrProcessor) this.ocrProcessor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OcrProcessor ocrProcessor_delegate$lambda$0(StructuredDataProcessor structuredDataProcessor) {
        return new OcrProcessor(structuredDataProcessor.context, new OcrConfiguration(CollectionsKt.listOf("en-US")), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReadableCodeDetector getReadableCodeDetector() {
        return (ReadableCodeDetector) this.readableCodeDetector.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReadableCodeDetector readableCodeDetector_delegate$lambda$1(StructuredDataProcessor structuredDataProcessor) {
        return new ReadableCodeDetector(structuredDataProcessor.context, structuredDataProcessor.scanConfiguration.structuredDataReadableCodeTypes);
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.StructuredDataProcessor$process$2, reason: invalid class name */
    /* JADX INFO: compiled from: StructuredDataProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.StructuredDataProcessor$process$2", f = "StructuredDataProcessor.kt", i = {0}, l = {35}, m = "invokeSuspend", n = {"structuredDataResult"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Page $page;
        Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: com.geniusscansdk.scanflow.StructuredDataProcessor$process$2$WhenMappings */
        /* JADX INFO: compiled from: StructuredDataProcessor.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ScanConfiguration.StructuredData.values().length];
                try {
                    iArr[ScanConfiguration.StructuredData.RECEIPT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ScanConfiguration.StructuredData.READABLE_CODE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Page page, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$page = page;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StructuredDataProcessor.this.new AnonymousClass2(this.$page, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0041  */
        /* JADX WARN: Code duplicated, block: B:13:0x004a  */
        /* JADX WARN: Code duplicated, block: B:14:0x004c  */
        /* JADX WARN: Code duplicated, block: B:19:0x005b  */
        /* JADX WARN: Code duplicated, block: B:21:0x0079 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x0081  */
        /* JADX WARN: Code duplicated, block: B:25:0x0087  */
        /* JADX WARN: Code duplicated, block: B:28:0x00ba A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:29:0x0056 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:30:0x0059 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:32:0x003b A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0077 -> B:22:0x007a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:29:0x0056
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r1 = r9.L$1
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r4 = r9.L$0
                com.geniusscansdk.structureddata.StructuredDataResult r4 = (com.geniusscansdk.structureddata.StructuredDataResult) r4
                kotlin.ResultKt.throwOnFailure(r10)
                goto L7a
            L18:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L20:
                kotlin.ResultKt.throwOnFailure(r10)
                com.geniusscansdk.structureddata.StructuredDataResult r10 = new com.geniusscansdk.structureddata.StructuredDataResult
                r1 = 3
                r10.<init>(r3, r3, r1, r3)
                com.geniusscansdk.scanflow.StructuredDataProcessor r1 = com.geniusscansdk.scanflow.StructuredDataProcessor.this
                com.geniusscansdk.scanflow.ScanConfiguration r1 = com.geniusscansdk.scanflow.StructuredDataProcessor.access$getScanConfiguration$p(r1)
                java.util.EnumSet<com.geniusscansdk.scanflow.ScanConfiguration$StructuredData> r1 = r1.structuredData
                java.util.Iterator r1 = r1.iterator()
                java.lang.String r4 = "iterator(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
                r4 = r10
            L3b:
                boolean r10 = r1.hasNext()
                if (r10 == 0) goto Lba
                java.lang.Object r10 = r1.next()
                com.geniusscansdk.scanflow.ScanConfiguration$StructuredData r10 = (com.geniusscansdk.scanflow.ScanConfiguration.StructuredData) r10
                r5 = -1
                if (r10 != 0) goto L4c
                r10 = r5
                goto L54
            L4c:
                int[] r6 = com.geniusscansdk.scanflow.StructuredDataProcessor.AnonymousClass2.WhenMappings.$EnumSwitchMapping$0
                int r10 = r10.ordinal()
                r10 = r6[r10]
            L54:
                if (r10 == r5) goto L3b
                r5 = 2
                if (r10 == r2) goto L87
                if (r10 != r5) goto L81
                com.geniusscansdk.scanflow.StructuredDataProcessor r10 = com.geniusscansdk.scanflow.StructuredDataProcessor.this
                com.geniusscansdk.structureddata.ReadableCodeDetector r10 = com.geniusscansdk.scanflow.StructuredDataProcessor.access$getReadableCodeDetector(r10)
                com.geniusscansdk.scanflow.Page r5 = r9.$page
                java.io.File r5 = r5.getEnhancedImage()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
                r6 = r9
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r9.L$0 = r4
                r9.L$1 = r1
                r9.label = r2
                java.lang.Object r10 = r10.detect(r5, r6)
                if (r10 != r0) goto L7a
                return r0
            L7a:
                java.util.List r10 = (java.util.List) r10
                com.geniusscansdk.structureddata.StructuredDataResult r4 = com.geniusscansdk.structureddata.StructuredDataResult.copy$default(r4, r3, r10, r2, r3)
                goto L3b
            L81:
                kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
                r9.<init>()
                throw r9
            L87:
                com.geniusscansdk.scanflow.StructuredDataProcessor r10 = com.geniusscansdk.scanflow.StructuredDataProcessor.this
                com.geniusscansdk.ocr.OcrProcessor r10 = com.geniusscansdk.scanflow.StructuredDataProcessor.access$getOcrProcessor(r10)
                com.geniusscansdk.scanflow.Page r6 = r9.$page
                com.geniusscansdk.ocr.OcrProcessor$Input r6 = com.geniusscansdk.scanflow.PageKt.toOcrInput(r6)
                com.geniusscansdk.ocr.OcrResult r10 = r10.processImage(r6)
                com.geniusscansdk.structureddata.StructuredDataExtractor r6 = new com.geniusscansdk.structureddata.StructuredDataExtractor
                r6.<init>()
                com.geniusscansdk.scanflow.StructuredDataProcessor r7 = com.geniusscansdk.scanflow.StructuredDataProcessor.this
                android.content.Context r7 = com.geniusscansdk.scanflow.StructuredDataProcessor.access$getContext$p(r7)
                android.content.res.Resources r7 = r7.getResources()
                android.content.res.Configuration r7 = r7.getConfiguration()
                java.util.Locale r7 = r7.locale
                java.lang.String r8 = "locale"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
                com.geniusscansdk.structureddata.StructuredDataReceipt r10 = r6.receiptFromOCRResult(r7, r10)
                com.geniusscansdk.structureddata.StructuredDataResult r4 = com.geniusscansdk.structureddata.StructuredDataResult.copy$default(r4, r10, r3, r5, r3)
                goto L3b
            Lba:
                com.geniusscansdk.scanflow.Page r9 = r9.$page
                r9.setStructuredDataResult(r4)
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.scanflow.StructuredDataProcessor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object process(Page page, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(page, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009c, code lost:
    
        if (r6.preloadModels(r0) == r1) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object preloadModelsIfNeeded(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.geniusscansdk.scanflow.StructuredDataProcessor.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            com.geniusscansdk.scanflow.StructuredDataProcessor$preloadModelsIfNeeded$1 r0 = (com.geniusscansdk.scanflow.StructuredDataProcessor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.geniusscansdk.scanflow.StructuredDataProcessor$preloadModelsIfNeeded$1 r0 = new com.geniusscansdk.scanflow.StructuredDataProcessor$preloadModelsIfNeeded$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 == r5) goto L37
            if (r2 != r4) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            goto L9f
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            java.lang.Object r6 = r0.L$0
            com.geniusscansdk.scanflow.StructuredDataProcessor r6 = (com.geniusscansdk.scanflow.StructuredDataProcessor) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L84
        L3f:
            kotlin.ResultKt.throwOnFailure(r7)
            com.geniusscansdk.scanflow.ScanConfiguration r7 = r6.scanConfiguration
            java.util.EnumSet<com.geniusscansdk.scanflow.ScanConfiguration$StructuredData> r7 = r7.structuredData
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r2 = r7 instanceof java.util.Collection
            if (r2 == 0) goto L56
            r2 = r7
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L56
            goto L84
        L56:
            java.util.Iterator r7 = r7.iterator()
        L5a:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L84
            java.lang.Object r2 = r7.next()
            com.geniusscansdk.scanflow.ScanConfiguration$StructuredData r2 = (com.geniusscansdk.scanflow.ScanConfiguration.StructuredData) r2
            boolean r2 = r2.getNeedsOCR()
            if (r2 == 0) goto L5a
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.geniusscansdk.scanflow.StructuredDataProcessor$preloadModelsIfNeeded$3 r2 = new com.geniusscansdk.scanflow.StructuredDataProcessor$preloadModelsIfNeeded$3
            r2.<init>(r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L84
            goto L9e
        L84:
            com.geniusscansdk.scanflow.ScanConfiguration r7 = r6.scanConfiguration
            java.util.EnumSet<com.geniusscansdk.scanflow.ScanConfiguration$StructuredData> r7 = r7.structuredData
            com.geniusscansdk.scanflow.ScanConfiguration$StructuredData r2 = com.geniusscansdk.scanflow.ScanConfiguration.StructuredData.READABLE_CODE
            boolean r7 = r7.contains(r2)
            if (r7 == 0) goto La2
            com.geniusscansdk.structureddata.ReadableCodeDetector r6 = r6.getReadableCodeDetector()
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r6 = r6.preloadModels(r0)
            if (r6 != r1) goto L9f
        L9e:
            return r1
        L9f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        La2:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.scanflow.StructuredDataProcessor.preloadModelsIfNeeded(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.StructuredDataProcessor$preloadModelsIfNeeded$3, reason: invalid class name */
    /* JADX INFO: compiled from: StructuredDataProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.StructuredDataProcessor$preloadModelsIfNeeded$3", f = "StructuredDataProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StructuredDataProcessor.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws InterruptedException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            StructuredDataProcessor.this.getOcrProcessor().preloadModels();
            return Unit.INSTANCE;
        }
    }
}
