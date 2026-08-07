package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import androidx.core.view.ViewCompat;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ff {
    public static int a(int i) {
        int iAlpha = (i ^ ViewCompat.MEASURED_SIZE_MASK) | (Color.alpha(i) << 24);
        ColorMatrix colorMatrix = (ColorMatrix) um.a.getValue();
        colorMatrix.getClass();
        float fAlpha = Color.alpha(iAlpha) / 255.0f;
        float fRed = Color.red(iAlpha) / 255.0f;
        float fGreen = Color.green(iAlpha) / 255.0f;
        float fBlue = Color.blue(iAlpha) / 255.0f;
        float[] array = colorMatrix.getArray();
        float[] fArr = {(array[3] * fAlpha) + (array[2] * fBlue) + (array[1] * fGreen) + (array[0] * fRed) + array[4], (array[8] * fAlpha) + (array[7] * fBlue) + (array[6] * fGreen) + (array[5] * fRed) + array[9], (array[13] * fAlpha) + (array[12] * fBlue) + (array[11] * fGreen) + (array[10] * fRed) + array[14], (array[18] * fAlpha) + (array[17] * fBlue) + (array[16] * fGreen) + (array[15] * fRed) + array[19]};
        float f = 255;
        return Color.argb(RangesKt.coerceIn((int) (fArr[3] * f), 0, 255), RangesKt.coerceIn((int) (fArr[0] * f), 0, 255), RangesKt.coerceIn((int) (fArr[1] * f), 0, 255), RangesKt.coerceIn((int) (fArr[2] * f), 0, 255));
    }

    public static void b(RectF rectF, RectF rectF2) {
        float fWidth = rectF.width();
        float fWidth2 = rectF2.width();
        if (fWidth <= fWidth2) {
            float f = rectF.left;
            float f2 = rectF2.left;
            if (f < f2) {
                rectF.left = f2;
                rectF.right += f2 - f;
            }
            float f3 = rectF.right;
            float f4 = rectF2.right;
            if (f3 > f4) {
                rectF.right = f4;
                rectF.left -= f3 - f4;
            }
        } else {
            float f5 = (fWidth - fWidth2) / 2.0f;
            rectF.left = -f5;
            rectF.right = fWidth2 + f5;
        }
        float fHeight = rectF.height();
        float fHeight2 = rectF2.height();
        if (fHeight > fHeight2) {
            float f6 = (fHeight - fHeight2) / 2.0f;
            rectF.top = -f6;
            rectF.bottom = fHeight2 + f6;
            return;
        }
        float f7 = rectF.top;
        float f8 = rectF2.top;
        if (f7 < f8) {
            rectF.top = f8;
            rectF.bottom += f8 - f7;
        }
        float f9 = rectF.bottom;
        float f10 = rectF2.bottom;
        if (f9 > f10) {
            rectF.bottom = f10;
            rectF.top -= f9 - f10;
        }
    }

    public static int a(int i, boolean z, boolean z2) {
        if (z2) {
            i = a(i);
        }
        if (!z) {
            return i;
        }
        int iBlue = ((Color.blue(i) * 11) + ((Color.green(i) * 59) + (Color.red(i) * 30))) / 100;
        return Color.argb(Color.alpha(i), iBlue, iBlue, iBlue);
    }

    public static ColorMatrixColorFilter a(boolean z, boolean z2) {
        ColorMatrix colorMatrix;
        if (!z && !z2) {
            return null;
        }
        if (z && z2) {
            colorMatrix = new ColorMatrix(new float[]{-0.3f, -0.59f, -0.11f, 0.0f, 255.0f, -0.3f, -0.59f, -0.11f, 0.0f, 255.0f, -0.3f, -0.59f, -0.11f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        } else if (z2) {
            colorMatrix = new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        } else if (z) {
            colorMatrix = new ColorMatrix(new float[]{0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        } else {
            colorMatrix = new ColorMatrix();
        }
        if (z2) {
            colorMatrix.postConcat((ColorMatrix) um.a.getValue());
        }
        return new ColorMatrixColorFilter(colorMatrix);
    }

    public static void a(RectF rectF, RectF rectF2) {
        float fWidth = rectF.width();
        float fWidth2 = rectF2.width();
        if (fWidth <= fWidth2) {
            float f = rectF.left;
            float f2 = rectF2.left;
            if (f < f2) {
                rectF.left = f2;
                rectF.right += f2 - f;
            }
            float f3 = rectF.right;
            float f4 = rectF2.right;
            if (f3 > f4) {
                rectF.right = f4;
                rectF.left -= f3 - f4;
            }
        } else {
            float f5 = (fWidth - fWidth2) / 2.0f;
            rectF.left = -f5;
            rectF.right = fWidth2 + f5;
        }
        float f6 = rectF.top;
        float f7 = rectF.bottom;
        float f8 = f6 - f7;
        float f9 = rectF2.top;
        float f10 = f9 - rectF2.bottom;
        if (f8 <= f10) {
            if (f6 > f9) {
                rectF.top = f9;
                rectF.bottom = f7 - (f6 - f9);
            }
            float f11 = rectF.bottom;
            float f12 = rectF2.bottom;
            if (f11 < f12) {
                rectF.bottom = f12;
                rectF.top += f12 - f11;
                return;
            }
            return;
        }
        float f13 = (f8 - f10) / 2.0f;
        rectF.top = f10 + f13;
        rectF.bottom = -f13;
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap a(String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }
}
