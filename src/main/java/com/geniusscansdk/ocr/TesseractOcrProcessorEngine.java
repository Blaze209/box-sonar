package com.geniusscansdk.ocr;

import android.content.Context;
import com.geniusscansdk.core.FilterConfiguration;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.ScanProcessor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: TesseractOcrProcessorEngine.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/geniusscansdk/ocr/TesseractOcrProcessorEngine;", "Lcom/geniusscansdk/ocr/OcrProcessorEngine;", "context", "Landroid/content/Context;", "languages", "", "Lcom/geniusscansdk/ocr/OcrLanguage;", "progressListener", "Lcom/geniusscansdk/ocr/OcrProcessor$ProgressListener;", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/geniusscansdk/ocr/OcrProcessor$ProgressListener;)V", "languageManager", "Lcom/geniusscansdk/ocr/TesseractLanguageManager;", "requiredEnhancement", "Lcom/geniusscansdk/core/ScanProcessor$Enhancement;", "getRequiredEnhancement", "()Lcom/geniusscansdk/core/ScanProcessor$Enhancement;", "processImage", "Lcom/geniusscansdk/ocr/OcrResult;", "imageFile", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadModels", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createEngine", "Lcom/geniusscansdk/ocr/JNIOCREngine;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TesseractOcrProcessorEngine implements OcrProcessorEngine {
    private final TesseractLanguageManager languageManager;
    private final List<OcrLanguage> languages;
    private final OcrProcessor.ProgressListener progressListener;
    private final ScanProcessor.Enhancement requiredEnhancement;

    /* JADX INFO: renamed from: com.geniusscansdk.ocr.TesseractOcrProcessorEngine$preloadModels$1, reason: invalid class name */
    /* JADX INFO: compiled from: TesseractOcrProcessorEngine.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.ocr.TesseractOcrProcessorEngine", f = "TesseractOcrProcessorEngine.kt", i = {}, l = {46}, m = "preloadModels", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TesseractOcrProcessorEngine.this.preloadModels(this);
        }
    }

    public TesseractOcrProcessorEngine(Context context, List<OcrLanguage> languages, OcrProcessor.ProgressListener progressListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(languages, "languages");
        this.languages = languages;
        this.progressListener = progressListener;
        this.languageManager = new TesseractLanguageManager(context);
        System.loadLibrary("gssdk-ocr");
        this.requiredEnhancement = ScanProcessor.Enhancement.INSTANCE.automatic(ScanProcessor.FilterStyle.DOCUMENT, FilterConfiguration.Color.Palette.MONOCHROME);
    }

    public /* synthetic */ TesseractOcrProcessorEngine(Context context, List list, OcrProcessor.ProgressListener progressListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, (i & 4) != 0 ? null : progressListener);
    }

    @Override // com.geniusscansdk.ocr.OcrProcessorEngine
    public ScanProcessor.Enhancement getRequiredEnhancement() {
        return this.requiredEnhancement;
    }

    /* JADX INFO: renamed from: com.geniusscansdk.ocr.TesseractOcrProcessorEngine$processImage$2, reason: invalid class name */
    /* JADX INFO: compiled from: TesseractOcrProcessorEngine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/geniusscansdk/ocr/OcrResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.ocr.TesseractOcrProcessorEngine$processImage$2", f = "TesseractOcrProcessorEngine.kt", i = {}, l = {30, 33}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OcrResult>, Object> {
        final /* synthetic */ File $imageFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(File file, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$imageFile = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TesseractOcrProcessorEngine.this.new AnonymousClass2(this.$imageFile, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OcrResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
        
            if (r6 == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws com.geniusscansdk.ocr.ModelDownloadingException, com.geniusscansdk.ocr.OcrProcessingException {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                r3 = 2
                if (r1 == 0) goto L24
                if (r1 == r2) goto L1a
                if (r1 != r3) goto L12
                kotlin.ResultKt.throwOnFailure(r6)
                goto L58
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                kotlin.ResultKt.throwOnFailure(r6)
                kotlin.Result r6 = (kotlin.Result) r6
                java.lang.Object r6 = r6.getValue()
                goto L3f
            L24:
                kotlin.ResultKt.throwOnFailure(r6)
                com.geniusscansdk.ocr.TesseractOcrProcessorEngine r6 = com.geniusscansdk.ocr.TesseractOcrProcessorEngine.this
                com.geniusscansdk.ocr.TesseractLanguageManager r6 = com.geniusscansdk.ocr.TesseractOcrProcessorEngine.access$getLanguageManager$p(r6)
                com.geniusscansdk.ocr.TesseractOcrProcessorEngine r1 = com.geniusscansdk.ocr.TesseractOcrProcessorEngine.this
                java.util.List r1 = com.geniusscansdk.ocr.TesseractOcrProcessorEngine.access$getLanguages$p(r1)
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.label = r2
                java.lang.Object r6 = r6.m13570downloadMissingLanguageFilesgIAlus(r1, r4)
                if (r6 != r0) goto L3f
                goto L57
            L3f:
                java.lang.Throwable r6 = kotlin.Result.m14783exceptionOrNullimpl(r6)
                if (r6 != 0) goto Lb6
                com.geniusscansdk.BitmapLoader r6 = new com.geniusscansdk.BitmapLoader
                r6.<init>()
                java.io.File r1 = r5.$imageFile
                r2 = r5
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r5.label = r3
                java.lang.Object r6 = r6.readBitmapSize(r1, r2)
                if (r6 != r0) goto L58
            L57:
                return r0
            L58:
                com.geniusscansdk.Size r6 = (com.geniusscansdk.Size) r6
                com.geniusscansdk.ocr.JNIOCREngineInput r0 = new com.geniusscansdk.ocr.JNIOCREngineInput
                java.io.File r1 = r5.$imageFile
                java.lang.String r1 = r1.getAbsolutePath()
                r0.<init>(r1)
                com.geniusscansdk.ocr.TesseractOcrProcessorEngine r5 = com.geniusscansdk.ocr.TesseractOcrProcessorEngine.this
                com.geniusscansdk.ocr.JNIOCREngine r5 = com.geniusscansdk.ocr.TesseractOcrProcessorEngine.access$createEngine(r5)
                com.geniusscansdk.ocr.JNIOCREngineResult r5 = r5.recognizeText(r0)
                com.geniusscansdk.ocr.JNIOCREngineError r0 = r5.status
                com.geniusscansdk.ocr.JNIOCREngineError r1 = com.geniusscansdk.ocr.JNIOCREngineError.SUCCESS
                if (r0 != r1) goto L9e
                com.geniusscansdk.ocr.OcrResult r0 = new com.geniusscansdk.ocr.OcrResult
                java.lang.String r1 = r5.text
                java.lang.String r2 = "text"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                com.geniusscansdk.core.JNITextLayout r2 = r5.textLayout
                java.lang.String r3 = "textLayout"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                com.geniusscansdk.core.TextLayout r2 = com.geniusscansdk.core.TextLayoutKt.fromJNI(r2)
                com.geniusscansdk.core.JNITextLayout r5 = r5.textLayout
                java.lang.String r5 = r5.getHocr()
                java.lang.String r3 = "getHocr(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
                com.geniusscansdk.ocr.SpatialText r5 = com.geniusscansdk.ocr.SpatialStringKt.hocrToSpatialText(r5, r6)
                r0.<init>(r1, r2, r5)
                return r0
            L9e:
                com.geniusscansdk.ocr.OcrProcessingException r6 = new com.geniusscansdk.ocr.OcrProcessingException
                com.geniusscansdk.ocr.JNIOCREngineError r5 = r5.status
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "OCR failed with error: "
                r0.<init>(r1)
                java.lang.StringBuilder r5 = r0.append(r5)
                java.lang.String r5 = r5.toString()
                r0 = 0
                r6.<init>(r5, r0, r3, r0)
                throw r6
            Lb6:
                com.geniusscansdk.ocr.ModelDownloadingException r5 = new com.geniusscansdk.ocr.ModelDownloadingException
                java.lang.String r0 = "Error downloading requested languages"
                r5.<init>(r0, r6)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.ocr.TesseractOcrProcessorEngine.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.geniusscansdk.ocr.OcrProcessorEngine
    public Object processImage(File file, Continuation<? super OcrResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(file, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.geniusscansdk.ocr.OcrProcessorEngine
    public Object preloadModels(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TesseractLanguageManager tesseractLanguageManager = this.languageManager;
            List<OcrLanguage> list = this.languages;
            anonymousClass1.label = 1;
            if (tesseractLanguageManager.m13570downloadMissingLanguageFilesgIAlus(list, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((Result) obj).getValue();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JNIOCREngine createEngine() {
        List<OcrLanguage> list = this.languages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((OcrLanguage) it.next()).getTesseractCode$gssdk_release());
        }
        JNIOCREngine jNIOCREngineCreate = JNIOCREngine.create(new JNIOCREngineConfiguration(new ArrayList(arrayList), this.languageManager.getLanguageDirectory().getAbsolutePath()), GeniusScanSDK.getLogger(), this.progressListener != null ? new JNIOCREngineProgressListener() { // from class: com.geniusscansdk.ocr.TesseractOcrProcessorEngine$createEngine$engineProgressListener$1$1
            @Override // com.geniusscansdk.ocr.JNIOCREngineProgressListener
            public void updateProgress(int progress) {
                this.this$0.progressListener.onProgressUpdate(progress);
            }
        } : null);
        Intrinsics.checkNotNullExpressionValue(jNIOCREngineCreate, "create(...)");
        return jNIOCREngineCreate;
    }
}
