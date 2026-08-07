package com.box.android.preview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.preview.R;

/* JADX INFO: loaded from: classes12.dex */
public final class ColorPickerLayoutBinding implements ViewBinding {
    public final GridView colorPickerGrid;
    private final LinearLayout rootView;

    private ColorPickerLayoutBinding(LinearLayout linearLayout, GridView gridView) {
        this.rootView = linearLayout;
        this.colorPickerGrid = gridView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ColorPickerLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ColorPickerLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.color_picker_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ColorPickerLayoutBinding bind(View view) {
        int i = R.id.color_picker_grid;
        GridView gridView = (GridView) ViewBindings.findChildViewById(view, i);
        if (gridView != null) {
            return new ColorPickerLayoutBinding((LinearLayout) view, gridView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
