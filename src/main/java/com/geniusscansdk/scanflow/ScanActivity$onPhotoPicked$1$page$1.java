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
@DebugMetadata(c = "com.geniusscansdk.scanflow.ScanActivity$onPhotoPicked$1$page$1", f = "ScanActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ScanActivity$onPhotoPicked$1$page$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Page>, Object> {
    final /* synthetic */ File $destinationFile;
    int label;
    final /* synthetic */ ScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScanActivity$onPhotoPicked$1$page$1(File file, ScanActivity scanActivity, Continuation<? super ScanActivity$onPhotoPicked$1$page$1> continuation) {
        super(2, continuation);
        this.$destinationFile = file;
        this.this$0 = scanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScanActivity$onPhotoPicked$1$page$1(this.$destinationFile, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Page> continuation) {
        return ((ScanActivity$onPhotoPicked$1$page$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws LicenseException, ProcessingException, IOException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String absolutePath = this.$destinationFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        String absolutePath2 = this.$destinationFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
        GeniusScanSDK.rotateImage$default(absolutePath, absolutePath2, RotationAngle.ROTATION_0, false, 8, null);
        return new Page(this.$destinationFile, this.this$0.getScanConfiguration());
    }
}
