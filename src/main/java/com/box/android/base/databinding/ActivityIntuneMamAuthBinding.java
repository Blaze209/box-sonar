package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class ActivityIntuneMamAuthBinding implements ViewBinding {
    public final TextView connectIntuneButton;
    public final TextView learnMoreButton;
    public final TextView logOutButton;
    public final LinearLayout logoContainer;
    private final ConstraintLayout rootView;
    public final TextView subtitleText;
    public final TextView titleText;

    private ActivityIntuneMamAuthBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.connectIntuneButton = textView;
        this.learnMoreButton = textView2;
        this.logOutButton = textView3;
        this.logoContainer = linearLayout;
        this.subtitleText = textView4;
        this.titleText = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityIntuneMamAuthBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityIntuneMamAuthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_intune_mam_auth, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityIntuneMamAuthBinding bind(View view) {
        int i = R.id.connectIntuneButton;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.learnMoreButton;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.logOutButton;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.logoContainer;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.subtitleText;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.titleText;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                return new ActivityIntuneMamAuthBinding((ConstraintLayout) view, textView, textView2, textView3, linearLayout, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
