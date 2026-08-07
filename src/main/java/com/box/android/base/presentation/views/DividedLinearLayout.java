package com.box.android.base.presentation.views;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.box.android.base.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class DividedLinearLayout extends LinearLayout {
    private static final String EXTRA_INSTANCE_STATE = "instanceState";
    private static final String EXTRA_IS_FULLSCREENED = "extraIsFullScreened";
    private int mDividerId;
    private float mDividerPercentage;
    private View mDividerView;
    private final ArrayList<View> mFirstChildViews;
    private final float mOriginalDividerPercentage;
    private View mParentView;
    private final ArrayList<View> mSecondChildViews;

    public DividedLinearLayout(Context context) {
        super(context);
        this.mFirstChildViews = new ArrayList<>(2);
        this.mSecondChildViews = new ArrayList<>(2);
        this.mOriginalDividerPercentage = 0.5f;
    }

    public DividedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFirstChildViews = new ArrayList<>(2);
        this.mSecondChildViews = new ArrayList<>(2);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DividedLinearLayout, 0, 0);
        try {
            float f = typedArrayObtainStyledAttributes.getFloat(R.styleable.DividedLinearLayout_dividePercentage, 0.5f);
            this.mOriginalDividerPercentage = f;
            this.mDividerPercentage = f;
            this.mDividerId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DividedLinearLayout_dividedDivider, -1);
            typedArrayObtainStyledAttributes.recycle();
            if (this.mDividerId == -1) {
                throw new RuntimeException("No Divider Id provided");
            }
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setDividerPercentage(float f) {
        this.mDividerPercentage = f;
    }

    private boolean isHorizontal() {
        return getOrientation() == 0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 0 || mode2 == 0) {
            throw new RuntimeException("DividerLinearLayout cannot have UNSPECIFIED dimensions");
        }
        measureChild(getDivider(), i, i2);
        int measuredWidth = getDivider().getMeasuredWidth();
        int measuredHeight = getDivider().getMeasuredHeight();
        boolean z = true;
        if (!isHorizontal()) {
            int i3 = measuredHeight / 2;
            int size3 = getFirstViews().size() == 0 ? 0 : ((int) ((size2 * this.mDividerPercentage) - i3)) / getFirstViews().size();
            int size4 = getSecondViews().size() == 0 ? 0 : (size2 - size3) - (i3 / getSecondViews().size());
            if (size3 < 0) {
                size3 = 0;
            }
            if (size4 < 0) {
                size4 = 0;
            }
            if (size3 != 0 && size4 != 0) {
                z = false;
            }
            Iterator<View> it = getFirstViews().iterator();
            while (it.hasNext()) {
                measureChild(it.next(), i, View.MeasureSpec.makeMeasureSpec(size3, 1073741824));
            }
            Iterator<View> it2 = getSecondViews().iterator();
            while (it2.hasNext()) {
                measureChild(it2.next(), i, View.MeasureSpec.makeMeasureSpec(size4, 1073741824));
            }
        } else {
            int i4 = measuredWidth / 2;
            int size5 = getFirstViews().size() == 0 ? 0 : ((int) ((size * this.mDividerPercentage) - i4)) / getFirstViews().size();
            int size6 = getSecondViews().size() == 0 ? 0 : ((size - size5) - i4) / getSecondViews().size();
            if (size5 < 0) {
                size5 = 0;
            }
            if (size6 < 0) {
                size6 = 0;
            }
            if (size5 != 0 && size6 != 0) {
                z = false;
            }
            Iterator<View> it3 = getFirstViews().iterator();
            while (it3.hasNext()) {
                measureChild(it3.next(), View.MeasureSpec.makeMeasureSpec(size5, 1073741824), i2);
            }
            Iterator<View> it4 = getSecondViews().iterator();
            while (it4.hasNext()) {
                measureChild(it4.next(), View.MeasureSpec.makeMeasureSpec(size6, 1073741824), i2);
            }
        }
        if (z) {
            getDivider().setVisibility(8);
        } else if (getDivider().getVisibility() == 8) {
            getDivider().setVisibility(0);
        }
        setMeasuredDimension(size, size2);
    }

    private View getDivider() {
        return this.mDividerView;
    }

    private List<View> getFirstViews() {
        return this.mFirstChildViews;
    }

    private List<View> getSecondViews() {
        return this.mSecondChildViews;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof View) {
            this.mParentView = (View) getParent();
        }
        View viewFindViewById = findViewById(this.mDividerId);
        this.mDividerView = viewFindViewById;
        if (viewFindViewById == null) {
            throw new RuntimeException("No Divider Could be found with given id");
        }
        boolean z = false;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt == this.mDividerView) {
                z = true;
            } else if (!z) {
                this.mFirstChildViews.add(childAt);
            } else {
                this.mSecondChildViews.add(childAt);
            }
        }
    }

    public void openFirstDivision() {
        if (this.mDividerPercentage == this.mOriginalDividerPercentage) {
            return;
        }
        View view = this.mParentView;
        final Drawable background = view == null ? null : view.getBackground();
        View view2 = this.mParentView;
        if (view2 != null) {
            view2.setBackgroundColor(-16777216);
        }
        animate().alpha(0.01f).setListener(new Animator.AnimatorListener() { // from class: com.box.android.base.presentation.views.DividedLinearLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DividedLinearLayout dividedLinearLayout = DividedLinearLayout.this;
                dividedLinearLayout.setDividerPercentage(dividedLinearLayout.mOriginalDividerPercentage);
                DividedLinearLayout.this.setScaleX(1.0f);
                DividedLinearLayout.this.setScaleY(1.0f);
                DividedLinearLayout.this.requestLayout();
                DividedLinearLayout.this.animate().alpha(1.0f).setListener(DividedLinearLayout.createEndListener(new Runnable() { // from class: com.box.android.base.presentation.views.DividedLinearLayout.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DividedLinearLayout.this.mParentView != null) {
                            DividedLinearLayout.this.mParentView.setBackgroundDrawable(background);
                        }
                    }
                }));
            }
        });
    }

    private float getFirstDivisionWidth() {
        return (getMeasuredWidth() - getDivider().getMeasuredWidth()) * this.mDividerPercentage;
    }

    private float getFirstDivisionHeight() {
        return (getMeasuredHeight() - getDivider().getMeasuredHeight()) * this.mDividerPercentage;
    }

    public void closeFirstDivision() {
        if (isHorizontal()) {
            closeFirstDivisionHorizontal();
        } else {
            closeFirstDivisionVertical();
        }
    }

    private void closeFirstDivisionVertical() {
        if (this.mDividerPercentage == 0.0f) {
            return;
        }
        View view = this.mParentView;
        final Drawable background = view == null ? null : view.getBackground();
        View view2 = this.mParentView;
        if (view2 != null) {
            view2.setBackgroundColor(-16777216);
        }
        animate().alpha(0.0f).scaleY(2.0f - this.mDividerPercentage).y(-getFirstDivisionHeight()).setListener(createEndListener(new Runnable() { // from class: com.box.android.base.presentation.views.DividedLinearLayout.2
            @Override // java.lang.Runnable
            public void run() {
                DividedLinearLayout.this.setY(0.0f);
                DividedLinearLayout.this.setScaleY(1.0f);
                DividedLinearLayout.this.setDividerPercentage(0.0f);
                DividedLinearLayout.this.requestLayout();
                DividedLinearLayout.this.animate().alpha(1.0f).setListener(DividedLinearLayout.createEndListener(new Runnable() { // from class: com.box.android.base.presentation.views.DividedLinearLayout.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DividedLinearLayout.this.mParentView != null) {
                            DividedLinearLayout.this.mParentView.setBackgroundDrawable(background);
                        }
                    }
                }));
            }
        }));
    }

    private void closeFirstDivisionHorizontal() {
        View view = this.mParentView;
        final Drawable background = view == null ? null : view.getBackground();
        View view2 = this.mParentView;
        if (view2 != null) {
            view2.setBackgroundColor(-16777216);
        }
        animate().alpha(0.0f).scaleX(2.0f - this.mDividerPercentage).x(-getFirstDivisionWidth()).setListener(createEndListener(new Runnable() { // from class: com.box.android.base.presentation.views.DividedLinearLayout.3
            @Override // java.lang.Runnable
            public void run() {
                DividedLinearLayout.this.setX(0.0f);
                DividedLinearLayout.this.setScaleX(1.0f);
                DividedLinearLayout.this.setDividerPercentage(0.0f);
                DividedLinearLayout.this.requestLayout();
                DividedLinearLayout.this.animate().alpha(1.0f).setListener(DividedLinearLayout.createEndListener(new Runnable() { // from class: com.box.android.base.presentation.views.DividedLinearLayout.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DividedLinearLayout.this.mParentView != null) {
                            DividedLinearLayout.this.mParentView.setBackgroundDrawable(background);
                        }
                    }
                }));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Animator.AnimatorListener createEndListener(final Runnable runnable) {
        return new Animator.AnimatorListener() { // from class: com.box.android.base.presentation.views.DividedLinearLayout.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                runnable.run();
            }
        };
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_INSTANCE_STATE, super.onSaveInstanceState());
        bundle.putBoolean(EXTRA_IS_FULLSCREENED, this.mDividerPercentage == 0.0f);
        return bundle;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (bundle.getBoolean(EXTRA_IS_FULLSCREENED, false)) {
                this.mDividerPercentage = 0.0f;
            }
            super.onRestoreInstanceState(bundle.getParcelable(EXTRA_INSTANCE_STATE));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mDividerView = null;
        this.mFirstChildViews.clear();
        this.mSecondChildViews.clear();
    }
}
