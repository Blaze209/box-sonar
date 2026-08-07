package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.box.android.R;
import com.box.android.coreservices.models.BoxInvitee;
import com.box.android.usx.adapters.InviteeAdapter;
import com.box.android.usx.views.ChipCollaborationView;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.tokenautocomplete.CharacterTokenizer;
import com.tokenautocomplete.TokenCompleteTextView;

/* JADX INFO: loaded from: classes11.dex */
public abstract class UsxFragmentInviteCollaboratorsBinding extends ViewDataBinding {
    public final Button addPersonalMessageButton;
    public final View bottomDivider;
    public final LinearLayout invitationLayoutContainer;
    public final ChipCollaborationView inviteCollaboratorAutocomplete;
    public final TextView inviteCollaboratorRole;
    public final TextView invitePeopleTitle;

    @Bindable
    protected InviteeAdapter mAdapter;

    @Bindable
    protected View.OnClickListener mOnRoleClickedListener;

    @Bindable
    protected LiveData<BoxCollaboration.Role> mRole;

    @Bindable
    protected TokenCompleteTextView.TokenListener<BoxInvitee> mTokenListener;

    @Bindable
    protected CharacterTokenizer mTokenizer;
    public final EditText personalMessageEditText;
    public final TextView personalMessageTextView;
    public final TextView roleName;

    public abstract void setAdapter(InviteeAdapter inviteeAdapter);

    public abstract void setOnRoleClickedListener(View.OnClickListener onClickListener);

    public abstract void setRole(LiveData<BoxCollaboration.Role> liveData);

    public abstract void setTokenListener(TokenCompleteTextView.TokenListener<BoxInvitee> tokenListener);

    public abstract void setTokenizer(CharacterTokenizer characterTokenizer);

    protected UsxFragmentInviteCollaboratorsBinding(Object obj, View view, int i, Button button, View view2, LinearLayout linearLayout, ChipCollaborationView chipCollaborationView, TextView textView, TextView textView2, EditText editText, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.addPersonalMessageButton = button;
        this.bottomDivider = view2;
        this.invitationLayoutContainer = linearLayout;
        this.inviteCollaboratorAutocomplete = chipCollaborationView;
        this.inviteCollaboratorRole = textView;
        this.invitePeopleTitle = textView2;
        this.personalMessageEditText = editText;
        this.personalMessageTextView = textView3;
        this.roleName = textView4;
    }

    public CharacterTokenizer getTokenizer() {
        return this.mTokenizer;
    }

    public InviteeAdapter getAdapter() {
        return this.mAdapter;
    }

    public View.OnClickListener getOnRoleClickedListener() {
        return this.mOnRoleClickedListener;
    }

    public LiveData<BoxCollaboration.Role> getRole() {
        return this.mRole;
    }

    public TokenCompleteTextView.TokenListener<BoxInvitee> getTokenListener() {
        return this.mTokenListener;
    }

    public static UsxFragmentInviteCollaboratorsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentInviteCollaboratorsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UsxFragmentInviteCollaboratorsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_fragment_invite_collaborators, viewGroup, z, obj);
    }

    public static UsxFragmentInviteCollaboratorsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentInviteCollaboratorsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UsxFragmentInviteCollaboratorsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.usx_fragment_invite_collaborators, null, false, obj);
    }

    public static UsxFragmentInviteCollaboratorsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UsxFragmentInviteCollaboratorsBinding bind(View view, Object obj) {
        return (UsxFragmentInviteCollaboratorsBinding) bind(obj, view, R.layout.usx_fragment_invite_collaborators);
    }
}
