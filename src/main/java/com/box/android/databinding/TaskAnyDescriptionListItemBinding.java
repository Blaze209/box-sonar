package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class TaskAnyDescriptionListItemBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView taskAnyDescription;

    private TaskAnyDescriptionListItemBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.taskAnyDescription = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static TaskAnyDescriptionListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TaskAnyDescriptionListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.task_any_description_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TaskAnyDescriptionListItemBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new TaskAnyDescriptionListItemBinding(textView, textView);
    }
}
