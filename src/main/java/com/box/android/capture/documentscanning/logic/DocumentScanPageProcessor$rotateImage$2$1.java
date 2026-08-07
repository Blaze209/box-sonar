package com.box.android.capture.documentscanning.logic;

import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.ProcessingException;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor$rotateImage$2$1", f = "DocumentScanPageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DocumentScanPageProcessor$rotateImage$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $degrees;
    final /* synthetic */ String $imagePath;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentScanPageProcessor$rotateImage$2$1(int i, String str, Continuation<? super DocumentScanPageProcessor$rotateImage$2$1> continuation) {
        super(2, continuation);
        this.$degrees = i;
        this.$imagePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentScanPageProcessor$rotateImage$2$1(this.$degrees, this.$imagePath, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocumentScanPageProcessor$rotateImage$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws LicenseException, ProcessingException, IOException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        RotationAngle rotationAngleFromDegrees = RotationAngle.fromDegrees(this.$degrees);
        String str = this.$imagePath;
        Intrinsics.checkNotNull(rotationAngleFromDegrees);
        GeniusScanSDK.rotateImage$default(str, str, rotationAngleFromDegrees, false, 8, null);
        return Unit.INSTANCE;
    }
}
