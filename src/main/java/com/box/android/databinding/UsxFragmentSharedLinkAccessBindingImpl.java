package com.box.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.box.android.R;
import com.box.android.generated.callback.OnCheckedChangeListener;
import com.box.android.usx.fragments.SharedLinkAccessFragment;
import com.box.android.utilities.SharedLinkAccessToggleListeners;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSharedLink;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/* JADX INFO: loaded from: classes11.dex */
public class UsxFragmentSharedLinkAccessBindingImpl extends UsxFragmentSharedLinkAccessBinding implements OnCheckedChangeListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final CompoundButton.OnCheckedChangeListener mCallback12;
    private final CompoundButton.OnCheckedChangeListener mCallback13;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final LinearLayout mboundView1;
    private final TextView mboundView2;
    private final ConstraintLayout mboundView4;
    private final LinearLayout mboundView6;
    private final ConstraintLayout mboundView8;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(13);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"usx_access_radio_group", "usx_permissions_radio_group"}, new int[]{9, 10}, new int[]{R.layout.usx_access_radio_group, R.layout.usx_permissions_radio_group});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.expire_link_divider, 11);
        sparseIntArray.put(R.id.password_divider, 12);
    }

    public UsxFragmentSharedLinkAccessBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private UsxFragmentSharedLinkAccessBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (UsxAccessRadioGroupBinding) objArr[9], (TextView) objArr[5], (View) objArr[11], (View) objArr[12], (UsxPermissionsRadioGroupBinding) objArr[10], (SwitchCompat) objArr[3], (SwitchCompat) objArr[7]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.accessRadioGroup);
        this.expireLinkDate.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[4];
        this.mboundView4 = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[6];
        this.mboundView6 = linearLayout2;
        linearLayout2.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[8];
        this.mboundView8 = constraintLayout2;
        constraintLayout2.setTag(null);
        setContainedBinding(this.permissionsRadioGroup);
        this.sharedLinkExpireLinkBtn.setTag(null);
        this.sharedLinkRequirePasswordBtn.setTag(null);
        setRootTag(view);
        this.mCallback13 = new OnCheckedChangeListener(this, 2);
        this.mCallback12 = new OnCheckedChangeListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512L;
        }
        this.accessRadioGroup.invalidateAll();
        this.permissionsRadioGroup.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.accessRadioGroup.hasPendingBindings() || this.permissionsRadioGroup.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (25 == i) {
            setSharedLinkAccessNotifier((SharedLinkAccessFragment.SharedLinkAccessNotifiers) obj);
            return true;
        }
        if (26 == i) {
            setShouldShowDownloadOption(((Boolean) obj).booleanValue());
            return true;
        }
        if (27 == i) {
            setShouldShowEditOption(((Boolean) obj).booleanValue());
            return true;
        }
        if (1 == i) {
            setActiveRadioButtons((HashSet) obj);
            return true;
        }
        if (15 == i) {
            setOnPasswordListener((View.OnClickListener) obj);
            return true;
        }
        if (12 == i) {
            setOnDateListener((View.OnClickListener) obj);
            return true;
        }
        if (24 != i) {
            return false;
        }
        setShareItem((BoxItem) obj);
        return true;
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkAccessBinding
    public void setSharedLinkAccessNotifier(SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers) {
        this.mSharedLinkAccessNotifier = sharedLinkAccessNotifiers;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkAccessBinding
    public void setShouldShowDownloadOption(boolean z) {
        this.mShouldShowDownloadOption = z;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkAccessBinding
    public void setShouldShowEditOption(boolean z) {
        this.mShouldShowEditOption = z;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkAccessBinding
    public void setActiveRadioButtons(HashSet hashSet) {
        this.mActiveRadioButtons = hashSet;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkAccessBinding
    public void setOnPasswordListener(View.OnClickListener onClickListener) {
        this.mOnPasswordListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkAccessBinding
    public void setOnDateListener(View.OnClickListener onClickListener) {
        this.mOnDateListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkAccessBinding
    public void setShareItem(BoxItem boxItem) {
        this.mShareItem = boxItem;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.accessRadioGroup.setLifecycleOwner(lifecycleOwner);
        this.permissionsRadioGroup.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangePermissionsRadioGroup((UsxPermissionsRadioGroupBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeAccessRadioGroup((UsxAccessRadioGroupBinding) obj, i2);
    }

    private boolean onChangePermissionsRadioGroup(UsxPermissionsRadioGroupBinding usxPermissionsRadioGroupBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeAccessRadioGroup(UsxAccessRadioGroupBinding usxAccessRadioGroupBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        long j3;
        int i;
        Date date;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        DateFormat dateInstance;
        BoxSharedLink.Access access;
        Boolean isPasswordEnabled;
        Date unsharedDate;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers = this.mSharedLinkAccessNotifier;
        boolean z4 = this.mShouldShowDownloadOption;
        boolean z5 = this.mShouldShowEditOption;
        HashSet hashSet = this.mActiveRadioButtons;
        View.OnClickListener onClickListener = this.mOnPasswordListener;
        View.OnClickListener onClickListener2 = this.mOnDateListener;
        BoxItem boxItem = this.mShareItem;
        long j4 = j & 768;
        if (j4 != 0) {
            BoxSharedLink sharedLink = boxItem != null ? boxItem.getSharedLink() : null;
            if (sharedLink != null) {
                BoxSharedLink.Access effectiveAccess = sharedLink.getEffectiveAccess();
                unsharedDate = sharedLink.getUnsharedDate();
                isPasswordEnabled = sharedLink.getIsPasswordEnabled();
                access = effectiveAccess;
            } else {
                access = null;
                isPasswordEnabled = null;
                unsharedDate = null;
            }
            j2 = 768;
            boolean z6 = access != BoxSharedLink.Access.COLLABORATORS;
            z = access == BoxSharedLink.Access.OPEN;
            z2 = unsharedDate != null;
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(isPasswordEnabled);
            if (j4 != 0) {
                j |= z6 ? 8192L : 4096L;
            }
            if ((j & 768) != 0) {
                j |= z ? 2048L : 1024L;
            }
            if ((j & 768) != 0) {
                j |= z2 ? 2621440L : 1310720L;
            }
            if ((j & 768) != 0) {
                j |= zSafeUnbox ? 32768L : 16384L;
            }
            i2 = z6 ? 0 : 8;
            i3 = z ? 0 : 8;
            long j5 = j;
            i = z2 ? 0 : 8;
            j3 = j5;
            z3 = zSafeUnbox;
            date = unsharedDate;
        } else {
            j2 = 768;
            j3 = j;
            i = 0;
            date = null;
            z = false;
            i2 = 0;
            z2 = false;
            i3 = 0;
            z3 = false;
        }
        long j6 = j3 & j2;
        if (j6 != 0) {
            if (!z3) {
                z = false;
            }
            if (j6 != 0) {
                j3 |= z ? 131072L : 65536L;
            }
            i4 = z ? 0 : 8;
        } else {
            i4 = 0;
        }
        String str = ((j3 & 2097152) == 0 || (dateInstance = SimpleDateFormat.getDateInstance()) == null) ? null : dateInstance.format(date);
        long j7 = j3 & j2;
        if (j7 == 0) {
            str = null;
        } else if (!z2) {
            str = "";
        }
        if ((j3 & 544) != 0) {
            this.accessRadioGroup.setActiveRadioButtons(hashSet);
        }
        if (j7 != 0) {
            this.accessRadioGroup.setShareItem(boxItem);
            TextViewBindingAdapter.setText(this.expireLinkDate, str);
            this.mboundView2.setVisibility(i2);
            this.mboundView4.setVisibility(i);
            this.mboundView6.setVisibility(i3);
            this.mboundView8.setVisibility(i4);
            this.permissionsRadioGroup.getRoot().setVisibility(i2);
            this.permissionsRadioGroup.setShareItem(boxItem);
            CompoundButtonBindingAdapter.setChecked(this.sharedLinkExpireLinkBtn, z2);
            CompoundButtonBindingAdapter.setChecked(this.sharedLinkRequirePasswordBtn, z3);
        }
        if ((j3 & 516) != 0) {
            this.accessRadioGroup.setSharedLinkAccessNotifier(sharedLinkAccessNotifiers);
            this.permissionsRadioGroup.setSharedLinkAccessNotifier(sharedLinkAccessNotifiers);
        }
        if ((j3 & 640) != 0) {
            this.mboundView4.setOnClickListener(onClickListener2);
        }
        if ((j3 & 576) != 0) {
            this.mboundView8.setOnClickListener(onClickListener);
        }
        if ((j3 & 520) != 0) {
            this.permissionsRadioGroup.setShouldShowDownloadOption(z4);
        }
        if ((j3 & 528) != 0) {
            this.permissionsRadioGroup.setShouldShowEditOption(z5);
        }
        if ((j3 & 512) != 0) {
            CompoundButtonBindingAdapter.setListeners(this.sharedLinkExpireLinkBtn, this.mCallback12, null);
            CompoundButtonBindingAdapter.setListeners(this.sharedLinkRequirePasswordBtn, this.mCallback13, null);
        }
        executeBindingsOn(this.accessRadioGroup);
        executeBindingsOn(this.permissionsRadioGroup);
    }

    @Override // com.box.android.generated.callback.OnCheckedChangeListener.Listener
    public final void _internalCallbackOnCheckedChanged(int i, CompoundButton compoundButton, boolean z) {
        if (i == 1) {
            SharedLinkAccessToggleListeners.onExpireToggle(z, this.mShareItem, this.mSharedLinkAccessNotifier);
        } else {
            if (i != 2) {
                return;
            }
            SharedLinkAccessToggleListeners.onPasswordToggle(z, this.mShareItem, this.mSharedLinkAccessNotifier);
        }
    }
}
