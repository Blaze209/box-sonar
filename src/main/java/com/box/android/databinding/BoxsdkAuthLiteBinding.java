package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.box.android.base.presentation.views.BoxSDKOAuthWebView;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxsdkAuthLiteBinding implements ViewBinding {
    public final FrameLayout oauthContainer;
    public final BoxSDKOAuthWebView oauthview;
    private final FrameLayout rootView;

    private BoxsdkAuthLiteBinding(FrameLayout frameLayout, FrameLayout frameLayout2, BoxSDKOAuthWebView boxSDKOAuthWebView) {
        this.rootView = frameLayout;
        this.oauthContainer = frameLayout2;
        this.oauthview = boxSDKOAuthWebView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BoxsdkAuthLiteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxsdkAuthLiteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.boxsdk_auth_lite, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxsdkAuthLiteBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        BoxSDKOAuthWebView boxSDKOAuthWebView = (BoxSDKOAuthWebView) ViewBindings.findChildViewById(view, R.id.oauthview);
        if (boxSDKOAuthWebView != null) {
            return new BoxsdkAuthLiteBinding(frameLayout, frameLayout, boxSDKOAuthWebView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.oauthview)));
    }
}
