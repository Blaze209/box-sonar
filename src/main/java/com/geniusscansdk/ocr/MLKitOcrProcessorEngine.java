package com.geniusscansdk.ocr;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.util.Xml;
import com.box.android.capture.documentscanning.logic.TextRecognitionConverter;
import com.geniusscansdk.BitmapLoader;
import com.geniusscansdk.Size;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.ScanProcessor;
import com.geniusscansdk.core.TextLayout;
import com.google.android.gms.common.moduleinstall.ModuleInstall;
import com.google.android.gms.common.moduleinstall.ModuleInstallRequest;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions;
import com.google.mlkit.vision.text.devanagari.DevanagariTextRecognizerOptions;
import com.google.mlkit.vision.text.japanese.JapaneseTextRecognizerOptions;
import com.google.mlkit.vision.text.korean.KoreanTextRecognizerOptions;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.tasks.TasksKt;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: MLKitOcrProcessorEngine.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\f\u0010 \u001a\u00020\u001e*\u00020!H\u0002J\f\u0010\"\u001a\u00020\u001e*\u00020\u001cH\u0002J\f\u0010#\u001a\u00020\u001e*\u00020$H\u0002J\f\u0010#\u001a\u00020\u001e*\u00020%H\u0002J\f\u0010#\u001a\u00020\u001e*\u00020&H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006'"}, d2 = {"Lcom/geniusscansdk/ocr/MLKitOcrProcessorEngine;", "Lcom/geniusscansdk/ocr/OcrProcessorEngine;", "context", "Landroid/content/Context;", "mlKitScript", "Lcom/geniusscansdk/ocr/MLKitScript;", "progressListener", "Lcom/geniusscansdk/ocr/OcrProcessor$ProgressListener;", "<init>", "(Landroid/content/Context;Lcom/geniusscansdk/ocr/MLKitScript;Lcom/geniusscansdk/ocr/OcrProcessor$ProgressListener;)V", "textRecognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "requiredEnhancement", "Lcom/geniusscansdk/core/ScanProcessor$Enhancement;", "getRequiredEnhancement", "()Lcom/geniusscansdk/core/ScanProcessor$Enhancement;", "processImage", "Lcom/geniusscansdk/ocr/OcrResult;", "imageFile", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadModels", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSpatialText", "Lcom/geniusscansdk/ocr/SpatialText;", "Lcom/google/mlkit/vision/text/Text;", "fileSize", "Lcom/geniusscansdk/Size;", "toHocr", "", "imageSize", "bboxAttribute", "Landroid/graphics/Rect;", "toPageProperty", "titleProperty", "Lcom/google/mlkit/vision/text/Text$TextBlock;", "Lcom/google/mlkit/vision/text/Text$Line;", "Lcom/google/mlkit/vision/text/Text$Element;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MLKitOcrProcessorEngine implements OcrProcessorEngine {
    private final Context context;
    private final OcrProcessor.ProgressListener progressListener;
    private final ScanProcessor.Enhancement requiredEnhancement;
    private final TextRecognizer textRecognizer;

    /* JADX INFO: compiled from: MLKitOcrProcessorEngine.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MLKitScript.values().length];
            try {
                iArr[MLKitScript.Latin.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MLKitScript.Chinese.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MLKitScript.Japanese.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MLKitScript.Devanagari.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MLKitScript.Korean.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.ocr.MLKitOcrProcessorEngine$preloadModels$1, reason: invalid class name */
    /* JADX INFO: compiled from: MLKitOcrProcessorEngine.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.ocr.MLKitOcrProcessorEngine", f = "MLKitOcrProcessorEngine.kt", i = {}, l = {75}, m = "preloadModels", n = {}, s = {})
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
            return MLKitOcrProcessorEngine.this.preloadModels(this);
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.ocr.MLKitOcrProcessorEngine$processImage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MLKitOcrProcessorEngine.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.ocr.MLKitOcrProcessorEngine", f = "MLKitOcrProcessorEngine.kt", i = {0, 0, 1, 1}, l = {55, 58}, m = "processImage", n = {"this", "imageFile", "this", "imageSize"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C17721 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C17721(Continuation<? super C17721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MLKitOcrProcessorEngine.this.processImage(null, this);
        }
    }

    public MLKitOcrProcessorEngine(Context context, MLKitScript mlKitScript, OcrProcessor.ProgressListener progressListener) {
        TextRecognizerOptions textRecognizerOptions;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mlKitScript, "mlKitScript");
        this.context = context;
        this.progressListener = progressListener;
        int i = WhenMappings.$EnumSwitchMapping$0[mlKitScript.ordinal()];
        if (i == 1) {
            TextRecognizerOptions textRecognizerOptionsBuild = new TextRecognizerOptions.Builder().build();
            Intrinsics.checkNotNullExpressionValue(textRecognizerOptionsBuild, "build(...)");
            textRecognizerOptions = textRecognizerOptionsBuild;
        } else if (i == 2) {
            ChineseTextRecognizerOptions chineseTextRecognizerOptionsBuild = new ChineseTextRecognizerOptions.Builder().build();
            Intrinsics.checkNotNullExpressionValue(chineseTextRecognizerOptionsBuild, "build(...)");
            textRecognizerOptions = chineseTextRecognizerOptionsBuild;
        } else if (i == 3) {
            JapaneseTextRecognizerOptions japaneseTextRecognizerOptionsBuild = new JapaneseTextRecognizerOptions.Builder().build();
            Intrinsics.checkNotNullExpressionValue(japaneseTextRecognizerOptionsBuild, "build(...)");
            textRecognizerOptions = japaneseTextRecognizerOptionsBuild;
        } else if (i == 4) {
            DevanagariTextRecognizerOptions devanagariTextRecognizerOptionsBuild = new DevanagariTextRecognizerOptions.Builder().build();
            Intrinsics.checkNotNullExpressionValue(devanagariTextRecognizerOptionsBuild, "build(...)");
            textRecognizerOptions = devanagariTextRecognizerOptionsBuild;
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            KoreanTextRecognizerOptions koreanTextRecognizerOptionsBuild = new KoreanTextRecognizerOptions.Builder().build();
            Intrinsics.checkNotNullExpressionValue(koreanTextRecognizerOptionsBuild, "build(...)");
            textRecognizerOptions = koreanTextRecognizerOptionsBuild;
        }
        this.textRecognizer = TextRecognition.getClient(textRecognizerOptions);
        this.requiredEnhancement = ScanProcessor.Enhancement.INSTANCE.none();
    }

    public /* synthetic */ MLKitOcrProcessorEngine(Context context, MLKitScript mLKitScript, OcrProcessor.ProgressListener progressListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, mLKitScript, (i & 4) != 0 ? null : progressListener);
    }

    @Override // com.geniusscansdk.ocr.OcrProcessorEngine
    public ScanProcessor.Enhancement getRequiredEnhancement() {
        return this.requiredEnhancement;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0099  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.geniusscansdk.ocr.OcrProcessorEngine
    public Object processImage(File file, Continuation<? super OcrResult> continuation) throws LicenseException, ModelDownloadingException, OcrProcessingException {
        C17721 c17721;
        MLKitOcrProcessorEngine mLKitOcrProcessorEngine;
        Size size;
        OcrProcessor.ProgressListener progressListener;
        if (continuation instanceof C17721) {
            c17721 = (C17721) continuation;
            if ((c17721.label & Integer.MIN_VALUE) != 0) {
                c17721.label -= Integer.MIN_VALUE;
            } else {
                c17721 = new C17721(continuation);
            }
        } else {
            c17721 = new C17721(continuation);
        }
        Object bitmapSize = c17721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c17721.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(bitmapSize);
                GeniusScanSDK.checkInitialization();
                BitmapLoader bitmapLoader = new BitmapLoader();
                c17721.L$0 = this;
                c17721.L$1 = file;
                c17721.label = 1;
                bitmapSize = bitmapLoader.readBitmapSize(file, c17721);
                if (bitmapSize != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                file = (File) c17721.L$1;
                this = (MLKitOcrProcessorEngine) c17721.L$0;
                ResultKt.throwOnFailure(bitmapSize);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                size = (Size) c17721.L$1;
                mLKitOcrProcessorEngine = (MLKitOcrProcessorEngine) c17721.L$0;
                ResultKt.throwOnFailure(bitmapSize);
            }
            Text text = (Text) bitmapSize;
            progressListener = mLKitOcrProcessorEngine.progressListener;
            if (progressListener != null) {
                progressListener.onProgressUpdate(100);
            }
            String text2 = text.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            Intrinsics.checkNotNull(text);
            return new OcrResult(text2, new TextLayout(mLKitOcrProcessorEngine.toHocr(text, size)), mLKitOcrProcessorEngine.toSpatialText(text, size));
            Size size2 = (Size) bitmapSize;
            OcrProcessor.ProgressListener progressListener2 = this.progressListener;
            if (progressListener2 != null) {
                progressListener2.onProgressUpdate(0);
            }
            Task<Text> taskProcess = this.textRecognizer.process(InputImage.fromFilePath(this.context, Uri.fromFile(file)));
            Intrinsics.checkNotNullExpressionValue(taskProcess, "process(...)");
            c17721.L$0 = this;
            c17721.L$1 = size2;
            c17721.label = 2;
            Object objAwait = TasksKt.await(taskProcess, c17721);
            if (objAwait != coroutine_suspended) {
                mLKitOcrProcessorEngine = this;
                size = size2;
                bitmapSize = objAwait;
                Text text3 = (Text) bitmapSize;
                progressListener = mLKitOcrProcessorEngine.progressListener;
                if (progressListener != null) {
                    progressListener.onProgressUpdate(100);
                }
                String text4 = text3.getText();
                Intrinsics.checkNotNullExpressionValue(text4, "getText(...)");
                Intrinsics.checkNotNull(text3);
                return new OcrResult(text4, new TextLayout(mLKitOcrProcessorEngine.toHocr(text3, size)), mLKitOcrProcessorEngine.toSpatialText(text3, size));
            }
            return coroutine_suspended;
        } catch (Exception e) {
            if ((e instanceof MlKitException) && ((MlKitException) e).getErrorCode() == 14) {
                throw new ModelDownloadingException("Error downloading MLKit models", e);
            }
            throw new OcrProcessingException("OCR failed", e);
        }
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
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            GeniusScanSDK.getLogger().debug("Making install request for OCR MLKit module");
            ModuleInstallRequest moduleInstallRequestBuild = ModuleInstallRequest.newBuilder().addApi(this.textRecognizer).build();
            Intrinsics.checkNotNullExpressionValue(moduleInstallRequestBuild, "build(...)");
            Task<ModuleInstallResponse> taskInstallModules = ModuleInstall.getClient(this.context).installModules(moduleInstallRequestBuild);
            Intrinsics.checkNotNullExpressionValue(taskInstallModules, "installModules(...)");
            anonymousClass1.label = 1;
            objAwait = TasksKt.await(taskInstallModules, anonymousClass1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwait);
        }
        if (((ModuleInstallResponse) objAwait).areModulesAlreadyInstalled()) {
            GeniusScanSDK.getLogger().debug("OCR MLKit module is already installed");
        } else {
            GeniusScanSDK.getLogger().debug("OCR MLKit module install has been requested");
        }
        return Unit.INSTANCE;
    }

    private final SpatialText toSpatialText(Text text, Size size) {
        RectangleF rectangleF;
        List<Text.TextBlock> textBlocks = text.getTextBlocks();
        Intrinsics.checkNotNullExpressionValue(textBlocks, "getTextBlocks(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = textBlocks.iterator();
        while (it.hasNext()) {
            List<Text.Line> lines = ((Text.TextBlock) it.next()).getLines();
            Intrinsics.checkNotNullExpressionValue(lines, "getLines(...)");
            CollectionsKt.addAll(arrayList, lines);
        }
        ArrayList<Text.Line> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Text.Line line : arrayList2) {
            Rect boundingBox = line.getBoundingBox();
            if (boundingBox != null) {
                rectangleF = new RectangleF(boundingBox.left, boundingBox.top, boundingBox.right, boundingBox.bottom);
            } else {
                rectangleF = new RectangleF();
            }
            String text2 = line.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            arrayList3.add(new SpatialString(text2, line.getConfidence(), rectangleF, size));
        }
        return new SpatialText(arrayList3);
    }

    private final String toHocr(final Text text, final Size size) {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        Intrinsics.checkNotNullExpressionValue(xmlSerializerNewSerializer, "newSerializer(...)");
        return XmlSerializerExtKt.document$default(xmlSerializerNewSerializer, null, null, new Function1() { // from class: com.geniusscansdk.ocr.MLKitOcrProcessorEngine$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MLKitOcrProcessorEngine.toHocr$lambda$13(this.f$0, size, text, (XmlSerializer) obj);
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toHocr$lambda$13(final MLKitOcrProcessorEngine mLKitOcrProcessorEngine, final Size size, final Text text, XmlSerializer document) throws IOException {
        Intrinsics.checkNotNullParameter(document, "$this$document");
        XmlSerializerExtKt.element(document, TextRecognitionConverter.Tags.HTML, (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.geniusscansdk.ocr.MLKitOcrProcessorEngine$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MLKitOcrProcessorEngine.toHocr$lambda$13$lambda$12(this.f$0, size, text, (XmlSerializer) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toHocr$lambda$13$lambda$12(final MLKitOcrProcessorEngine mLKitOcrProcessorEngine, final Size size, final Text text, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtKt.element(element, "body", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.geniusscansdk.ocr.MLKitOcrProcessorEngine$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MLKitOcrProcessorEngine.toHocr$lambda$13$lambda$12$lambda$11(this.f$0, size, text, (XmlSerializer) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toHocr$lambda$13$lambda$12$lambda$11(final MLKitOcrProcessorEngine mLKitOcrProcessorEngine, final Size size, final Text text, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtKt.element(element, "div", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.geniusscansdk.ocr.MLKitOcrProcessorEngine$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MLKitOcrProcessorEngine.toHocr$lambda$13$lambda$12$lambda$11$lambda$10(this.f$0, size, text, (XmlSerializer) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toHocr$lambda$13$lambda$12$lambda$11$lambda$10(final MLKitOcrProcessorEngine mLKitOcrProcessorEngine, Size size, final Text text, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtKt.attribute(element, TextRecognitionConverter.Attributes.CLASS, TextRecognitionConverter.Values.OCR_PAGE);
        XmlSerializerExtKt.attribute(element, "title", mLKitOcrProcessorEngine.toPageProperty(size));
        XmlSerializerExtKt.element(element, "div", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.geniusscansdk.ocr.MLKitOcrProcessorEngine$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MLKitOcrProcessorEngine.toHocr$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9(text, mLKitOcrProcessorEngine, (XmlSerializer) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toHocr$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9(Text text, final MLKitOcrProcessorEngine mLKitOcrProcessorEngine, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtKt.attribute(element, TextRecognitionConverter.Attributes.CLASS, TextRecognitionConverter.Values.OCR_AREA);
        List<Text.TextBlock> textBlocks = text.getTextBlocks();
        Intrinsics.checkNotNullExpressionValue(textBlocks, "getTextBlocks(...)");
        for (final Text.TextBlock textBlock : textBlocks) {
            XmlSerializerExtKt.element(element, "p", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.geniusscansdk.ocr.MLKitOcrProcessorEngine$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MLKitOcrProcessorEngine.toHocr$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(this.f$0, textBlock, (XmlSerializer) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toHocr$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(final MLKitOcrProcessorEngine mLKitOcrProcessorEngine, Text.TextBlock textBlock, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtKt.attribute(element, TextRecognitionConverter.Attributes.CLASS, TextRecognitionConverter.Values.OCR_PARAGRAPH);
        Intrinsics.checkNotNull(textBlock);
        XmlSerializerExtKt.attribute(element, "title", mLKitOcrProcessorEngine.titleProperty(textBlock));
        List<Text.Line> lines = textBlock.getLines();
        Intrinsics.checkNotNullExpressionValue(lines, "getLines(...)");
        for (final Text.Line line : lines) {
            XmlSerializerExtKt.element(element, "span", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.geniusscansdk.ocr.MLKitOcrProcessorEngine$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MLKitOcrProcessorEngine.toHocr$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5(this.f$0, line, (XmlSerializer) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toHocr$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5(final MLKitOcrProcessorEngine mLKitOcrProcessorEngine, Text.Line line, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtKt.attribute(element, TextRecognitionConverter.Attributes.CLASS, TextRecognitionConverter.Values.OCR_LINE);
        Intrinsics.checkNotNull(line);
        XmlSerializerExtKt.attribute(element, "title", mLKitOcrProcessorEngine.titleProperty(line));
        List<Text.Element> elements = line.getElements();
        Intrinsics.checkNotNullExpressionValue(elements, "getElements(...)");
        for (final Text.Element element2 : elements) {
            XmlSerializerExtKt.element(element, "span", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.geniusscansdk.ocr.MLKitOcrProcessorEngine$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MLKitOcrProcessorEngine.toHocr$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3(this.f$0, element2, (XmlSerializer) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toHocr$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3(MLKitOcrProcessorEngine mLKitOcrProcessorEngine, Text.Element element, XmlSerializer element2) throws IOException {
        Intrinsics.checkNotNullParameter(element2, "$this$element");
        XmlSerializerExtKt.attribute(element2, TextRecognitionConverter.Attributes.CLASS, TextRecognitionConverter.Values.OCR_WORD);
        Intrinsics.checkNotNull(element);
        XmlSerializerExtKt.attribute(element2, "title", mLKitOcrProcessorEngine.titleProperty(element));
        element2.text(element.getText());
        return Unit.INSTANCE;
    }

    private final String bboxAttribute(Rect rect) {
        return "bbox " + rect.left + " " + rect.top + " " + rect.right + " " + rect.bottom;
    }

    private final String toPageProperty(Size size) {
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{"image \"\"", "bbox 0 0 " + size.getWidth() + " " + size.getHeight(), "ppageno 0"}), "; ", null, null, 0, null, null, 62, null);
    }

    private final String titleProperty(Text.TextBlock textBlock) {
        Rect boundingBox = textBlock.getBoundingBox();
        Intrinsics.checkNotNull(boundingBox);
        return bboxAttribute(boundingBox);
    }

    private final String titleProperty(Text.Line line) {
        Rect boundingBox = line.getBoundingBox();
        Intrinsics.checkNotNull(boundingBox);
        Rect boundingBox2 = line.getBoundingBox();
        Intrinsics.checkNotNull(boundingBox2);
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{bboxAttribute(boundingBox), "baseline 0 0", "x_size " + boundingBox2.height()}), "; ", null, null, 0, null, null, 62, null);
    }

    private final String titleProperty(Text.Element element) {
        Rect boundingBox = element.getBoundingBox();
        Intrinsics.checkNotNull(boundingBox);
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{bboxAttribute(boundingBox), "x_wconf " + ((int) (element.getConfidence() * 100))}), "; ", null, null, 0, null, null, 62, null);
    }
}
