package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.box.androidsdk.content.views.BoxAvatarView;

/* JADX INFO: loaded from: classes11.dex */
public final class UsxViewInitialsBinding implements ViewBinding {
    public final BoxAvatarView collaboratorInitials;
    private final LinearLayout rootView;

    private UsxViewInitialsBinding(LinearLayout linearLayout, BoxAvatarView boxAvatarView) {
        this.rootView = linearLayout;
        this.collaboratorInitials = boxAvatarView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UsxViewInitialsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UsxViewInitialsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.usx_view_initials, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UsxViewInitialsBinding bind(View view) {
        BoxAvatarView boxAvatarView = (BoxAvatarView) ViewBindings.findChildViewById(view, R.id.collaborator_initials);
        if (boxAvatarView != null) {
            return new UsxViewInitialsBinding((LinearLayout) view, boxAvatarView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.collaborator_initials)));
    }
}
