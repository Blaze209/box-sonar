package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class ActionModeCloseBinding implements ViewBinding {
    public final ImageView actionModeCloseButton;
    private final ImageView rootView;

    private ActionModeCloseBinding(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.actionModeCloseButton = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }

    public static ActionModeCloseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActionModeCloseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.action_mode_close, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActionModeCloseBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ImageView imageView = (ImageView) view;
        return new ActionModeCloseBinding(imageView, imageView);
    }
}
