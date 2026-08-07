package com.pspdfkit.internal.ui.inspector;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.pspdfkit.R;
import com.pspdfkit.internal.g9;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.u40;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR*\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/pspdfkit/internal/ui/inspector/ColorPreviewView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "I", "getPreviousColor", "()I", "setPreviousColor", "(I)V", "previousColor", "b", "getCurrentColor", "setCurrentColor", "currentColor", "Lcom/pspdfkit/internal/ui/inspector/ColorPreviewView$a;", "c", "Lcom/pspdfkit/internal/ui/inspector/ColorPreviewView$a;", "getOnPreviousColorSelected", "()Lcom/pspdfkit/internal/ui/inspector/ColorPreviewView$a;", "setOnPreviousColorSelected", "(Lcom/pspdfkit/internal/ui/inspector/ColorPreviewView$a;)V", "onPreviousColorSelected", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ColorPreviewView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int previousColor;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int currentColor;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public a onPreviousColorSelected;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final View g;
    public final View h;
    public ValueAnimator i;

    public interface a {
        void a(int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColorPreviewView(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }

    public static final void a(ColorPreviewView colorPreviewView, View view) {
        colorPreviewView.setCurrentColor(colorPreviewView.previousColor);
        a aVar = colorPreviewView.onPreviousColorSelected;
        if (aVar != null) {
            aVar.a(colorPreviewView.previousColor);
        }
    }

    public final int getCurrentColor() {
        return this.currentColor;
    }

    public final a getOnPreviousColorSelected() {
        return this.onPreviousColorSelected;
    }

    public final int getPreviousColor() {
        return this.previousColor;
    }

    public final void setCurrentColor(int i) {
        int i2 = this.currentColor;
        if (i2 != i) {
            a(i2, i);
        }
        this.currentColor = i;
        a();
    }

    public final void setOnPreviousColorSelected(a aVar) {
        this.onPreviousColorSelected = aVar;
    }

    public final void setPreviousColor(int i) {
        this.previousColor = i;
        this.h.setBackgroundColor(i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColorPreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorPreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.previousColor = -16777216;
        this.currentColor = -16777216;
        LayoutInflater.from(getContext()).inflate(R.layout.pspdf__color_preview_view, this);
        setBackground(new g9(context, 0, 0));
        setOrientation(0);
        View viewFindViewById = findViewById(R.id.pspdf__hex_title);
        viewFindViewById.getClass();
        this.d = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.pspdf__hsl_title);
        viewFindViewById2.getClass();
        this.e = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.pspdf__rgb_title);
        viewFindViewById3.getClass();
        this.f = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.pspdf__current_color_view);
        viewFindViewById4.getClass();
        this.g = viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.pspdf__previous_color_view);
        viewFindViewById5.getClass();
        this.h = viewFindViewById5;
        viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.ui.inspector.ColorPreviewView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ColorPreviewView.a(this.f$0, view);
            }
        });
    }

    public final void a(int i, int i2) {
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i), Integer.valueOf(i2));
        valueAnimatorOfObject.setDuration(160L);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.internal.ui.inspector.ColorPreviewView$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ColorPreviewView.a(this.f$0, valueAnimator2);
            }
        });
        valueAnimatorOfObject.start();
        this.i = valueAnimatorOfObject;
    }

    public static final void a(ColorPreviewView colorPreviewView, ValueAnimator valueAnimator) {
        valueAnimator.getClass();
        View view = colorPreviewView.g;
        Object animatedValue = valueAnimator.getAnimatedValue();
        animatedValue.getClass();
        view.setBackgroundColor(((Integer) animatedValue).intValue());
    }

    public final void a() {
        int i = (Color.alpha(this.currentColor) != 255 || ColorUtils.calculateLuminance(this.currentColor) > 0.5d) ? -16777216 : -1;
        this.d.setText(u40.a(this.currentColor, true, false));
        this.d.setTextColor(i);
        float[] fArr = new float[3];
        ColorUtils.colorToHSL(this.currentColor, fArr);
        String strA = no.a(getContext(), R.string.pspdf__color_picker_hsl, null);
        strA.getClass();
        float f = 100;
        this.e.setText(strA + " " + ((int) fArr[0]) + " " + ((int) (fArr[1] * f)) + " " + ((int) (fArr[2] * f)));
        this.e.setTextColor(i);
        String strA2 = no.a(getContext(), R.string.pspdf__color_picker_rgb, null);
        strA2.getClass();
        this.f.setText(strA2 + " " + Color.red(this.currentColor) + " " + Color.green(this.currentColor) + " " + Color.blue(this.currentColor));
        this.f.setTextColor(i);
    }

    public /* synthetic */ ColorPreviewView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
