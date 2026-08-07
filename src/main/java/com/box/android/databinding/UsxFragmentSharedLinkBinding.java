package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.box.android.R;
import com.box.android.usx.fragments.UsxFragment;
import com.box.android.usx.views.CollaboratorsInitialsView;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxItem;

/* JADX INFO: loaded from: classes11.dex */
public abstract class UsxFragmentSharedLinkBinding extends ViewDataBinding {
    public final CollaboratorsInitialsView initialViews;
    public final EditText inviteCollabs;

    @Bindable
    protected boolean mIsAllowedToInviteCollaborator;

    @Bindable
    protected boolean mIsAllowedToShare;

    @Bindable
    protected View.OnClickListener mOnCollabsListener;

    @Bindable
    protected View.OnClickListener mOnCopyLinkListener;

    @Bindable
    protected View.OnClickListener mOnEditAccessClickListener;

    @Bindable
    protected View.OnClickListener mOnInviteCollabsClickListener;

    @Bindable
    protected View.OnClickListener mOnShareViaListener;

    @Bindable
    protected BoxItem mShareItem;

    @Bindable
    protected BoxCollaboration.Role mUserRole;

    @Bindable
    protected UsxFragment.UsxNotifiers mUsxNotifier;
    public final LinearLayout noSharePermissionTextContainer;
    public final TextView shareViaButton;
    public final SwitchCompat sharedLinkSwitch;
    public final TextView temp;

    public abstract void setIsAllowedToInviteCollaborator(boolean z);

    public abstract void setIsAllowedToShare(boolean z);

    public abstract void setOnCollabsListener(View.OnClickListener onClickListener);

    public abstract void setOnCopyLinkListener(View.OnClickListener onClickListener);

    public abstract void setOnEditAccessClickListener(View.OnClickListener onClickListener);

    public abstract void setOnInviteCollabsClickListener(View.OnClickListener onClickListener);

    public abstract void setOnShareViaListener(View.OnClickListener onClickListener);

    public abstract void setShareItem(BoxItem boxItem);

    public abstract void setUserRole(BoxCollaboration.Role role);

    public abstract void setUsxNotifier(UsxFragment.UsxNotifiers usxNotifiers);

    protected UsxFragmentSharedLinkBinding(Object obj, View view, int i, CollaboratorsInitialsView collaboratorsInitialsView, EditText editText, LinearLayout linearLayout, TextView textView, SwitchCompat switchCompat, TextView textView2) {
        super(obj, view, i);
        this.initialViews = collaboratorsInitialsView;
        this.inviteCollabs = editText;
        this.noSharePermissionTextContainer = linearLayout;
        this.shareViaButton = textView;
        this.sharedLinkSwitch = switchCompat;
        this.temp = textView2;
    }

    public View.OnClickListener getOnInviteCollabsClickListener() {
        return this.mOnInviteCollabsClickListener;
    }

    public View.OnClickListener getOnEditAccessClickListener() {
        return this.mOnEditAccessClickListener;
    }

    public View.OnClickListener getOnCollabsListener() {
        return this.mOnCollabsListener;
    }

    public View.OnClickListener getOnShareViaListener() {
        return this.mOnShareViaListener;
    }

    public View.OnClickListener getOnCopyLinkListener() {
        return this.mOnCopyLinkListener;
    }

    public UsxFragment.UsxNotifiers getUsxNotifier() {
        return this.mUsxNotifier;
    }

    public BoxItem getShareItem() {
        return this.mShareItem;
    }

    public boolean getIsAllowedToInviteCollaborator() {
        return this.mIsAllowedToInviteCollaborator;
    }

    public boolean getIsAllowedToShare() {
        return this.mIsAllowedToShare;
    }

    public BoxCollaboration.Role getUserRole() {
        return this.mUserRole;
    }

    public static UsxFragmentSharedLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentSharedLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UsxFragmentSharedLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_fragment_shared_link, viewGroup, z, obj);
    }

    public static UsxFragmentSharedLinkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentSharedLinkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UsxFragmentSharedLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_fragment_shared_link, null, false, obj);
    }

    public static UsxFragmentSharedLinkBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentSharedLinkBinding bind(View view, Object obj) {
        return (UsxFragmentSharedLinkBinding) bind(obj, view, R.layout.usx_fragment_shared_link);
    }
}
