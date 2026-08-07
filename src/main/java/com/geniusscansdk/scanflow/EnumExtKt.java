package com.geniusscansdk.scanflow;

import androidx.exifinterface.media.ExifInterface;
import com.geniusscansdk.camera.FlashMode;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnumExt.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a$\u0010\u0003\u001a\u0002H\u0004\"\u0010\b\u0000\u0010\u0004\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00040\u0005*\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"toScanFlowFlashMode", "Lcom/geniusscansdk/scanflow/ScanConfiguration$FlashMode;", "Lcom/geniusscansdk/camera/FlashMode;", ES6Iterator.NEXT_METHOD, ExifInterface.GPS_DIRECTION_TRUE, "", "(Ljava/lang/Enum;)Ljava/lang/Enum;", "gssdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EnumExtKt {
    /* JADX WARN: Code duplicated, block: B:10:0x001c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    public static final ScanConfiguration.FlashMode toScanFlowFlashMode(FlashMode flashMode) {
        Intrinsics.checkNotNullParameter(flashMode, "<this>");
        for (ScanConfiguration.FlashMode flashMode2 : ScanConfiguration.FlashMode.values()) {
            if (flashMode2.getInternalMode() == flashMode) {
                if (flashMode2 != null) {
                    return flashMode2;
                }
                throw new IllegalArgumentException("Invalid mode: " + flashMode);
            }
        }
        flashMode2 = null;
        if (flashMode2 != null) {
            return flashMode2;
        }
        throw new IllegalArgumentException("Invalid mode: " + flashMode);
    }

    public static final /* synthetic */ <T extends Enum<T>> T next(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) new Enum[0][(t.ordinal() + 1) % 0];
    }
}
