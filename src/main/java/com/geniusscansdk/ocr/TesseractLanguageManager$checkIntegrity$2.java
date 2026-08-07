package com.geniusscansdk.ocr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TesseractLanguageManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.geniusscansdk.ocr.TesseractLanguageManager$checkIntegrity$2", f = "TesseractLanguageManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TesseractLanguageManager$checkIntegrity$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ OcrLanguage $language;
    final /* synthetic */ File $languageFile;
    int label;
    final /* synthetic */ TesseractLanguageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TesseractLanguageManager$checkIntegrity$2(TesseractLanguageManager tesseractLanguageManager, File file, OcrLanguage ocrLanguage, Continuation<? super TesseractLanguageManager$checkIntegrity$2> continuation) {
        super(2, continuation);
        this.this$0 = tesseractLanguageManager;
        this.$languageFile = file;
        this.$language = ocrLanguage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TesseractLanguageManager$checkIntegrity$2(this.this$0, this.$languageFile, this.$language, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((TesseractLanguageManager$checkIntegrity$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM14780constructorimpl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!Intrinsics.areEqual(this.this$0.md5Hasher.md5(new FileInputStream(this.$languageFile)), this.$language.getTesseractMD5$gssdk_release())) {
            this.$languageFile.delete();
            Result.Companion companion = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(new IOException("Language file is not valid")));
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(Unit.INSTANCE);
        }
        return Result.m14779boximpl(objM14780constructorimpl);
    }
}
