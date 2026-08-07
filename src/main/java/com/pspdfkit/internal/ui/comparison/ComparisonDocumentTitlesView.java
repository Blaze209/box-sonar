package com.pspdfkit.internal.ui.comparison;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.R;
import com.pspdfkit.internal.f60;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/pspdfkit/internal/ui/comparison/ComparisonDocumentTitlesView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", FirebaseAnalytics.Param.INDEX, "", "setCurrentDocument", "(I)V", "theme", "setTheme", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "b", "I", "getDefStyle", "()I", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ComparisonDocumentTitlesView extends View {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final AttributeSet attrs;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int defStyle;
    public final Paint c;
    public int d;
    public int e;
    public int f;
    public int g;
    public float h;
    public final String[] i;
    public float j;
    public final float[] k;
    public float l;
    public float m;
    public float n;
    public int o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ComparisonDocumentTitlesView(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }

    public final void a() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(this.attrs, R.styleable.pspdf__BreadCrumbsView, R.attr.pspdf__breadCrumbsViewStyle, this.d);
        typedArrayObtainStyledAttributes.getClass();
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__BreadCrumbsView_pspdf__titleColor, 0);
        this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__BreadCrumbsView_pspdf__selectedTitleColor, 0);
        this.g = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__BreadCrumbsView_pspdf__dividerColor, 0);
        this.h = typedArrayObtainStyledAttributes.getDimension(R.styleable.pspdf__BreadCrumbsView_pspdf__textSize, 0.0f);
        setBackgroundColor(typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__BreadCrumbsView_pspdf__backgroundColor, f60.a(getContext(), android.R.attr.colorBackground, R.color.pspdf__onPrimaryLight)));
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
        canvas.getClass();
        int length = this.i.length;
        int i = 0;
        while (i < length) {
            Paint paint = this.c;
            float f = this.k[i];
            String str = this.i[i];
            str.getClass();
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(this.h);
            paint.setColor(i == this.o ? this.f : this.e);
            paint.setTypeface(i == this.o ? Typeface.create(Typeface.DEFAULT, 1) : Typeface.create(Typeface.DEFAULT, 0));
            paint.setAlpha(i == this.o ? 255 : 150);
            canvas.drawText(str, f, (this.h / 2) + this.l, paint);
            i++;
        }
        float f2 = this.j;
        float f3 = this.l;
        this.c.setColor(this.g);
        this.c.setStrokeWidth(2.0f);
        this.c.setAlpha(180);
        float f4 = f2 + 16;
        canvas.drawLine(f2, this.n, f4, f3, this.c);
        canvas.drawLine(f4, f3, f2, getHeight() - this.n, this.c);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        this.m = getMeasuredWidth() - (getPaddingEnd() + getPaddingStart());
        float measuredHeight = getMeasuredHeight() - (getPaddingBottom() + getPaddingTop());
        this.n = measuredHeight;
        this.l = measuredHeight / 2.0f;
        float f = this.m;
        this.j = f / 2.0f;
        float[] fArr = this.k;
        fArr[0] = 0.25f * f;
        fArr[1] = f * 0.75f;
        super.onMeasure(i, i2);
    }

    public final void setCurrentDocument(int index) {
        this.o = index;
        invalidate();
    }

    public final void setTheme(int theme) {
        this.d = theme;
        a();
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ComparisonDocumentTitlesView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComparisonDocumentTitlesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.attrs = attributeSet;
        this.defStyle = i;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.c = paint;
        this.d = R.style.PSPDFKit_BreadCrumbsView;
        this.i = new String[]{context.getString(R.string.pspdf__old_document), context.getString(R.string.pspdf__new_document)};
        this.k = new float[2];
        a();
    }

    public /* synthetic */ ComparisonDocumentTitlesView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
