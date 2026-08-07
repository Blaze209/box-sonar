package com.box.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.box.android.R;
import com.box.android.generated.callback.OnCheckedChangeListener;
import com.box.android.generated.callback.OnClickListener;
import com.box.android.usx.fragments.UsxFragment;
import com.box.android.usx.views.CollaboratorsInitialsView;
import com.box.android.utilities.CollaborationRoleBindingAdapters;
import com.box.android.utilities.InviteCollaboratorsBindingAdapters;
import com.box.android.utilities.SharedLinkBindingAdapters;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSharedLink;
import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes11.dex */
public class UsxFragmentSharedLinkBindingImpl extends UsxFragmentSharedLinkBinding implements OnClickListener.Listener, OnCheckedChangeListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final CompoundButton.OnCheckedChangeListener mCallback10;
    private final View.OnClickListener mCallback11;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final LinearLayout mboundView1;
    private final View mboundView12;
    private final LinearLayout mboundView13;
    private final TextView mboundView14;
    private final TextView mboundView15;
    private final TextView mboundView16;
    private final LinearLayout mboundView17;
    private final TextView mboundView18;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final LinearLayout mboundView5;
    private final TextView mboundView7;
    private final TextView mboundView8;
    private final LinearLayout mboundView9;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.initialViews, 20);
    }

    public UsxFragmentSharedLinkBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private UsxFragmentSharedLinkBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CollaboratorsInitialsView) objArr[20], (EditText) objArr[4], (LinearLayout) objArr[6], (TextView) objArr[19], (SwitchCompat) objArr[10], (TextView) objArr[11]);
        this.mDirtyFlags = -1L;
        this.inviteCollabs.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        View view2 = (View) objArr[12];
        this.mboundView12 = view2;
        view2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[13];
        this.mboundView13 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView = (TextView) objArr[14];
        this.mboundView14 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[15];
        this.mboundView15 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[16];
        this.mboundView16 = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[17];
        this.mboundView17 = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView4 = (TextView) objArr[18];
        this.mboundView18 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[2];
        this.mboundView2 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[3];
        this.mboundView3 = textView6;
        textView6.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[5];
        this.mboundView5 = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView7 = (TextView) objArr[7];
        this.mboundView7 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[8];
        this.mboundView8 = textView8;
        textView8.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) objArr[9];
        this.mboundView9 = linearLayout5;
        linearLayout5.setTag(null);
        this.noSharePermissionTextContainer.setTag(null);
        this.shareViaButton.setTag(null);
        this.sharedLinkSwitch.setTag(null);
        this.temp.setTag(null);
        setRootTag(view);
        this.mCallback11 = new OnClickListener(this, 2);
        this.mCallback10 = new OnCheckedChangeListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2048L;
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
        if (14 == i) {
            setOnInviteCollabsClickListener((View.OnClickListener) obj);
            return true;
        }
        if (17 == i) {
            setOnShareViaListener((View.OnClickListener) obj);
            return true;
        }
        if (6 == i) {
            setIsAllowedToInviteCollaborator(((Boolean) obj).booleanValue());
            return true;
        }
        if (11 == i) {
            setOnCopyLinkListener((View.OnClickListener) obj);
            return true;
        }
        if (13 == i) {
            setOnEditAccessClickListener((View.OnClickListener) obj);
            return true;
        }
        if (31 == i) {
            setUsxNotifier((UsxFragment.UsxNotifiers) obj);
            return true;
        }
        if (10 == i) {
            setOnCollabsListener((View.OnClickListener) obj);
            return true;
        }
        if (24 == i) {
            setShareItem((BoxItem) obj);
            return true;
        }
        if (30 == i) {
            setUserRole((BoxCollaboration.Role) obj);
            return true;
        }
        if (7 != i) {
            return false;
        }
        setIsAllowedToShare(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkBinding
    public void setOnInviteCollabsClickListener(View.OnClickListener onClickListener) {
        this.mOnInviteCollabsClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkBinding
    public void setOnShareViaListener(View.OnClickListener onClickListener) {
        this.mOnShareViaListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkBinding
    public void setIsAllowedToInviteCollaborator(boolean z) {
        this.mIsAllowedToInviteCollaborator = z;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkBinding
    public void setOnCopyLinkListener(View.OnClickListener onClickListener) {
        this.mOnCopyLinkListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(11);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkBinding
    public void setOnEditAccessClickListener(View.OnClickListener onClickListener) {
        this.mOnEditAccessClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkBinding
    public void setUsxNotifier(UsxFragment.UsxNotifiers usxNotifiers) {
        this.mUsxNotifier = usxNotifiers;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(31);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkBinding
    public void setOnCollabsListener(View.OnClickListener onClickListener) {
        this.mOnCollabsListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkBinding
    public void setShareItem(BoxItem boxItem) {
        this.mShareItem = boxItem;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkBinding
    public void setUserRole(BoxCollaboration.Role role) {
        this.mUserRole = role;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(30);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentSharedLinkBinding
    public void setIsAllowedToShare(boolean z) {
        this.mIsAllowedToShare = z;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.databinding.InverseBindingListener] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        String str;
        long j2;
        int i3;
        int i4;
        boolean z;
        String type;
        String str2;
        BoxSharedLink sharedLink;
        int i5;
        int i6;
        String string;
        String string2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mOnInviteCollabsClickListener;
        View.OnClickListener onClickListener2 = this.mOnShareViaListener;
        boolean z2 = this.mIsAllowedToInviteCollaborator;
        View.OnClickListener onClickListener3 = this.mOnCopyLinkListener;
        View.OnClickListener onClickListener4 = this.mOnEditAccessClickListener;
        UsxFragment.UsxNotifiers usxNotifiers = this.mUsxNotifier;
        View.OnClickListener onClickListener5 = this.mOnCollabsListener;
        BoxItem boxItem = this.mShareItem;
        BoxCollaboration.Role role = this.mUserRole;
        boolean z3 = this.mIsAllowedToShare;
        long j3 = j & 2052;
        if (j3 != 0) {
            if (j3 != 0) {
                j |= z2 ? 139264L : 69632L;
            }
            int i7 = z2 ? 8 : 0;
            i2 = z2 ? 0 : 8;
            i = i7;
        } else {
            i = 0;
            i2 = 0;
        }
        if ((j & 2432) != r4) {
            type = boxItem != null ? boxItem.getType() : null;
            long j4 = j & 2176;
            if (j4 != r4) {
                sharedLink = boxItem != null ? boxItem.getSharedLink() : null;
                z = sharedLink != null;
                if (j4 != r4) {
                    j = z ? j | 134774784 : j | 67387392;
                }
                i4 = z ? 0 : 8;
                if (z) {
                    str = null;
                    string2 = this.sharedLinkSwitch.getResources().getString(R.string.box_sharesdk_share_link_enabled);
                } else {
                    str = null;
                    string2 = this.sharedLinkSwitch.getResources().getString(R.string.box_sharesdk_enable_share_link);
                }
                str2 = string2;
                j = j;
            } else {
                str = null;
                i4 = 0;
                z = false;
                str2 = null;
                sharedLink = null;
            }
            long j5 = j & 2304;
            if (j5 != 0) {
                boolean z4 = role == null;
                if (j5 != 0) {
                    j |= z4 ? CacheValidityPolicy.MAX_AGE : FileUtils.ONE_GB;
                }
                long j6 = j;
                i3 = z4 ? 8 : 0;
                j2 = j6;
            } else {
                j2 = j;
                i3 = 0;
            }
        } else {
            str = null;
            j2 = j;
            i3 = 0;
            i4 = 0;
            z = false;
            type = null;
            str2 = null;
            sharedLink = null;
        }
        float f = 0.0f;
        if ((j2 & 2704) != r4) {
            if ((j2 & 2688) != r4) {
                j2 = z3 ? j2 | 2097152 : j2 | 1048576;
            }
            if ((j2 & 2560) != r4) {
                j2 |= z3 ? 8388608L : 4194304L;
            }
            if ((j2 & 2560) != r4) {
                f = z3 ? 1.0f : 0.7f;
            }
        }
        float f2 = f;
        if ((j2 & 1048576) != r4) {
            if (boxItem != null) {
                sharedLink = boxItem.getSharedLink();
            }
            z = sharedLink != null;
            if ((j2 & 2176) != r4) {
                j2 = z ? j2 | 134774784 : j2 | 67387392;
            }
        }
        BoxSharedLink boxSharedLink = sharedLink;
        boolean z5 = z;
        long j7 = j2 & 2688;
        if (j7 != r4) {
            boolean z6 = z3 ? true : z5;
            if (j7 != r4) {
                j2 |= z6 ? 570425344L : 285212672L;
            }
            int i8 = z6 ? 0 : 8;
            i6 = z6 ? 8 : 0;
            i5 = i8;
        } else {
            i5 = 0;
            i6 = 0;
        }
        String url = ((j2 & 32768) == r4 || boxSharedLink == null) ? str : boxSharedLink.getURL();
        long j8 = j2 & 2176;
        if (j8 != r4) {
            string = z5 ? url : this.temp.getResources().getString(R.string.box_sharesdk_no_shared_link_instructions);
        } else {
            string = str;
        }
        if ((j2 & 2049) != r4) {
            this.inviteCollabs.setOnClickListener(onClickListener);
        }
        if ((j2 & 2052) != r4) {
            this.inviteCollabs.setVisibility(i2);
            this.mboundView1.setVisibility(i);
        }
        if (j8 != r4) {
            this.mboundView12.setVisibility(i4);
            this.mboundView13.setVisibility(i4);
            this.mboundView14.setVisibility(i4);
            this.mboundView15.setVisibility(i4);
            SharedLinkBindingAdapters.setAccess(this.mboundView15, boxSharedLink);
            this.mboundView16.setVisibility(i4);
            this.mboundView17.setVisibility(i4);
            CompoundButtonBindingAdapter.setChecked(this.sharedLinkSwitch, z5);
            TextViewBindingAdapter.setText(this.sharedLinkSwitch, str2);
            TextViewBindingAdapter.setText(this.temp, string);
        }
        if ((j2 & 2560) != r4) {
            if (getBuildSdkInt() >= 11) {
                this.mboundView13.setAlpha(f2);
                this.mboundView14.setAlpha(f2);
                this.mboundView15.setAlpha(f2);
            }
            this.sharedLinkSwitch.setEnabled(z3);
        }
        if ((j2 & 2576) != r4) {
            ViewBindingAdapter.setOnClick(this.mboundView13, onClickListener4, z3);
        }
        if ((j2 & 2056) != r4) {
            this.mboundView18.setOnClickListener(onClickListener3);
        }
        if ((j2 & 2304) != r4) {
            this.mboundView2.setVisibility(i3);
            InviteCollaboratorsBindingAdapters.setRoleName(this.mboundView2, role);
            this.mboundView7.setVisibility(i3);
            InviteCollaboratorsBindingAdapters.setRoleName(this.mboundView7, role);
        }
        if ((j2 & 2432) != r4) {
            String str3 = type;
            CollaborationRoleBindingAdapters.setNoInviteTextForShareLink(this.mboundView3, role, str3);
            CollaborationRoleBindingAdapters.setNoPermissionTextForShareLink(this.mboundView8, role, str3);
        }
        if ((j2 & 2112) != r4) {
            this.mboundView5.setOnClickListener(onClickListener5);
        }
        if ((j2 & 2688) != r4) {
            this.mboundView9.setVisibility(i5);
            this.noSharePermissionTextContainer.setVisibility(i6);
        }
        if ((j2 & 2050) != r4) {
            this.shareViaButton.setOnClickListener(onClickListener2);
        }
        if ((j2 & 2048) != r4) {
            CompoundButtonBindingAdapter.setListeners(this.sharedLinkSwitch, this.mCallback10, str);
            this.temp.setOnClickListener(this.mCallback11);
        }
    }

    @Override // com.box.android.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        UsxFragment.UsxNotifiers usxNotifiers = this.mUsxNotifier;
        if (this.sharedLinkSwitch != null) {
            this.sharedLinkSwitch.isChecked();
            SharedLinkBindingAdapters.onLinkClick(this.sharedLinkSwitch.isChecked(), usxNotifiers);
        }
    }

    @Override // com.box.android.generated.callback.OnCheckedChangeListener.Listener
    public final void _internalCallbackOnCheckedChanged(int i, CompoundButton compoundButton, boolean z) {
        BoxItem boxItem = this.mShareItem;
        UsxFragment.UsxNotifiers usxNotifiers = this.mUsxNotifier;
        if (boxItem != null) {
            SharedLinkBindingAdapters.onSharedLinkToggle(z, boxItem.getSharedLink(), usxNotifiers);
        }
    }
}
