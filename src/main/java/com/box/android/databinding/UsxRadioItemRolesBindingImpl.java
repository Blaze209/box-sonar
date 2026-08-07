package com.box.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.box.android.utilities.CollaborationRoleBindingAdapters;
import com.box.androidsdk.content.models.BoxCollaboration;
import java.util.HashSet;

/* JADX INFO: loaded from: classes11.dex */
public class UsxRadioItemRolesBindingImpl extends UsxRadioItemRolesBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public UsxRadioItemRolesBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private UsxRadioItemRolesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[4], (TextView) objArr[3], (TextView) objArr[2], (RadioButton) objArr[1], (ConstraintLayout) objArr[0]);
        this.mDirtyFlags = -1L;
        this.divider.setTag(null);
        this.rolesDescription.setTag(null);
        this.rolesName.setTag(null);
        this.rolesRadio.setTag(null);
        this.rolesTextLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            setRoleDescription((String) obj);
            return true;
        }
        if (22 == i) {
            setRoleTag((BoxCollaboration.Role) obj);
            return true;
        }
        if (20 == i) {
            setRoleName((String) obj);
            return true;
        }
        if (8 == i) {
            setIsLastDivider(((Boolean) obj).booleanValue());
            return true;
        }
        if (3 == i) {
            setCheckRole(((Boolean) obj).booleanValue());
            return true;
        }
        if (9 == i) {
            setListener((View.OnClickListener) obj);
            return true;
        }
        if (21 != i) {
            return false;
        }
        setRoleOptions((HashSet) obj);
        return true;
    }

    @Override // com.box.android.databinding.UsxRadioItemRolesBinding
    public void setRoleDescription(String str) {
        this.mRoleDescription = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxRadioItemRolesBinding
    public void setRoleTag(BoxCollaboration.Role role) {
        this.mRoleTag = role;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxRadioItemRolesBinding
    public void setRoleName(String str) {
        this.mRoleName = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxRadioItemRolesBinding
    public void setIsLastDivider(boolean z) {
        this.mIsLastDivider = z;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxRadioItemRolesBinding
    public void setCheckRole(boolean z) {
        this.mCheckRole = z;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxRadioItemRolesBinding
    public void setListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxRadioItemRolesBinding
    public void setRoleOptions(HashSet hashSet) {
        this.mRoleOptions = hashSet;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        String str = this.mRoleDescription;
        BoxCollaboration.Role role = this.mRoleTag;
        String str2 = this.mRoleName;
        boolean z = this.mIsLastDivider;
        boolean z2 = this.mCheckRole;
        View.OnClickListener onClickListener = this.mListener;
        HashSet hashSet = this.mRoleOptions;
        long j2 = j & 136;
        int i = 0;
        if (j2 != 0) {
            if (j2 != 0) {
                j |= z ? 512L : 256L;
            }
            if (z) {
                i = 8;
            }
        }
        long j3 = j & 144;
        long j4 = j & 160;
        long j5 = j & 192;
        if ((136 & j) != 0) {
            this.divider.setVisibility(i);
        }
        if ((129 & j) != 0) {
            TextViewBindingAdapter.setText(this.rolesDescription, str);
        }
        if ((132 & j) != 0) {
            TextViewBindingAdapter.setText(this.rolesName, str2);
        }
        if ((j & 130) != 0) {
            this.rolesRadio.setTag(role);
            this.rolesTextLayout.setTag(role);
        }
        if (j3 != 0) {
            CompoundButtonBindingAdapter.setChecked(this.rolesRadio, z2);
        }
        if (j5 != 0) {
            CollaborationRoleBindingAdapters.addRoleOption(this.rolesRadio, hashSet);
        }
        if (j4 != 0) {
            this.rolesRadio.setOnClickListener(onClickListener);
            this.rolesTextLayout.setOnClickListener(onClickListener);
        }
    }
}
