package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public abstract class UsxFragmentCollaborationsBinding extends ViewDataBinding {
    public final ListView collaboratorsList;
    public final TextView noCollaboratorsText;

    protected UsxFragmentCollaborationsBinding(Object obj, View view, int i, ListView listView, TextView textView) {
        super(obj, view, i);
        this.collaboratorsList = listView;
        this.noCollaboratorsText = textView;
    }

    public static UsxFragmentCollaborationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentCollaborationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UsxFragmentCollaborationsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_fragment_collaborations, viewGroup, z, obj);
    }

    public static UsxFragmentCollaborationsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentCollaborationsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UsxFragmentCollaborationsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_fragment_collaborations, null, false, obj);
    }

    public static UsxFragmentCollaborationsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentCollaborationsBinding bind(View view, Object obj) {
        return (UsxFragmentCollaborationsBinding) bind(obj, view, R.layout.usx_fragment_collaborations);
    }
}
