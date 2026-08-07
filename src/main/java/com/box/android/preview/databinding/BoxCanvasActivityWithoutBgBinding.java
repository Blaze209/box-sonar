package com.box.android.preview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.box.android.preview.R;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxCanvasActivityWithoutBgBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private BoxCanvasActivityWithoutBgBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BoxCanvasActivityWithoutBgBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxCanvasActivityWithoutBgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.box_canvas_activity_without_bg, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxCanvasActivityWithoutBgBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new BoxCanvasActivityWithoutBgBinding((ConstraintLayout) view);
    }
}
