package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.box.android.R;
import com.box.androidsdk.content.views.BoxAvatarView;

/* JADX INFO: loaded from: classes11.dex */
public abstract class UsxListItemCollaborationBinding extends ViewDataBinding {
    public final BoxAvatarView collaboratorInitials;
    public final TextView collaboratorRole;
    public final TextView collaboratorRoleTitle;

    protected UsxListItemCollaborationBinding(Object obj, View view, int i, BoxAvatarView boxAvatarView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.collaboratorInitials = boxAvatarView;
        this.collaboratorRole = textView;
        this.collaboratorRoleTitle = textView2;
    }

    public static UsxListItemCollaborationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxListItemCollaborationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UsxListItemCollaborationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_list_item_collaboration, viewGroup, z, obj);
    }

    public static UsxListItemCollaborationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxListItemCollaborationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UsxListItemCollaborationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_list_item_collaboration, null, false, obj);
    }

    public static UsxListItemCollaborationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxListItemCollaborationBinding bind(View view, Object obj) {
        return (UsxListItemCollaborationBinding) bind(obj, view, R.layout.usx_list_item_collaboration);
    }
}
