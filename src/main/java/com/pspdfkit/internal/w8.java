package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes3.dex */
public final class w8 {
    public final int a;
    public final int b;
    public final int c;

    public w8(Context context) {
        this.a = a80.a(context, 36);
        this.c = (int) un.a(context, 1, 3);
        this.b = (int) un.a(context, 1, 8);
    }

    public final BitmapShader a(int i, int i2) {
        int i3 = i < this.a ? this.c : this.b;
        int i4 = i3 * 2;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(570425344);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Rect rect = new Rect(0, 0, i3, i3);
        canvas.drawRect(rect, paint);
        rect.offset(i3, i3);
        canvas.drawRect(rect, paint);
        rect.set(0, 0, i4, i4);
        paint.setColor(i2);
        canvas.drawRect(rect, paint);
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        return new BitmapShader(bitmapCreateBitmap, tileMode, tileMode);
    }
}
