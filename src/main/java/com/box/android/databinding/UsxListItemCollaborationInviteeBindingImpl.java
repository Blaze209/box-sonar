package com.box.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.box.android.utilities.InviteCollaboratorsBindingAdapters;

/* JADX INFO: loaded from: classes11.dex */
public class UsxListItemCollaborationInviteeBindingImpl extends UsxListItemCollaborationInviteeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public UsxListItemCollaborationInviteeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private UsxListItemCollaborationInviteeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.collaborationInviteeEmail.setTag(null);
        this.collaborationInviteeName.setTag(null);
        this.collaboratorInitials.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
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
        if (5 == i) {
            setInviteeName((String) obj);
            return true;
        }
        if (4 != i) {
            return false;
        }
        setInviteeEmail((String) obj);
        return true;
    }

    @Override // com.box.android.databinding.UsxListItemCollaborationInviteeBinding
    public void setInviteeName(String str) {
        this.mInviteeName = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxListItemCollaborationInviteeBinding
    public void setInviteeEmail(String str) {
        this.mInviteeEmail = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        String str = this.mInviteeName;
        String str2 = this.mInviteeEmail;
        long j2 = 5 & j;
        if ((j & 6) != 0) {
            TextViewBindingAdapter.setText(this.collaborationInviteeEmail, str2);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.collaborationInviteeName, str);
            InviteCollaboratorsBindingAdapters.setInitialsThumnb(this.collaboratorInitials, str);
        }
    }
}
