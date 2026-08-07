package com.box.android.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.box.android.R;
import com.box.android.adapters.listitems.NavigationBarItem;
import com.box.android.domain.configuration.FeatureFlips;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class NavigationBarAdapter extends ArrayAdapter<NavigationBarItem> {
    private final Context mContext;
    private final boolean mIsRedesignEnabled;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    public NavigationBarAdapter(Activity activity, List<NavigationBarItem> list, FeatureFlips featureFlips) {
        super(activity, featureFlips.getMainScreenRedesign().getEnabled() ? R.layout.layout_breadcrumb_spinner : R.layout.layout_breadcrumb_spinner_legacy);
        this.mIsRedesignEnabled = featureFlips.getMainScreenRedesign().getEnabled();
        this.mContext = activity;
        setNavigationList(list);
    }

    public void setNavigationList(List<NavigationBarItem> list) {
        clear();
        setNotifyOnChange(false);
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
        setNotifyOnChange(true);
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return i != getCount() - 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).getType();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(this.mIsRedesignEnabled ? R.layout.layout_breadcrumb_spinner : R.layout.layout_breadcrumb_spinner_legacy, viewGroup, false);
        NavigationBarItem item = getItem(i);
        TextView textView = (TextView) viewInflate.findViewById(R.id.breadcrumb_textview);
        textView.setText(item.getName());
        if (this.mIsRedesignEnabled) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_account_tree, 0);
            return viewInflate;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_spinner_icon, 0);
        return viewInflate;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.spinner_dropdown_item, viewGroup, false);
        NavigationBarItem item = getItem(i);
        CheckedTextView checkedTextView = (CheckedTextView) viewInflate.findViewById(R.id.text);
        checkedTextView.setText(item.getName());
        if (i == getCount() - 1) {
            checkedTextView.setEnabled(false);
            return viewInflate;
        }
        checkedTextView.setEnabled(true);
        return viewInflate;
    }
}
