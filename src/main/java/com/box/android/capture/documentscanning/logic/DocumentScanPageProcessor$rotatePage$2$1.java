package com.box.android.capture.documentscanning.logic;

import com.box.android.domain.models.DocumentPosition;
import com.box.android.domain.models.ScannedDocumentPage;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.ProcessingException;
import com.geniusscansdk.core.Quadrangle;
import com.geniusscansdk.core.RotationAngle;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DocumentScanPageProcessor.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/models/ScannedDocumentPage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor$rotatePage$2$1", f = "DocumentScanPageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DocumentScanPageProcessor$rotatePage$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ScannedDocumentPage>, Object> {
    final /* synthetic */ int $degrees;
    final /* synthetic */ ScannedDocumentPage $page;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentScanPageProcessor$rotatePage$2$1(int i, ScannedDocumentPage scannedDocumentPage, Continuation<? super DocumentScanPageProcessor$rotatePage$2$1> continuation) {
        super(2, continuation);
        this.$degrees = i;
        this.$page = scannedDocumentPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentScanPageProcessor$rotatePage$2$1(this.$degrees, this.$page, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ScannedDocumentPage> continuation) {
        return ((DocumentScanPageProcessor$rotatePage$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws LicenseException, ProcessingException, IOException {
        DocumentPosition documentPosition;
        Quadrangle quadrangle;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        RotationAngle rotationAngleFromDegrees = RotationAngle.fromDegrees(this.$degrees);
        DocumentPosition quadrangle2 = this.$page.getQuadrangle();
        if (quadrangle2 == null || (quadrangle = ScannedDocumentPageToGeniusMapperKt.toQuadrangle(quadrangle2)) == null) {
            documentPosition = null;
        } else {
            Intrinsics.checkNotNull(rotationAngleFromDegrees);
            Quadrangle quadrangleRotate = quadrangle.rotate(rotationAngleFromDegrees);
            if (quadrangleRotate != null) {
                documentPosition = ScannedDocumentPageToGeniusMapperKt.toDocumentPosition(quadrangleRotate);
            } else {
                documentPosition = null;
            }
        }
        DocumentPosition documentPosition2 = documentPosition;
        String originalImagePath = this.$page.getOriginalImagePath();
        String originalImagePath2 = this.$page.getOriginalImagePath();
        Intrinsics.checkNotNull(rotationAngleFromDegrees);
        GeniusScanSDK.rotateImage$default(originalImagePath, originalImagePath2, rotationAngleFromDegrees, false, 8, null);
        return ScannedDocumentPage.copy$default(this.$page, null, null, null, null, documentPosition2, false, 0, 0, null, 495, null);
    }
}
