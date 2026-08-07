package com.geniusscansdk.ocr;

import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseKeyApi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TesseractLanguageManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.geniusscansdk.ocr.TesseractLanguageManager$downloadLanguage$2", f = "TesseractLanguageManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TesseractLanguageManager$downloadLanguage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ String $language;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TesseractLanguageManager$downloadLanguage$2(String str, File file, Continuation<? super TesseractLanguageManager$downloadLanguage$2> continuation) {
        super(2, continuation);
        this.$language = str;
        this.$file = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TesseractLanguageManager$downloadLanguage$2(this.$language, this.$file, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((TesseractLanguageManager$downloadLanguage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        Object objM14780constructorimpl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        GeniusScanSDK.getLogger().info("Downloading language file for " + this.$language);
        URLConnection uRLConnectionOpenConnection = new URL("https://github.com/thegrizzlylabs/tessdata_fast/raw/ac9220a95b843b62798a5a6bab39be9c087d23f7/" + this.$language + ".traineddata").openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                FileOutputStream fileOutputStream = new FileOutputStream(this.$file);
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                    ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    Result.Companion companion = Result.INSTANCE;
                    objM14780constructorimpl = Result.m14780constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileOutputStream, th);
                        throw th2;
                    }
                }
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(new LicenseKeyApi.HttpException(responseCode)));
            }
            return Result.m14779boximpl(objM14780constructorimpl);
        } catch (IOException e) {
            e = e;
            if (e instanceof UnknownHostException) {
                e = new IOException("No Internet connection");
            }
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m14779boximpl(Result.m14780constructorimpl(ResultKt.createFailure(e)));
        }
    }
}
