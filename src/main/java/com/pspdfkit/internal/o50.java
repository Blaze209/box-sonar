package com.pspdfkit.internal;

import android.graphics.Paint;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class o50 {
    public static final float[] a = {1.0f, 2.0f, 3.0f, 4.0f, 6.0f, 8.0f, 9.0f, 10.0f, 12.0f, 14.0f, 16.0f, 18.0f, 20.0f, 25.0f, 30.0f, 35.0f, 40.0f, 45.0f, 50.0f, 55.0f, 60.0f, 70.0f, 80.0f, 90.0f, 100.0f, 110.0f, 120.0f, 130.0f, 144.0f};

    public static float a(String str, Paint paint, float f, float f2, boolean z, boolean z2, int i) {
        float desiredWidth;
        str = str;
        boolean z3 = (i & 64) != 0;
        float[] fArr = a;
        str.getClass();
        paint.getClass();
        if (f <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        int length = (z && z3) ? fArr.length / 4 : fArr.length;
        TextPaint textPaint = new TextPaint(paint);
        int i2 = length / 2;
        int i3 = length - 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 <= i3) {
            textPaint.setTextSize(fArr[i2]);
            int i6 = (int) f;
            StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(str, 0, str.length(), new TextPaint(textPaint), i6).build();
            staticLayoutBuild.getClass();
            if (z) {
                IntRange intRangeUntil = RangesKt.until(0, staticLayoutBuild.getLineCount());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
                Iterator<Integer> it = intRangeUntil.iterator();
                while (it.hasNext()) {
                    arrayList.add(Float.valueOf(staticLayoutBuild.getLineWidth(((IntIterator) it).nextInt())));
                }
                Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) arrayList);
                fMaxOrNull.getClass();
                desiredWidth = Math.min(f, fMaxOrNull.floatValue());
            } else {
                desiredWidth = Layout.getDesiredWidth(str, textPaint);
            }
            float f3 = desiredWidth;
            BoringLayout.Metrics metricsIsBoring = BoringLayout.isBoring(str, textPaint);
            int height = (z || metricsIsBoring == null) ? staticLayoutBuild.getHeight() : new BoringLayout(str, textPaint, i6, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, metricsIsBoring, false).getHeight();
            if (f3 > f || height > f2) {
                i3 = i2 - 1;
                i2 = (i4 + i3) / 2;
            } else {
                i4 = i2 + 1;
                i5 = i2;
                i2 = (i4 + i3) / 2;
            }
        }
        return z2 ? fArr[i5] : fArr[Math.max(i5, 3)];
    }
}
