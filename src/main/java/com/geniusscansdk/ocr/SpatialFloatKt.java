package com.geniusscansdk.ocr;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpatialFloat.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"description", "", "Lcom/geniusscansdk/ocr/SpatialFloat;", "gssdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SpatialFloatKt {
    public static final String description(SpatialFloat spatialFloat) {
        Intrinsics.checkNotNullParameter(spatialFloat, "<this>");
        RectangleF boundingBox = spatialFloat.getBoundingBox();
        if (boundingBox == null) {
            boundingBox = new RectangleF();
        }
        return boundingBox + " / " + spatialFloat.getValue();
    }
}
