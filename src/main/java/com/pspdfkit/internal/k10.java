package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.internal.jni.NativeNativeShapeDetector;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class k10 {
    public static Boolean b;
    public final NativeNativeShapeDetector a;

    public k10(Context context) {
        try {
            NativeNativeShapeDetector nativeNativeShapeDetectorCreateFromTemplatesData = NativeNativeShapeDetector.createFromTemplatesData(wg.a(context.getAssets().open(wg.b("PSPDFShapeTemplates.data"), 2)));
            if (nativeNativeShapeDetectorCreateFromTemplatesData == null) {
                throw new IllegalStateException("Could not parse magic ink shape templates data");
            }
            this.a = nativeNativeShapeDetectorCreateFromTemplatesData;
        } catch (IOException unused) {
            throw new IllegalStateException("Could not read shape templates data (PSPDFShapeTemplates.data) from assets.");
        }
    }
}
