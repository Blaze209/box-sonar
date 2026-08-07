package com.box.android.base.views.behavior;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes9.dex */
public class ScrollDisappearBehavior extends CoordinatorLayout.Behavior<ViewGroup> {
    private boolean mIsAnimated;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, ViewGroup viewGroup, View view, View view2, int i) {
        return true;
    }

    public ScrollDisappearBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsAnimated = false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, final ViewGroup viewGroup, View view, int i, int i2, int i3, int i4) {
        super.onNestedScroll(coordinatorLayout, viewGroup, view, i, i2, i3, i4);
        if (i2 > 0 && !this.mIsAnimated && viewGroup.getVisibility() == 0) {
            this.mIsAnimated = true;
            viewGroup.animate().alpha(0.0f).translationYBy(viewGroup.getHeight()).setListener(new Animator.AnimatorListener() { // from class: com.box.android.base.views.behavior.ScrollDisappearBehavior.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ScrollDisappearBehavior.this.mIsAnimated = false;
                    viewGroup.setVisibility(4);
                    viewGroup.setAlpha(1.0f);
                    viewGroup.setTranslationY(0.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    ScrollDisappearBehavior.this.mIsAnimated = false;
                }
            }).start();
        } else {
            if (i2 >= 0 || this.mIsAnimated || viewGroup.getVisibility() == 0) {
                return;
            }
            this.mIsAnimated = true;
            viewGroup.setTranslationY(viewGroup.getHeight());
            viewGroup.setAlpha(0.0f);
            viewGroup.setVisibility(0);
            viewGroup.animate().alpha(1.0f).translationYBy(viewGroup.getHeight() * (-1)).setListener(new Animator.AnimatorListener() { // from class: com.box.android.base.views.behavior.ScrollDisappearBehavior.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ScrollDisappearBehavior.this.mIsAnimated = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    ScrollDisappearBehavior.this.mIsAnimated = false;
                }
            }).start();
        }
    }
}
