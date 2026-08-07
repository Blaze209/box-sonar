package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.box.android.base.presentation.views.ToolbarWithOverlayWarning;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes11.dex */
public final class EmailSupportLayoutBinding implements ViewBinding {
    public final TextView attachLogFileSubtext;
    public final AppCompatCheckBox attachLogFilesCheckBox;
    public final TextInputLayout inputLayoutName;
    public final TextInputEditText msgBody;
    private final CoordinatorLayout rootView;
    public final ToolbarWithOverlayWarning toolbarSupport;

    private EmailSupportLayoutBinding(CoordinatorLayout coordinatorLayout, TextView textView, AppCompatCheckBox appCompatCheckBox, TextInputLayout textInputLayout, TextInputEditText textInputEditText, ToolbarWithOverlayWarning toolbarWithOverlayWarning) {
        this.rootView = coordinatorLayout;
        this.attachLogFileSubtext = textView;
        this.attachLogFilesCheckBox = appCompatCheckBox;
        this.inputLayoutName = textInputLayout;
        this.msgBody = textInputEditText;
        this.toolbarSupport = toolbarWithOverlayWarning;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static EmailSupportLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EmailSupportLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.email_support_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EmailSupportLayoutBinding bind(View view) {
        int i = R.id.attachLogFileSubtext;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.attachLogFileSubtext);
        if (textView != null) {
            i = R.id.attachLogFilesCheckBox;
            AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, R.id.attachLogFilesCheckBox);
            if (appCompatCheckBox != null) {
                i = R.id.input_layout_name;
                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.input_layout_name);
                if (textInputLayout != null) {
                    i = R.id.msgBody;
                    TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.msgBody);
                    if (textInputEditText != null) {
                        i = R.id.toolbarSupport;
                        ToolbarWithOverlayWarning toolbarWithOverlayWarning = (ToolbarWithOverlayWarning) ViewBindings.findChildViewById(view, R.id.toolbarSupport);
                        if (toolbarWithOverlayWarning != null) {
                            return new EmailSupportLayoutBinding((CoordinatorLayout) view, textView, appCompatCheckBox, textInputLayout, textInputEditText, toolbarWithOverlayWarning);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
