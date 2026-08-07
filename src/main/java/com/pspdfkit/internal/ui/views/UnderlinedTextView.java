package com.pspdfkit.internal.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.pspdfkit.ui.LocalizedTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/pspdfkit/internal/ui/views/UnderlinedTextView;", "Lcom/pspdfkit/ui/LocalizedTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "getUnderLineColor", "()I", "setUnderLineColor", "(I)V", "underLineColor", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UnderlinedTextView extends LocalizedTextView {
    public final Paint a;
    public final Rect b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnderlinedTextView(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }

    public final int getUnderLineColor() {
        return this.a.getColor();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.getClass();
        int lineCount = getLineCount();
        Paint paint = this.a;
        for (int i = 0; i < lineCount; i++) {
            int lineBounds = getLineBounds(i, this.b);
            float f = this.b.left;
            float f2 = lineBounds;
            Context context = getContext();
            context.getClass();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            displayMetrics.getClass();
            float fApplyDimension = TypedValue.applyDimension(1, 2.0f, displayMetrics) + f2;
            float f3 = this.b.right;
            Context context2 = getContext();
            context2.getClass();
            DisplayMetrics displayMetrics2 = context2.getResources().getDisplayMetrics();
            displayMetrics2.getClass();
            canvas.drawLine(f, fApplyDimension, f3, TypedValue.applyDimension(1, 2.0f, displayMetrics2) + f2, paint);
        }
        super.onDraw(canvas);
    }

    public final void setUnderLineColor(int i) {
        this.a.setColor(i);
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnderlinedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnderlinedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        Paint paint = new Paint();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        paint.setStrokeWidth(TypedValue.applyDimension(1, 1.0f, displayMetrics));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-16776961);
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        displayMetrics2.getClass();
        float fApplyDimension = TypedValue.applyDimension(1, 2.0f, displayMetrics2);
        DisplayMetrics displayMetrics3 = context.getResources().getDisplayMetrics();
        displayMetrics3.getClass();
        paint.setPathEffect(new DashPathEffect(new float[]{fApplyDimension, TypedValue.applyDimension(1, 2.0f, displayMetrics3)}, 0.0f));
        this.a = paint;
        this.b = new Rect();
        setWillNotDraw(false);
    }

    public /* synthetic */ UnderlinedTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
