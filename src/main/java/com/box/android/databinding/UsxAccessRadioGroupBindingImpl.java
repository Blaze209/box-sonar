package com.box.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import com.box.android.R;
import com.box.android.generated.callback.OnCheckedChangeListener;
import com.box.android.generated.callback.OnClickListener;
import com.box.android.usx.fragments.SharedLinkAccessFragment;
import com.box.android.utilities.SharedLinkAccessToggleListeners;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSharedLink;
import java.util.HashSet;

/* JADX INFO: loaded from: classes11.dex */
public class UsxAccessRadioGroupBindingImpl extends UsxAccessRadioGroupBinding implements OnClickListener.Listener, OnCheckedChangeListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback4;
    private final CompoundButton.OnCheckedChangeListener mCallback5;
    private final View.OnClickListener mCallback6;
    private final CompoundButton.OnCheckedChangeListener mCallback7;
    private final View.OnClickListener mCallback8;
    private final CompoundButton.OnCheckedChangeListener mCallback9;
    private long mDirtyFlags;
    private final RadioGroup mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.link_access_name, 7);
        sparseIntArray.put(R.id.link_access_description, 8);
        sparseIntArray.put(R.id.company_access_name, 9);
        sparseIntArray.put(R.id.company_access_description, 10);
        sparseIntArray.put(R.id.folder_access_name, 11);
        sparseIntArray.put(R.id.folder_access_description, 12);
    }

    public UsxAccessRadioGroupBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private UsxAccessRadioGroupBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RadioButton) objArr[4], (TextView) objArr[10], (ConstraintLayout) objArr[3], (TextView) objArr[9], (RadioButton) objArr[6], (TextView) objArr[12], (ConstraintLayout) objArr[5], (TextView) objArr[11], (RadioButton) objArr[2], (TextView) objArr[8], (ConstraintLayout) objArr[1], (TextView) objArr[7]);
        this.mDirtyFlags = -1L;
        this.companyAccess.setTag(null);
        this.companyAccessLayout.setTag(null);
        this.folderAccess.setTag(null);
        this.folderAccessLayout.setTag(null);
        this.linkAccess.setTag(null);
        this.linkAccessLayout.setTag(null);
        RadioGroup radioGroup = (RadioGroup) objArr[0];
        this.mboundView0 = radioGroup;
        radioGroup.setTag(null);
        setRootTag(view);
        this.mCallback8 = new OnClickListener(this, 5);
        this.mCallback6 = new OnClickListener(this, 3);
        this.mCallback4 = new OnClickListener(this, 1);
        this.mCallback9 = new OnCheckedChangeListener(this, 6);
        this.mCallback7 = new OnCheckedChangeListener(this, 4);
        this.mCallback5 = new OnCheckedChangeListener(this, 2);
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
        if (25 == i) {
            setSharedLinkAccessNotifier((SharedLinkAccessFragment.SharedLinkAccessNotifiers) obj);
            return true;
        }
        if (1 == i) {
            setActiveRadioButtons((HashSet) obj);
            return true;
        }
        if (24 != i) {
            return false;
        }
        setShareItem((BoxItem) obj);
        return true;
    }

    @Override // com.box.android.databinding.UsxAccessRadioGroupBinding
    public void setSharedLinkAccessNotifier(SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers) {
        this.mSharedLinkAccessNotifier = sharedLinkAccessNotifiers;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxAccessRadioGroupBinding
    public void setActiveRadioButtons(HashSet hashSet) {
        this.mActiveRadioButtons = hashSet;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxAccessRadioGroupBinding
    public void setShareItem(BoxItem boxItem) {
        this.mShareItem = boxItem;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean zContains;
        int i;
        boolean zContains2;
        boolean zContains3;
        int i2;
        int i3;
        long j2;
        boolean z;
        boolean z2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers = this.mSharedLinkAccessNotifier;
        HashSet hashSet = this.mActiveRadioButtons;
        BoxItem boxItem = this.mShareItem;
        long j3 = j & 10;
        boolean z3 = false;
        if (j3 != 0) {
            if (hashSet != null) {
                zContains2 = hashSet.contains(BoxSharedLink.Access.COLLABORATORS);
                zContains3 = hashSet.contains(BoxSharedLink.Access.OPEN);
                zContains = hashSet.contains(BoxSharedLink.Access.COMPANY);
            } else {
                zContains = false;
                zContains2 = false;
                zContains3 = false;
            }
            if (j3 != 0) {
                j |= zContains2 ? 512L : 256L;
            }
            if ((j & 10) != 0) {
                j |= zContains3 ? 128L : 64L;
            }
            if ((j & 10) != 0) {
                j |= zContains ? 32L : 16L;
            }
            i = 8;
            i2 = zContains2 ? 0 : 8;
            i3 = zContains3 ? 0 : 8;
            if (zContains) {
                i = 0;
            }
        } else {
            zContains = false;
            i = 0;
            zContains2 = false;
            zContains3 = false;
            i2 = 0;
            i3 = 0;
        }
        long j4 = 12 & j;
        if (j4 != 0) {
            BoxSharedLink sharedLink = boxItem != null ? boxItem.getSharedLink() : null;
            BoxSharedLink.Access effectiveAccess = sharedLink != null ? sharedLink.getEffectiveAccess() : null;
            z = effectiveAccess == BoxSharedLink.Access.OPEN;
            j2 = 10;
            z2 = effectiveAccess == BoxSharedLink.Access.COLLABORATORS;
            if (effectiveAccess == BoxSharedLink.Access.COMPANY) {
                z3 = true;
            }
        } else {
            j2 = 10;
            z = false;
            z2 = false;
        }
        if ((j & j2) != 0) {
            this.companyAccess.setEnabled(zContains);
            this.companyAccessLayout.setVisibility(i);
            this.folderAccess.setEnabled(zContains2);
            this.folderAccessLayout.setVisibility(i2);
            this.linkAccess.setEnabled(zContains3);
            this.linkAccessLayout.setVisibility(i3);
        }
        if (j4 != 0) {
            CompoundButtonBindingAdapter.setChecked(this.companyAccess, z3);
            CompoundButtonBindingAdapter.setChecked(this.folderAccess, z2);
            CompoundButtonBindingAdapter.setChecked(this.linkAccess, z);
        }
        if ((j & 8) != 0) {
            CompoundButtonBindingAdapter.setListeners(this.companyAccess, this.mCallback7, null);
            this.companyAccessLayout.setOnClickListener(this.mCallback6);
            CompoundButtonBindingAdapter.setListeners(this.folderAccess, this.mCallback9, null);
            this.folderAccessLayout.setOnClickListener(this.mCallback8);
            CompoundButtonBindingAdapter.setListeners(this.linkAccess, this.mCallback5, null);
            this.linkAccessLayout.setOnClickListener(this.mCallback4);
        }
    }

    @Override // com.box.android.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        if (i == 1) {
            SharedLinkAccessToggleListeners.onAccessLevelCheckChanged(true, BoxSharedLink.Access.OPEN, this.mSharedLinkAccessNotifier);
        } else if (i == 3) {
            SharedLinkAccessToggleListeners.onAccessLevelCheckChanged(true, BoxSharedLink.Access.COMPANY, this.mSharedLinkAccessNotifier);
        } else {
            if (i != 5) {
                return;
            }
            SharedLinkAccessToggleListeners.onAccessLevelCheckChanged(true, BoxSharedLink.Access.COLLABORATORS, this.mSharedLinkAccessNotifier);
        }
    }

    @Override // com.box.android.generated.callback.OnCheckedChangeListener.Listener
    public final void _internalCallbackOnCheckedChanged(int i, CompoundButton compoundButton, boolean z) {
        if (i == 2) {
            SharedLinkAccessToggleListeners.onAccessLevelCheckChanged(z, BoxSharedLink.Access.OPEN, this.mSharedLinkAccessNotifier);
        } else if (i == 4) {
            SharedLinkAccessToggleListeners.onAccessLevelCheckChanged(z, BoxSharedLink.Access.COMPANY, this.mSharedLinkAccessNotifier);
        } else {
            if (i != 6) {
                return;
            }
            SharedLinkAccessToggleListeners.onAccessLevelCheckChanged(z, BoxSharedLink.Access.COLLABORATORS, this.mSharedLinkAccessNotifier);
        }
    }
}
