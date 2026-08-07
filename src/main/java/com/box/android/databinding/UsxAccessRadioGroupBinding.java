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
import com.box.android.usx.fragments.SharedLinkAccessFragment;
import com.box.androidsdk.content.models.BoxItem;
import java.util.HashSet;

/* JADX INFO: loaded from: classes11.dex */
public abstract class UsxAccessRadioGroupBinding extends ViewDataBinding {
    public final RadioButton companyAccess;
    public final TextView companyAccessDescription;
    public final ConstraintLayout companyAccessLayout;
    public final TextView companyAccessName;
    public final RadioButton folderAccess;
    public final TextView folderAccessDescription;
    public final ConstraintLayout folderAccessLayout;
    public final TextView folderAccessName;
    public final RadioButton linkAccess;
    public final TextView linkAccessDescription;
    public final ConstraintLayout linkAccessLayout;
    public final TextView linkAccessName;

    @Bindable
    protected HashSet mActiveRadioButtons;

    @Bindable
    protected BoxItem mShareItem;

    @Bindable
    protected SharedLinkAccessFragment.SharedLinkAccessNotifiers mSharedLinkAccessNotifier;

    public abstract void setActiveRadioButtons(HashSet hashSet);

    public abstract void setShareItem(BoxItem boxItem);

    public abstract void setSharedLinkAccessNotifier(SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers);

    protected UsxAccessRadioGroupBinding(Object obj, View view, int i, RadioButton radioButton, TextView textView, ConstraintLayout constraintLayout, TextView textView2, RadioButton radioButton2, TextView textView3, ConstraintLayout constraintLayout2, TextView textView4, RadioButton radioButton3, TextView textView5, ConstraintLayout constraintLayout3, TextView textView6) {
        super(obj, view, i);
        this.companyAccess = radioButton;
        this.companyAccessDescription = textView;
        this.companyAccessLayout = constraintLayout;
        this.companyAccessName = textView2;
        this.folderAccess = radioButton2;
        this.folderAccessDescription = textView3;
        this.folderAccessLayout = constraintLayout2;
        this.folderAccessName = textView4;
        this.linkAccess = radioButton3;
        this.linkAccessDescription = textView5;
        this.linkAccessLayout = constraintLayout3;
        this.linkAccessName = textView6;
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

    public static UsxAccessRadioGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxAccessRadioGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UsxAccessRadioGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_access_radio_group, viewGroup, z, obj);
    }

    public static UsxAccessRadioGroupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxAccessRadioGroupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UsxAccessRadioGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_access_radio_group, null, false, obj);
    }

    public static UsxAccessRadioGroupBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxAccessRadioGroupBinding bind(View view, Object obj) {
        return (UsxAccessRadioGroupBinding) bind(obj, view, R.layout.usx_access_radio_group);
    }
}
