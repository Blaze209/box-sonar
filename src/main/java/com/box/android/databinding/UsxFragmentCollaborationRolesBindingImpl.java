package com.box.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.box.android.R;
import com.box.android.usx.fragments.CollaboratorsRolesFragment;
import com.box.android.utilities.CollaborationRoleBindingAdapters;
import com.box.android.vm.SelectRoleShareVM;
import com.box.androidsdk.content.models.BoxCollaboration;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class UsxFragmentCollaborationRolesBindingImpl extends UsxFragmentCollaborationRolesBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.collaborator_role_title, 2);
        sparseIntArray.put(R.id.remove_btn, 3);
    }

    public UsxFragmentCollaborationRolesBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private UsxFragmentCollaborationRolesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[2], (RadioGroup) objArr[1], (TextView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.collaboratorRolesGroup.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
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
        if (32 == i) {
            setViewModel((SelectRoleShareVM) obj);
            return true;
        }
        if (23 != i) {
            return false;
        }
        setRoleUpdateNotifier((CollaboratorsRolesFragment.RoleUpdateNotifier) obj);
        return true;
    }

    @Override // com.box.android.databinding.UsxFragmentCollaborationRolesBinding
    public void setViewModel(SelectRoleShareVM selectRoleShareVM) {
        this.mViewModel = selectRoleShareVM;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(32);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentCollaborationRolesBinding
    public void setRoleUpdateNotifier(CollaboratorsRolesFragment.RoleUpdateNotifier roleUpdateNotifier) {
        this.mRoleUpdateNotifier = roleUpdateNotifier;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(23);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModelSelectedRole((LiveData) obj, i2);
    }

    private boolean onChangeViewModelSelectedRole(LiveData<BoxCollaboration.Role> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        LiveData<BoxCollaboration.Role> liveData;
        boolean z;
        List<BoxCollaboration.Role> roles;
        boolean zIsOwnerRoleAllowed;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SelectRoleShareVM selectRoleShareVM = this.mViewModel;
        CollaboratorsRolesFragment.RoleUpdateNotifier roleUpdateNotifier = this.mRoleUpdateNotifier;
        long j2 = 15 & j;
        List<BoxCollaboration.Role> list = null;
        LiveData<BoxCollaboration.Role> liveData2 = null;
        boolean z2 = false;
        if (j2 != 0) {
            if (selectRoleShareVM != null) {
                boolean zIsRemoveAllowed = selectRoleShareVM.isRemoveAllowed();
                LiveData<BoxCollaboration.Role> selectedRole = selectRoleShareVM.getSelectedRole();
                roles = selectRoleShareVM.getRoles();
                zIsOwnerRoleAllowed = selectRoleShareVM.isOwnerRoleAllowed();
                z = zIsRemoveAllowed;
                liveData2 = selectedRole;
            } else {
                roles = null;
                zIsOwnerRoleAllowed = false;
                z = false;
            }
            updateLiveDataRegistration(0, liveData2);
            if ((j & 11) != 0 && liveData2 != null) {
                liveData2.getValue();
            }
            List<BoxCollaboration.Role> list2 = roles;
            liveData = liveData2;
            list = list2;
            z2 = zIsOwnerRoleAllowed;
        } else {
            liveData = null;
            z = false;
        }
        if (j2 != 0) {
            CollaborationRoleBindingAdapters.populateRadioGroup(this.collaboratorRolesGroup, list, z2, z, liveData, this.removeBtn, roleUpdateNotifier);
        }
    }
}
