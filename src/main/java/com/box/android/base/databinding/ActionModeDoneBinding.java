package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class ActionModeDoneBinding implements ViewBinding {
    public final ImageView actionModeCloseButton;
    private final ImageView rootView;

    private ActionModeDoneBinding(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.actionModeCloseButton = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }

    public static ActionModeDoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActionModeDoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.action_mode_done, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActionModeDoneBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ImageView imageView = (ImageView) view;
        return new ActionModeDoneBinding(imageView, imageView);
    }
}
