package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class LayoutPincodeBinding implements ViewBinding {
    public final View center;
    public final AppCompatImageButton fingerprintButton;
    public final ImageView logo;
    public final EditText pincodeBox;
    public final TextView pincodeInstruction;
    private final RelativeLayout rootView;

    private LayoutPincodeBinding(RelativeLayout relativeLayout, View view, AppCompatImageButton appCompatImageButton, ImageView imageView, EditText editText, TextView textView) {
        this.rootView = relativeLayout;
        this.center = view;
        this.fingerprintButton = appCompatImageButton;
        this.logo = imageView;
        this.pincodeBox = editText;
        this.pincodeInstruction = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutPincodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutPincodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_pincode, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutPincodeBinding bind(View view) {
        int i = R.id.center;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            i = R.id.fingerprint_button;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton != null) {
                i = R.id.logo;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.pincodeBox;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText != null) {
                        i = R.id.pincodeInstruction;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new LayoutPincodeBinding((RelativeLayout) view, viewFindChildViewById, appCompatImageButton, imageView, editText, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
