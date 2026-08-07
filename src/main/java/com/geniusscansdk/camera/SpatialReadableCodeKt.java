package com.geniusscansdk.camera;

import com.geniusscansdk.structureddata.ReadableCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpatialReadableCode.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toReadableCode", "Lcom/geniusscansdk/structureddata/ReadableCode;", "Lcom/geniusscansdk/camera/SpatialReadableCode;", "gssdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SpatialReadableCodeKt {
    public static final ReadableCode toReadableCode(SpatialReadableCode spatialReadableCode) {
        Intrinsics.checkNotNullParameter(spatialReadableCode, "<this>");
        return new ReadableCode(spatialReadableCode.getValue(), spatialReadableCode.getType());
    }
}
