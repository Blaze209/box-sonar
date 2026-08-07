package com.box.android.base.presentation.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class FloatingActionMenuBehavior extends CoordinatorLayout.Behavior {
    private float mTranslationY;

    public FloatingActionMenuBehavior(Context context, AttributeSet attributeSet) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof Snackbar.SnackbarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (!(view instanceof FloatingActionMenu) || !(view2 instanceof Snackbar.SnackbarLayout)) {
            return false;
        }
        updateTranslation(coordinatorLayout, view, view2);
        return false;
    }

    private void updateTranslation(CoordinatorLayout coordinatorLayout, View view, View view2) {
        float translationY = getTranslationY(coordinatorLayout, view);
        if (translationY != this.mTranslationY) {
            ViewCompat.animate(view).cancel();
            if (Math.abs(translationY - this.mTranslationY) == view2.getHeight()) {
                ViewCompat.animate(view).translationY(translationY).setListener(null);
            } else {
                ViewCompat.setTranslationY(view, translationY);
            }
            this.mTranslationY = translationY;
        }
    }

    private float getTranslationY(CoordinatorLayout coordinatorLayout, View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        float fMin = 0.0f;
        for (int i = 0; i < size; i++) {
            View view2 = dependencies.get(i);
            if ((view2 instanceof Snackbar.SnackbarLayout) && coordinatorLayout.doViewsOverlap(view, view2)) {
                fMin = Math.min(fMin, ViewCompat.getTranslationY(view2) - view2.getHeight());
            }
        }
        return fMin;
    }
}
