package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class DialogUploadProgBinding implements ViewBinding {
    public final LinearLayout dialogContainer;
    public final TextView loadName;
    public final ProgressBar progressHorizontal;
    private final LinearLayout rootView;

    private DialogUploadProgBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.dialogContainer = linearLayout2;
        this.loadName = textView;
        this.progressHorizontal = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogUploadProgBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogUploadProgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_upload_prog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogUploadProgBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.load_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.load_name);
        if (textView != null) {
            i = R.id.progress_horizontal;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress_horizontal);
            if (progressBar != null) {
                return new DialogUploadProgBinding(linearLayout, linearLayout, textView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
