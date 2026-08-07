package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.box.android.R;
import com.box.android.usx.fragments.CollaboratorsRolesFragment;
import com.box.android.vm.SelectRoleShareVM;

/* JADX INFO: loaded from: classes11.dex */
public abstract class UsxFragmentCollaborationRolesBinding extends ViewDataBinding {
    public final TextView collaboratorRoleTitle;
    public final RadioGroup collaboratorRolesGroup;

    @Bindable
    protected CollaboratorsRolesFragment.RoleUpdateNotifier mRoleUpdateNotifier;

    @Bindable
    protected SelectRoleShareVM mViewModel;
    public final TextView removeBtn;

    public abstract void setRoleUpdateNotifier(CollaboratorsRolesFragment.RoleUpdateNotifier roleUpdateNotifier);

    public abstract void setViewModel(SelectRoleShareVM selectRoleShareVM);

    protected UsxFragmentCollaborationRolesBinding(Object obj, View view, int i, TextView textView, RadioGroup radioGroup, TextView textView2) {
        super(obj, view, i);
        this.collaboratorRoleTitle = textView;
        this.collaboratorRolesGroup = radioGroup;
        this.removeBtn = textView2;
    }

    public SelectRoleShareVM getViewModel() {
        return this.mViewModel;
    }

    public CollaboratorsRolesFragment.RoleUpdateNotifier getRoleUpdateNotifier() {
        return this.mRoleUpdateNotifier;
    }

    public static UsxFragmentCollaborationRolesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentCollaborationRolesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UsxFragmentCollaborationRolesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_fragment_collaboration_roles, viewGroup, z, obj);
    }

    public static UsxFragmentCollaborationRolesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentCollaborationRolesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UsxFragmentCollaborationRolesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_fragment_collaboration_roles, null, false, obj);
    }

    public static UsxFragmentCollaborationRolesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentCollaborationRolesBinding bind(View view, Object obj) {
        return (UsxFragmentCollaborationRolesBinding) bind(obj, view, R.layout.usx_fragment_collaboration_roles);
    }
}
