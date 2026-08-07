package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class SortOrderMenuHeaderBinding implements ViewBinding {
    private final TextView rootView;

    private SortOrderMenuHeaderBinding(TextView textView) {
        this.rootView = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static SortOrderMenuHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SortOrderMenuHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.sort_order_menu_header, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SortOrderMenuHeaderBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new SortOrderMenuHeaderBinding((TextView) view);
    }
}
