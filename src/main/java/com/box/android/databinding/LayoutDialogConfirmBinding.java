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
public final class LayoutDialogConfirmBinding implements ViewBinding {
    public final TextView dialogText;
    public final TextView dialogTitle;
    public final OKCancelView okCancelView;
    private final LinearLayout rootView;

    private LayoutDialogConfirmBinding(LinearLayout linearLayout, TextView textView, TextView textView2, OKCancelView oKCancelView) {
        this.rootView = linearLayout;
        this.dialogText = textView;
        this.dialogTitle = textView2;
        this.okCancelView = oKCancelView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDialogConfirmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutDialogConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_dialog_confirm, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutDialogConfirmBinding bind(View view) {
        int i = R.id.dialog_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_text);
        if (textView != null) {
            i = R.id.dialog_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_title);
            if (textView2 != null) {
                i = R.id.okCancelView;
                OKCancelView oKCancelView = (OKCancelView) ViewBindings.findChildViewById(view, R.id.okCancelView);
                if (oKCancelView != null) {
                    return new LayoutDialogConfirmBinding((LinearLayout) view, textView, textView2, oKCancelView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
