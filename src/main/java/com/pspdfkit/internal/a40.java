package com.pspdfkit.internal;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.stamps.PredefinedStampType;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class a40 {
    public static final HashMap a;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put(PredefinedStampType.APPROVED, -13281254);
        map.put(PredefinedStampType.COMPLETED, -13281254);
        map.put(PredefinedStampType.FINAL, -13281254);
        map.put(PredefinedStampType.VOID, -8781810);
        map.put(PredefinedStampType.NOT_APPROVED, -8781810);
        map.put(PredefinedStampType.INITIAL_HERE, -13491091);
        map.put(PredefinedStampType.SIGN_HERE, -11010038);
        map.put(PredefinedStampType.WITNESS, -3563453);
        map.put(PredefinedStampType.ACCEPTED, -13281254);
        map.put(PredefinedStampType.REJECTED, -8781810);
        map.put(PredefinedStampType.CUSTOM, Integer.valueOf(Color.rgb(66, 66, 66)));
    }

    public static Path a(RectF rectF, float f, float f2, float f3) {
        float f4 = rectF.left;
        float f5 = rectF.top;
        float f6 = rectF.right;
        float f7 = rectF.bottom;
        float fMax = Math.max(0.0f, Math.min(f, (f6 - f4) / 2.0f));
        float f8 = (f7 - f5) / 2.0f;
        float fMax2 = Math.max(0.0f, Math.min(f2, f8));
        float fWidth = rectF.width() / 5.0f;
        float f9 = rectF.top + f8;
        Path path = new Path();
        path.setFillType(Path.FillType.WINDING);
        if (f3 == 0.0f) {
            path.moveTo(f4, f9);
            float f10 = fWidth + f4;
            path.lineTo(f10, f5);
            path.lineTo(f6 - fMax, f5);
            path.rQuadTo(fMax, 0.0f, fMax, fMax2);
            path.lineTo(f6, f7 - fMax2);
            path.rQuadTo(0.0f, fMax2, -fMax, fMax2);
            path.lineTo(f10, f7);
            path.lineTo(f4, f9);
            path.close();
            return path;
        }
        Path path2 = new Path();
        float fSqrt = (float) (Math.sqrt(2.0d) * ((double) f3));
        path2.moveTo(f4, f9);
        float f11 = fWidth + f4;
        path2.lineTo(f11, f5);
        float f12 = f11 + fSqrt;
        path2.lineTo(f12, f5);
        path2.lineTo(fSqrt + f4, f9);
        path2.lineTo(f12, f7);
        path2.lineTo(f11, f7);
        path2.lineTo(f4, f9);
        path2.close();
        Path path3 = new Path();
        path3.moveTo(f11, f5);
        path3.lineTo(f6 - fMax, f5);
        path3.rQuadTo(fMax, 0.0f, fMax, fMax2);
        path3.lineTo(f6, f7 - fMax2);
        path3.rQuadTo(0.0f, fMax2, -fMax, fMax2);
        path3.lineTo(f11, f7);
        float f13 = fMax - f3;
        float f14 = fMax2 - f3;
        float f15 = f7 - f3;
        path3.lineTo(f11, f15);
        float f16 = f6 - f3;
        path3.lineTo(f16 - f13, f15);
        float f17 = -f14;
        path3.rQuadTo(f13, 0.0f, f13, f17);
        float f18 = f3 + f5;
        path3.lineTo(f16, f14 + f18);
        path3.rQuadTo(0.0f, f17, -f13, f17);
        path3.lineTo(f11, f18);
        path3.lineTo(f11, f5);
        path3.close();
        path.addPath(path2);
        path.addPath(path3);
        return path;
    }

    public static String b(StampAnnotation stampAnnotation) {
        String name;
        if (stampAnnotation.getTitle() == null || stampAnnotation.getTitle().isEmpty()) {
            name = stampAnnotation.getStampType() != null ? stampAnnotation.getStampType().getName() : "";
        } else {
            name = stampAnnotation.getTitle();
        }
        return name.toUpperCase(Locale.getDefault());
    }

    public static int a(StampAnnotation stampAnnotation) {
        if (stampAnnotation.getColor() != 0) {
            return stampAnnotation.getColor();
        }
        PredefinedStampType predefinedStampTypeFromStampType = PredefinedStampType.fromStampType(stampAnnotation.getStampType());
        HashMap map = a;
        if (map.containsKey(predefinedStampTypeFromStampType)) {
            return ((Integer) map.get(predefinedStampTypeFromStampType)).intValue();
        }
        return -15459505;
    }
}
