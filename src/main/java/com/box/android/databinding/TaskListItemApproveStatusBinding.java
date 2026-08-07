package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class TaskListItemApproveStatusBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView taskApproveBtn;
    public final Group taskApproveRejectBtnGroup;
    public final ImageView taskCollabStatusIcon;
    public final TextView taskCollabStatusMessage;
    public final Group taskCollabStatusViews;
    public final TextView taskRejectBtn;

    private TaskListItemApproveStatusBinding(ConstraintLayout constraintLayout, TextView textView, Group group, ImageView imageView, TextView textView2, Group group2, TextView textView3) {
        this.rootView = constraintLayout;
        this.taskApproveBtn = textView;
        this.taskApproveRejectBtnGroup = group;
        this.taskCollabStatusIcon = imageView;
        this.taskCollabStatusMessage = textView2;
        this.taskCollabStatusViews = group2;
        this.taskRejectBtn = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TaskListItemApproveStatusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TaskListItemApproveStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.task_list_item_approve_status, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TaskListItemApproveStatusBinding bind(View view) {
        int i = R.id.task_approve_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.task_approve_btn);
        if (textView != null) {
            i = R.id.task_approve_reject_btn_group;
            Group group = (Group) ViewBindings.findChildViewById(view, R.id.task_approve_reject_btn_group);
            if (group != null) {
                i = R.id.task_collab_status_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.task_collab_status_icon);
                if (imageView != null) {
                    i = R.id.task_collab_status_message;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.task_collab_status_message);
                    if (textView2 != null) {
                        i = R.id.task_collab_status_views;
                        Group group2 = (Group) ViewBindings.findChildViewById(view, R.id.task_collab_status_views);
                        if (group2 != null) {
                            i = R.id.task_reject_btn;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.task_reject_btn);
                            if (textView3 != null) {
                                return new TaskListItemApproveStatusBinding((ConstraintLayout) view, textView, group, imageView, textView2, group2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
