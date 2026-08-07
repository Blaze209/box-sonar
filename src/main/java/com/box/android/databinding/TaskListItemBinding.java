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
public final class TaskListItemBinding implements ViewBinding {
    public final TextView dueDateLabel;
    private final ConstraintLayout rootView;
    public final TextView statusField;
    public final TaskListItemAssigneesBinding taskAssignees;
    public final BoxAvatarView taskAvatar;
    public final TextView taskCreationDate;
    public final TextView taskDueDate;
    public final TextView taskHeader;
    public final TextView taskMessage;
    public final TextView taskStatus;

    private TaskListItemBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TaskListItemAssigneesBinding taskListItemAssigneesBinding, BoxAvatarView boxAvatarView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.dueDateLabel = textView;
        this.statusField = textView2;
        this.taskAssignees = taskListItemAssigneesBinding;
        this.taskAvatar = boxAvatarView;
        this.taskCreationDate = textView3;
        this.taskDueDate = textView4;
        this.taskHeader = textView5;
        this.taskMessage = textView6;
        this.taskStatus = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TaskListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TaskListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.task_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TaskListItemBinding bind(View view) {
        int i = R.id.due_date_label;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.due_date_label);
        if (textView != null) {
            i = R.id.status_field;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.status_field);
            if (textView2 != null) {
                i = R.id.task_assignees;
                View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.task_assignees);
                if (viewFindChildViewById != null) {
                    TaskListItemAssigneesBinding taskListItemAssigneesBindingBind = TaskListItemAssigneesBinding.bind(viewFindChildViewById);
                    i = R.id.task_avatar;
                    BoxAvatarView boxAvatarView = (BoxAvatarView) ViewBindings.findChildViewById(view, R.id.task_avatar);
                    if (boxAvatarView != null) {
                        i = R.id.task_creation_date;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.task_creation_date);
                        if (textView3 != null) {
                            i = R.id.task_due_date;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.task_due_date);
                            if (textView4 != null) {
                                i = R.id.task_header;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.task_header);
                                if (textView5 != null) {
                                    i = R.id.task_message;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.task_message);
                                    if (textView6 != null) {
                                        i = R.id.task_status;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.task_status);
                                        if (textView7 != null) {
                                            return new TaskListItemBinding((ConstraintLayout) view, textView, textView2, taskListItemAssigneesBindingBind, boxAvatarView, textView3, textView4, textView5, textView6, textView7);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
