package com.geniusscansdk.ocr;

import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.ScanProcessor;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: OcrProcessorEngine.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/geniusscansdk/ocr/OcrProcessorEngine;", "", "processImage", "Lcom/geniusscansdk/ocr/OcrResult;", "imageFile", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadModels", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requiredEnhancement", "Lcom/geniusscansdk/core/ScanProcessor$Enhancement;", "getRequiredEnhancement", "()Lcom/geniusscansdk/core/ScanProcessor$Enhancement;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OcrProcessorEngine {
    ScanProcessor.Enhancement getRequiredEnhancement();

    Object preloadModels(Continuation<? super Unit> continuation);

    Object processImage(File file, Continuation<? super OcrResult> continuation) throws LicenseException, OcrException;
}
