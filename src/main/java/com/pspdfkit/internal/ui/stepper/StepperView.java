package com.pspdfkit.internal.ui.stepper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.pspdfkit.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000b¨\u0006#"}, d2 = {"Lcom/pspdfkit/internal/ui/stepper/StepperView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCircleY", "()I", "", "getCirclePositions", "()[I", "getStartCirclePosition", "getEndCirclePosition", "count", "", "setStepsCount", "(I)V", "", "", "stepLabels", "setSteps", "(Ljava/util/List;)V", "theme", "setTheme", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "b", "I", "getDefStyle", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StepperView extends View {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final AttributeSet attrs;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int defStyle;
    public final Paint c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float k;
    public float l;
    public int m;
    public float n;
    public float o;
    public int p;
    public int q;
    public int r;
    public ArrayList<String> s;
    public int[] t;
    public int u;
    public int[] v;
    public int[] w;
    public final Rect x;
    public int y;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepperView(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }

    private final int[] getCirclePositions() {
        int i = this.m;
        int[] iArr = new int[i];
        if (i != 0) {
            iArr[0] = getStartCirclePosition();
            int i2 = 1;
            if (i != 1) {
                iArr[this.m - 1] = getEndCirclePosition();
                if (i >= 3) {
                    int i3 = (int) ((getLayoutDirection() == 1 ? iArr[0] - iArr[this.m - 1] : iArr[this.m - 1] - iArr[0]) / (this.m - 1));
                    boolean z = getLayoutDirection() == 1;
                    int i4 = this.m;
                    if (z) {
                        int i5 = i4 - 1;
                        while (i2 < i5) {
                            iArr[i2] = iArr[i2 - 1] - i3;
                            i2++;
                        }
                    } else {
                        int i6 = i4 - 1;
                        while (i2 < i6) {
                            iArr[i2] = iArr[i2 - 1] + i3;
                            i2++;
                        }
                    }
                }
            }
        }
        return iArr;
    }

    private final int getCircleY() {
        return (getMeasuredHeight() - ((((int) this.l) + this.q) + (getPaddingBottom() + getPaddingTop()))) / 2;
    }

    private final int getEndCirclePosition() {
        return getLayoutDirection() == 1 ? getPaddingLeft() + ((int) this.n) + this.p : ((getMeasuredWidth() - getPaddingRight()) - ((int) this.n)) - this.p;
    }

    private final int getStartCirclePosition() {
        return getLayoutDirection() == 1 ? ((getMeasuredWidth() - getPaddingRight()) - ((int) this.n)) - this.p : getPaddingLeft() + ((int) this.n) + this.p;
    }

    public final void a() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.pspdf__StepperView, R.attr.pspdf__stepperViewStyle, this.y);
        typedArrayObtainStyledAttributes.getClass();
        this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StepperView_pspdf__selectedTextColor, 0);
        this.g = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StepperView_pspdf__unselectedTextColor, 0);
        this.d = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StepperView_pspdf__selectedStepColor, 0);
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StepperView_pspdf__unselectedStepColor, 0);
        this.h = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StepperView_pspdf__selectedDividerColor, 0);
        this.i = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StepperView_pspdf__unselectedDividerColor, 0);
        this.j = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StepperView_pspdf__labelTextColor, 0);
        this.k = typedArrayObtainStyledAttributes.getDimension(R.styleable.pspdf__StepperView_pspdf__stepNumberTextSize, 0.0f);
        this.l = typedArrayObtainStyledAttributes.getDimension(R.styleable.pspdf__StepperView_pspdf__stepLabelTextSize, 0.0f);
        this.n = typedArrayObtainStyledAttributes.getDimension(R.styleable.pspdf__StepperView_pspdf__stepRadius, 0.0f);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__StepperView_pspdf__stepPadding, 0);
        this.o = typedArrayObtainStyledAttributes.getDimension(R.styleable.pspdf__StepperView_pspdf__stepPadding, 0.0f);
        this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__StepperView_pspdf__stepPadding, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final AttributeSet getAttrs() {
        return this.attrs;
    }

    public final int getDefStyle() {
        return this.defStyle;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        canvas2.getClass();
        int i = this.m;
        int i2 = 1;
        if (i < 1) {
            return;
        }
        int i3 = 0;
        int i4 = 0;
        while (i4 < i) {
            float f = this.t[i4];
            float f2 = this.u;
            int i5 = this.r;
            int i6 = i4 == i5 ? i2 : i3;
            int i7 = i4 < i5 ? i2 : i3;
            int i8 = i4 + 1;
            String strValueOf = String.valueOf(i8);
            if (i6 == 0 || i7 != 0) {
                Paint paint = this.c;
                if (i7 != 0) {
                    paint.setColor(this.d);
                    canvas2.drawCircle(f, f2, this.n, this.c);
                    this.c.setColor(this.f);
                    float f3 = this.k * 0.1f;
                    this.c.setStrokeWidth(f3);
                    double d = (int) f;
                    double d2 = f3;
                    double d3 = 4.5d * d2;
                    double d4 = (int) f2;
                    double d5 = d2 * 3.5d;
                    Rect rect = new Rect((int) (d - d3), (int) (d4 - d5), (int) (d + d3), (int) (d4 + d5));
                    float f4 = rect.left;
                    float f5 = rect.bottom;
                    float f6 = 3.25f * f3;
                    float f7 = f3 * 0.75f;
                    canvas.drawLine((0.5f * f3) + f4, f5 - f6, f6 + f4, f5 - f7, this.c);
                    canvas2 = canvas;
                    canvas2.drawLine((2.75f * f3) + rect.left, rect.bottom - f7, rect.right - (f3 * 0.375f), rect.top + f7, this.c);
                    a(canvas2, i4, f, this.c);
                    i2 = 1;
                    i3 = 0;
                } else {
                    paint.setColor(this.e);
                    canvas2.drawCircle(f, f2, this.n, this.c);
                    this.c.setColor(this.g);
                    Paint paint2 = this.c;
                    paint2.setTextAlign(Paint.Align.CENTER);
                    paint2.setTextSize(this.k);
                    i2 = 1;
                    paint2.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
                    i3 = 0;
                    paint2.getTextBounds(strValueOf, 0, strValueOf.length(), this.x);
                    canvas2.drawText(strValueOf, f, ((this.x.height() / 2.0f) + this.u) - this.x.bottom, paint2);
                    a(canvas2, i4, f, this.c);
                }
            } else {
                this.c.setColor(this.d);
                canvas2.drawCircle(f, f2, this.n, this.c);
                this.c.setColor(this.f);
                Paint paint3 = this.c;
                paint3.setTextAlign(Paint.Align.CENTER);
                paint3.setTextSize(this.k);
                paint3.setTypeface(Typeface.create(Typeface.DEFAULT, i2));
                paint3.getTextBounds(strValueOf, i3, strValueOf.length(), this.x);
                canvas2.drawText(strValueOf, f, ((this.x.height() / 2.0f) + this.u) - this.x.bottom, paint3);
                a(canvas2, i4, f, this.c);
            }
            i4 = i8;
        }
        int length = this.v.length;
        int i9 = i3;
        while (i9 < length) {
            int i10 = this.v[i9];
            int i11 = this.w[i9];
            int i12 = this.u;
            int i13 = i9 < this.r ? i2 : i3;
            Paint paint4 = this.c;
            if (i13 != 0) {
                paint4.setColor(this.h);
            } else {
                paint4.setColor(this.i);
            }
            this.c.setStrokeWidth(3.0f);
            float f8 = i12;
            canvas2.drawLine(i10, f8, i11, f8, this.c);
            i9++;
            canvas2 = canvas;
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        if (this.s.isEmpty()) {
            int i3 = this.m;
            int i4 = 0;
            while (i4 < i3) {
                i4++;
                this.s.add("Step " + i4);
            }
        } else {
            this.m = this.s.size();
        }
        if (this.m > 0) {
            this.u = getPaddingTop() + getCircleY();
            this.t = getCirclePositions();
            int i5 = this.m;
            if (i5 >= 1) {
                int i6 = i5 - 1;
                this.v = new int[i6];
                this.w = new int[i6];
                int i7 = this.p + ((int) this.n);
                for (int i8 = 1; i8 < i5; i8++) {
                    boolean z = getLayoutDirection() == 1;
                    int[] iArr = this.v;
                    int[] iArr2 = this.t;
                    if (z) {
                        int i9 = i8 - 1;
                        iArr[i9] = iArr2[i9] - i7;
                        this.w[i9] = iArr2[i8] + i7;
                    } else {
                        int i10 = i8 - 1;
                        iArr[i10] = iArr2[i10] + i7;
                        this.w[i10] = iArr2[i8] - i7;
                    }
                }
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setSteps(List<String> stepLabels) {
        stepLabels.getClass();
        this.s = new ArrayList<>(stepLabels);
        requestLayout();
    }

    public final void setStepsCount(int count) {
        this.m = count;
        requestLayout();
    }

    public final void setTheme(int theme) {
        this.y = theme;
        a();
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepperView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.attrs = attributeSet;
        this.defStyle = i;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.c = paint;
        this.m = 3;
        this.o = 40.0f;
        this.q = 8;
        this.s = new ArrayList<>();
        this.t = new int[0];
        this.v = new int[0];
        this.w = new int[0];
        this.x = new Rect();
        this.y = R.style.PSPDFKit_StepView;
        a();
    }

    public final void a(Canvas canvas, int i, float f, Paint paint) {
        String str = this.s.get(i);
        str.getClass();
        String str2 = str;
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(this.l);
        paint.setColor(this.j);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, this.r == i ? 1 : 0));
        paint.getTextBounds(str2, 0, str2.length(), this.x);
        canvas.drawText(str2, f, this.n + this.o + (((this.x.height() / 2.0f) + this.u) - this.x.bottom), paint);
    }

    public /* synthetic */ StepperView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
