package com.pspdfkit.internal;

import android.util.Log;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.IntSize;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
public final class zz extends Painter {
    public final ImageBitmap a;

    public zz(ImageBitmap imageBitmap) {
        imageBitmap.getClass();
        this.a = imageBitmap;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long getIntrinsicSize() {
        return Size.m6629constructorimpl((((long) Float.floatToRawIntBits(this.a.getWidth())) << 32) | (((long) Float.floatToRawIntBits(this.a.getHeight())) & 4294967295L));
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(DrawScope drawScope) {
        drawScope.getClass();
        try {
            DrawScope.m7378drawImageAZ2fEMs$default(drawScope, this.a, 0L, 0L, 0L, IntSize.m9853constructorimpl((((long) MathKt.roundToInt(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() & 4294967295L)))) & 4294967295L) | (((long) MathKt.roundToInt(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)))) << 32)), 0.0f, null, null, 0, 0, 1006, null);
        } catch (IllegalStateException e) {
            Log.w("RetainedBitmapImage", "Bitmap draw skipped during disposal race", e);
        }
    }
}
