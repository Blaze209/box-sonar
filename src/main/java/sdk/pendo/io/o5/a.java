package sdk.pendo.io.o5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import sdk.pendo.io.s7.e1;

/* JADX INFO: loaded from: classes4.dex */
public class a extends FrameLayout {
    private View a;
    private Bitmap b;
    private boolean c;
    private final c d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final int i;
    private final boolean j;
    private final float k;

    /* JADX INFO: renamed from: sdk.pendo.io.o5.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0444a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.RECTANGULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.OVAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static class b {
        Context a;
        View b;
        c c = c.RECTANGULAR;
        float d;
        float e;
        float f;
        float g;
        int h;
        boolean i;
        float j;

        b(Context context, View view) {
            this.a = context;
            this.b = view;
        }

        b a(int i) {
            this.h = i;
            return this;
        }

        b a(float f, float f2, float f3, float f4) {
            this.d = f;
            this.e = f2;
            this.f = f3;
            this.g = f4;
            return this;
        }

        b a(boolean z) {
            this.i = z;
            return this;
        }

        b a(float f) {
            this.j = f;
            return this;
        }
    }

    enum c {
        OVAL,
        RECTANGULAR
    }

    a(b bVar) {
        super(bVar.a);
        this.c = true;
        this.a = bVar.b;
        this.e = bVar.d;
        this.f = bVar.e;
        this.g = bVar.f;
        this.h = bVar.g;
        this.d = bVar.c;
        this.i = bVar.h;
        this.j = bVar.i;
        this.k = bVar.j;
        setBackgroundColor(0);
    }

    private void a() {
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            return;
        }
        Bitmap bitmap = this.b;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.b.recycle();
        }
        this.b = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.b);
        RectF rectF = new RectF(0.0f, 0.0f, measuredWidth, measuredHeight);
        Paint paint = new Paint(1);
        paint.setColor(this.i);
        paint.setAntiAlias(true);
        paint.setAlpha(Color.alpha(this.i));
        canvas.drawRect(rectF, paint);
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        Rect rectA = e1.a(this.a);
        Rect rectA2 = e1.a(this);
        float f = rectA.left - rectA2.left;
        float f2 = rectA.top - rectA2.top;
        RectF rectF2 = new RectF(f - this.e, f2 - this.f, f + this.a.getMeasuredWidth() + this.g, f2 + this.a.getMeasuredHeight() + this.h);
        if (this.j) {
            int i = C0444a.a[this.d.ordinal()];
            if (i == 1) {
                float f3 = this.k;
                canvas.drawRoundRect(rectF2, f3, f3, paint);
            } else if (i == 2) {
                canvas.drawOval(rectF2, paint);
            }
        }
        this.c = false;
    }

    public void b() {
        a();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        if (this.c || (bitmap = this.b) == null || bitmap.isRecycled()) {
            a();
        }
        Bitmap bitmap2 = this.b;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.b, 0.0f, 0.0f, (Paint) null);
    }

    public float getBackDropPaddingRight() {
        return this.g;
    }

    public float getBackDropPaddingTop() {
        return this.f;
    }

    @Override // android.view.View
    public boolean isInEditMode() {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c = true;
    }
}
