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
public final class TaskListItemGeneralStatusBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ImageView taskCollabStatusIcon;
    public final TextView taskCompleteAction;
    public final TextView taskCompleteMessage;

    private TaskListItemGeneralStatusBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.taskCollabStatusIcon = imageView;
        this.taskCompleteAction = textView;
        this.taskCompleteMessage = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TaskListItemGeneralStatusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TaskListItemGeneralStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.task_list_item_general_status, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TaskListItemGeneralStatusBinding bind(View view) {
        int i = R.id.task_collab_status_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.task_collab_status_icon);
        if (imageView != null) {
            i = R.id.task_complete_action;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.task_complete_action);
            if (textView != null) {
                i = R.id.task_complete_message;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.task_complete_message);
                if (textView2 != null) {
                    return new TaskListItemGeneralStatusBinding((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
