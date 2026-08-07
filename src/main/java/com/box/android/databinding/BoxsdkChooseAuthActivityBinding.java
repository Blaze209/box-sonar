package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxsdkChooseAuthActivityBinding implements ViewBinding {
    public final ListView boxsdkAccountsList;
    private final LinearLayout rootView;

    private BoxsdkChooseAuthActivityBinding(LinearLayout linearLayout, ListView listView) {
        this.rootView = linearLayout;
        this.boxsdkAccountsList = listView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BoxsdkChooseAuthActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxsdkChooseAuthActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.boxsdk_choose_auth_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxsdkChooseAuthActivityBinding bind(View view) {
        ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.boxsdk_accounts_list);
        if (listView != null) {
            return new BoxsdkChooseAuthActivityBinding((LinearLayout) view, listView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.boxsdk_accounts_list)));
    }
}
