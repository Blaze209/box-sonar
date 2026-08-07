package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.box.android.R;
import com.box.android.usx.fragments.SharedLinkAccessFragment;
import com.box.androidsdk.content.models.BoxItem;
import java.util.HashSet;

/* JADX INFO: loaded from: classes11.dex */
public abstract class UsxFragmentSharedLinkAccessBinding extends ViewDataBinding {
    public final UsxAccessRadioGroupBinding accessRadioGroup;
    public final TextView expireLinkDate;
    public final View expireLinkDivider;

    @Bindable
    protected HashSet mActiveRadioButtons;

    @Bindable
    protected View.OnClickListener mOnDateListener;

    @Bindable
    protected View.OnClickListener mOnPasswordListener;

    @Bindable
    protected BoxItem mShareItem;

    @Bindable
    protected SharedLinkAccessFragment.SharedLinkAccessNotifiers mSharedLinkAccessNotifier;

    @Bindable
    protected boolean mShouldShowDownloadOption;

    @Bindable
    protected boolean mShouldShowEditOption;
    public final View passwordDivider;
    public final UsxPermissionsRadioGroupBinding permissionsRadioGroup;
    public final SwitchCompat sharedLinkExpireLinkBtn;
    public final SwitchCompat sharedLinkRequirePasswordBtn;

    public abstract void setActiveRadioButtons(HashSet hashSet);

    public abstract void setOnDateListener(View.OnClickListener onClickListener);

    public abstract void setOnPasswordListener(View.OnClickListener onClickListener);

    public abstract void setShareItem(BoxItem boxItem);

    public abstract void setSharedLinkAccessNotifier(SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers);

    public abstract void setShouldShowDownloadOption(boolean z);

    public abstract void setShouldShowEditOption(boolean z);

    protected UsxFragmentSharedLinkAccessBinding(Object obj, View view, int i, UsxAccessRadioGroupBinding usxAccessRadioGroupBinding, TextView textView, View view2, View view3, UsxPermissionsRadioGroupBinding usxPermissionsRadioGroupBinding, SwitchCompat switchCompat, SwitchCompat switchCompat2) {
        super(obj, view, i);
        this.accessRadioGroup = usxAccessRadioGroupBinding;
        this.expireLinkDate = textView;
        this.expireLinkDivider = view2;
        this.passwordDivider = view3;
        this.permissionsRadioGroup = usxPermissionsRadioGroupBinding;
        this.sharedLinkExpireLinkBtn = switchCompat;
        this.sharedLinkRequirePasswordBtn = switchCompat2;
    }

    public HashSet getActiveRadioButtons() {
        return this.mActiveRadioButtons;
    }

    public BoxItem getShareItem() {
        return this.mShareItem;
    }

    public SharedLinkAccessFragment.SharedLinkAccessNotifiers getSharedLinkAccessNotifier() {
        return this.mSharedLinkAccessNotifier;
    }

    public View.OnClickListener getOnPasswordListener() {
        return this.mOnPasswordListener;
    }

    public View.OnClickListener getOnDateListener() {
        return this.mOnDateListener;
    }

    public boolean getShouldShowDownloadOption() {
        return this.mShouldShowDownloadOption;
    }

    public boolean getShouldShowEditOption() {
        return this.mShouldShowEditOption;
    }

    public static UsxFragmentSharedLinkAccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentSharedLinkAccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UsxFragmentSharedLinkAccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_fragment_shared_link_access, viewGroup, z, obj);
    }

    public static UsxFragmentSharedLinkAccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentSharedLinkAccessBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UsxFragmentSharedLinkAccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_fragment_shared_link_access, null, false, obj);
    }

    public static UsxFragmentSharedLinkAccessBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentSharedLinkAccessBinding bind(View view, Object obj) {
        return (UsxFragmentSharedLinkAccessBinding) bind(obj, view, R.layout.usx_fragment_shared_link_access);
    }
}
