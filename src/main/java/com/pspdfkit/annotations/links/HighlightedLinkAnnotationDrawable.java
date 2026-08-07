package com.pspdfkit.annotations.links;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.annotations.LinkAnnotation;
import com.pspdfkit.internal.eo;
import com.pspdfkit.internal.gf;
import com.pspdfkit.internal.h60;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.drawable.PdfDrawable;

/* JADX INFO: loaded from: classes3.dex */
class HighlightedLinkAnnotationDrawable extends PdfDrawable {
    private static final int FADE_OUT_ANIMATION_DURATION = 1500;
    private static final int INITIAL_ALPHA_VALUE = 120;
    private static final int POP_OUT_ANIMATION_DURATION = 150;
    private static final Paint highlightedBackgroundColor;
    private static final Paint highlightedBorderColor;
    private static final RectF sharedDrawRect = new RectF();
    private boolean animateOnDraw;
    private float animationPadding;
    private float cornerRadius;
    private int highlightedLinkAnnotationAnimationPadding;
    private int highlightedLinkAnnotationPadding;
    private final RectF highlightedRect;
    private float highlightedRectangleCornerRadiusToHeightRatio;
    private int highlightedRectangleMaxCornerRadius;
    private int highlightedRectangleMinCornerRadius;
    private final LinkAnnotation linkAnnotation;

    static {
        Paint paint = new Paint();
        highlightedBackgroundColor = paint;
        paint.setStyle(Paint.Style.FILL);
        BlendMode blendMode = BlendMode.DARKEN;
        gf.a(paint, blendMode);
        paint.setAlpha(120);
        Paint paint2 = new Paint();
        highlightedBorderColor = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        gf.a(paint2, blendMode);
        paint2.setAlpha(120);
    }

    public HighlightedLinkAnnotationDrawable(LinkAnnotation linkAnnotation) {
        uw.a(linkAnnotation, "linkAnnotation", null);
        this.linkAnnotation = linkAnnotation;
        this.highlightedRect = new RectF();
        this.animateOnDraw = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPopOutAnimation$0(ValueAnimator valueAnimator) {
        this.animationPadding = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPopOutAnimation$1(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        highlightedBorderColor.setAlpha(iIntValue);
        highlightedBackgroundColor.setAlpha(iIntValue);
        invalidateSelf();
    }

    private void startPopOutAnimation() {
        ValueAnimator valueAnimatorOfFloat = ObjectAnimator.ofFloat(0.0f, this.highlightedLinkAnnotationAnimationPadding);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.annotations.links.HighlightedLinkAnnotationDrawable$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$startPopOutAnimation$0(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.setRepeatMode(2);
        valueAnimatorOfFloat.setRepeatCount(1);
        ValueAnimator valueAnimatorOfInt = ObjectAnimator.ofInt(highlightedBackgroundColor.getAlpha(), 0);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.annotations.links.HighlightedLinkAnnotationDrawable$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$startPopOutAnimation$1(valueAnimator);
            }
        });
        valueAnimatorOfInt.setDuration(1500L);
        valueAnimatorOfInt.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(valueAnimatorOfFloat, valueAnimatorOfInt);
        animatorSet.start();
        invalidateSelf();
    }

    public void applyTheme(eo eoVar) {
        Paint paint = highlightedBackgroundColor;
        paint.setColor(eoVar.a);
        Paint paint2 = highlightedBorderColor;
        paint2.setColor(eoVar.b);
        paint2.setStrokeWidth(eoVar.c);
        this.highlightedLinkAnnotationPadding = eoVar.d;
        this.highlightedLinkAnnotationAnimationPadding = eoVar.e;
        this.highlightedRectangleCornerRadiusToHeightRatio = eoVar.f;
        this.highlightedRectangleMinCornerRadius = eoVar.g;
        this.highlightedRectangleMaxCornerRadius = eoVar.h;
        paint2.setAlpha(120);
        paint.setAlpha(120);
        h60.a(new Runnable() { // from class: com.pspdfkit.annotations.links.HighlightedLinkAnnotationDrawable$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.invalidateSelf();
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.animateOnDraw) {
            this.animateOnDraw = false;
            startPopOutAnimation();
        }
        RectF rectF = sharedDrawRect;
        rectF.set(this.highlightedRect);
        float f = this.animationPadding;
        if (f != 0.0f) {
            float f2 = -f;
            rectF.inset(f2, f2);
        }
        float f3 = this.cornerRadius;
        canvas.drawRoundRect(rectF, f3, f3, highlightedBackgroundColor);
        float f4 = this.cornerRadius;
        canvas.drawRoundRect(rectF, f4, f4, highlightedBorderColor);
    }

    public LinkAnnotation getLinkAnnotation() {
        return this.linkAnnotation;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawable
    public void updatePdfToViewTransformation(Matrix matrix) {
        uw.a(matrix, "matrix", null);
        super.updatePdfToViewTransformation(matrix);
        this.cornerRadius = this.highlightedRectangleMinCornerRadius;
        RectF rectF = new RectF();
        RectF rectF2 = this.highlightedRect;
        rectF.set(this.linkAnnotation.getBoundingBox());
        int i = this.highlightedLinkAnnotationPadding;
        rectF.inset(-i, i);
        rectF2.set(rectF);
        matrix.mapRect(rectF2);
        this.cornerRadius = Math.max(this.cornerRadius, Math.max(this.highlightedRectangleMinCornerRadius, Math.min(rectF2.height() * this.highlightedRectangleCornerRadiusToHeightRatio, this.highlightedRectangleMaxCornerRadius)));
        getBounds().set((int) rectF2.left, (int) rectF2.top, (int) Math.ceil(rectF2.right), (int) Math.ceil(rectF2.bottom));
    }
}
