package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.box.androidsdk.content.views.BoxAvatarView;

/* JADX INFO: loaded from: classes11.dex */
public final class LayoutMenuAvatarBinding implements ViewBinding {
    public final BoxAvatarView avatarView;
    private final FrameLayout rootView;

    private LayoutMenuAvatarBinding(FrameLayout frameLayout, BoxAvatarView boxAvatarView) {
        this.rootView = frameLayout;
        this.avatarView = boxAvatarView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutMenuAvatarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutMenuAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_menu_avatar, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutMenuAvatarBinding bind(View view) {
        BoxAvatarView boxAvatarView = (BoxAvatarView) ViewBindings.findChildViewById(view, R.id.avatar_view);
        if (boxAvatarView != null) {
            return new LayoutMenuAvatarBinding((FrameLayout) view, boxAvatarView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.avatar_view)));
    }
}
