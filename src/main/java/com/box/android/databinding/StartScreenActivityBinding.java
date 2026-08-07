package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class StartScreenActivityBinding implements ViewBinding {
    public final AppCompatImageButton configurationOptionsButton;
    public final TextView loginButton;
    public final ImageView logo;
    public final TextView newToBoxButton;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;

    private StartScreenActivityBinding(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, TextView textView, ImageView imageView, TextView textView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.configurationOptionsButton = appCompatImageButton;
        this.loginButton = textView;
        this.logo = imageView;
        this.newToBoxButton = textView2;
        this.root = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StartScreenActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static StartScreenActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.start_screen_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static StartScreenActivityBinding bind(View view) {
        int i = R.id.configurationOptionsButton;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, R.id.configurationOptionsButton);
        if (appCompatImageButton != null) {
            i = R.id.loginButton;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.loginButton);
            if (textView != null) {
                i = R.id.logo;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.logo);
                if (imageView != null) {
                    i = R.id.newToBoxButton;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.newToBoxButton);
                    if (textView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        return new StartScreenActivityBinding(constraintLayout, appCompatImageButton, textView, imageView, textView2, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
