package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.box.android.base.presentation.views.OKCancelView;

/* JADX INFO: loaded from: classes11.dex */
public final class LayoutEdittextDialogBinding implements ViewBinding {
    public final EditText dialogEditText;
    public final TextView dialogExtensionText;
    public final TextView dialogTitle;
    public final TextView errorText;
    public final OKCancelView okCancelView;
    private final LinearLayout rootView;

    private LayoutEdittextDialogBinding(LinearLayout linearLayout, EditText editText, TextView textView, TextView textView2, TextView textView3, OKCancelView oKCancelView) {
        this.rootView = linearLayout;
        this.dialogEditText = editText;
        this.dialogExtensionText = textView;
        this.dialogTitle = textView2;
        this.errorText = textView3;
        this.okCancelView = oKCancelView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutEdittextDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutEdittextDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_edittext_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutEdittextDialogBinding bind(View view) {
        int i = R.id.dialog_edit_text;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.dialog_edit_text);
        if (editText != null) {
            i = R.id.dialog_extension_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_extension_text);
            if (textView != null) {
                i = R.id.dialog_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_title);
                if (textView2 != null) {
                    i = R.id.error_text;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.error_text);
                    if (textView3 != null) {
                        i = R.id.okCancelView;
                        OKCancelView oKCancelView = (OKCancelView) ViewBindings.findChildViewById(view, R.id.okCancelView);
                        if (oKCancelView != null) {
                            return new LayoutEdittextDialogBinding((LinearLayout) view, editText, textView, textView2, textView3, oKCancelView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
