package com.box.android.capture.documentscanning.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.box.android.data.api.models.annotations.Location;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.DocumentPageFilterType;
import com.box.android.domain.models.DocumentPosition;
import com.box.android.domain.models.DocumentScanningError;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ScannedDocumentPage;
import com.box.android.domain.models.ScannedPageProcessingResult;
import com.box.android.domain.services.IDocumentScanPageProcessor;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.geniusscansdk.core.ScanProcessor;
import com.geniusscansdk.core.TextLayout;
import com.geniusscansdk.pdf.PDFSize;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.tasks.TasksKt;

/* JADX INFO: compiled from: DocumentScanPageProcessor.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 82\u00020\u0001:\u000389:B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0016J*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u001bJD\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096@¢\u0006\u0002\u0010'JH\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020)0\u00102\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190+2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010/JH\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020)0\u00102\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190+2\u0006\u0010,\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0002032\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u00104J\u0018\u00105\u001a\u0004\u0018\u0001062\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u00104J\u0012\u00107\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006;"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/DocumentScanPageProcessor;", "Lcom/box/android/domain/services/IDocumentScanPageProcessor;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "workingDir", "Ljava/io/File;", "getWorkingDir", "()Ljava/io/File;", "workingDir$delegate", "Lkotlin/Lazy;", "getWorkingDirectory", "getEnhancedImageDirectory", "prepareFile", "rotateImage", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "imagePath", "", "degrees", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rotatePage", "Lcom/box/android/domain/models/ScannedDocumentPage;", Location.TYPE_PAGE, "(Lcom/box/android/domain/models/ScannedDocumentPage;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processImage", "Lcom/box/android/domain/models/ScannedPageProcessingResult;", "context", "Landroid/content/Context;", "originalImageFile", "distortionCorrection", "", "filterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "documentPosition", "Lcom/box/android/domain/models/DocumentPosition;", "(Landroid/content/Context;Ljava/io/File;ZLcom/box/android/domain/models/DocumentPageFilterType;Lcom/box/android/domain/models/DocumentPosition;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDocument", "Lcom/box/android/domain/models/DocumentScanningError;", SupportedFileExtensions.PAGES_EXTENSION, "", "title", "outputFileName", "ocrOptional", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLandroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "outputFile", "(Ljava/util/List;Ljava/lang/String;Ljava/io/File;ZLandroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recognizeTextSafe", "Lcom/box/android/capture/documentscanning/logic/DocumentScanPageProcessor$PageScanResult;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recognizeText", "Lcom/box/android/capture/documentscanning/logic/DocumentScanPageProcessor$PageLayout;", "preparePdfFont", "Companion", "PageLayout", "PageScanResult", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentScanPageProcessor implements IDocumentScanPageProcessor {
    private static final String ENHANCED_IMAGES_SUBDIR = "EnhancedImages";
    private static final String FONT_NAME = "roboto_light.ttf";
    private static final String LOGTAG = "ScannedPageProcessor";
    private static final String WORKING_SUBDIR = "DocumentScanning";
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: workingDir$delegate, reason: from kotlin metadata */
    private final Lazy workingDir;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final PDFSize PAGE_SIZE_A4 = new PDFSize(8.27d, 11.69d);

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor$processImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentScanPageProcessor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor", f = "DocumentScanPageProcessor.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {95}, m = "processImage", n = {"context", "originalImageFile", "filterType", "documentPosition", "distortionCorrection", "$i$f$resultOf", "$i$a$-resultOf-DocumentScanPageProcessor$processImage$2"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanPageProcessor.this.processImage(null, null, false, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor$recognizeText$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DocumentScanPageProcessor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor", f = "DocumentScanPageProcessor.kt", i = {0, 0, 0, 0}, l = {246}, m = "recognizeText", n = {"imagePath", "bitmap", "image", "recognizer"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C09811 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09811(Continuation<? super C09811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanPageProcessor.this.recognizeText(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor$recognizeTextSafe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DocumentScanPageProcessor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor", f = "DocumentScanPageProcessor.kt", i = {0, 0, 0, 0, 0}, l = {232}, m = "recognizeTextSafe", n = {"imagePath", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$i$f$measureTimeMillis", "start$iv", "$i$a$-measureTimeMillis-DocumentScanPageProcessor$recognizeTextSafe$elapsedTime$1"}, s = {"L$0", "L$1", "I$0", "J$0", "I$1"}, v = 1)
    static final class C09821 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09821(Continuation<? super C09821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanPageProcessor.this.recognizeTextSafe(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor$rotateImage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DocumentScanPageProcessor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor", f = "DocumentScanPageProcessor.kt", i = {0, 0, 0, 0}, l = {66}, m = "rotateImage", n = {"imagePath", "degrees", "$i$f$resultOf", "$i$a$-resultOf-DocumentScanPageProcessor$rotateImage$2"}, s = {"L$0", "I$0", "I$1", "I$2"}, v = 1)
    static final class C09831 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09831(Continuation<? super C09831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanPageProcessor.this.rotateImage(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor$rotatePage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DocumentScanPageProcessor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor", f = "DocumentScanPageProcessor.kt", i = {0, 0, 0, 0}, l = {74}, m = "rotatePage", n = {Location.TYPE_PAGE, "degrees", "$i$f$resultOf", "$i$a$-resultOf-DocumentScanPageProcessor$rotatePage$2"}, s = {"L$0", "I$0", "I$1", "I$2"}, v = 1)
    static final class C09841 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09841(Continuation<? super C09841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanPageProcessor.this.rotatePage(null, 0, this);
        }
    }

    @Inject
    public DocumentScanPageProcessor(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.userContextManager = userContextManager;
        this.workingDir = LazyKt.lazy(new Function0() { // from class: com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DocumentScanPageProcessor.workingDir_delegate$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: compiled from: DocumentScanPageProcessor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/DocumentScanPageProcessor$Companion;", "", "<init>", "()V", "LOGTAG", "", "WORKING_SUBDIR", "FONT_NAME", "ENHANCED_IMAGES_SUBDIR", "PAGE_SIZE_A4", "Lcom/geniusscansdk/pdf/PDFSize;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final File getWorkingDir() {
        return (File) this.workingDir.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File workingDir_delegate$lambda$0(DocumentScanPageProcessor documentScanPageProcessor) {
        return new File(documentScanPageProcessor.userContextManager.getPreviewStorage().getMediaProcessingDirectory(), WORKING_SUBDIR);
    }

    @Override // com.box.android.domain.services.IDocumentScanPageProcessor
    public File getWorkingDirectory() {
        File workingDir = getWorkingDir();
        workingDir.mkdir();
        return workingDir;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getEnhancedImageDirectory() {
        File file = new File(getWorkingDirectory(), ENHANCED_IMAGES_SUBDIR);
        file.mkdirs();
        return file;
    }

    @Override // com.box.android.domain.services.IDocumentScanPageProcessor
    public File prepareFile() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new File(getWorkingDirectory(), string + ".jpg");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IDocumentScanPageProcessor
    public Object rotateImage(String str, int i, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C09831 c09831;
        Result.Error error;
        if (continuation instanceof C09831) {
            c09831 = (C09831) continuation;
            if ((c09831.label & Integer.MIN_VALUE) != 0) {
                c09831.label -= Integer.MIN_VALUE;
            } else {
                c09831 = new C09831(continuation);
            }
        } else {
            c09831 = new C09831(continuation);
        }
        Object obj = c09831.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09831.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                DocumentScanPageProcessor$rotateImage$2$1 documentScanPageProcessor$rotateImage$2$1 = new DocumentScanPageProcessor$rotateImage$2$1(i, str, null);
                c09831.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c09831.I$0 = i;
                c09831.I$1 = 0;
                c09831.I$2 = 0;
                c09831.label = 1;
                if (BuildersKt.withContext(io2, documentScanPageProcessor$rotateImage$2$1, c09831) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c09831.I$2;
                int i4 = c09831.I$1;
                int i5 = c09831.I$0;
                ResultKt.throwOnFailure(obj);
            }
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(new DomainError.CacheWriteError(null, 1, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IDocumentScanPageProcessor
    public Object rotatePage(ScannedDocumentPage scannedDocumentPage, int i, Continuation<? super Result<ScannedDocumentPage, ? extends DomainError>> continuation) {
        C09841 c09841;
        Result.Error error;
        if (continuation instanceof C09841) {
            c09841 = (C09841) continuation;
            if ((c09841.label & Integer.MIN_VALUE) != 0) {
                c09841.label -= Integer.MIN_VALUE;
            } else {
                c09841 = new C09841(continuation);
            }
        } else {
            c09841 = new C09841(continuation);
        }
        Object objWithContext = c09841.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09841.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                DocumentScanPageProcessor$rotatePage$2$1 documentScanPageProcessor$rotatePage$2$1 = new DocumentScanPageProcessor$rotatePage$2$1(i, scannedDocumentPage, null);
                c09841.L$0 = SpillingKt.nullOutSpilledVariable(scannedDocumentPage);
                c09841.I$0 = i;
                c09841.I$1 = 0;
                c09841.I$2 = 0;
                c09841.label = 1;
                objWithContext = BuildersKt.withContext(io2, documentScanPageProcessor$rotatePage$2$1, c09841);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c09841.I$2;
                int i4 = c09841.I$1;
                int i5 = c09841.I$0;
                ResultKt.throwOnFailure(objWithContext);
            }
            error = new Result.Success((ScannedDocumentPage) objWithContext);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(new DomainError.CacheWriteError(null, 1, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.domain.services.IDocumentScanPageProcessor
    public Object processImage(Context context, File file, boolean z, DocumentPageFilterType documentPageFilterType, DocumentPosition documentPosition, Continuation<? super Result<ScannedPageProcessingResult, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
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
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objWithContext);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                DocumentScanPageProcessor$processImage$2$1 documentScanPageProcessor$processImage$2$1 = new DocumentScanPageProcessor$processImage$2$1(this, documentPosition, documentPageFilterType, z, context, file, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(file);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(documentPageFilterType);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(documentPosition);
                anonymousClass1.Z$0 = z;
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                objWithContext = BuildersKt.withContext(io2, documentScanPageProcessor$processImage$2$1, anonymousClass1);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                boolean z2 = anonymousClass1.Z$0;
                ResultKt.throwOnFailure(objWithContext);
            }
            error = new Result.Success((ScanProcessor.Result) objWithContext);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            ScanProcessor.Result result = (ScanProcessor.Result) ((Result.Success) error).getValue();
            error = new Result.Success(new ScannedPageProcessingResult(ScannedDocumentPageToGeniusMapperKt.toDocumentPageFilterType(result.appliedFilterConfiguration), ScannedDocumentPageToGeniusMapperKt.toDocumentPosition(result.appliedQuadrangle), (File) result.output));
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(LOGTAG, "Error while processing scanned page " + ((Exception) ((Result.Error) error).getValue()));
            return new Result.Error(new DomainError.CacheWriteError(null, 1, null));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.box.android.domain.services.IDocumentScanPageProcessor
    public Object createDocument(List<ScannedDocumentPage> list, String str, String str2, boolean z, Context context, Continuation<? super Result<? extends File, ? extends DocumentScanningError>> continuation) {
        return createDocument(list, str, new File(this.userContextManager.getPreviewStorage().getTempUploadDirectory(), str2), z, context, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor$createDocument$3, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentScanPageProcessor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Ljava/io/File;", "Lcom/box/android/domain/models/DocumentScanningError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor$createDocument$3", f = "DocumentScanPageProcessor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {169}, m = "invokeSuspend", n = {"totalTime", "charactersByLanguage", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "rotatedFileName", "$i$f$map", "$i$f$mapTo", "$i$a$-map-DocumentScanPageProcessor$createDocument$3$pdfPages$1"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends File, ? extends DocumentScanningError>>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $ocrOptional;
        final /* synthetic */ File $outputFile;
        final /* synthetic */ List<ScannedDocumentPage> $pages;
        final /* synthetic */ String $title;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        final /* synthetic */ DocumentScanPageProcessor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(List<ScannedDocumentPage> list, String str, DocumentScanPageProcessor documentScanPageProcessor, Context context, File file, boolean z, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$pages = list;
            this.$title = str;
            this.this$0 = documentScanPageProcessor;
            this.$context = context;
            this.$outputFile = file;
            this.$ocrOptional = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$pages, this.$title, this.this$0, this.$context, this.$outputFile, this.$ocrOptional, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends File, ? extends DocumentScanningError>> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x008b  */
        /* JADX WARN: Code duplicated, block: B:13:0x0101 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0102  */
        /* JADX WARN: Code duplicated, block: B:17:0x0115  */
        /* JADX WARN: Code duplicated, block: B:18:0x0119  */
        /* JADX WARN: Code duplicated, block: B:20:0x011c A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:22:0x011f  */
        /* JADX WARN: Code duplicated, block: B:24:0x0122  */
        /* JADX WARN: Code duplicated, block: B:26:0x015b  */
        /* JADX WARN: Code duplicated, block: B:29:0x0164  */
        /* JADX WARN: Code duplicated, block: B:31:0x016c  */
        /* JADX WARN: Code duplicated, block: B:32:0x016f  */
        /* JADX WARN: Code duplicated, block: B:34:0x0172  */
        /* JADX WARN: Code duplicated, block: B:35:0x0179  */
        /* JADX WARN: Code duplicated, block: B:37:0x017c  */
        /* JADX WARN: Code duplicated, block: B:40:0x018e  */
        /* JADX WARN: Code duplicated, block: B:42:0x01a2  */
        /* JADX WARN: Code duplicated, block: B:43:0x01a9  */
        /* JADX WARN: Code duplicated, block: B:47:0x01e4  */
        /* JADX WARN: Code duplicated, block: B:48:0x01e9  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0102 -> B:15:0x0109). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 768
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IDocumentScanPageProcessor
    public Object createDocument(List<ScannedDocumentPage> list, String str, File file, boolean z, Context context, Continuation<? super Result<? extends File, ? extends DocumentScanningError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass3(list, str, this, context, file, z, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object recognizeTextSafe(String str, Continuation<? super PageScanResult> continuation) {
        C09821 c09821;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        MlKitException e;
        long j;
        Ref.ObjectRef objectRef3;
        T error;
        if (continuation instanceof C09821) {
            c09821 = (C09821) continuation;
            if ((c09821.label & Integer.MIN_VALUE) != 0) {
                c09821.label -= Integer.MIN_VALUE;
            } else {
                c09821 = new C09821(continuation);
            }
        } else {
            c09821 = new C09821(continuation);
        }
        Object obj = c09821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09821.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                c09821.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c09821.L$1 = objectRef4;
                c09821.L$2 = objectRef4;
                c09821.L$3 = objectRef4;
                c09821.I$0 = 0;
                c09821.J$0 = jCurrentTimeMillis;
                c09821.I$1 = 0;
                c09821.label = 1;
                Object objRecognizeText = recognizeText(str, c09821);
                if (objRecognizeText == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef3 = objectRef4;
                objectRef = objectRef3;
                objectRef2 = objectRef;
                obj = objRecognizeText;
                j = jCurrentTimeMillis;
            } catch (MlKitException e2) {
                objectRef = objectRef4;
                objectRef2 = objectRef;
                e = e2;
                j = jCurrentTimeMillis;
                objectRef3 = objectRef;
                error = new Result.Error(e);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c09821.I$1;
            j = c09821.J$0;
            int i3 = c09821.I$0;
            objectRef3 = (Ref.ObjectRef) c09821.L$3;
            objectRef = (Ref.ObjectRef) c09821.L$2;
            objectRef2 = (Ref.ObjectRef) c09821.L$1;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (MlKitException e3) {
                e = e3;
                objectRef3 = objectRef;
                error = new Result.Error(e);
            }
        }
        error = new Result.Success(obj);
        objectRef3.element = error;
        return new PageScanResult((Result) objectRef2.element, System.currentTimeMillis() - j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object recognizeText(String str, Continuation<? super PageLayout> continuation) {
        C09811 c09811;
        Bitmap bitmap;
        if (continuation instanceof C09811) {
            c09811 = (C09811) continuation;
            if ((c09811.label & Integer.MIN_VALUE) != 0) {
                c09811.label -= Integer.MIN_VALUE;
            } else {
                c09811 = new C09811(continuation);
            }
        } else {
            c09811 = new C09811(continuation);
        }
        Object obj = c09811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09811.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
            if (bitmapDecodeFile == null) {
                return null;
            }
            InputImage inputImageFromBitmap = InputImage.fromBitmap(bitmapDecodeFile, 0);
            Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap, "fromBitmap(...)");
            TextRecognizer client = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
            Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
            Task<Text> taskProcess = client.process(inputImageFromBitmap);
            Intrinsics.checkNotNullExpressionValue(taskProcess, "process(...)");
            c09811.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c09811.L$1 = bitmapDecodeFile;
            c09811.L$2 = SpillingKt.nullOutSpilledVariable(inputImageFromBitmap);
            c09811.L$3 = SpillingKt.nullOutSpilledVariable(client);
            c09811.label = 1;
            Object objAwait = TasksKt.await(taskProcess, c09811);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
            bitmap = bitmapDecodeFile;
            obj = objAwait;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bitmap = (Bitmap) c09811.L$1;
            ResultKt.throwOnFailure(obj);
        }
        Text text = (Text) obj;
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        TextRecognitionConverter textRecognitionConverter = TextRecognitionConverter.INSTANCE;
        Intrinsics.checkNotNull(text);
        TextRecognitionConversionResult textRecognitionConversionResultConvertTextToHOcr = textRecognitionConverter.convertTextToHOcr(text, rect);
        return new PageLayout(new TextLayout(textRecognitionConversionResultConvertTextToHOcr.getHOcrString()), textRecognitionConversionResultConvertTextToHOcr.getCharactersByLanguage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File preparePdfFont(Context context) {
        File file = new File(getWorkingDirectory(), FONT_NAME);
        if (file.exists()) {
            return file;
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open(FONT_NAME);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ByteStreamsKt.copyTo$default(inputStreamOpen, fileOutputStream, 0, 2, null);
                return file;
            } finally {
                inputStreamOpen.close();
                fileOutputStream.close();
            }
        } catch (Exception unused) {
            BoxLogUtils.e("Cannot copy font for OCR");
            return null;
        }
    }

    /* JADX INFO: compiled from: DocumentScanPageProcessor.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/DocumentScanPageProcessor$PageLayout;", "", "textLayout", "Lcom/geniusscansdk/core/TextLayout;", "charactersByLanguage", "", "", "", "<init>", "(Lcom/geniusscansdk/core/TextLayout;Ljava/util/Map;)V", "getTextLayout", "()Lcom/geniusscansdk/core/TextLayout;", "getCharactersByLanguage", "()Ljava/util/Map;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class PageLayout {
        private final Map<String, Integer> charactersByLanguage;
        private final TextLayout textLayout;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PageLayout copy$default(PageLayout pageLayout, TextLayout textLayout, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                textLayout = pageLayout.textLayout;
            }
            if ((i & 2) != 0) {
                map = pageLayout.charactersByLanguage;
            }
            return pageLayout.copy(textLayout, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final TextLayout getTextLayout() {
            return this.textLayout;
        }

        public final Map<String, Integer> component2() {
            return this.charactersByLanguage;
        }

        public final PageLayout copy(TextLayout textLayout, Map<String, Integer> charactersByLanguage) {
            Intrinsics.checkNotNullParameter(charactersByLanguage, "charactersByLanguage");
            return new PageLayout(textLayout, charactersByLanguage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageLayout)) {
                return false;
            }
            PageLayout pageLayout = (PageLayout) other;
            return Intrinsics.areEqual(this.textLayout, pageLayout.textLayout) && Intrinsics.areEqual(this.charactersByLanguage, pageLayout.charactersByLanguage);
        }

        public int hashCode() {
            TextLayout textLayout = this.textLayout;
            return ((textLayout == null ? 0 : textLayout.hashCode()) * 31) + this.charactersByLanguage.hashCode();
        }

        public String toString() {
            return "PageLayout(textLayout=" + this.textLayout + ", charactersByLanguage=" + this.charactersByLanguage + ")";
        }

        public PageLayout(TextLayout textLayout, Map<String, Integer> charactersByLanguage) {
            Intrinsics.checkNotNullParameter(charactersByLanguage, "charactersByLanguage");
            this.textLayout = textLayout;
            this.charactersByLanguage = charactersByLanguage;
        }

        public final Map<String, Integer> getCharactersByLanguage() {
            return this.charactersByLanguage;
        }

        public final TextLayout getTextLayout() {
            return this.textLayout;
        }
    }

    /* JADX INFO: compiled from: DocumentScanPageProcessor.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/DocumentScanPageProcessor$PageScanResult;", "", "textRecognition", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/capture/documentscanning/logic/DocumentScanPageProcessor$PageLayout;", "Lcom/google/mlkit/common/MlKitException;", "elapsedTime", "", "<init>", "(Lcom/box/android/domain/utils/result/Result;J)V", "getTextRecognition", "()Lcom/box/android/domain/utils/result/Result;", "getElapsedTime", "()J", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class PageScanResult {
        private final long elapsedTime;
        private final Result<PageLayout, MlKitException> textRecognition;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PageScanResult copy$default(PageScanResult pageScanResult, Result result, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                result = pageScanResult.textRecognition;
            }
            if ((i & 2) != 0) {
                j = pageScanResult.elapsedTime;
            }
            return pageScanResult.copy(result, j);
        }

        public final Result<PageLayout, MlKitException> component1() {
            return this.textRecognition;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getElapsedTime() {
            return this.elapsedTime;
        }

        public final PageScanResult copy(Result<PageLayout, ? extends MlKitException> textRecognition, long elapsedTime) {
            return new PageScanResult(textRecognition, elapsedTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageScanResult)) {
                return false;
            }
            PageScanResult pageScanResult = (PageScanResult) other;
            return Intrinsics.areEqual(this.textRecognition, pageScanResult.textRecognition) && this.elapsedTime == pageScanResult.elapsedTime;
        }

        public int hashCode() {
            Result<PageLayout, MlKitException> result = this.textRecognition;
            return ((result == null ? 0 : result.hashCode()) * 31) + Long.hashCode(this.elapsedTime);
        }

        public String toString() {
            return "PageScanResult(textRecognition=" + this.textRecognition + ", elapsedTime=" + this.elapsedTime + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PageScanResult(Result<PageLayout, ? extends MlKitException> result, long j) {
            this.textRecognition = result;
            this.elapsedTime = j;
        }

        public final long getElapsedTime() {
            return this.elapsedTime;
        }

        public final Result<PageLayout, MlKitException> getTextRecognition() {
            return this.textRecognition;
        }
    }
}
