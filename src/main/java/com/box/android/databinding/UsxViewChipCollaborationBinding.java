package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class UsxViewChipCollaborationBinding implements ViewBinding {
    public final TextView collaboratorInitials;
    public final TextView name;
    private final RelativeLayout rootView;

    private UsxViewChipCollaborationBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.collaboratorInitials = textView;
        this.name = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static UsxViewChipCollaborationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UsxViewChipCollaborationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.usx_view_chip_collaboration, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UsxViewChipCollaborationBinding bind(View view) {
        int i = R.id.collaborator_initials;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.collaborator_initials);
        if (textView != null) {
            i = R.id.name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.name);
            if (textView2 != null) {
                return new UsxViewChipCollaborationBinding((RelativeLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
