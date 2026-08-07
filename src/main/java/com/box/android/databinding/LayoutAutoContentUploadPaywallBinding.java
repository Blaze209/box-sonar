package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.box.android.base.presentation.views.OKCancelView;

/* JADX INFO: loaded from: classes11.dex */
public final class LayoutAutoContentUploadPaywallBinding implements ViewBinding {
    public final LinearLayout dialogContainer;
    public final OKCancelView okCancelView;
    public final ImageView paywallAutoContentUploadIcon;
    public final TextView paywallAutoContentUploadText;
    public final ImageView paywallStorageSpaceIcon;
    public final TextView paywallStorageSpaceText;
    public final ImageView paywallUploadLimitIcon;
    public final TextView paywallUploadLimitText;
    private final LinearLayout rootView;

    private LayoutAutoContentUploadPaywallBinding(LinearLayout linearLayout, LinearLayout linearLayout2, OKCancelView oKCancelView, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, ImageView imageView3, TextView textView3) {
        this.rootView = linearLayout;
        this.dialogContainer = linearLayout2;
        this.okCancelView = oKCancelView;
        this.paywallAutoContentUploadIcon = imageView;
        this.paywallAutoContentUploadText = textView;
        this.paywallStorageSpaceIcon = imageView2;
        this.paywallStorageSpaceText = textView2;
        this.paywallUploadLimitIcon = imageView3;
        this.paywallUploadLimitText = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutAutoContentUploadPaywallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutAutoContentUploadPaywallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_auto_content_upload_paywall, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutAutoContentUploadPaywallBinding bind(View view) {
        int i = R.id.dialog_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.dialog_container);
        if (linearLayout != null) {
            i = R.id.okCancelView;
            OKCancelView oKCancelView = (OKCancelView) ViewBindings.findChildViewById(view, R.id.okCancelView);
            if (oKCancelView != null) {
                i = R.id.paywallAutoContentUploadIcon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.paywallAutoContentUploadIcon);
                if (imageView != null) {
                    i = R.id.paywallAutoContentUploadText;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.paywallAutoContentUploadText);
                    if (textView != null) {
                        i = R.id.paywallStorageSpaceIcon;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.paywallStorageSpaceIcon);
                        if (imageView2 != null) {
                            i = R.id.paywallStorageSpaceText;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.paywallStorageSpaceText);
                            if (textView2 != null) {
                                i = R.id.paywallUploadLimitIcon;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.paywallUploadLimitIcon);
                                if (imageView3 != null) {
                                    i = R.id.paywallUploadLimitText;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.paywallUploadLimitText);
                                    if (textView3 != null) {
                                        return new LayoutAutoContentUploadPaywallBinding((LinearLayout) view, linearLayout, oKCancelView, imageView, textView, imageView2, textView2, imageView3, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
