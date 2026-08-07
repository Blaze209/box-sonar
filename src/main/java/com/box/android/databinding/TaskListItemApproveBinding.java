package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class TaskListItemApproveBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TaskListItemApproveStatusBinding taskCollaboratorStatus;
    public final TaskListItemBinding taskListCommon;

    private TaskListItemApproveBinding(ConstraintLayout constraintLayout, TaskListItemApproveStatusBinding taskListItemApproveStatusBinding, TaskListItemBinding taskListItemBinding) {
        this.rootView = constraintLayout;
        this.taskCollaboratorStatus = taskListItemApproveStatusBinding;
        this.taskListCommon = taskListItemBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TaskListItemApproveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TaskListItemApproveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.task_list_item_approve, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TaskListItemApproveBinding bind(View view) {
        int i = R.id.task_collaborator_status;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.task_collaborator_status);
        if (viewFindChildViewById != null) {
            TaskListItemApproveStatusBinding taskListItemApproveStatusBindingBind = TaskListItemApproveStatusBinding.bind(viewFindChildViewById);
            View viewFindChildViewById2 = ViewBindings.findChildViewById(view, R.id.task_list_common);
            if (viewFindChildViewById2 != null) {
                return new TaskListItemApproveBinding((ConstraintLayout) view, taskListItemApproveStatusBindingBind, TaskListItemBinding.bind(viewFindChildViewById2));
            }
            i = R.id.task_list_common;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
