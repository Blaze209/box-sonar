package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class SharedLinkPasswordBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final AppCompatEditText sharedLinkPassword;

    private SharedLinkPasswordBinding(FrameLayout frameLayout, AppCompatEditText appCompatEditText) {
        this.rootView = frameLayout;
        this.sharedLinkPassword = appCompatEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static SharedLinkPasswordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SharedLinkPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.shared_link_password, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SharedLinkPasswordBinding bind(View view) {
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.shared_link_password);
        if (appCompatEditText != null) {
            return new SharedLinkPasswordBinding((FrameLayout) view, appCompatEditText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.shared_link_password)));
    }
}
