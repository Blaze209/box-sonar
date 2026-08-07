package com.box.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import com.box.android.R;
import com.box.android.generated.callback.OnClickListener;
import com.box.android.usx.fragments.SharedLinkAccessFragment;
import com.box.android.utilities.SharedLinkAccessToggleListeners;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSharedLink;

/* JADX INFO: loaded from: classes11.dex */
public class UsxPermissionsRadioGroupBindingImpl extends UsxPermissionsRadioGroupBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback1;
    private final View.OnClickListener mCallback2;
    private final View.OnClickListener mCallback3;
    private long mDirtyFlags;
    private final RadioGroup mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.radio_button_view_only_title, 8);
        sparseIntArray.put(R.id.radio_button_view_only_subtitle, 9);
    }

    public UsxPermissionsRadioGroupBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private UsxPermissionsRadioGroupBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RadioButton) objArr[5], (RadioButton) objArr[2], (RadioButton) objArr[1], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[9], (TextView) objArr[8]);
        this.mDirtyFlags = -1L;
        RadioGroup radioGroup = (RadioGroup) objArr[0];
        this.mboundView0 = radioGroup;
        radioGroup.setTag(null);
        this.permissionsCanEdit.setTag(null);
        this.permissionsViewAndDownload.setTag(null);
        this.permissionsViewOnly.setTag(null);
        this.radioButtonCanEditSubtitle.setTag(null);
        this.radioButtonCanEditTitle.setTag(null);
        this.radioButtonViewAndDownloadSubtitle.setTag(null);
        this.radioButtonViewAndDownloadTitle.setTag(null);
        setRootTag(view);
        this.mCallback2 = new OnClickListener(this, 2);
        this.mCallback3 = new OnClickListener(this, 3);
        this.mCallback1 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
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
        if (26 == i) {
            setShouldShowDownloadOption(((Boolean) obj).booleanValue());
            return true;
        }
        if (27 == i) {
            setShouldShowEditOption(((Boolean) obj).booleanValue());
            return true;
        }
        if (24 != i) {
            return false;
        }
        setShareItem((BoxItem) obj);
        return true;
    }

    @Override // com.box.android.databinding.UsxPermissionsRadioGroupBinding
    public void setSharedLinkAccessNotifier(SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers) {
        this.mSharedLinkAccessNotifier = sharedLinkAccessNotifiers;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxPermissionsRadioGroupBinding
    public void setShouldShowDownloadOption(boolean z) {
        this.mShouldShowDownloadOption = z;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxPermissionsRadioGroupBinding
    public void setShouldShowEditOption(boolean z) {
        this.mShouldShowEditOption = z;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxPermissionsRadioGroupBinding
    public void setShareItem(BoxItem boxItem) {
        this.mShareItem = boxItem;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002c A[PHI: r2
      0x002c: PHI (r2v1 long) = (r2v0 long), (r2v11 long) binds: [B:7:0x001b, B:13:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0041 A[PHI: r2
      0x0041: PHI (r2v3 long) = (r2v2 long), (r2v9 long) binds: [B:18:0x0033, B:24:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        boolean z;
        boolean zCanDownload;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers = this.mSharedLinkAccessNotifier;
        boolean z2 = this.mShouldShowDownloadOption;
        boolean z3 = this.mShouldShowEditOption;
        BoxItem boxItem = this.mShareItem;
        long j2 = j & 18;
        boolean z4 = false;
        if (j2 == 0) {
            i = 0;
        } else {
            if (j2 != 0) {
                j |= z2 ? 64L : 32L;
            }
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
        }
        long j3 = j & 20;
        if (j3 != 0) {
            if (j3 != 0) {
                j |= z3 ? 256L : 128L;
            }
            i2 = z3 ? 0 : 8;
        }
        long j4 = 24 & j;
        if (j4 != 0) {
            BoxSharedLink sharedLink = boxItem != null ? boxItem.getSharedLink() : null;
            BoxSharedLink.EffectivePermission effectivePermission = sharedLink != null ? sharedLink.getEffectivePermission() : null;
            if (effectivePermission != null) {
                boolean zCanPreview = effectivePermission.canPreview();
                boolean zCanEdit = effectivePermission.canEdit();
                zCanDownload = effectivePermission.canDownload();
                z4 = zCanEdit;
                z = zCanPreview;
            } else {
                z = false;
                zCanDownload = false;
            }
        } else {
            z = false;
            zCanDownload = false;
        }
        if ((20 & j) != 0) {
            this.permissionsCanEdit.setVisibility(i2);
            this.radioButtonCanEditSubtitle.setVisibility(i2);
            this.radioButtonCanEditTitle.setVisibility(i2);
        }
        if (j4 != 0) {
            CompoundButtonBindingAdapter.setChecked(this.permissionsCanEdit, z4);
            CompoundButtonBindingAdapter.setChecked(this.permissionsViewAndDownload, zCanDownload);
            CompoundButtonBindingAdapter.setChecked(this.permissionsViewOnly, z);
        }
        if ((16 & j) != 0) {
            this.permissionsCanEdit.setOnClickListener(this.mCallback3);
            this.permissionsViewAndDownload.setOnClickListener(this.mCallback2);
            this.permissionsViewOnly.setOnClickListener(this.mCallback1);
        }
        if ((j & 18) != 0) {
            this.permissionsViewAndDownload.setVisibility(i);
            this.radioButtonViewAndDownloadSubtitle.setVisibility(i);
            this.radioButtonViewAndDownloadTitle.setVisibility(i);
        }
    }

    @Override // com.box.android.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        if (i == 1) {
            SharedLinkAccessToggleListeners.onPermissionChange(BoxSharedLink.Permission.CAN_PREVIEW, this.mSharedLinkAccessNotifier);
        } else if (i == 2) {
            SharedLinkAccessToggleListeners.onPermissionChange(BoxSharedLink.Permission.CAN_DOWNLOAD, this.mSharedLinkAccessNotifier);
        } else {
            if (i != 3) {
                return;
            }
            SharedLinkAccessToggleListeners.onPermissionChange(BoxSharedLink.Permission.CAN_EDIT, this.mSharedLinkAccessNotifier);
        }
    }
}
