package com.box.android.preview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.preview.R;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxPreviewSdkViewAnnotationContextMenuBinding implements ViewBinding {
    public final Button deleteComment;
    public final LinearLayout popupMenuContainer;
    private final LinearLayout rootView;
    public final Button viewComment;

    private BoxPreviewSdkViewAnnotationContextMenuBinding(LinearLayout linearLayout, Button button, LinearLayout linearLayout2, Button button2) {
        this.rootView = linearLayout;
        this.deleteComment = button;
        this.popupMenuContainer = linearLayout2;
        this.viewComment = button2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BoxPreviewSdkViewAnnotationContextMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxPreviewSdkViewAnnotationContextMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.box_preview_sdk_view_annotation_context_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxPreviewSdkViewAnnotationContextMenuBinding bind(View view) {
        int i = R.id.delete_comment;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = R.id.view_comment;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i2);
            if (button2 != null) {
                return new BoxPreviewSdkViewAnnotationContextMenuBinding(linearLayout, button, linearLayout, button2);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
