package com.box.android.capture.imagecapture.logic;

import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ImageCaptureHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/capture/imagecapture/logic/IImageCaptureHelper;", "", "compressImage", "Ljava/io/File;", "file", "compressionRate", "", "(Ljava/io/File;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IImageCaptureHelper {
    Object compressImage(File file, int i, Continuation<? super File> continuation);
}
