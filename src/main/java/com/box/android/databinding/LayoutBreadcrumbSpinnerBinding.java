package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class LayoutBreadcrumbSpinnerBinding implements ViewBinding {
    public final TextView breadcrumbTextview;
    private final TextView rootView;

    private LayoutBreadcrumbSpinnerBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.breadcrumbTextview = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static LayoutBreadcrumbSpinnerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutBreadcrumbSpinnerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_breadcrumb_spinner, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutBreadcrumbSpinnerBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new LayoutBreadcrumbSpinnerBinding(textView, textView);
    }
}
