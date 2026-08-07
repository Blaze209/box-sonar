package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.box.android.browse.R;

/* JADX INFO: loaded from: classes10.dex */
public final class PickerToolbarBinding implements ViewBinding {
    private final Toolbar rootView;

    private PickerToolbarBinding(Toolbar toolbar) {
        this.rootView = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public Toolbar getRoot() {
        return this.rootView;
    }

    public static PickerToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PickerToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.picker_toolbar, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PickerToolbarBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new PickerToolbarBinding((Toolbar) view);
    }
}
