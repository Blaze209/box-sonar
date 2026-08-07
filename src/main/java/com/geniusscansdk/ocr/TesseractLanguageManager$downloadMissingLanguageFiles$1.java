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
@DebugMetadata(c = "com.geniusscansdk.ocr.TesseractLanguageManager", f = "TesseractLanguageManager.kt", i = {0, 0, 0, 1}, l = {29, 32}, m = "downloadMissingLanguageFiles-gIAlu-s", n = {"this", "language", "languageFile", "this"}, s = {"L$0", "L$2", "L$3", "L$0"})
final class TesseractLanguageManager$downloadMissingLanguageFiles$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TesseractLanguageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TesseractLanguageManager$downloadMissingLanguageFiles$1(TesseractLanguageManager tesseractLanguageManager, Continuation<? super TesseractLanguageManager$downloadMissingLanguageFiles$1> continuation) {
        super(continuation);
        this.this$0 = tesseractLanguageManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM13570downloadMissingLanguageFilesgIAlus = this.this$0.m13570downloadMissingLanguageFilesgIAlus(null, this);
        return objM13570downloadMissingLanguageFilesgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM13570downloadMissingLanguageFilesgIAlus : Result.m14779boximpl(objM13570downloadMissingLanguageFilesgIAlus);
    }
}
