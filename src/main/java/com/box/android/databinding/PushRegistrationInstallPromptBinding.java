package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class PushRegistrationInstallPromptBinding implements ViewBinding {
    public final ImageView bannerImage;
    public final TextView detailHeaderText;
    public final TextView detailSubHeaderText;
    public final Button dismissButton;
    public final Button enableButton;
    public final Guideline guideline11;
    public final Guideline guideline2;
    public final Guideline guideline3;
    public final Guideline guideline4;
    public final Guideline guideline5;
    public final Guideline guideline7;
    public final TextView headerText;
    private final ConstraintLayout rootView;

    private PushRegistrationInstallPromptBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, Button button, Button button2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, TextView textView3) {
        this.rootView = constraintLayout;
        this.bannerImage = imageView;
        this.detailHeaderText = textView;
        this.detailSubHeaderText = textView2;
        this.dismissButton = button;
        this.enableButton = button2;
        this.guideline11 = guideline;
        this.guideline2 = guideline2;
        this.guideline3 = guideline3;
        this.guideline4 = guideline4;
        this.guideline5 = guideline5;
        this.guideline7 = guideline6;
        this.headerText = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PushRegistrationInstallPromptBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PushRegistrationInstallPromptBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.push_registration_install_prompt, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PushRegistrationInstallPromptBinding bind(View view) {
        int i = R.id.bannerImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.bannerImage);
        if (imageView != null) {
            i = R.id.detailHeaderText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.detailHeaderText);
            if (textView != null) {
                i = R.id.detailSubHeaderText;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.detailSubHeaderText);
                if (textView2 != null) {
                    i = R.id.dismissButton;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.dismissButton);
                    if (button != null) {
                        i = R.id.enableButton;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.enableButton);
                        if (button2 != null) {
                            i = R.id.guideline11;
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline11);
                            if (guideline != null) {
                                i = R.id.guideline2;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline2);
                                if (guideline2 != null) {
                                    i = R.id.guideline3;
                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline3);
                                    if (guideline3 != null) {
                                        i = R.id.guideline4;
                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline4);
                                        if (guideline4 != null) {
                                            i = R.id.guideline5;
                                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline5);
                                            if (guideline5 != null) {
                                                i = R.id.guideline7;
                                                Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline7);
                                                if (guideline6 != null) {
                                                    i = R.id.headerText;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.headerText);
                                                    if (textView3 != null) {
                                                        return new PushRegistrationInstallPromptBinding((ConstraintLayout) view, imageView, textView, textView2, button, button2, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, textView3);
                                                    }
                                                }
                                            }
                                        }
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
