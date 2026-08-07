package com.box.android.collections.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.collections.R;

/* JADX INFO: loaded from: classes10.dex */
public final class ListItemMultiSelectDialogBinding implements ViewBinding {
    public final AppCompatCheckBox multiSelectCheckbox;
    private final LinearLayout rootView;

    private ListItemMultiSelectDialogBinding(LinearLayout linearLayout, AppCompatCheckBox appCompatCheckBox) {
        this.rootView = linearLayout;
        this.multiSelectCheckbox = appCompatCheckBox;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ListItemMultiSelectDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ListItemMultiSelectDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.list_item_multi_select_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ListItemMultiSelectDialogBinding bind(View view) {
        int i = R.id.multi_select_checkbox;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, i);
        if (appCompatCheckBox != null) {
            return new ListItemMultiSelectDialogBinding((LinearLayout) view, appCompatCheckBox);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
