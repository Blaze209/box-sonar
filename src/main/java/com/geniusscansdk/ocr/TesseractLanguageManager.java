package com.geniusscansdk.ocr;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: TesseractLanguageManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086@¢\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000eH\u0002J&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/geniusscansdk/ocr/TesseractLanguageManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "md5Hasher", "Lcom/geniusscansdk/ocr/MD5Hasher;", "languageDirectory", "Ljava/io/File;", "getLanguageDirectory", "()Ljava/io/File;", "downloadMissingLanguageFiles", "Lkotlin/Result;", "", "languages", "", "Lcom/geniusscansdk/ocr/OcrLanguage;", "downloadMissingLanguageFiles-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadLanguage", "language", "", "file", "downloadLanguage-0E7RQCE", "(Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLanguageDirectoryIfNeeded", "checkIntegrity", "languageFile", "checkIntegrity-0E7RQCE", "(Lcom/geniusscansdk/ocr/OcrLanguage;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TesseractLanguageManager {
    private final Context context;
    private final MD5Hasher md5Hasher;

    public TesseractLanguageManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.md5Hasher = new MD5Hasher();
    }

    public final File getLanguageDirectory() {
        return new File(this.context.getExternalCacheDir(), "tessdata");
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0073  */
    /* JADX WARN: Code duplicated, block: B:21:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:24:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:27:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:29:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ca A[PHI: r2 r5 r10 r11
      0x00ca: PHI (r2v2 java.util.Iterator) = (r2v3 java.util.Iterator), (r2v4 java.util.Iterator) binds: [B:29:0x00c7, B:20:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x00ca: PHI (r5v0 java.io.File) = (r5v2 java.io.File), (r5v3 java.io.File) binds: [B:29:0x00c7, B:20:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x00ca: PHI (r10v1 'this' com.geniusscansdk.ocr.TesseractLanguageManager) = 
      (r10v3 'this' com.geniusscansdk.ocr.TesseractLanguageManager)
      (r10v7 'this' com.geniusscansdk.ocr.TesseractLanguageManager)
     binds: [B:29:0x00c7, B:20:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x00ca: PHI (r11v3 com.geniusscansdk.ocr.OcrLanguage) = (r11v4 com.geniusscansdk.ocr.OcrLanguage), (r11v7 com.geniusscansdk.ocr.OcrLanguage) binds: [B:29:0x00c7, B:20:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d9, code lost:
    
        if (r12 == r1) goto L32;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00d9 -> B:33:0x00dc). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: downloadMissingLanguageFiles-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m13570downloadMissingLanguageFilesgIAlus(java.util.List<com.geniusscansdk.ocr.OcrLanguage> r11, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r12) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.ocr.TesseractLanguageManager.m13570downloadMissingLanguageFilesgIAlus(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: downloadLanguage-0E7RQCE, reason: not valid java name */
    public final Object m13569downloadLanguage0E7RQCE(String str, File file, Continuation<? super Result<Unit>> continuation) {
        TesseractLanguageManager$downloadLanguage$1 tesseractLanguageManager$downloadLanguage$1;
        if (continuation instanceof TesseractLanguageManager$downloadLanguage$1) {
            tesseractLanguageManager$downloadLanguage$1 = (TesseractLanguageManager$downloadLanguage$1) continuation;
            if ((tesseractLanguageManager$downloadLanguage$1.label & Integer.MIN_VALUE) != 0) {
                tesseractLanguageManager$downloadLanguage$1.label -= Integer.MIN_VALUE;
            } else {
                tesseractLanguageManager$downloadLanguage$1 = new TesseractLanguageManager$downloadLanguage$1(this, continuation);
            }
        } else {
            tesseractLanguageManager$downloadLanguage$1 = new TesseractLanguageManager$downloadLanguage$1(this, continuation);
        }
        Object objWithContext = tesseractLanguageManager$downloadLanguage$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = tesseractLanguageManager$downloadLanguage$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            TesseractLanguageManager$downloadLanguage$2 tesseractLanguageManager$downloadLanguage$2 = new TesseractLanguageManager$downloadLanguage$2(str, file, null);
            tesseractLanguageManager$downloadLanguage$1.label = 1;
            objWithContext = BuildersKt.withContext(io2, tesseractLanguageManager$downloadLanguage$2, tesseractLanguageManager$downloadLanguage$1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).getValue();
    }

    private final void createLanguageDirectoryIfNeeded() {
        if (getLanguageDirectory().exists()) {
            return;
        }
        getLanguageDirectory().mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: checkIntegrity-0E7RQCE, reason: not valid java name */
    public final Object m13568checkIntegrity0E7RQCE(OcrLanguage ocrLanguage, File file, Continuation<? super Result<Unit>> continuation) {
        TesseractLanguageManager$checkIntegrity$1 tesseractLanguageManager$checkIntegrity$1;
        if (continuation instanceof TesseractLanguageManager$checkIntegrity$1) {
            tesseractLanguageManager$checkIntegrity$1 = (TesseractLanguageManager$checkIntegrity$1) continuation;
            if ((tesseractLanguageManager$checkIntegrity$1.label & Integer.MIN_VALUE) != 0) {
                tesseractLanguageManager$checkIntegrity$1.label -= Integer.MIN_VALUE;
            } else {
                tesseractLanguageManager$checkIntegrity$1 = new TesseractLanguageManager$checkIntegrity$1(this, continuation);
            }
        } else {
            tesseractLanguageManager$checkIntegrity$1 = new TesseractLanguageManager$checkIntegrity$1(this, continuation);
        }
        Object objWithContext = tesseractLanguageManager$checkIntegrity$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = tesseractLanguageManager$checkIntegrity$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            TesseractLanguageManager$checkIntegrity$2 tesseractLanguageManager$checkIntegrity$2 = new TesseractLanguageManager$checkIntegrity$2(this, file, ocrLanguage, null);
            tesseractLanguageManager$checkIntegrity$1.label = 1;
            objWithContext = BuildersKt.withContext(io2, tesseractLanguageManager$checkIntegrity$2, tesseractLanguageManager$checkIntegrity$1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).getValue();
    }
}
