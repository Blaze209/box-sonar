package com.pspdfkit.ui.search;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.animation.DecelerateInterpolator;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.internal.k00;
import com.pspdfkit.ui.drawable.PdfDrawable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class SearchResultDrawable extends PdfDrawable {
    private static final int POP_OUT_ANIMATION_DURATION = 100;
    private static final Paint searchResultBackgroundPaint;
    private static final Paint searchResultBorderPaint;
    private static final RectF sharedDrawRect = new RectF();
    private boolean animateOnDraw;
    private float animationPadding;
    private float cornerRadius;
    private final List<RectF> highlightedRects;
    private final boolean isSelected;
    private int noteAnnotationViewSizePx;
    private final SearchResult searchResult;
    private int searchResultAnimationPadding;
    private int searchResultAnnotationPadding;
    private float searchResultCornerRadiusToHeightRatio;
    private int searchResultMaxCornerRadius;
    private int searchResultMinCornerRadius;
    private int searchResultPadding;

    static {
        Paint paint = new Paint();
        searchResultBackgroundPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_OVER;
        paint.setXfermode(new PorterDuffXfermode(mode));
        Paint paint2 = new Paint();
        searchResultBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setXfermode(new PorterDuffXfermode(mode));
    }

    public SearchResultDrawable(SearchResult searchResult, boolean z) {
        this.searchResult = searchResult;
        this.animateOnDraw = z;
        this.isSelected = z;
        this.highlightedRects = new ArrayList(searchResult.textBlock.pageRects.size());
        for (int i = 0; i < searchResult.textBlock.pageRects.size(); i++) {
            this.highlightedRects.add(new RectF());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPopOutAnimation$0(ValueAnimator valueAnimator) {
        this.animationPadding = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidateSelf();
    }

    private void startPopOutAnimation() {
        ValueAnimator valueAnimatorOfFloat = ObjectAnimator.ofFloat(0.0f, this.searchResultAnimationPadding);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.ui.search.SearchResultDrawable$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$startPopOutAnimation$0(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.setRepeatMode(2);
        valueAnimatorOfFloat.setRepeatCount(1);
        valueAnimatorOfFloat.start();
        invalidateSelf();
    }

    public void applyTheme(k00 k00Var, int i) {
        searchResultBackgroundPaint.setColor(k00Var.a);
        Paint paint = searchResultBorderPaint;
        paint.setColor(k00Var.b);
        paint.setStrokeWidth(k00Var.c);
        this.searchResultPadding = k00Var.d;
        this.searchResultAnnotationPadding = k00Var.e;
        this.searchResultAnimationPadding = k00Var.f;
        this.searchResultCornerRadiusToHeightRatio = k00Var.g;
        this.searchResultMinCornerRadius = k00Var.h;
        this.searchResultMaxCornerRadius = k00Var.i;
        this.noteAnnotationViewSizePx = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.animateOnDraw) {
            this.animateOnDraw = false;
            startPopOutAnimation();
        }
        for (RectF rectF : this.highlightedRects) {
            RectF rectF2 = sharedDrawRect;
            rectF2.set(rectF);
            float f = this.animationPadding;
            if (f != 0.0f) {
                float f2 = -f;
                rectF2.inset(f2, f2);
            }
            float f3 = this.cornerRadius;
            canvas.drawRoundRect(rectF2, f3, f3, searchResultBackgroundPaint);
            if (this.isSelected) {
                float f4 = this.cornerRadius;
                canvas.drawRoundRect(rectF2, f4, f4, searchResultBorderPaint);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public SearchResult getSearchResult() {
        return this.searchResult;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawable
    public void updatePdfToViewTransformation(Matrix matrix) {
        super.updatePdfToViewTransformation(matrix);
        this.cornerRadius = this.searchResultMinCornerRadius;
        RectF rectF = new RectF();
        for (int i = 0; i < this.searchResult.textBlock.pageRects.size(); i++) {
            RectF rectF2 = this.highlightedRects.get(i);
            rectF.set(this.searchResult.textBlock.pageRects.get(i));
            if (this.searchResult.annotation != null) {
                int i2 = this.searchResultAnnotationPadding;
                rectF.inset(-i2, i2);
            } else {
                int i3 = this.searchResultPadding;
                rectF.inset(-i3, i3);
            }
            rectF2.set(rectF);
            matrix.mapRect(rectF2);
            Annotation annotation = this.searchResult.annotation;
            if (annotation != null && annotation.getType() == AnnotationType.NOTE) {
                float f = (this.noteAnnotationViewSizePx / 2) + this.searchResultAnnotationPadding;
                rectF2.set(rectF2.centerX() - f, rectF2.centerY() - f, rectF2.centerX() + f, rectF2.centerY() + f);
            }
            this.cornerRadius = Math.max(this.cornerRadius, Math.max(this.searchResultMinCornerRadius, Math.min(rectF2.height() * this.searchResultCornerRadiusToHeightRatio, this.searchResultMaxCornerRadius)));
            int i4 = (int) rectF2.left;
            int i5 = (int) rectF2.top;
            int iCeil = (int) Math.ceil(rectF2.right);
            int iCeil2 = (int) Math.ceil(rectF2.bottom);
            if (i == 0) {
                getBounds().set(i4, i5, iCeil, iCeil2);
            } else {
                getBounds().union(i4, i5, iCeil, iCeil2);
            }
        }
    }
}
