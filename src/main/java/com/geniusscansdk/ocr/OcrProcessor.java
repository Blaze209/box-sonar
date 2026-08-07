package com.geniusscansdk.ocr;

import android.content.Context;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.ProcessingException;
import com.geniusscansdk.core.Quadrangle;
import com.geniusscansdk.core.RotationAngle;
import com.geniusscansdk.core.ScanProcessor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OcrProcessor.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/geniusscansdk/ocr/OcrProcessor;", "", "context", "Landroid/content/Context;", "configuration", "Lcom/geniusscansdk/ocr/OcrConfiguration;", "progressListener", "Lcom/geniusscansdk/ocr/OcrProcessor$ProgressListener;", "<init>", "(Landroid/content/Context;Lcom/geniusscansdk/ocr/OcrConfiguration;Lcom/geniusscansdk/ocr/OcrProcessor$ProgressListener;)V", "engine", "Lcom/geniusscansdk/ocr/OcrProcessorEngine;", "getEngine", "()Lcom/geniusscansdk/ocr/OcrProcessorEngine;", "engine$delegate", "Lkotlin/Lazy;", "scanProcessor", "Lcom/geniusscansdk/core/ScanProcessor;", "temporaryFolder", "Ljava/io/File;", "processImage", "Lcom/geniusscansdk/ocr/OcrResult;", "imageFile", "input", "Lcom/geniusscansdk/ocr/OcrProcessor$Input;", "preloadModels", "", "createEngine", "ProgressListener", "Input", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OcrProcessor {
    private final OcrConfiguration configuration;
    private final Context context;

    /* JADX INFO: renamed from: engine$delegate, reason: from kotlin metadata */
    private final Lazy engine;
    private final ProgressListener progressListener;
    private final ScanProcessor scanProcessor;
    private final File temporaryFolder;

    /* JADX INFO: compiled from: OcrProcessor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/geniusscansdk/ocr/OcrProcessor$ProgressListener;", "", "onProgressUpdate", "", "progress", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ProgressListener {
        void onProgressUpdate(int progress);
    }

    public OcrProcessor(Context context, OcrConfiguration configuration, ProgressListener progressListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.context = context;
        this.configuration = configuration;
        this.progressListener = progressListener;
        this.engine = LazyKt.lazy(new Function0() { // from class: com.geniusscansdk.ocr.OcrProcessor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.createEngine();
            }
        });
        this.scanProcessor = new ScanProcessor(context);
        File externalFilesDir = context.getExternalFilesDir(null);
        Intrinsics.checkNotNull(externalFilesDir);
        this.temporaryFolder = externalFilesDir;
    }

    public /* synthetic */ OcrProcessor(Context context, OcrConfiguration ocrConfiguration, ProgressListener progressListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, ocrConfiguration, (i & 4) != 0 ? null : progressListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OcrProcessorEngine getEngine() {
        return (OcrProcessorEngine) this.engine.getValue();
    }

    /* JADX INFO: compiled from: OcrProcessor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/geniusscansdk/ocr/OcrProcessor$Input;", "", "image", "Ljava/io/File;", "quadrangle", "Lcom/geniusscansdk/core/Quadrangle;", "rotationAngle", "Lcom/geniusscansdk/core/RotationAngle;", "<init>", "(Ljava/io/File;Lcom/geniusscansdk/core/Quadrangle;Lcom/geniusscansdk/core/RotationAngle;)V", "getImage", "()Ljava/io/File;", "getQuadrangle", "()Lcom/geniusscansdk/core/Quadrangle;", "getRotationAngle", "()Lcom/geniusscansdk/core/RotationAngle;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Input {
        private final File image;
        private final Quadrangle quadrangle;
        private final RotationAngle rotationAngle;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Input(File image) {
            this(image, null, null, 6, null);
            Intrinsics.checkNotNullParameter(image, "image");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Input(File image, Quadrangle quadrangle) {
            this(image, quadrangle, null, 4, null);
            Intrinsics.checkNotNullParameter(image, "image");
        }

        public static /* synthetic */ Input copy$default(Input input, File file, Quadrangle quadrangle, RotationAngle rotationAngle, int i, Object obj) {
            if ((i & 1) != 0) {
                file = input.image;
            }
            if ((i & 2) != 0) {
                quadrangle = input.quadrangle;
            }
            if ((i & 4) != 0) {
                rotationAngle = input.rotationAngle;
            }
            return input.copy(file, quadrangle, rotationAngle);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getImage() {
            return this.image;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Quadrangle getQuadrangle() {
            return this.quadrangle;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final RotationAngle getRotationAngle() {
            return this.rotationAngle;
        }

        public final Input copy(File image, Quadrangle quadrangle, RotationAngle rotationAngle) {
            Intrinsics.checkNotNullParameter(image, "image");
            return new Input(image, quadrangle, rotationAngle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Input)) {
                return false;
            }
            Input input = (Input) other;
            return Intrinsics.areEqual(this.image, input.image) && Intrinsics.areEqual(this.quadrangle, input.quadrangle) && this.rotationAngle == input.rotationAngle;
        }

        public int hashCode() {
            int iHashCode = this.image.hashCode() * 31;
            Quadrangle quadrangle = this.quadrangle;
            int iHashCode2 = (iHashCode + (quadrangle == null ? 0 : quadrangle.hashCode())) * 31;
            RotationAngle rotationAngle = this.rotationAngle;
            return iHashCode2 + (rotationAngle != null ? rotationAngle.hashCode() : 0);
        }

        public String toString() {
            return "Input(image=" + this.image + ", quadrangle=" + this.quadrangle + ", rotationAngle=" + this.rotationAngle + ")";
        }

        public Input(File image, Quadrangle quadrangle, RotationAngle rotationAngle) {
            Intrinsics.checkNotNullParameter(image, "image");
            this.image = image;
            this.quadrangle = quadrangle;
            this.rotationAngle = rotationAngle;
        }

        public /* synthetic */ Input(File file, Quadrangle quadrangle, RotationAngle rotationAngle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(file, (i & 2) != 0 ? null : quadrangle, (i & 4) != 0 ? null : rotationAngle);
        }

        public final File getImage() {
            return this.image;
        }

        public final Quadrangle getQuadrangle() {
            return this.quadrangle;
        }

        public final RotationAngle getRotationAngle() {
            return this.rotationAngle;
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.ocr.OcrProcessor$processImage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OcrProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/geniusscansdk/ocr/OcrResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.ocr.OcrProcessor$processImage$1", f = "OcrProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C17731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OcrResult>, Object> {
        final /* synthetic */ File $imageFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17731(File file, Continuation<? super C17731> continuation) {
            super(2, continuation);
            this.$imageFile = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OcrProcessor.this.new C17731(this.$imageFile, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OcrResult> continuation) {
            return ((C17731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws LicenseException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            GeniusScanSDK.checkInitialization();
            return OcrProcessor.this.processImage(new Input(this.$imageFile, null, null, 6, null));
        }
    }

    public final OcrResult processImage(File imageFile) throws LicenseException, OcrException {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        return (OcrResult) BuildersKt__BuildersKt.runBlocking$default(null, new C17731(imageFile, null), 1, null);
    }

    /* JADX INFO: renamed from: com.geniusscansdk.ocr.OcrProcessor$processImage$2, reason: invalid class name */
    /* JADX INFO: compiled from: OcrProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/geniusscansdk/ocr/OcrResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.ocr.OcrProcessor$processImage$2", f = "OcrProcessor.kt", i = {0}, l = {92}, m = "invokeSuspend", n = {"preProcessingResult"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OcrResult>, Object> {
        final /* synthetic */ Input $input;
        Object L$0;
        int label;
        final /* synthetic */ OcrProcessor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Input input, OcrProcessor ocrProcessor, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$input = input;
            this.this$0 = ocrProcessor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$input, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OcrResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ScanProcessor.PerspectiveCorrection perspectiveCorrectionNone;
            ScanProcessor.Rotation rotationNone;
            Throwable th;
            ScanProcessor.Result<File> result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                GeniusScanSDK.checkInitialization();
                Quadrangle quadrangle = this.$input.getQuadrangle();
                if (quadrangle == null || (perspectiveCorrectionNone = ScanProcessor.PerspectiveCorrection.INSTANCE.withQuadrangle(quadrangle)) == null) {
                    perspectiveCorrectionNone = ScanProcessor.PerspectiveCorrection.INSTANCE.none();
                }
                ScanProcessor.PerspectiveCorrection perspectiveCorrection = perspectiveCorrectionNone;
                ScanProcessor.CurvatureCorrection curvatureCorrectionNone = ScanProcessor.CurvatureCorrection.INSTANCE.none();
                ScanProcessor.Enhancement requiredEnhancement = this.this$0.getEngine().getRequiredEnhancement();
                RotationAngle rotationAngle = this.$input.getRotationAngle();
                if (rotationAngle == null || (rotationNone = ScanProcessor.Rotation.INSTANCE.withAngle(rotationAngle)) == null) {
                    rotationNone = ScanProcessor.Rotation.INSTANCE.none();
                }
                try {
                    ScanProcessor.Result<File> resultProcess = this.this$0.scanProcessor.process(this.$input.getImage(), new ScanProcessor.Configuration<>(perspectiveCorrection, curvatureCorrectionNone, requiredEnhancement, rotationNone, null, ScanProcessor.OutputConfiguration.INSTANCE.file(this.this$0.temporaryFolder), 16, null));
                    try {
                        this.L$0 = resultProcess;
                        this.label = 1;
                        Object objProcessImage = this.this$0.getEngine().processImage(resultProcess.output, this);
                        if (objProcessImage == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objProcessImage;
                        result = resultProcess;
                    } catch (Throwable th2) {
                        th = th2;
                        result = resultProcess;
                        result.output.delete();
                        throw th;
                    }
                } catch (ProcessingException e) {
                    throw new OcrProcessingException("Error preprocessing image", e);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                result = (ScanProcessor.Result) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th3) {
                    th = th3;
                    result.output.delete();
                    throw th;
                }
            }
            OcrResult ocrResult = (OcrResult) obj;
            result.output.delete();
            return ocrResult;
        }
    }

    public final OcrResult processImage(Input input) throws LicenseException, OcrException {
        Intrinsics.checkNotNullParameter(input, "input");
        return (OcrResult) BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass2(input, this, null), 1, null);
    }

    /* JADX INFO: renamed from: com.geniusscansdk.ocr.OcrProcessor$preloadModels$1, reason: invalid class name */
    /* JADX INFO: compiled from: OcrProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.ocr.OcrProcessor$preloadModels$1", f = "OcrProcessor.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OcrProcessor.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (OcrProcessor.this.getEngine().preloadModels(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void preloadModels() throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OcrProcessorEngine createEngine() {
        Object next;
        List<OcrLanguage> allLanguages = OcrLanguage.INSTANCE.getAllLanguages(this.context);
        List<String> languageTags = this.configuration.getLanguageTags();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(languageTags, 10));
        for (String str : languageTags) {
            Iterator<T> it = allLanguages.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((OcrLanguage) next).getTag(), str));
            OcrLanguage ocrLanguage = (OcrLanguage) next;
            if (ocrLanguage == null) {
                throw new IllegalArgumentException("\"Language with tag " + str + " is not supported. Please refer to the documentation for the supported languages.\"");
            }
            arrayList.add(ocrLanguage);
        }
        ArrayList arrayList2 = arrayList;
        OcrEngineSelector.EngineSelection engineSelectionSelectEngine = new OcrEngineSelector().selectEngine(arrayList2);
        if (engineSelectionSelectEngine instanceof OcrEngineSelector.EngineSelection.MLKit) {
            GeniusScanSDK.getLogger().debug("Choosing MLKit for OCR processing");
            return new MLKitOcrProcessorEngine(this.context, ((OcrEngineSelector.EngineSelection.MLKit) engineSelectionSelectEngine).getScript(), this.progressListener);
        }
        if (!(engineSelectionSelectEngine instanceof OcrEngineSelector.EngineSelection.Tesseract)) {
            throw new NoWhenBranchMatchedException();
        }
        GeniusScanSDK.getLogger().debug("Choosing Tesseract for OCR processing");
        return new TesseractOcrProcessorEngine(this.context, arrayList2, this.progressListener);
    }
}
