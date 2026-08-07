package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class LayoutBreadcrumbSpinnerLegacyBinding implements ViewBinding {
    public final TextView breadcrumbTextview;
    private final TextView rootView;

    private LayoutBreadcrumbSpinnerLegacyBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.breadcrumbTextview = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static LayoutBreadcrumbSpinnerLegacyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutBreadcrumbSpinnerLegacyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_breadcrumb_spinner_legacy, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutBreadcrumbSpinnerLegacyBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new LayoutBreadcrumbSpinnerLegacyBinding(textView, textView);
    }
}
