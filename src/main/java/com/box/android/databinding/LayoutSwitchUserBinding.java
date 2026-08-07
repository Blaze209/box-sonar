package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class LayoutSwitchUserBinding implements ViewBinding {
    public final TextView dialogTitle;
    public final LinearLayout linearLayoutTitleContainer;
    public final ListView list;
    private final LinearLayout rootView;

    private LayoutSwitchUserBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, ListView listView) {
        this.rootView = linearLayout;
        this.dialogTitle = textView;
        this.linearLayoutTitleContainer = linearLayout2;
        this.list = listView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSwitchUserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutSwitchUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_switch_user, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutSwitchUserBinding bind(View view) {
        int i = R.id.dialog_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_title);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.list);
            if (listView != null) {
                return new LayoutSwitchUserBinding(linearLayout, textView, linearLayout, listView);
            }
            i = R.id.list;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
