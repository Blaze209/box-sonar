package sdk.pendo.io.o5;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.e1;

/* JADX INFO: loaded from: classes4.dex */
public class d extends Drawable {
    private final Path b;
    private Point c;
    private final Paint e;
    private final Paint f;
    private float g;
    private int h;
    private int j;
    private final int k;
    private float l;
    private final Point d = new Point();
    private int i = 0;
    private final RectF a = new RectF();

    public d(int i, int i2, int i3, int i4) {
        this.k = i;
        this.g = i4;
        if (i2 != 0) {
            Paint paint = new Paint(1);
            this.e = paint;
            paint.setColor(i2);
            paint.setStyle(Paint.Style.FILL);
        } else {
            this.e = null;
        }
        if (i3 != 0) {
            Paint paint2 = new Paint(1);
            this.f = paint2;
            paint2.setColor(i3);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(i);
        } else {
            this.f = null;
        }
        this.b = new Path();
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00be  */
    private void a(Rect rect) {
        int i;
        boolean z;
        int i2;
        int i3 = rect.left;
        int i4 = this.h;
        int i5 = i3 + i4;
        int i6 = rect.top + i4;
        int i7 = rect.right - i4;
        int i8 = rect.bottom - i4;
        a(i7, i8);
        int iApplyDimension = this.k + ((int) TypedValue.applyDimension(1, 1.0f, e1.a()));
        int i9 = this.j;
        if (i9 == 0) {
            i7 -= this.i;
        }
        if (i9 == 2) {
            i8 -= this.i;
        }
        if (i9 == 1) {
            i5 += this.i;
        }
        if (i9 == 3) {
            i6 += this.i;
        }
        float f = i8;
        float f2 = this.g;
        float f3 = f - f2;
        float f4 = i7;
        float f5 = f4 - f2;
        float f6 = i6;
        float f7 = f6 + f2;
        float f8 = i5;
        float f9 = f2 + f8;
        float f10 = this.l / 2.0f;
        if (this.c == null) {
            PendoLogger.d("PendoTooltipTextDrawable", "calculatePath - drawable doesn't have a targetPoint");
            this.b.reset();
            this.a.set(f8, f6, f4, f);
            Path path = this.b;
            RectF rectF = this.a;
            float f11 = this.g;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
            return;
        }
        PendoLogger.d("PendoTooltipTextDrawable", "calculatePath - drawable has a targetPoint");
        Point point = this.d;
        Point point2 = this.c;
        point.set(point2.x, point2.y);
        int i10 = this.j;
        if (i10 == 1 || i10 == 0) {
            Point point3 = this.d;
            int i11 = point3.y;
            if (i11 < i6 || i11 > i8) {
                z = false;
            } else {
                float f12 = i11 + i6;
                if (f12 + f10 > f3) {
                    i = (int) ((f3 - f10) - f6);
                } else {
                    if (f12 - f10 < f7) {
                        i = (int) ((f7 + f10) - f6);
                    }
                    z = true;
                }
                point3.y = i;
                z = true;
            }
        } else {
            Point point4 = this.d;
            int i12 = point4.x;
            if (i12 < i5 || i12 > i7) {
                z = false;
            } else {
                float f13 = i12 + i5;
                if (f13 + f10 > f5) {
                    i2 = (int) ((f5 - f10) - f8);
                } else {
                    if (f13 - f10 < f9) {
                        i2 = (int) ((f9 + f10) - f8);
                    }
                    z = true;
                }
                point4.x = i2;
                z = true;
            }
        }
        this.b.reset();
        this.b.moveTo(this.g + f8, f6);
        if (z && this.j == 3) {
            float fMax = Math.max((this.d.x + i5) - f10, this.g + f8);
            float fMin = Math.min(this.d.x + i5 + f10, f4 - this.g);
            this.b.lineTo(fMax, f6);
            this.b.lineTo(this.d.x + f8, rect.top + iApplyDimension);
            this.b.lineTo(fMin, f6);
        }
        this.b.lineTo(f4 - this.g, f6);
        this.b.quadTo(f4, f6, f4, this.g + f6);
        if (z && this.j == 0) {
            float fMax2 = Math.max((this.d.y + i6) - f10, this.g + f6);
            float fMin2 = Math.min(this.d.y + i6 + f10, f - this.g);
            this.b.lineTo(f4, fMax2);
            this.b.lineTo(rect.right - iApplyDimension, this.d.y + f6);
            this.b.lineTo(f4, fMin2);
        }
        this.b.lineTo(f4, f - this.g);
        this.b.quadTo(f4, f, f4 - this.g, f);
        if (z && this.j == 2) {
            float fMin3 = Math.min(this.d.x + i5 + f10, f4 - this.g);
            float fMax3 = Math.max((i5 + this.d.x) - f10, this.g + f8);
            this.b.lineTo(fMin3, f);
            this.b.lineTo(this.d.x + f8, rect.bottom - iApplyDimension);
            this.b.lineTo(fMax3, f);
        }
        this.b.lineTo(this.g + f8, f);
        this.b.quadTo(f8, f, f8, f - this.g);
        if (z && this.j == 1) {
            float fMin4 = Math.min(this.d.y + i6 + f10, f - this.g);
            float fMax4 = Math.max((i6 + this.d.y) - f10, this.g + f6);
            this.b.lineTo(f8, fMin4);
            this.b.lineTo(rect.left + iApplyDimension, this.d.y + f6);
            this.b.lineTo(f8, fMax4);
        }
        float f14 = this.g;
        if (f14 == 0.0f) {
            this.b.lineTo(f8, f6 - (this.k / 2.0f));
        } else {
            this.b.lineTo(f8, f14 + f6);
        }
        this.b.quadTo(f8, f6, this.g + f8, f6);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = this.e;
        if (paint != null) {
            canvas.drawPath(this.b, paint);
        }
        Paint paint2 = this.f;
        if (paint2 != null) {
            canvas.drawPath(this.b, paint2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.setAlpha(i);
        this.f.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    private void a(int i, int i2) {
        float fMin = Math.min(i, i2) / 2;
        if (this.g > fMin) {
            this.g = fMin - (this.l / 2.0f);
        }
    }

    private boolean a(Point point, Point point2) {
        if (point == null) {
            return point2 == null;
        }
        return point.equals(point2);
    }

    public void a(int i, int i2, Point point, int i3, int i4) {
        if (i == this.j && i2 == this.h && a(this.c, point)) {
            return;
        }
        this.j = i;
        this.h = i2;
        this.i = i3;
        this.l = i4;
        this.c = point != null ? new Point(point) : null;
        if (getBounds().isEmpty()) {
            return;
        }
        a(getBounds());
        invalidateSelf();
    }
}
