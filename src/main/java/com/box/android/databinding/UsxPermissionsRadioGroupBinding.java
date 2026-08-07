package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.box.android.R;
import com.box.android.usx.fragments.SharedLinkAccessFragment;
import com.box.androidsdk.content.models.BoxItem;

/* JADX INFO: loaded from: classes11.dex */
public abstract class UsxPermissionsRadioGroupBinding extends ViewDataBinding {

    @Bindable
    protected BoxItem mShareItem;

    @Bindable
    protected SharedLinkAccessFragment.SharedLinkAccessNotifiers mSharedLinkAccessNotifier;

    @Bindable
    protected boolean mShouldShowDownloadOption;

    @Bindable
    protected boolean mShouldShowEditOption;
    public final RadioButton permissionsCanEdit;
    public final RadioButton permissionsViewAndDownload;
    public final RadioButton permissionsViewOnly;
    public final TextView radioButtonCanEditSubtitle;
    public final TextView radioButtonCanEditTitle;
    public final TextView radioButtonViewAndDownloadSubtitle;
    public final TextView radioButtonViewAndDownloadTitle;
    public final TextView radioButtonViewOnlySubtitle;
    public final TextView radioButtonViewOnlyTitle;

    public abstract void setShareItem(BoxItem boxItem);

    public abstract void setSharedLinkAccessNotifier(SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers);

    public abstract void setShouldShowDownloadOption(boolean z);

    public abstract void setShouldShowEditOption(boolean z);

    protected UsxPermissionsRadioGroupBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.permissionsCanEdit = radioButton;
        this.permissionsViewAndDownload = radioButton2;
        this.permissionsViewOnly = radioButton3;
        this.radioButtonCanEditSubtitle = textView;
        this.radioButtonCanEditTitle = textView2;
        this.radioButtonViewAndDownloadSubtitle = textView3;
        this.radioButtonViewAndDownloadTitle = textView4;
        this.radioButtonViewOnlySubtitle = textView5;
        this.radioButtonViewOnlyTitle = textView6;
    }

    public BoxItem getShareItem() {
        return this.mShareItem;
    }

    public SharedLinkAccessFragment.SharedLinkAccessNotifiers getSharedLinkAccessNotifier() {
        return this.mSharedLinkAccessNotifier;
    }

    public boolean getShouldShowEditOption() {
        return this.mShouldShowEditOption;
    }

    public boolean getShouldShowDownloadOption() {
        return this.mShouldShowDownloadOption;
    }

    public static UsxPermissionsRadioGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxPermissionsRadioGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UsxPermissionsRadioGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_permissions_radio_group, viewGroup, z, obj);
    }

    public static UsxPermissionsRadioGroupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxPermissionsRadioGroupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UsxPermissionsRadioGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_permissions_radio_group, null, false, obj);
    }

    public static UsxPermissionsRadioGroupBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxPermissionsRadioGroupBinding bind(View view, Object obj) {
        return (UsxPermissionsRadioGroupBinding) bind(obj, view, R.layout.usx_permissions_radio_group);
    }
}
