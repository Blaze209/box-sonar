package com.pspdfkit.internal.views.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.pspdfkit.internal.a80;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public class CircleImageView extends AppCompatImageView {
    public static final ImageView.ScaleType n = ImageView.ScaleType.CENTER;
    public final Paint a;
    public final Paint b;
    public final Paint c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public Bitmap h;
    public BitmapShader i;
    public int j;
    public int k;
    public float l;
    public float m;

    public CircleImageView(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new Paint();
        this.c = new Paint();
        this.d = 4;
        this.e = -7829368;
        this.f = -1;
        this.g = false;
        super.setScaleType(n);
        a();
    }

    public final void a(Drawable drawable, boolean z) {
        super.setImageDrawable(drawable);
        this.g = z;
        this.h = a(drawable);
        a();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return n;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.drawCircle(this.j / 2.0f, this.k / 2.0f, this.l, this.a);
        if (this.h != null) {
            canvas.drawCircle(this.j / 2.0f, this.k / 2.0f, this.l, this.b);
        }
        canvas.drawCircle(this.j / 2.0f, this.k / 2.0f, this.m, this.c);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.j = i;
        this.k = i2;
        a();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (i == this.f) {
            return;
        }
        this.f = i;
        this.a.setColor(i);
        invalidate();
    }

    public void setBackgroundColorResource(int i) {
        setBackgroundColor(ContextCompat.getColor(getContext(), i));
    }

    public void setBorderColor(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        this.c.setColor(i);
        invalidate();
    }

    public void setBorderColorResource(int i) {
        setBorderColor(ContextCompat.getColor(getContext(), i));
    }

    public void setBorderWidthDp(int i) {
        if (this.d == i) {
            return;
        }
        this.d = i;
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.h = bitmap;
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        a(drawable, true);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        this.h = a(getDrawable());
        a();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == n) {
            return;
        }
        throw new IllegalArgumentException("ScaleType " + scaleType + " not supported.");
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof ColorDrawable)) {
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return bitmapCreateBitmap;
            } catch (Exception e) {
                PdfLog.e("Nutri.CircleImageView", e, "Can't create bitmap in CircleImageView", new Object[0]);
                return null;
            }
        }
        throw new IllegalArgumentException("ColorDrawable not supported.");
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint();
        this.b = new Paint();
        this.c = new Paint();
        this.d = 4;
        this.e = -7829368;
        this.f = -1;
        this.g = false;
        super.setScaleType(n);
        a();
    }

    public final void a() {
        if (this.j == 0 && this.k == 0) {
            return;
        }
        int iA = a80.a(getContext(), this.d);
        if (this.h != null) {
            Bitmap bitmap = this.h;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.i = new BitmapShader(bitmap, tileMode, tileMode);
            this.b.setAntiAlias(true);
            this.b.setShader(this.i);
            if (this.g) {
                this.b.setAlpha(75);
            }
        }
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setAntiAlias(true);
        this.c.setColor(this.e);
        this.c.setStrokeWidth(iA);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setAntiAlias(true);
        this.a.setColor(this.f);
        this.m = Math.min((this.k - iA) / 2.0f, (this.j - iA) / 2.0f);
        this.l = Math.min(this.k / 2.0f, this.j / 2.0f);
        invalidate();
    }
}
