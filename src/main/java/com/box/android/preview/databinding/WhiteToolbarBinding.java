package com.box.android.preview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.box.android.preview.R;

/* JADX INFO: loaded from: classes12.dex */
public final class WhiteToolbarBinding implements ViewBinding {
    private final Toolbar rootView;

    private WhiteToolbarBinding(Toolbar toolbar) {
        this.rootView = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public Toolbar getRoot() {
        return this.rootView;
    }

    public static WhiteToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WhiteToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.white_toolbar, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static WhiteToolbarBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new WhiteToolbarBinding((Toolbar) view);
    }
}
