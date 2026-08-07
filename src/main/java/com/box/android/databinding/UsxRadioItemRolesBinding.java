package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.box.android.R;
import com.box.androidsdk.content.models.BoxCollaboration;
import java.util.HashSet;

/* JADX INFO: loaded from: classes11.dex */
public abstract class UsxRadioItemRolesBinding extends ViewDataBinding {
    public final View divider;

    @Bindable
    protected boolean mCheckRole;

    @Bindable
    protected boolean mIsLastDivider;

    @Bindable
    protected View.OnClickListener mListener;

    @Bindable
    protected String mRoleDescription;

    @Bindable
    protected String mRoleName;

    @Bindable
    protected HashSet mRoleOptions;

    @Bindable
    protected BoxCollaboration.Role mRoleTag;
    public final TextView rolesDescription;
    public final TextView rolesName;
    public final RadioButton rolesRadio;
    public final ConstraintLayout rolesTextLayout;

    public abstract void setCheckRole(boolean z);

    public abstract void setIsLastDivider(boolean z);

    public abstract void setListener(View.OnClickListener onClickListener);

    public abstract void setRoleDescription(String str);

    public abstract void setRoleName(String str);

    public abstract void setRoleOptions(HashSet hashSet);

    public abstract void setRoleTag(BoxCollaboration.Role role);

    protected UsxRadioItemRolesBinding(Object obj, View view, int i, View view2, TextView textView, TextView textView2, RadioButton radioButton, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.divider = view2;
        this.rolesDescription = textView;
        this.rolesName = textView2;
        this.rolesRadio = radioButton;
        this.rolesTextLayout = constraintLayout;
    }

    public String getRoleName() {
        return this.mRoleName;
    }

    public String getRoleDescription() {
        return this.mRoleDescription;
    }

    public BoxCollaboration.Role getRoleTag() {
        return this.mRoleTag;
    }

    public View.OnClickListener getListener() {
        return this.mListener;
    }

    public boolean getIsLastDivider() {
        return this.mIsLastDivider;
    }

    public HashSet getRoleOptions() {
        return this.mRoleOptions;
    }

    public boolean getCheckRole() {
        return this.mCheckRole;
    }

    public static UsxRadioItemRolesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxRadioItemRolesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UsxRadioItemRolesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_radio_item_roles, viewGroup, z, obj);
    }

    public static UsxRadioItemRolesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxRadioItemRolesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UsxRadioItemRolesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_radio_item_roles, null, false, obj);
    }

    public static UsxRadioItemRolesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxRadioItemRolesBinding bind(View view, Object obj) {
        return (UsxRadioItemRolesBinding) bind(obj, view, R.layout.usx_radio_item_roles);
    }
}
