package com.geniusscansdk.scanflow;

import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.ProcessingException;
import com.geniusscansdk.core.RotationAngle;
import java.io.File;
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

/* JADX INFO: compiled from: ScanActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/geniusscansdk/scanflow/Page;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.geniusscansdk.scanflow.ScanActivity$scanFromImageUrl$1$page$1", f = "ScanActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ScanActivity$scanFromImageUrl$1$page$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Page>, Object> {
    final /* synthetic */ File $sourceImage;
    int label;
    final /* synthetic */ ScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScanActivity$scanFromImageUrl$1$page$1(ScanActivity scanActivity, File file, Continuation<? super ScanActivity$scanFromImageUrl$1$page$1> continuation) {
        super(2, continuation);
        this.this$0 = scanActivity;
        this.$sourceImage = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScanActivity$scanFromImageUrl$1$page$1(this.this$0, this.$sourceImage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Page> continuation) {
        return ((ScanActivity$scanFromImageUrl$1$page$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws LicenseException, ProcessingException, IOException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ImageStore imageStore = this.this$0.imageStore;
            if (imageStore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageStore");
                imageStore = null;
            }
            File fileGenerateImageFile = imageStore.generateImageFile("jpeg");
            String absolutePath = this.$sourceImage.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            String absolutePath2 = fileGenerateImageFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
            GeniusScanSDK.rotateImage$default(absolutePath, absolutePath2, RotationAngle.ROTATION_0, false, 8, null);
            return new Page(fileGenerateImageFile, this.this$0.getScanConfiguration());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
