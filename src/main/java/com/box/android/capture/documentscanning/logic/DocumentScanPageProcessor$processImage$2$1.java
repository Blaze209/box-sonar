package com.box.android.capture.documentscanning.logic;

import android.content.Context;
import com.box.android.domain.models.DocumentPageFilterType;
import com.box.android.domain.models.DocumentPosition;
import com.geniusscansdk.core.FilterConfiguration;
import com.geniusscansdk.core.ScanProcessor;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DocumentScanPageProcessor.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/geniusscansdk/core/ScanProcessor$Result;", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor$processImage$2$1", f = "DocumentScanPageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DocumentScanPageProcessor$processImage$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ScanProcessor.Result<File>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $distortionCorrection;
    final /* synthetic */ DocumentPosition $documentPosition;
    final /* synthetic */ DocumentPageFilterType $filterType;
    final /* synthetic */ File $originalImageFile;
    int label;
    final /* synthetic */ DocumentScanPageProcessor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentScanPageProcessor$processImage$2$1(DocumentScanPageProcessor documentScanPageProcessor, DocumentPosition documentPosition, DocumentPageFilterType documentPageFilterType, boolean z, Context context, File file, Continuation<? super DocumentScanPageProcessor$processImage$2$1> continuation) {
        super(2, continuation);
        this.this$0 = documentScanPageProcessor;
        this.$documentPosition = documentPosition;
        this.$filterType = documentPageFilterType;
        this.$distortionCorrection = z;
        this.$context = context;
        this.$originalImageFile = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentScanPageProcessor$processImage$2$1(this.this$0, this.$documentPosition, this.$filterType, this.$distortionCorrection, this.$context, this.$originalImageFile, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ScanProcessor.Result<File>> continuation) {
        return ((DocumentScanPageProcessor$processImage$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ScanProcessor.PerspectiveCorrection perspectiveCorrectionAutomatic;
        ScanProcessor.Enhancement enhancementAutomatic$default;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            File enhancedImageDirectory = this.this$0.getEnhancedImageDirectory();
            if (this.$documentPosition != null) {
                perspectiveCorrectionAutomatic = ScanProcessor.PerspectiveCorrection.INSTANCE.withQuadrangle(ScannedDocumentPageToGeniusMapperKt.toQuadrangle(this.$documentPosition));
            } else {
                perspectiveCorrectionAutomatic = ScanProcessor.PerspectiveCorrection.INSTANCE.automatic();
            }
            ScanProcessor.PerspectiveCorrection perspectiveCorrection = perspectiveCorrectionAutomatic;
            FilterConfiguration filterConfiguration = ScannedDocumentPageToGeniusMapperKt.toFilterConfiguration(this.$filterType);
            if (filterConfiguration == null || (enhancementAutomatic$default = ScanProcessor.Enhancement.INSTANCE.withFilterConfiguration(filterConfiguration)) == null) {
                enhancementAutomatic$default = ScanProcessor.Enhancement.Companion.automatic$default(ScanProcessor.Enhancement.INSTANCE, null, 1, null);
            }
            return new ScanProcessor(this.$context).process(this.$originalImageFile, new ScanProcessor.Configuration<>(perspectiveCorrection, ScanProcessor.CurvatureCorrection.INSTANCE.create(this.$distortionCorrection), enhancementAutomatic$default, ScanProcessor.Rotation.INSTANCE.automatic(), ScanProcessor.Readability.INSTANCE.disabled(), ScanProcessor.OutputConfiguration.INSTANCE.file(ScanProcessor.OutputFileFormat.JPEG, enhancedImageDirectory)));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
