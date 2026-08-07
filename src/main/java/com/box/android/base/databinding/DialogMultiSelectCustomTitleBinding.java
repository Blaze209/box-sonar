package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class DialogMultiSelectCustomTitleBinding implements ViewBinding {
    public final AppCompatImageButton addItemButton;
    public final TextView dialogTitle;
    private final LinearLayout rootView;

    private DialogMultiSelectCustomTitleBinding(LinearLayout linearLayout, AppCompatImageButton appCompatImageButton, TextView textView) {
        this.rootView = linearLayout;
        this.addItemButton = appCompatImageButton;
        this.dialogTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogMultiSelectCustomTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogMultiSelectCustomTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_multi_select_custom_title, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogMultiSelectCustomTitleBinding bind(View view) {
        int i = R.id.add_item_button;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.dialog_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new DialogMultiSelectCustomTitleBinding((LinearLayout) view, appCompatImageButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
