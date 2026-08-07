package com.box.android.preview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.preview.R;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxPreviewSdkCreateAnnotationContextMenuBinding implements ViewBinding {
    public final LinearLayout popupMenuContainer;
    public final AppCompatImageButton redo;
    public final AppCompatImageButton remove;
    private final LinearLayout rootView;
    public final AppCompatButton saveComment;
    public final AppCompatImageButton undo;

    private BoxPreviewSdkCreateAnnotationContextMenuBinding(LinearLayout linearLayout, LinearLayout linearLayout2, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, AppCompatButton appCompatButton, AppCompatImageButton appCompatImageButton3) {
        this.rootView = linearLayout;
        this.popupMenuContainer = linearLayout2;
        this.redo = appCompatImageButton;
        this.remove = appCompatImageButton2;
        this.saveComment = appCompatButton;
        this.undo = appCompatImageButton3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BoxPreviewSdkCreateAnnotationContextMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxPreviewSdkCreateAnnotationContextMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.box_preview_sdk_create_annotation_context_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxPreviewSdkCreateAnnotationContextMenuBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.redo;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.remove;
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton2 != null) {
                i = R.id.save_comment;
                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                if (appCompatButton != null) {
                    i = R.id.undo;
                    AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageButton3 != null) {
                        return new BoxPreviewSdkCreateAnnotationContextMenuBinding(linearLayout, linearLayout, appCompatImageButton, appCompatImageButton2, appCompatButton, appCompatImageButton3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
