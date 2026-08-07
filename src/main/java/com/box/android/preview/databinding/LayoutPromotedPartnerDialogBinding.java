package com.box.android.preview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.preview.R;

/* JADX INFO: loaded from: classes12.dex */
public final class LayoutPromotedPartnerDialogBinding implements ViewBinding {
    public final TextView dialogMessage;
    public final TextView dialogTitle;
    public final ImageView partnerImage;
    private final LinearLayout rootView;

    private LayoutPromotedPartnerDialogBinding(LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView) {
        this.rootView = linearLayout;
        this.dialogMessage = textView;
        this.dialogTitle = textView2;
        this.partnerImage = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutPromotedPartnerDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutPromotedPartnerDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_promoted_partner_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutPromotedPartnerDialogBinding bind(View view) {
        int i = R.id.dialog_message;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.dialog_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.partner_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    return new LayoutPromotedPartnerDialogBinding((LinearLayout) view, textView, textView2, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
