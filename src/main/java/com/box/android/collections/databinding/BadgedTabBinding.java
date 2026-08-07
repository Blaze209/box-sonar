package com.box.android.collections.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.collections.R;

/* JADX INFO: loaded from: classes10.dex */
public final class BadgedTabBinding implements ViewBinding {
    public final TextView badge;
    private final LinearLayout rootView;
    public final TextView text1;

    private BadgedTabBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.badge = textView;
        this.text1 = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BadgedTabBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BadgedTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.badged_tab, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BadgedTabBinding bind(View view) {
        int i = R.id.badge;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = android.R.id.text1;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, android.R.id.text1);
            if (textView2 != null) {
                return new BadgedTabBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
