package com.geniusscansdk.camera;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ReadableCodeDetectionCallback.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0014\u0010\u0007\u001a\u00020\u00032\n\u0010\b\u001a\u00060\tj\u0002`\nH&¨\u0006\u000b"}, d2 = {"Lcom/geniusscansdk/camera/ReadableCodeDetectionCallback;", "", "onReadableCodesDetected", "", "codes", "", "Lcom/geniusscansdk/camera/SpatialReadableCode;", "onDetectorInitializationFailed", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ReadableCodeDetectionCallback {
    void onDetectorInitializationFailed(Exception error);

    void onReadableCodesDetected(List<SpatialReadableCode> codes);
}
