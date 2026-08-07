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

/* JADX INFO: loaded from: classes11.dex */
public final class UsxPasswordEditTextBinding implements ViewBinding {
    public final EditText boxPasswordEditText;
    public final TextView boxPasswordErrorMessage;
    private final LinearLayout rootView;

    private UsxPasswordEditTextBinding(LinearLayout linearLayout, EditText editText, TextView textView) {
        this.rootView = linearLayout;
        this.boxPasswordEditText = editText;
        this.boxPasswordErrorMessage = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UsxPasswordEditTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UsxPasswordEditTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.usx_password_edit_text, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UsxPasswordEditTextBinding bind(View view) {
        int i = R.id.box_password_edit_text;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.box_password_edit_text);
        if (editText != null) {
            i = R.id.box_password_error_message;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.box_password_error_message);
            if (textView != null) {
                return new UsxPasswordEditTextBinding((LinearLayout) view, editText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
