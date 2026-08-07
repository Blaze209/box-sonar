package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class ShieldBlockedStateViewBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final LinearLayout shieldBlockedStateContainer;
    public final ImageView shieldBlockedStateImage;
    public final TextView shieldBlockedStateText;

    private ShieldBlockedStateViewBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.shieldBlockedStateContainer = linearLayout2;
        this.shieldBlockedStateImage = imageView;
        this.shieldBlockedStateText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ShieldBlockedStateViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ShieldBlockedStateViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.shield_blocked_state_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ShieldBlockedStateViewBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.shield_blocked_state_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.shield_blocked_state_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new ShieldBlockedStateViewBinding(linearLayout, linearLayout, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
