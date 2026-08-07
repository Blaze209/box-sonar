package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.box.android.base.presentation.views.OKCancelView;

/* JADX INFO: loaded from: classes11.dex */
public final class LayoutTitlelessConfirmBinding implements ViewBinding {
    public final TextView dialogText;
    public final OKCancelView okCancelView;
    private final LinearLayout rootView;

    private LayoutTitlelessConfirmBinding(LinearLayout linearLayout, TextView textView, OKCancelView oKCancelView) {
        this.rootView = linearLayout;
        this.dialogText = textView;
        this.okCancelView = oKCancelView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutTitlelessConfirmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutTitlelessConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_titleless_confirm, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutTitlelessConfirmBinding bind(View view) {
        int i = R.id.dialog_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_text);
        if (textView != null) {
            i = R.id.okCancelView;
            OKCancelView oKCancelView = (OKCancelView) ViewBindings.findChildViewById(view, R.id.okCancelView);
            if (oKCancelView != null) {
                return new LayoutTitlelessConfirmBinding((LinearLayout) view, textView, oKCancelView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
