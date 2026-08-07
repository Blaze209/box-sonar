package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;
import com.box.androidsdk.content.views.BoxAvatarView;

/* JADX INFO: loaded from: classes9.dex */
public final class ViewInitialsBinding implements ViewBinding {
    public final BoxAvatarView collaboratorInitials;
    private final LinearLayout rootView;

    private ViewInitialsBinding(LinearLayout linearLayout, BoxAvatarView boxAvatarView) {
        this.rootView = linearLayout;
        this.collaboratorInitials = boxAvatarView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewInitialsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewInitialsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_initials, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewInitialsBinding bind(View view) {
        int i = R.id.collaborator_initials;
        BoxAvatarView boxAvatarView = (BoxAvatarView) ViewBindings.findChildViewById(view, i);
        if (boxAvatarView != null) {
            return new ViewInitialsBinding((LinearLayout) view, boxAvatarView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
