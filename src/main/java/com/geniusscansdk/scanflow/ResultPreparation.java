package com.geniusscansdk.scanflow;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import com.box.android.data.api.models.annotations.Location;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.geniusscansdk.R;
import com.geniusscansdk.ocr.OcrResult;
import com.geniusscansdk.pdf.DocumentGenerator;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ResultPreparation.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0086@¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u001c\u0010\u0017\u001a\u00020\u00182\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082@¢\u0006\u0002\u0010\u0011J \u0010\u0019\u001a\u0004\u0018\u00010\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/geniusscansdk/scanflow/ResultPreparation;", "", "context", "Landroid/content/Context;", "ocrBackgroundProcessor", "Lcom/geniusscansdk/scanflow/OcrBackgroundProcessor;", "imageStore", "Lcom/geniusscansdk/scanflow/ImageStore;", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "<init>", "(Landroid/content/Context;Lcom/geniusscansdk/scanflow/OcrBackgroundProcessor;Lcom/geniusscansdk/scanflow/ImageStore;Lcom/geniusscansdk/scanflow/ScanConfiguration;)V", "prepareResult", "Lcom/geniusscansdk/scanflow/ScanResult;", SupportedFileExtensions.PAGES_EXTENSION, "", "Lcom/geniusscansdk/scanflow/Page;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showInitialProgressDialog", "Landroid/app/ProgressDialog;", "createScanResult", "multiPageDocument", "Ljava/io/File;", "extractStructuredData", "", "generateMultiPageDocument", "progressListener", "Lcom/geniusscansdk/scanflow/DocumentGeneration$ProgressListener;", "waitForOcrCompletion", "progressDialog", "(Landroid/app/ProgressDialog;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultPreparation {
    private static final String TAG;
    private final Context context;
    private final ImageStore imageStore;
    private final OcrBackgroundProcessor ocrBackgroundProcessor;
    private final ScanConfiguration scanConfiguration;

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.ResultPreparation$extractStructuredData$1, reason: invalid class name */
    /* JADX INFO: compiled from: ResultPreparation.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.ResultPreparation", f = "ResultPreparation.kt", i = {0, 0}, l = {80}, m = "extractStructuredData", n = {"structuredDataProcessor", Location.TYPE_PAGE}, s = {"L$0", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResultPreparation.this.extractStructuredData(null, this);
        }
    }

    public ResultPreparation(Context context, OcrBackgroundProcessor ocrBackgroundProcessor, ImageStore imageStore, ScanConfiguration scanConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageStore, "imageStore");
        Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
        this.context = context;
        this.ocrBackgroundProcessor = ocrBackgroundProcessor;
        this.imageStore = imageStore;
        this.scanConfiguration = scanConfiguration;
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.ResultPreparation$prepareResult$2, reason: invalid class name */
    /* JADX INFO: compiled from: ResultPreparation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/geniusscansdk/scanflow/ScanResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.ResultPreparation$prepareResult$2", f = "ResultPreparation.kt", i = {0}, l = {32}, m = "invokeSuspend", n = {"progressDialog"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ScanResult>, Object> {
        final /* synthetic */ List<Page> $pages;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<Page> list, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$pages = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = ResultPreparation.this.new AnonymousClass2(this.$pages, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ScanResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final ProgressDialog progressDialog;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ProgressDialog progressDialogShowInitialProgressDialog = ResultPreparation.this.showInitialProgressDialog();
                Job[] jobArr = {BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ResultPreparation$prepareResult$2$tasks$1(ResultPreparation.this, progressDialogShowInitialProgressDialog, null), 3, null), BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ResultPreparation$prepareResult$2$tasks$2(ResultPreparation.this, this.$pages, null), 3, null)};
                this.L$0 = progressDialogShowInitialProgressDialog;
                this.label = 1;
                if (AwaitKt.joinAll(CollectionsKt.listOf((Object[]) jobArr), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                progressDialog = progressDialogShowInitialProgressDialog;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                progressDialog = (ProgressDialog) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            progressDialog.setMessage(ResultPreparation.this.context.getString(R.string.gssdk_progress_generating_document));
            ScanResult scanResultCreateScanResult = ResultPreparation.this.createScanResult(this.$pages, ResultPreparation.this.generateMultiPageDocument(this.$pages, new DocumentGeneration.ProgressListener() { // from class: com.geniusscansdk.scanflow.ResultPreparation$prepareResult$2$$ExternalSyntheticLambda0
                @Override // com.geniusscansdk.scanflow.DocumentGeneration.ProgressListener
                public final void onProgressUpdate(int i2) {
                    progressDialog.setProgress(i2);
                }
            }));
            progressDialog.dismiss();
            return scanResultCreateScanResult;
        }
    }

    public final Object prepareResult(List<Page> list, Continuation<? super ScanResult> continuation) {
        return CoroutineScopeKt.coroutineScope(new AnonymousClass2(list, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProgressDialog showInitialProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this.context);
        progressDialog.setProgressStyle(1);
        progressDialog.setMessage(progressDialog.getContext().getString(R.string.gssdk_progress_generating_document));
        progressDialog.setMax(100);
        progressDialog.setCancelable(false);
        progressDialog.show();
        return progressDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScanResult createScanResult(List<Page> pages, File multiPageDocument) {
        ScanResult.OcrResult ocrResult;
        ScanResult scanResult = new ScanResult(null, null, 3, null);
        ScanConfiguration.OcrConfiguration ocrConfiguration = this.scanConfiguration.ocrConfiguration;
        List<Page> list = pages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Page page : list) {
            OcrResult ocrResult2 = page.getOcrResult();
            if (ocrConfiguration == null || ocrResult2 == null) {
                ocrResult = null;
            } else {
                ocrResult = new ScanResult.OcrResult(ocrConfiguration.outputFormats.contains(ScanConfiguration.OcrOutputFormat.RAW_TEXT) ? ocrResult2.text : null, ocrConfiguration.outputFormats.contains(ScanConfiguration.OcrOutputFormat.HOCR) ? ocrResult2.textLayout.getHocr() : null);
            }
            File originalImage = page.getOriginalImage();
            File enhancedImage = page.getEnhancedImage();
            Intrinsics.checkNotNull(enhancedImage);
            arrayList.add(new ScanResult.Scan(originalImage, enhancedImage, ocrResult, page.getStructuredDataResult()));
        }
        scanResult.scans = arrayList;
        scanResult.multiPageDocument = multiPageDocument;
        return scanResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008a -> B:23:0x0061). Please report as a decompilation issue!!! */
    public final Object extractStructuredData(List<Page> list, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Iterator it;
        StructuredDataProcessor structuredDataProcessor;
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
            if (this.scanConfiguration.structuredData.isEmpty()) {
                return Unit.INSTANCE;
            }
            StructuredDataProcessor structuredDataProcessor2 = new StructuredDataProcessor(this.context, this.scanConfiguration);
            it = list.iterator();
            structuredDataProcessor = structuredDataProcessor2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Page page = (Page) anonymousClass1.L$2;
            it = (Iterator) anonymousClass1.L$1;
            structuredDataProcessor = (StructuredDataProcessor) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                Log.e(TAG, "Error extracting structured data for page " + page, e);
            }
        }
        while (it.hasNext()) {
            Page page2 = (Page) it.next();
            CoroutineDispatcher io2 = Dispatchers.getIO();
            ResultPreparation$extractStructuredData$2$1 resultPreparation$extractStructuredData$2$1 = new ResultPreparation$extractStructuredData$2$1(structuredDataProcessor, page2, null);
            anonymousClass1.L$0 = structuredDataProcessor;
            anonymousClass1.L$1 = it;
            anonymousClass1.L$2 = page2;
            anonymousClass1.label = 1;
            if (BuildersKt.withContext(io2, resultPreparation$extractStructuredData$2$1, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File generateMultiPageDocument(List<Page> pages, DocumentGeneration.ProgressListener progressListener) {
        return new DocumentGeneration(this.imageStore, new DocumentGenerator(this.context), progressListener).generateDocument(pages, this.context.getExternalFilesDir(null), this.scanConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object waitForOcrCompletion(final ProgressDialog progressDialog, Continuation<? super Unit> continuation) {
        if (this.ocrBackgroundProcessor == null) {
            return Unit.INSTANCE;
        }
        progressDialog.setMessage(this.context.getString(R.string.gssdk_progress_recognizing_text));
        this.ocrBackgroundProcessor.setProgressListener(new Function1() { // from class: com.geniusscansdk.scanflow.ResultPreparation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ResultPreparation.waitForOcrCompletion$lambda$3(progressDialog, ((Integer) obj).intValue());
            }
        });
        Object objWaitForCompletion = this.ocrBackgroundProcessor.waitForCompletion(continuation);
        return objWaitForCompletion == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWaitForCompletion : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit waitForOcrCompletion$lambda$3(ProgressDialog progressDialog, int i) {
        progressDialog.setProgress(i);
        return Unit.INSTANCE;
    }

    static {
        Intrinsics.checkNotNullExpressionValue("ResultPreparation", "getSimpleName(...)");
        TAG = "ResultPreparation";
    }
}
