package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.pspdfkit.R;
import com.pspdfkit.internal.jni.NativePDFSnapper;
import com.pspdfkit.internal.jni.NativeSnapPoint;
import com.pspdfkit.internal.jni.NativeSnapPointType;
import com.pspdfkit.internal.jni.NativeSnapResult;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.utils.PdfLog;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class aq {
    public Matrix a;
    public final PSPDFKitPreferences b;
    public final NativePDFSnapper c;
    public final int d;
    public float e;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ EnumEntries<NativeSnapPointType> a = EnumEntriesKt.enumEntries(NativeSnapPointType.values());
    }

    public aq(Context context, NativePDFSnapper nativePDFSnapper, Matrix matrix, PSPDFKitPreferences pSPDFKitPreferences) {
        this.a = matrix;
        this.b = pSPDFKitPreferences;
        this.c = nativePDFSnapper;
        this.d = context.getResources().getDimensionPixelSize(R.dimen.pspdf__measurement_snapping_threshold);
    }

    public final PointF a(PointF pointF) {
        PointF point;
        if (this.b.isMeasurementSnappingEnabled().booleanValue() && this.e > 0.0f) {
            NativeSnapResult nativeSnapResultTrySnapNonBlocking = this.c.trySnapNonBlocking(pointF);
            nativeSnapResultTrySnapNonBlocking.getClass();
            if (nativeSnapResultTrySnapNonBlocking.getHasError()) {
                PdfLog.w("Nutri.MeasureSnapHand", "Measurement tools: Couldn't snap point " + pointF + ": " + nativeSnapResultTrySnapNonBlocking.getError(), new Object[0]);
                return pointF;
            }
            NativeSnapPoint snapPoint = nativeSnapResultTrySnapNonBlocking.getSnapPoint();
            if (snapPoint != null && (point = snapPoint.getPoint()) != null) {
                return point;
            }
        }
        return pointF;
    }
}
