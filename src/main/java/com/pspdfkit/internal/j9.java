package com.pspdfkit.internal;

import androidx.core.graphics.ColorUtils;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class j9 {
    public static ArrayList a(int i) {
        float[] fArr = new float[3];
        ColorUtils.colorToHSL(i, fArr);
        float f = 0.0f;
        if (fArr[1] == 0.0f) {
            ArrayList arrayList = new ArrayList();
            float f2 = 1.0f / 8;
            for (int i2 = 0; i2 < 9; i2++) {
                arrayList.add(Integer.valueOf(ColorUtils.HSLToColor(new float[]{0.0f, 0.0f, f})));
                f += f2;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        float f3 = fArr[2];
        float f4 = 0.1f;
        if (f3 <= 0.1f || f3 >= 0.9f) {
            f3 = 0.5f;
        }
        float f5 = 4;
        float f6 = (f3 - 0.1f) / f5;
        float f7 = (0.9f - f3) / f5;
        int i3 = 0;
        while (i3 < 9) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, 3);
            fArrCopyOf[2] = f4;
            arrayList2.add(Integer.valueOf(ColorUtils.HSLToColor(fArrCopyOf)));
            f4 += i3 < 4 ? f6 : f7;
            i3++;
        }
        float f8 = 160.0f / 9;
        float f9 = fArr[0] - 80.0f;
        for (int i4 = 0; i4 < 9; i4++) {
            float[] fArrCopyOf2 = Arrays.copyOf(fArr, 3);
            float f10 = 360;
            fArrCopyOf2[0] = (f9 + f10) % f10;
            arrayList2.add(Integer.valueOf(ColorUtils.HSLToColor(fArrCopyOf2)));
            f9 += f8;
        }
        return arrayList2;
    }
}
