package com.geniusscansdk.ocr;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: TesseractLanguageManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.geniusscansdk.ocr.TesseractLanguageManager", f = "TesseractLanguageManager.kt", i = {}, l = {64}, m = "checkIntegrity-0E7RQCE", n = {}, s = {})
final class TesseractLanguageManager$checkIntegrity$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TesseractLanguageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TesseractLanguageManager$checkIntegrity$1(TesseractLanguageManager tesseractLanguageManager, Continuation<? super TesseractLanguageManager$checkIntegrity$1> continuation) {
        super(continuation);
        this.this$0 = tesseractLanguageManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM13568checkIntegrity0E7RQCE = this.this$0.m13568checkIntegrity0E7RQCE(null, null, this);
        return objM13568checkIntegrity0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM13568checkIntegrity0E7RQCE : Result.m14779boximpl(objM13568checkIntegrity0E7RQCE);
    }
}
