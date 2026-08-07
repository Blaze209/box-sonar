package com.box.android.preview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.box.android.preview.R;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxCanvasActivityBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private BoxCanvasActivityBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BoxCanvasActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxCanvasActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.box_canvas_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxCanvasActivityBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new BoxCanvasActivityBinding((ConstraintLayout) view);
    }
}
