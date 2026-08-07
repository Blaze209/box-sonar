package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxPreviewsdkViewPageNumberBinding implements ViewBinding {
    public final LinearLayout pageNumberContainer;
    public final TextView pagerNumberLabelText;
    private final LinearLayout rootView;

    private BoxPreviewsdkViewPageNumberBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.pageNumberContainer = linearLayout2;
        this.pagerNumberLabelText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BoxPreviewsdkViewPageNumberBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxPreviewsdkViewPageNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.box_previewsdk_view_page_number, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxPreviewsdkViewPageNumberBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.pagerNumberLabelText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new BoxPreviewsdkViewPageNumberBinding(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
