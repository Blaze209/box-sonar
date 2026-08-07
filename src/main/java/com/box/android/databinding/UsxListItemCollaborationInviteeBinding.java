package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public abstract class UsxListItemCollaborationInviteeBinding extends ViewDataBinding {
    public final TextView collaborationInviteeEmail;
    public final TextView collaborationInviteeName;
    public final TextView collaboratorInitials;

    @Bindable
    protected String mInviteeEmail;

    @Bindable
    protected String mInviteeName;

    public abstract void setInviteeEmail(String str);

    public abstract void setInviteeName(String str);

    protected UsxListItemCollaborationInviteeBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.collaborationInviteeEmail = textView;
        this.collaborationInviteeName = textView2;
        this.collaboratorInitials = textView3;
    }

    public String getInviteeName() {
        return this.mInviteeName;
    }

    public String getInviteeEmail() {
        return this.mInviteeEmail;
    }

    public static UsxListItemCollaborationInviteeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxListItemCollaborationInviteeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UsxListItemCollaborationInviteeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_list_item_collaboration_invitee, viewGroup, z, obj);
    }

    public static UsxListItemCollaborationInviteeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxListItemCollaborationInviteeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UsxListItemCollaborationInviteeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_list_item_collaboration_invitee, null, false, obj);
    }

    public static UsxListItemCollaborationInviteeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxListItemCollaborationInviteeBinding bind(View view, Object obj) {
        return (UsxListItemCollaborationInviteeBinding) bind(obj, view, R.layout.usx_list_item_collaboration_invitee);
    }
}
