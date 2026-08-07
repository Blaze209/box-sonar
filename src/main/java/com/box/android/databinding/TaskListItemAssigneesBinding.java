package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class TaskListItemAssigneesBinding implements ViewBinding {
    public final TextView assigneeCount;
    public final ImageView assigneeLogo;
    private final ConstraintLayout rootView;

    private TaskListItemAssigneesBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView) {
        this.rootView = constraintLayout;
        this.assigneeCount = textView;
        this.assigneeLogo = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TaskListItemAssigneesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TaskListItemAssigneesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.task_list_item_assignees, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TaskListItemAssigneesBinding bind(View view) {
        int i = R.id.assignee_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.assignee_count);
        if (textView != null) {
            i = R.id.assignee_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.assignee_logo);
            if (imageView != null) {
                return new TaskListItemAssigneesBinding((ConstraintLayout) view, textView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
