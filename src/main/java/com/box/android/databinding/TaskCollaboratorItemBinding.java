package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.box.androidsdk.content.views.BoxAvatarView;

/* JADX INFO: loaded from: classes11.dex */
public final class TaskCollaboratorItemBinding implements ViewBinding {
    public final BoxAvatarView avatar;
    public final TextView name;
    private final ConstraintLayout rootView;
    public final TextView status;

    private TaskCollaboratorItemBinding(ConstraintLayout constraintLayout, BoxAvatarView boxAvatarView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.avatar = boxAvatarView;
        this.name = textView;
        this.status = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TaskCollaboratorItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TaskCollaboratorItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.task_collaborator_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TaskCollaboratorItemBinding bind(View view) {
        int i = R.id.avatar;
        BoxAvatarView boxAvatarView = (BoxAvatarView) ViewBindings.findChildViewById(view, R.id.avatar);
        if (boxAvatarView != null) {
            i = R.id.name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.name);
            if (textView != null) {
                i = R.id.status;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.status);
                if (textView2 != null) {
                    return new TaskCollaboratorItemBinding((ConstraintLayout) view, boxAvatarView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
